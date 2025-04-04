package com.apiautomation.demo.base;

import java.util.HashMap;

import com.apiautomation.demo.models.request.LoginRequest;
import com.apiautomation.demo.models.request.SignupRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {
	
	private static final String BASE_PATH ="/api/auth/";
	
	public Response login (LoginRequest payload) {
	  return	postRequest(payload,BASE_PATH+"login");
	}
	
	public Response signup(SignupRequest payload) {
		return postRequest(payload,BASE_PATH+"signup");
	}
	public Response forgotPassword(String  emailaddress) {
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("email", emailaddress);
		
		return postRequest(payload,BASE_PATH+"signup");
	}

}
