package com.Reqres.TestScripts;

import java.util.LinkedHashMap;
import java.util.Map;
import org.testng.annotations.Test;
import com.Utilitties.ConvertJsonFiletoMap;
import com.Utilitties.FakeData;
import com.Utilitties.ResponseCode;
import com.Utilitties.ResponsePage;
import io.restassured.response.Response;

public class CreateResource {

	@Test
	public void createResource() {
		Map<String, Object> values = ConvertJsonFiletoMap.getDataInMapFromJsonFile("Resource");
		values.put("name", FakeData.getFirstName());
		values.put("job", FakeData.getRole());

		Response response = ResponsePage.getPostResponse("https://reqres.in/", "/api/users", values);
		response.prettyPrint();

		String id = response.path("id");
		BasicData.setData("id", id);
		ResponseCode.validate201(response);
	}

	@Test(dependsOnMethods = { "createResource" })
	public void getSingleResource() {
		Map<String, Object> pathParams = new LinkedHashMap<>();
		pathParams.put("id", BasicData.getData("id"));

		Response response = ResponsePage.getGetResponse("https://reqres.in/", "api/users/{id}", pathParams);
		response.prettyPrint();
		ResponseCode.validate404(response);
	}

}
