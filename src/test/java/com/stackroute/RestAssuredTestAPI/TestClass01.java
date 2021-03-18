package com.stackroute.RestAssuredTestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TestClass01 
{
	
	@Test
	public void test01()
	{
		Response res = RestAssured.get("https://reqres.in/api/users");
		System.out.println(res.getStatusCode());
		
		
		int statusCode =res.getStatusCode();
		Assert.assertEquals(statusCode,200);
		
	}
	
	@Test
	public void test02()
	{
		given().get("https://reqres.in/api/users").then().statusCode(200);
		
	}
	

}
