package com.keywordsFramework;


import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;






import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.safari.SafariDriver;


import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Keyword {
	public static WebDriver driver;
	 
	 
	/**
	 * This keyword can we use for opening for Browser..
	 * @param browsername
	 */
	public static void OpenBrowser(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 Keyword.windosMaximize();
		} else if (browsername.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Keyword.windosMaximize();
		}else if (browsername.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver();
			driver = new SafariDriver();
			Keyword.windosMaximize();
		}else {
			System.err.println("Invalid Browser Name"+browsername);
		}
	 
	}
	/**
	 * This keyword can use for launch the URL
	 * @param url
	 */
	public static void LaunchURL(String url) {
		driver.get(url);
	}
	/**
	 * This keyword can use for get Title of web page..
	 * @return
	 */
	public static String gettitel() {
		return driver.getTitle();
	}
	
	/**
	 * 
	 * @param element
	 */
	public static void clickon(WebElement element ) {
		element.click();
	}
	
	/**
	 * 
	 * @param text
	 */
	public static void clickon(String locator) {
		WebElement element = getWebElement(locator);
		element.click();
	}
	
	public static WebElement getWebElement(String locator) {
		String locatorType = locator.split("##")[0];
		 String locatoValue = locator.split("##")[1];
		 WebElement element =null;
		 if (locatorType.equalsIgnoreCase("xpath")) {
			 element = driver.findElement(By.xpath(locatoValue));
			}else if (locatorType.equalsIgnoreCase("css")) {
				element = driver.findElement(By.cssSelector(locatoValue));
			} else if (locatorType.equalsIgnoreCase(locatoValue)) {
				element = driver.findElement(By.id("id"));
			} else if (locatorType.equalsIgnoreCase("classname")) {
				element = driver.findElement(By.className(locatoValue));
			} else if (locatorType.equalsIgnoreCase("lunktext")) {
				element = driver.findElement(By.linkText(locatoValue));
			} else if(locatorType.equalsIgnoreCase("partiallinktext")){
				element = driver.findElement(By.partialLinkText(locatoValue));
			}else if (locatorType.equalsIgnoreCase("tagname")) {
				element = driver.findElement(By.tagName(locatoValue));
			} else {
				System.err.println("invalid locator");
			}
		return element;
		
	}
	/**
	 * 
	 * @param element
	 */
	public static void clickon(By element, String locator) {
		driver.findElement(element).click();
	}
	/**
	 * 
	 * @param element
	 * @param key
	 * @throws IOException 
	 */
	public static void EnterText( String locator , String key) throws IOException {
		 WebElement element = getWebElement(locator);
		 element.sendKeys(key , Keys.ENTER);
	}
	
	/**
	 * 
	 * @param element
	 */
	public static void hovertoElement(  WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * 
	 */
	public static void windosMaximize() {
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param element
	 */
	public static void clickonSubMenu(WebElement element) {
		Actions action = new Actions(driver);
		
		action.moveToElement(element).click().perform();
	}
	/**
	 * 
	 * @throws IOException
	 */
	public static void captureScreenshort() throws IOException {
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("DDmmyy_HHmmss");
		LocalDateTime ldt = LocalDateTime.now();
		String date = dft.format(ldt);
		TakesScreenshot capture = (TakesScreenshot)driver;
		File src =capture.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:/Users/Amol/Desktop/handling windows/ScreenShots/"+date+"IMG.png");
		Files.copy(src, dest);
	}
	public static java.util.List<WebElement> getWebElements(String locator) {
		String locatorType = locator.split("##")[0];
		 String locatoValue = locator.split("##")[1];
		  java.util.List<WebElement> elements = new ArrayList<WebElement>();
		 if (locatorType.equalsIgnoreCase("xpath")) {
			 elements = driver.findElements(By.xpath(locatoValue));
			}else if (locatorType.equalsIgnoreCase("css")) {
				elements = driver.findElements(By.cssSelector(locatoValue));
			} else if (locatorType.equalsIgnoreCase(locatoValue)) {
				elements = driver.findElements(By.id("id"));
			} else if (locatorType.equalsIgnoreCase("classname")) {
				elements = driver.findElements(By.className(locatoValue));
			} else if (locatorType.equalsIgnoreCase("lunktext")) {
				elements = driver.findElements(By.linkText(locatoValue));
			} else if(locatorType.equalsIgnoreCase("partiallinktext")){
				elements = driver.findElements(By.partialLinkText(locatoValue));
			}else if (locatorType.equalsIgnoreCase("tagname")) {
				elements = driver.findElements(By.tagName(locatoValue));
			} else {
				System.err.println("invalid locator");
			}
		return elements;
	}
	
	public static java.util.List<String> gettextofelement(String locator) {
		java.util.List<WebElement> 	el = getWebElements(locator);
		java.util.List<String> text = new ArrayList<String>();
		for (WebElement element : el) {
			text.add(element.getText());
		}
		return text;
	}
	public static void closeBrowser() {
		driver.close();
		System.out.println("Browser close sucssfullay");
	}
	
	
	
}








