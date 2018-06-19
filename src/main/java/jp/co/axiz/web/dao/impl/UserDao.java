package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.IUserDao;
import jp.co.axiz.web.entity.User;

@Repository
public class UserDao implements IUserDao {

	 @Autowired
	    private NamedParameterJdbcTemplate nPjT;

	@Override
	public User findByNameAndPass(String name, String pass) {
		String sql = "SELECT * FROM users WHERE user_name = :userName AND password = :pass";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userName", name);
		param.addValue("pass", pass);

		List<User> resultList = nPjT.query(sql, param,new BeanPropertyRowMapper<User>(User.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}
}
