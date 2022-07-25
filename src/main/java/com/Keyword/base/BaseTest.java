package com.Keyword.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Keywords.Util.Enviroment;
import com.keywordsFramework.Keyword;

public class BaseTest {

	Keyword keywords = new Keyword();

	@BeforeMethod
	public void setup() throws IOException {
		Keyword.OpenBrowser(Enviroment.getBrowserName());
		String env = System.getProperty("env");
		keywords.LaunchURL(Enviroment.getUrl(env));
	}

	@AfterMethod
	public void tearDown() {
		/*keywords.closeBrowser();*/

	}
}
