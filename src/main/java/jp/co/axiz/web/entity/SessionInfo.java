package jp.co.axiz.web.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value= "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionInfo implements Serializable {
	private static final long serialVersionUID = 6334063099671792256L;

	private User loginUser;
	private User newUser;
	private User prevUser;

	public User getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	public User getNewUser() {
		return newUser;
	}
	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
	public User getPrevUser() {
		return prevUser;
	}
	public void setPrevUser(User prevUser) {
		this.prevUser = prevUser;
	}

	public void invalidate() {
		loginUser = null;
		newUser = null;
		prevUser = null;
	}
}
