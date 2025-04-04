package com.apiautomation.demo.tests;

import org.testng.annotations.Test;

import com.apiautomation.demo.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {

    @Test	
	public void forgotPassword() {
		
    	AuthService auth = new AuthService();
    	Response response = auth.forgotPassword("kram.kendre34@gmail.com");
    	System.out.println(response.asPrettyString());
    	
	}
}
