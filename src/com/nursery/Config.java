package com.nursery;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config
{
	private static Properties p = new Properties();
	static
	// static代码块自动运行。
	{
		InputStream is = null;
		try
		{
			is = Config.class.getClassLoader().getResourceAsStream(
					"Config.properties");
			if (is != null)
			{
				p.load(is);
			}
		} catch (IOException io)
		{
			io.printStackTrace();
		} finally
		{
			if (is != null)
			{
				try
				{
					is.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public static String get(String key)
	{
		return p.getProperty(key);
	}

	public static String getPath()
	{
		return p.getProperty("FILE_PATH");
	}
}
