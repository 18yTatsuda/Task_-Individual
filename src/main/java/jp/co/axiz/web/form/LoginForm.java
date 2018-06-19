package jp.co.axiz.web.form;

import javax.validation.constraints.NotBlank;

public class LoginForm {

	@NotBlank
	private String loginName;

	@NotBlank
	private String pass;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}



}
