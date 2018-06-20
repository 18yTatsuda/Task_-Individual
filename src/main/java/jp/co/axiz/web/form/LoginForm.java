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

	public void setUserName(String _userName) {
		this.userName = _userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String _password) {
		this.password = _password;
	}
}
