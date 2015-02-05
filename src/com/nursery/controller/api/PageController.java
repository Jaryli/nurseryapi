package com.nursery.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController
{

	@RequestMapping(value = "{view}.html", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public String view(@PathVariable String view, HttpServletRequest request,
			HttpServletResponse response)
	{
		return view;
	}
}
