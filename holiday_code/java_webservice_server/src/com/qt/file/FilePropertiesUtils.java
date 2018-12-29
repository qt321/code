package com.qt.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FilePropertiesUtils
{
	public static String getImageUtilPath()
	{
		Properties p=new Properties();
		
		try
		{
			p.load(new FileInputStream("./application.properties"));
		
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p.getProperty("imgurl");
	}

}
