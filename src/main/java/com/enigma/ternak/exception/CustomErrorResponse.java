package com.enigma.ternak.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomErrorResponse {
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	    private LocalDateTime timestamp;
	    private int status;
	    private String message;
	    private String path;
	    
	    public CustomErrorResponse() {
	
		}

		public CustomErrorResponse(LocalDateTime timestamp, int status, String message, String path) {
			super();
			this.timestamp = timestamp;
			this.status = status;
			this.message = message;
			this.path = path;
		}
	
		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public int getStatus() {
			return status;
		}

		public String getMessage() {
			return message;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
	    
	        
}
