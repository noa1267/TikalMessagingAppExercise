package com.tikal.MessagingApp.exceptions;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {
    private HttpStatus status;
    private List<String> errors;
    private Date timestamp;

    public ApiError(HttpStatus status, List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
        this.timestamp = new Date(); 
    }

    public ApiError(HttpStatus status, String error) {
        super();
        this.status = status;
        this.timestamp = new Date();
        errors = Arrays.asList(error);
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "ApiError [status=" + status + ", errors=" + errors + ", timestamp=" + timestamp + "]";
	}
}
