package com.apiautomation.demo.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 import com.apiautomation.filters.LoggingFilter;

public class BaseService {
	
	private static  final String BASEURL ="http://64.227.160.186:8080";
	private RequestSpecification requestspecification;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService() {
		requestspecification=RestAssured.given().baseUri(BASEURL);
		
	}
	
	protected void setAuthToken(String token) {
		requestspecification.header("Authorization","Bearer "+token);
		
	}
	protected Response postRequest(Object payload,String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	protected Response getRequest(String endpoint) {
		return requestspecification.get(endpoint);
	}
	protected Response putRequest(Object payload,String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
}
