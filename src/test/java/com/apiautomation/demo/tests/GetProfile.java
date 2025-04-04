package com.apiautomation.demo.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.apiautomation.demo.base.AuthService;
import com.apiautomation.demo.base.UserManagementService;
import com.apiautomation.demo.models.request.LoginRequest;
import com.apiautomation.demo.models.response.LoginResponse;
import com.apiautomation.demo.models.response.UserProfileResponse;

import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)
public class GetProfile {
	
	@Test(description="get user profile")
	public void getUserProfile() {
		AuthService auth = new AuthService();
		
		Response repsonse = auth.login(new LoginRequest("Travis","travis666"));
		LoginResponse loginResponse = repsonse.as(LoginResponse.class);
	
		
		
		UserManagementService usermanage = new UserManagementService();
		Response profileResponse = usermanage.getProfile(loginResponse.getToken());
		System.out.println(profileResponse.asPrettyString());
		UserProfileResponse profileResponses = profileResponse.as(UserProfileResponse.class);
	
		System.out.println(profileResponses.getId());
		
		
	}

}
