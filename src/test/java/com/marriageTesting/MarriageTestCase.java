package com.marriageTesting;

import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Keyword.base.BaseTest;
import com.keywordsFramework.Keyword;
import com.marriage.pages.HomePageMarriage;

public class MarriageTestCase extends BaseTest {
	
	@Test
	public void clickongirl() throws ParseException {
	HomePageMarriage home =	PageFactory.initElements(Keyword.driver, HomePageMarriage.class);
		home.SelectLanguage();
		home.Girls();
		home.getbirth();
		
	}

}
