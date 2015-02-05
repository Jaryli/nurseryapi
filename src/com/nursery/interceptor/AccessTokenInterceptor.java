package com.nursery.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nursery.bean.UserAccessToken;
import com.nursery.cache.AccessTokenCache;

public class AccessTokenInterceptor implements HandlerInterceptor
{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		System.out
				.println("————————————————————————我是拦截器2————————————————————————————————————————");

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception
	{
		// TODO Auto-generated method stub
		System.out
				.println("————————————————————————我是拦截器1————————————————————————————————————————");
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception
	{
		// 缓存的懒加载，有访问才将接入码放入缓存
		String accessToken = request.getHeader("x-access-token");
		UserAccessToken userToken;
		if (AccessTokenCache.contains(accessToken))
		{
			userToken = AccessTokenCache.get(accessToken);
			request.setAttribute("store", userToken);
			return true;
		}
		// TODO：验证token有效性
		userToken = new UserAccessToken();
		AccessTokenCache.put(accessToken, userToken);
		request.setAttribute("userToken", userToken);
		// response.getWriter().print("InvalidAccessToken");
		return true;
	}
}
