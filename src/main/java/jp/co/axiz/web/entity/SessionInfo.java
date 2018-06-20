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
	private ImageInfo newImage;
	private ImageInfo prevImage;
	private ImageInfo afterImage;

	public User getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	public ImageInfo getNewImage() {
		return newImage;
	}
	public void setNewImage(ImageInfo newImage) {
		this.newImage = newImage;
	}
	public ImageInfo getPrevImage() {
		return prevImage;
	}
	public void setPrevImage(ImageInfo prevImage) {
		this.prevImage = prevImage;
	}

	public ImageInfo getAfterImage() {
		return afterImage;
	}

	public void setAfterImage(ImageInfo _afterImage) {
		afterImage = _afterImage;
	}

	public User getNewUser() {
		return newUser;
	}
	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public void invalidate() {
		loginUser = null;
		newUser = null;
		newImage = null;
		prevImage = null;
		afterImage = null;
	}
}
