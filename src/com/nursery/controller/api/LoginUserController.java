package com.nursery.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nursery.bean.LoginUser;
import com.nursery.service.LoginUserService;

@Controller
public class LoginUserController
{

	@Autowired
	private LoginUserService loginUserService;

	/*
	 * 
	 */
	@RequestMapping(value = "getAllUser", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<LoginUser> getList()
	{
		System.out.println("asdfasdfasdf!!!");
		return loginUserService.getAllUser();
	}
}
