package com.nursery.util;

import java.util.Random;

/*
 * 根据UserId生成16位认证码
 * */
public class AccessTokenUtil
{
	private static final int USER_LENGTH = 3;
	private static final int TOKEN_LENGTH = 16;

	public static String generateAccessToken(int userId)
	{
		if (userId <= 0)
		{
			return "";
		}
		String userpart = userId + "";
		if (userpart.length() > USER_LENGTH)
		{
			System.err.println("StoreId length should not be greater than "
					+ USER_LENGTH);
			return "";
		} else
		{
			int diff = USER_LENGTH - userpart.length();
			StringBuilder sb = new StringBuilder();
			while (diff > 0)
			{
				sb.append("0");
				diff--;
			}
			sb.append(userpart);
			userpart = sb.toString();
		}

		// 生成密码部分（13位）
		Random random = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TOKEN_LENGTH - USER_LENGTH; i++)
		{
			sb.append(random.nextInt(10));
		}
		String tokenpart = sb.toString();
		return userpart + tokenpart;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(generateAccessToken(212));

	}

}
