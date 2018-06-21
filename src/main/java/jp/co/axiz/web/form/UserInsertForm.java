package jp.co.axiz.web.form;

import javax.validation.constraints.NotBlank;

public class UserInsertForm {

	private Integer userId;

	@NotBlank
	private String user_name;

	@NotBlank
	private String user_pass;

	@NotBlank
	private String confirmPassword;

	@NotBlank
	private String nickname;

	private String email;

	private String memo;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}


	public boolean isEmpty() {
		return (user_name == null || user_name.isEmpty())
				&& (user_pass == null || user_pass.isEmpty())
				&& (nickname == null || nickname.isEmpty());
	}
}
