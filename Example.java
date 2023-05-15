package Automation;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example {
	   @Test
	   public void get() {
	      
	        RestAssured.baseURI = "https://reqres.in/api/users/";
	         
	      
	        RequestSpecification httpRequest = RestAssured.given();
	        Response response = httpRequest.request(Method.GET, "");
	        int statusCode = response.getStatusCode();
	        Assert.assertEquals(statusCode, 200);
	        System.out.println(statusCode);
	        System.out.println(response.asPrettyString());
	        String  email =  response.jsonPath().get("data[1].email");
	        System.out.println(email);
	    }

	
	@Test 
	   public void post() {
	        RestAssured.baseURI = "https://reqres.in/api/users/";
	        RequestSpecification request = RestAssured.given();
	        JSONObject updateData = new JSONObject();
	        updateData.put("name", "morpheus"); 
	        updateData.put("job", "leader");
	        request.header("Content-Type", "application/json");
	        request.body(updateData.toJSONString());
	        Response response = request.request(Method.POST, "");
	        int statusCode = response.getStatusCode();
	        Assert.assertEquals(statusCode, 201);
	        System.out.println(response.asPrettyString());
	     /*   JsonPath newData = response.jsonPath();
	        String name = newData.get("name");
	        Assert.assertEquals(name, "morpheus");
	        System.out.println(name);
	        */
	    }
	 @Test
	   public void put() {
	        RestAssured.baseURI = "https://reqres.in/api/users/";
	 
	        RequestSpecification request = RestAssured.given();
	        Map<String,String> headers= new HashMap<>();
	        headers.put("name", "morpheus");
	        headers.put("job", "zion resident"); 
	 
	        request.header("Content-Type", "application/json");
	 
	        request.body(headers);
	        Response response = request.request(Method.PUT, "");
	        System.out.println(response.asPrettyString());
	       int statusCode = response.getStatusCode();
	        Assert.assertEquals(statusCode, 200);
	 
	        JsonPath newData = response.jsonPath();
	        String name = newData.get("job");
	        System.out.println(name);
	        
	    }
	 @Test
	   public void delete() {
	        RestAssured.baseURI = "https://reqres.in/api/users/";
	 
	        RequestSpecification httpRequest = RestAssured.given();
	 
	        Response response = httpRequest.request(Method.DELETE, "1");
	        int statusCode = response.getStatusCode();
	        Assert.assertEquals(statusCode, 204);
	        if(response.getStatusCode()== 204)
	    		   {
	        	System.out.println("Scussesfully Verified the Status Code displayed as ::" +statusCode);
	    		   }
	    }
	 
	 
	 
	 
	 
}
