package com.platzi.api.platziAPITest;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.platzi.api.baseAPI.BaseClient;
import com.platzi.api.httpRequest.HttpRequest;

import io.qameta.allure.Description;
import io.restassured.response.Response;

public class platziTest extends BaseClient {

	public static String expectedResult = null;
	public static Response response;
	public static HttpRequest httpRequest = new HttpRequest();
	public static HashMap<String ,String> headerMap = new HashMap<>();
	
	@BeforeMethod
	public void Setup() {
	
		headerMap = httpRequest.setHeaders();
		response = httpRequest.createProductUsingPostCall(loginKeys());		
		headerMap.put("access_token",getKeyValueFromJsonResponse(response.asString(),"access_token"));
		int actual = response.getStatusCode();
		Assert.assertEquals(actual, 201);
 	}
	
	@Description("Validate the status code for POST call when new product is created")
	@Test
	public void tc_post_api_platzi_001() {
		
		response = httpRequest.createProductUsingPostCall(createPostCallBody());
		int actual =response.getStatusCode();
		Assert.assertEquals(actual, 201);
	}
	
	@Description("Validate Newly Product is visible in product using GET call")
	@Test
	public void tc_post_api_platzi_002() {
		
		response = httpRequest.retrieveProductUsingGetCall(getKeyValueFromJsonResponse(response.asString(),"id"));
		int actual =response.getStatusCode();
		Assert.assertEquals(actual, 201);
	}
	

}
