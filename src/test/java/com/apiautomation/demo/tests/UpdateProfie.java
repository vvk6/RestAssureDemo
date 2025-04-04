package com.apiautomation.demo.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.apiautomation.demo.base.AuthService;
import com.apiautomation.demo.base.UserManagementService;
import com.apiautomation.demo.models.request.LoginRequest;
import com.apiautomation.demo.models.request.ProfileRequest;
import com.apiautomation.demo.models.response.LoginResponse;
import com.apiautomation.demo.models.response.UserProfileResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class UpdateProfie {
	@Test(description="verify if the user can update his details")
	public void UpdateProfileTest() {
		
		AuthService auth = new AuthService();
		
		Response repsonse = auth.login(new LoginRequest("Travis","travis666"));
		System.out.println(repsonse.asPrettyString());
		LoginResponse loginResponse = repsonse.as(LoginResponse.class);
		System.out.println("--------------------------------------------------");
		
		UserManagementService usrservice = new UserManagementService();
		repsonse= usrservice.getProfile(loginResponse.getToken());
		System.out.println(repsonse.asPrettyString());
		System.out.println("--------------------------------------------------");
		
		ProfileRequest profileReq = new ProfileRequest.Builder()
	            .firstname("Travis jr")
	            .lastName("Head")
	            .email("travis.head@gmail.com")
	            .mobileNumber("9192939495")
	            .build();

			 repsonse = usrservice.updateProfile(loginResponse.getToken(), profileReq);
			 System.out.println(repsonse.asPrettyString());
	}

}
