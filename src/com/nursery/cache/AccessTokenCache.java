package com.nursery.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.nursery.bean.UserAccessToken;

public class AccessTokenCache
{
	private static Map<String, UserAccessToken> map = new HashMap<String, UserAccessToken>();

	public static void put(String key, UserAccessToken token)
	{
		map.put(key, token);
	}

	public static UserAccessToken get(String key)
	{
		return map.get(key);
	}

	public static boolean contains(String key)
	{
		return map.containsKey(key);
	}

	public static void clear()
	{
		map.clear();
	}

	public static String getCacheContent()
	{
		StringBuilder sb = new StringBuilder();
		for (Entry<String, UserAccessToken> entry : map.entrySet())
		{
			sb.append(entry.getKey()).append(":")
					.append(entry.getValue().getId()).append(":")
					.append(entry.getValue().getAccessToken()).append("\r\n");
		}
		return sb.toString();
	}
}
