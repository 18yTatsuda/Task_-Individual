package jp.co.axiz.web.form;

import javax.validation.constraints.NotBlank;

public class LoginForm {

	@NotBlank
	private String userName;

	@NotBlank
	private String pass;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}



}
