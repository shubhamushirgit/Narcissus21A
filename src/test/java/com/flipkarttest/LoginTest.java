package com.flipkarttest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Keyword.base.BaseTest;
import com.Keyword.pages.HomePage;
import com.Keywords.Util.Locators;
import com.Keywords.Util.PropUtil;
import com.keywordsFramework.Keyword;
import com.marriage.pages.HomePageMarriage;

/**
 * 
 * @author Amol
 *
 */
public class LoginTest extends BaseTest {

	/*
	 * @Test(description = "with framework") public void verifyTitle() {
	 * 
	 * String actual = Keyword.driver.getTitle(); String expected =
	 * "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
	 * SoftAssert softly = new SoftAssert(); softly.assertEquals(actual, expected);
	 * }
	 * 
	 * @Test public void Mentab() throws InterruptedException, IOException {
	 * 
	 * Keyword.windosMaximize();
	 * 
	 * WebElement men =
	 * Keyword.driver.findElement(By.xpath(PropUtil.getlocator("mentab")));
	 * Keyword.hovertoElement(men); Thread.sleep(4000); WebElement sub =
	 * Keyword.driver.findElement(By.xpath(PropUtil.getlocator("mensubtab")));
	 * Keyword.clickonSubMenu(sub); Keyword.captureScreenshort(); }
	 * 
	 * @Test public void getverifysearchproducttitel() throws IOException {
	 * 
	 * Keyword.EnterText(Locators.searchproduts, "Men T-Shirts"); List<String>
	 * titles = Keyword.gettextofelement(Locators.produt); SoftAssert softly = new
	 * SoftAssert(); for (String title : titles) {
	 * softly.assertTrue(title.contains(title) ||
	 * title.contains("t-shirtsHRX by Hrithik Roshan") ||
	 * title.contains("t-shirtsRoadster") || title.contains("t-shirtsCalvin")||
	 * title.contains("t-shirtsUrbano Fashion"),"titel doesnt contents t-shirts"
	 * +title); } softly.assertAll();
	 * 
	 * 
	 * }
	 */

	@Test
	public void clickonbikes() {
		HomePage home = PageFactory.initElements(Keyword.driver, HomePage.class);
		home.clickonbike();

	}


	
}
