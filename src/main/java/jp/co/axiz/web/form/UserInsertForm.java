package jp.co.axiz.web.form;

import javax.validation.constraints.NotBlank;

public class UserInsertForm {

	private Integer userId;

	@NotBlank
	private String userName;

	@NotBlank
	private String password;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getpassword() {
		return password;
	}

	public void setUser_pass(String password) {
		this.password = password;
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
		return (userName == null || userName.isEmpty())
				&& (password == null || password.isEmpty())
				&& (nickname == null || nickname.isEmpty());
	}
}
