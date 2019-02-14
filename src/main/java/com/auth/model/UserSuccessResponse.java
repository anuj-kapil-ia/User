package com.auth.model;

public class UserSuccessResponse extends UserResponse {
	private String username;
	private String message;
	 public String getUserName() {
			return username;
		}

		public void setUserName(String username) {
			this.username = username;
		}
	 public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
}
