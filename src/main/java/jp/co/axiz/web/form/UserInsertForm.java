package jp.co.axiz.web.form;

import javax.validation.constraints.NotBlank;

public class UserInsertForm {

	private Integer userId;

	@NotBlank
	private String userName;

	@NotBlank
	private String user_pass;

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

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
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
				&& (user_pass == null || user_pass.isEmpty())
				&& (nickname == null || nickname.isEmpty());
	}
}
