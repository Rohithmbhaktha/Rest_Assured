package API_Automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class Api_training {


	@Test
	public void get() {
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		int statuscode = response.getStatusCode();
		System.out.println("Status code is "+response.getStatusCode());
		Assert.assertEquals(statuscode, 200);
		String body = response.getBody().asPrettyString();
		System.out.println(body);

	}	
	@Test
	public void post() {

		/*	RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject updateData = new JSONObject();
		updateData.put("name", "rohith"); 
		updateData.put("job", "leader");
		httpRequest.header("Content-Type", "application/json");
		Response response = httpRequest.request(Method.POST, "");
		String response1 = response.getBody().asString();
		System.out.println(response 1);
		int status = response.getStatusCode();
		System.out.println("Status code is = "+status);
		 */
		RestAssured.baseURI = "https://reqres.in/api/users/";
		RequestSpecification request = RestAssured.given();
		JSONObject updateData = new JSONObject();
		updateData.put("name", "rohith"); 
		updateData.put("job", "leader");
		request.header("Content-Type", "application/json");
		request.body(updateData.toJSONString());
		Response response = request.request(Method.POST, "");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		System.out.println(response.asPrettyString());

	}
	@Test(priority=3)
	public void delete() {

		RestAssured.baseURI = "https://reqres.in/api/users/";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.DELETE, "/2");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 204);
		if(response.getStatusCode()== 204)
		{
			System.out.println("successfuly Verified the Status Code displayed as ::" +statusCode);
		}
	}


	@Test
	public void PrintingHeaders()
	{


		Response response=RestAssured.get("https://reqres.in/api/users?page=2"); 
		Headers head = response.headers();
		String body = response.getBody().toString();
		System.out.println(body);
		for (Header header: head)
		{
			System.out.println(header.getName()+"            "+header.getValue());

		}		 
		Assert.assertEquals(body.contains("Michael"), false);

	}

	@Test(priority=0)
	public void put() {


		JSONObject request= new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		System.out.println(request.toJSONString());

		given().
		header("Content-Type","Application/json").
		body(request.toJSONString());
		when().
		put("https://reqres.in/api/users/2").
		then().statusCode(200);
	}
	@Test(priority=1)
	public void deletemethod() {
		given().
		header("Content-Type","Application/json").
		when().
		delete("https://reqres.in/api/users/2").
		then().statusCode(200);
	}
}

