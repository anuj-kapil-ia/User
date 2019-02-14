package com.auth.model;

public class UserErrorResponse extends UserResponse {

	private String message;
	 public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
}
