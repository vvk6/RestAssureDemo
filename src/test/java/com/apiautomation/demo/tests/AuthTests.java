package com.apiautomation.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.apiautomation.demo.base.AuthService;
import com.apiautomation.demo.models.request.LoginRequest;
import com.apiautomation.demo.models.request.SignupRequest;
import com.apiautomation.demo.models.response.LoginResponse;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.api.listeners.TestListener.class)
public class AuthTests {

	@Test(description= "verify if login is working")
	public void login() {
		/*
		 * RestAssured.baseURI = "http://64.227.160.186:8080"; RequestSpecification x =
		 * RestAssured.given(); RequestSpecification y =
		 * x.header("Content-Type","application/json"); RequestSpecification z =
		 * y.body("{\"username\": \"vvk6\",   \"password\": \"pwd123\"}"); Response
		 * response = z.post("/api/auth/login");
		 */
		
		AuthService auth = new AuthService();
		LoginRequest loginreq = new LoginRequest("vvk6","pwd123");
		//Response response = auth.login("{\"username\": \"vvk6\",   \"password\": \"pwd123\"}");
		Response response = auth.login(loginreq);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
	System.out.println( response.asPrettyString());
	System.out.println( response.getStatusCode());
	System.out.println(loginResponse.getToken());
	Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	
	@Test(description ="verify new user can signup")
	public void signup() {
		AuthService auth = new AuthService();
		//SignupRequest signupreq = new SignupRequest("Ramk","kRam123","kram.kendre@gmail.com","Tkukaram","kkendre","8377991234");
		SignupRequest	signupreq =new SignupRequest.Builder()
		              .username("Ramk1")
		              .email("kram.kendre34@gmail.com")
		              .password("kRam123")
		              .firstName("thukaram")
		              .lastName("Kendre")
		              .mobileNumber("7766234879")
		              .build();
	Response response = auth.signup(signupreq);
	System.out.println( response.asPrettyString());
	System.out.println( response.getStatusCode());
//	Assert.assertEquals(response.getStatusCode(), 200);
	

	
	}
}
