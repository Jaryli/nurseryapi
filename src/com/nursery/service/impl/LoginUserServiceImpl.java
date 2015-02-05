package com.nursery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.bean.LoginUser;
import com.nursery.dao.LoginUserDao;
import com.nursery.service.LoginUserService;

@Service("loginUserService")
public class LoginUserServiceImpl implements LoginUserService
{
	@Autowired
	private LoginUserDao loginUserDao;

	@Override
	public List<LoginUser> getAllUser()
	{
		return loginUserDao.getAllUser();
	}
}
