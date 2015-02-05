package com.nursery.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nursery.bean.LoginUser;
import com.nursery.dao.LoginUserDao;

@Repository("loginUserDao")
public class LoginUserDaoImpl implements LoginUserDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<LoginUser> getAllUser()
	{
		List<LoginUser> items = null;
		String sql = "select * from UserTable";
		items = jdbcTemplate.query(sql, new RowMapper<LoginUser>()
		{
			@Override
			public LoginUser mapRow(ResultSet arg0, int arg1)
					throws SQLException
			{
				LoginUser item = new LoginUser();
				item.setUserId(arg0.getInt("UserId"));
				item.setUserName(arg0.getString("UserName"));
				item.setUserTrueName(arg0.getString("UserTrueName"));
				return item;
			}
		});
		return items;
	}

}
