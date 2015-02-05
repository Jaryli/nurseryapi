package com.nursery.util;

import java.util.Random;

public class StringUtil
{
	/**
	 * 判断字符串是否为空（空字符串或Null）
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value)
	{
		if (value == null || "".equals(value))
		{
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * 判断字符串是否不为空（空字符串或Null）
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNotEmpty(String value)
	{
		return !isEmpty(value);
	}

	public static String getRandomString(int length)
	{
		String base = "abcdefghijklmnopqrstuvwxyz0123456789[]()*&^%$#@!~':";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++)
		{
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String intArrayToString(int[] array)
	{
		if (array == null)
		{
			return "";
		}
		String str = "";
		StringBuilder sb = new StringBuilder();
		for (int a : array)
		{
			sb.append(a).append(',');
		}
		if (sb.length() > 0)
		{
			str = sb.substring(0, sb.length() - 1);
		}
		return str;
	}

	public static int[] stringToIntArray(String str)
	{
		if (isEmpty(str))
		{
			return new int[0];
		}
		String[] sarray = str.split(",");
		int[] iarray = new int[sarray.length];
		for (int i = 0; i < sarray.length; i++)
		{
			iarray[i] = Integer.parseInt(sarray[i]);
		}
		return iarray;
	}

	public static String join(String[] array, String delimiter)
	{
		if (array == null || array.length == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		int length = array.length;
		for (int i = 0; i < length; i++)
		{
			if (i != length - 1)
			{
				sb.append(array[i]).append(delimiter);
			} else
			{
				sb.append(array[i]);
			}
		}
		return sb.toString();
	}
}
