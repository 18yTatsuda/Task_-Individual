package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.User;

public interface IUserService {

	public User authentication(String name,String pass);
}
