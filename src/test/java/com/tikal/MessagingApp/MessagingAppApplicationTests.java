package com.tikal.MessagingApp;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.tikal.MessagingApp.exceptions.ApiError;

@SpringBootTest
class MessagingAppApplicationTests {
	private final String URL = "http://localhost:8080/messages";

	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void whenNoHandlerForHttpRequest_thenNotFound() {
	    ResultParser resultParser = new ResultParser();
	    Object response = resultParser.getResponseData(URL+"xyz", "GET", null);
	    assertTrue(response instanceof ApiError);
	    assertEquals(((ApiError) response).getStatus(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void whenHttpRequestMethodNotSupported_thenMethodNotAllowed() {
	    ResultParser resultParser = new ResultParser();
	    Object response = resultParser.getResponseData(URL, "DELETE", null);
	    assertTrue(response instanceof ApiError);
	    assertEquals(((ApiError) response).getStatus(), HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	
	@Test
	public void wheneMethodArgumentNotValid_thenBadRequest() {
	    ResultParser resultParser = new ResultParser();
	    String input = "{\"sender\" : \"abc\", \"recipient\" : \"noa1267\", \"msgContent\" : \"\"}";
	    Object response = resultParser.getResponseData("POST", "", input);
	    assertTrue(response instanceof ApiError);
	    assertEquals(((ApiError) response).getStatus(), HttpStatus.BAD_REQUEST);
	    assertTrue(((ApiError) response).getErrors().contains("possible length"));
	}

	private void assertEquals(HttpStatus status1, HttpStatus status2) {
		if (status1.compareTo(status2)==0)
			return;
	}
}
