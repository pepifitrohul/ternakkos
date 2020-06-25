def repository = 'https://github.com/pepifitrohul/ternakkos'
def credentialsId = "git"
def dockerDev = [:]
def dockerDevHost = "10.10.11.15"
def dockerRegisty = "10.10.11.6:8083"
def imageTag = "ternakkos-pep"
def imageName = "ternakkos-pep"
def imageVersion = "latest"
def appEnvVariableName = "TERNAKKOS-PEP_IMAGES"
def appEnvVariable = dockerRegisty + "/" + imageTag + "/" + imageName + ":" + imageVersion
def images = imageName + ":" + "imageVersion"

pipeline {
    agent any
    stages {
        stage('git checkout'){
            steps {
                checkout([$class : 'GitSCM', branch: [
                        [name: '*/master']
                ], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                          userRemoteConfigs: [
                                  [credentialsId: credentialsId, url: repoBackend]
                          ]
                ])
            }
        }

        stage('build and deploy'){
            steps {
                sh 'mcn clean package -X'
                sh 'mvn deploy'
            }
        }

        stage('docker build and tag image'){
            steps {
                sh 'docker build . -t ${images}'
                sh 'docker tag ${imagesName}:${imageVersion} ${appEnvVariable}'
            }
        }

        stage('Push Images'){
            steps {
                withCredentials(
                        [usernamePassword(
                                credentialsId: 'nexus-docker',
                                usernameVariable: 'USERNAME',
                                passwordVariable: 'PASSWORD'
                        )]
                ){
                    sh "docker login -u ${USERNAME} -p ${PASSWORD} http://${dockerRegistry}"
                    sh "docker push ${appEnvVariable}"
                }
            }
        }

        stage('Deploy Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-dev', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    script {
                        dockerDev.name = "docker-dev"
                        dockerDev.host = "${dockerDevHost}"
                        dockerDev.user = "${USERNAME}"
                        dockerDev.password = "${PASSWORD}"
                        dockerDev.allowAnyHosts = true
                    }

                    sshPut remote: dockerDev, from: './docker-compose.yml', into: "./${imageName}-docker-compose.yml"
                    sshCommand remote: dockerDev, command: "export ${appEnvVariableName}=${appEnvVariable}; docker-compose -f ./${imageName}-docker-compose.yml up -d"
                }
            }
        }

    }
}