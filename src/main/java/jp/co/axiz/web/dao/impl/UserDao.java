package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

	@Override
	public int register(User user) {
		String sql = "INSERT INTO users (user_name ,password ,nickname ,email ,memo) VALUES (:user_name,:password,:nickname,:email,:memo))";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userName", user.getUserName());
		param.addValue("password", user.getPassword());
		param.addValue("nickname", user.getNickName());
		param.addValue("email", user.getEmail());
		param.addValue("memo", user.getMemo());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		nPjT.update(sql, param,keyHolder,new String[] {"user_id"});
		return keyHolder.getKey().intValue();
	}
}
