package com.demo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Common {

	public static String getUrl() {
		 try {
			 InputStream in = Common.class.getClassLoader().getResourceAsStream("config.properties");
			 Properties pro = new Properties();
			 pro.load(in);
			 String path=pro.getProperty("path");
			 System.out.println(pro.getProperty("path"));
			 return path;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
