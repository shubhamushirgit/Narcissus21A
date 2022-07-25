package com.Keywords.Util;


import java.awt.Window;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;

import com.keywordsFramework.Keyword;

public class PropUtil {

	public static String getlocator(String locator) throws IOException {
		String fileName = "/src/test/resources/ObjectRepositoy.properties";
		return getProperties(fileName, locator)	;
	}
	
	public static String getEnviroment(String key) throws IOException {
		String fileName ="/src/main/resources/Enviroment.properties";
		return getProperties(fileName, key);
	}
	
	public static String getProperties(String fileName , String key) throws IOException {
		String dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(dir+fileName);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	

}
