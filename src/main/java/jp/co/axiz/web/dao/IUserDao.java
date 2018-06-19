package jp.co.axiz.web.dao;

import jp.co.axiz.web.entity.User;

public interface IUserDao {

	public User findByNameAndPass(String name,String pass);

}
