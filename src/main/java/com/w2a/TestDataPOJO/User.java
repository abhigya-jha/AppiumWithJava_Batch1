package com.w2a.TestDataPOJO;

import java.util.ArrayList;

public class User {
	
	public String validUsername;
	public String validPassword;
	public String invalidUsername;
	public String invalidPassword;
	public ArrayList<Tech> Tech;
	
	public String getValidUsername() {
		return validUsername;
	}
	public void setValidUsername(String validUsername) {
		this.validUsername = validUsername;
	}
	public String getValidPassword() {
		return validPassword;
	}
	public void setValidPassword(String validPassword) {
		this.validPassword = validPassword;
	}
	public String getInvalidUsername() {
		return invalidUsername;
	}
	public void setInvalidUsername(String invalidUsername) {
		this.invalidUsername = invalidUsername;
	}
	public String getInvalidPassword() {
		return invalidPassword;
	}
	public void setInvalidPassword(String invalidPassword) {
		this.invalidPassword = invalidPassword;
	}
	public ArrayList<Tech> getTech() {
		return Tech;
	}
	public void setTech(ArrayList<Tech> tech) {
		Tech = tech;
	}
	
	
	
	

}
