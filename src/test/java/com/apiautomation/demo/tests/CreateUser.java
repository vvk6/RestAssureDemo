package com.apiautomation.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.apiautomation.demo.base.AuthService;
import com.apiautomation.demo.models.request.SignupRequest;

import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)
public class CreateUser {

	@Test(description="creating a new user")
	public void signupNewUser() {
		SoftAssert softAssert = new SoftAssert();
		AuthService auth = new AuthService();
		//SignupRequest signupreq = new SignupRequest("Ramk","kRam123","kram.kendre@gmail.com","Tkukaram","kkendre","8377991234");
		SignupRequest	signupreq =new SignupRequest.Builder()
		              .username("Travis")
		              .email("travis.head@gmail.com")
		              .password("travis666")
		              .firstName("Travis")
		              .lastName("Head")
		              .mobileNumber("9988776677")
		              .build();
	Response response = auth.signup(signupreq);
	System.out.println( response.asPrettyString());
	System.out.println( response.getStatusCode());
	softAssert.assertEquals( response.getStatusCode(), 200);
	softAssert.assertEquals( response.asPrettyString(), "User registered successfully");	
	 softAssert.assertAll();
	

	
	}
}
