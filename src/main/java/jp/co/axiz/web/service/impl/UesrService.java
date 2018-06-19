package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.impl.UserDao;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.IUserService;

@Service
@Transactional
public class UesrService implements IUserService{

	@Autowired
	private UserDao userDao;

	@Override
	public User authentication(String name, String pass) {
		return userDao.findByNameAndPass(name, pass);
	}

}
