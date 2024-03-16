package com.Utilitties;

import static org.testng.Assert.*;

import io.restassured.response.Response;

public class ResponseCode {

	public static void validate201(Response response) {
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 201);
	}

	public static void validate200(Response response) {
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);
	}

	public static void validate404(Response response) {
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 404);
	}
}
