package com.stackroute.RestAssuredTestAPI;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class TestClass03 
{
	Response res = null;
	
	@Test
	public void test05()
	{
		RestAssured.baseURI= "https://jsonplaceholder.typicode.com/";
		RequestSpecification httpRequest = RestAssured.given();	
		
		res= httpRequest.request(Method.GET, "/posts");
		String responseBody = res.getBody().asString();
		
		assertTrue(responseBody.contains("qui est esse"));
		
		String contentType = res.getContentType();
		assertEquals(contentType,"application/json; charset=utf-8");
		
		
		
	}
	
	
	@Test
	public void test03()
	{
		RestAssured.baseURI= "https://reqres.in/api/users";
		RequestSpecification httpRequest = RestAssured.given();	
		
		Response res = httpRequest.get("/4");
		
		JsonPath jsonPath = res.jsonPath();
		given().get("/4").then().body("data.id",equalTo(4));
		given().get("/4").then().body("data.first_name",equalTo("Eve"));
		given().get("/4").then().body("data.last_name",equalTo("Holt"));
		
		
		
	}
	
	@Test
	public void test04()
	{
		RestAssured.baseURI= "https://cloud.google.com/maps-platform/";
		RequestSpecification httpRequest = RestAssured.given();	
		
		given().formParam("location", "22.5899375,88.2862135").param("radius","500")
		.when().get("/maps/api/place/nearbysearch/json")
		.then().assertThat().statusCode(404);
		
		
	}

}
