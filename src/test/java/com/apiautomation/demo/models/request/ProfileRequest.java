package com.apiautomation.demo.models.request;

public class ProfileRequest {
   String	 firstName; 
	 String  lastName; 
	String  email; 
	String   mobileNumber;
	public ProfileRequest(String firstName, String lastName, String email, String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "ProfileRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + "]";
	} 
	public static class Builder{
		String	 firstName; 
		 String  lastName; 
		String  email; 
		String   mobileNumber;
		
		public Builder firstname(String firstName) {
			this.firstName=firstName;
			return this;
		}
		public Builder lastName(String lastName) {
			this.lastName=lastName;
			return this;
		}
		public Builder email(String email) {
			this.email=email;
			return this;
		}
		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber=mobileNumber;
			return this;
		}
		
		public ProfileRequest build() {
			ProfileRequest profReq = new ProfileRequest(firstName,lastName,email,mobileNumber);
			return profReq;
		}
	}
}
