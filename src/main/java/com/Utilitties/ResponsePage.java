package com.Utilitties;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResponsePage {

	public static Response getPostResponse(String baseUri, String basePath, Object body) {
		return given().baseUri(baseUri).basePath(basePath).log().uri().body(body).contentType(ContentType.JSON).when()
				.post().then().extract().response();
	}

	public static Response getGetResponse(String baseUri, String basePath, Map<String, Object> pathParam) {
		return given().baseUri(baseUri).basePath(basePath).log().uri().pathParams(pathParam).when().get().then()
				.extract().response();
	}
}
