package com.emilindadie.exception;

public class ErrorException extends Exception {
	
	private String exeptionName;
	private String exeptionMessage;
	
	public ErrorException(String exeptionName, String exeptionMessage){
		this.exeptionName = exeptionName;
		this.exeptionMessage = exeptionMessage;
	}

	public String getExeptionName() {
		return exeptionName;
	}

	public void setExeptionName(String exeptionName) {
		this.exeptionName = exeptionName;
	}

	public String getExeptionMessage() {
		return exeptionMessage;
	}

	public void setExeptionMessage(String exeptionMessage) {
		this.exeptionMessage = exeptionMessage;
	}
}