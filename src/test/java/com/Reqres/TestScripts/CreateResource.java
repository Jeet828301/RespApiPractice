package com.Reqres.TestScripts;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import com.Utilitties.ConvertJsonFiletoMap;
import com.Utilitties.FakeData;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateResource {

	@Test
	public void createResource() {

		Map<String, Object> values = ConvertJsonFiletoMap.getDataInMapFromJsonFile("Resource");
		values.put("name", FakeData.getFirstName());
		values.put("job", FakeData.getRole());

		Response response = given().baseUri("https://reqres.in/").log().uri().basePath("/api/users").body(values)
				.contentType(ContentType.JSON).when().post().then().extract().response();
		response.prettyPrint();

		String id = response.path("id");
		BasicData.setData("id", id);
	}

	@Test(dependsOnMethods = { "createResource" })
	public void getSingleResource() {
		String id = (String) BasicData.getData("id");
		Response response = given().baseUri("https://reqres.in/").basePath("api/users/{id}").pathParam("id", id).log()
				.uri().when().get().then().extract().response();
		response.prettyPrint();
	}

}
