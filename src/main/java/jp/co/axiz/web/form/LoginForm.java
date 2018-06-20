package jp.co.axiz.web.form;

import javax.validation.constraints.NotBlank;

public class LoginForm {

	@NotBlank
	private String userName;

	@NotBlank
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}



}
