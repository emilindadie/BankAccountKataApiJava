package com.emilindadie.model;

public class ApiResponse<T> {
	private T data;
	private Exception error;

	public ApiResponse(T data, Exception error){
		this.data = data;
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Exception getError() {
		return error;
	}

	public void setError(Exception error) {
		this.error = error;
	}
}
