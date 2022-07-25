package com.Keywords.Util;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.keywordsFramework.Keyword;

public class Wait {
	
	public static void impliciteWait(int time) {
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public static void explicitewait( int time , int pollseconds,WebElement elements) {
		WebDriverWait wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(time));
		wait.pollingEvery(Duration.ofSeconds(pollseconds));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	public static void fluentwait(WebElement element,int pollseconds) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Keyword.driver);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.pollingEvery(Duration.ofSeconds(pollseconds));
		wait.ignoring(NoSuchElementException.class);
	}

}
