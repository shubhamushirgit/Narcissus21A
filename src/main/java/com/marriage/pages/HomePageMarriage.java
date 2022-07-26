package com.marriage.pages;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.jcajce.provider.symmetric.Serpent.TECB;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.reporters.Files;

import com.Keywords.Util.PropUtil;
import com.github.dockerjava.api.model.Driver;
import com.keywordsFramework.Keyword;

public class HomePageMarriage {
	@FindBy(xpath = "//span[contains(text(),\"Language/भाषा\")]")
	public WebElement Language;

	@FindBy(css = "div#navbar-menu>ul>li[class=\"nav-item active\"]>a>font>font")
	public WebElement HomePage;

	@FindBy(css = "div#navbar-menu>ul>li+li>a[href=\"/login\"]>font>font")
	public WebElement Login;

	@FindBy(css = "div#navbar-menu>ul>li+li+li>a[href=\"/packages\"]>font>font")
	public WebElement Register;

	@FindBy(css = "div#navbar-menu>ul>li+li+li+li>a[href=\"/girls\"]")
	public WebElement Girls;

	@FindBy(css = "div#navbar-menu>ul>li+li+li+li+li>a[href=\"/boys\"]>font>font")
	public WebElement Boys;

	@FindBy(css = "div#navbar-menu>ul>li+li+li+li+li+li>a[href=\"/divorcees\"]>font>font")
	public WebElement Divorced;

	@FindBy(css = "div#navbar-menu>ul>li+li+li+li+li+li+li>a[href=\"/widows\"]>font>font")
	public WebElement Widow;

	@FindBy(css = "div#navbar-menu>ul>li+li+li+li+li+li+li+li>a[href=\"/widowers\"]>font>font")
	public WebElement Vidur;

	@FindBy(css = "div#navbar-menu>ul>li>a[href=\"/search\"]>font>font")
	public WebElement search;

	public void HomePage() {
		HomePage.click();
	}

	public void Login() {
		Login.click();
	}

	public void Register() {
		Register.click();
	}

	public void Girls() {

		Girls.click();

	}

	public void SelectLanguage() {
		Language.click();
		WebElement slectLang = Keyword.driver.findElement(By.xpath("//select[@id=\"languageOption\"]"));
		Select by = new Select(slectLang);
		by.selectByIndex(0);
	}

	public void getbirth() throws ParseException, IOException {

		for (int i = 1; i <= 3; i++) {
			if (i != 0) {
				JavascriptExecutor scroll = (JavascriptExecutor) Keyword.driver;
				scroll.executeScript("window.scrollBy(0,1500)");

			}
			WebElement data = Keyword.driver
					.findElement(By.xpath("//div[@class=\"col-xs-12 col-md-6 profile-user user\"][" + i + "]"));

			WebElement date = data.findElement(By.tagName("th").tagName("td"));

			String bdate = date.getText();
			SimpleDateFormat ftm = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
			Date ActualDate = ftm.parse(bdate);

			Date Fromdate = ftm.parse("01/01/1995");
			Date Todate = ftm.parse("01/01/1999");

			if (ActualDate.compareTo(Fromdate) >= 0 & ActualDate.compareTo(Todate) <= 0) {
				String profileID = Keyword.driver.findElement(By.xpath("//div[@data-type=\"Girls\"]/div[" + i + "]"))
						.getText();
				System.out.println(profileID + "***** Valied ***");
				Keyword.driver.findElement(By.xpath("//a[contains(text(),\"View profile\")][" + i + "]")).click();

				String parentwindo = Keyword.driver.getWindowHandle();
				Set<String> chiledwindo = Keyword.driver.getWindowHandles();

				for (String windo : chiledwindo) {
					Keyword.driver.switchTo().window(windo);
					TakesScreenshot ts = (TakesScreenshot) Keyword.driver;
					File src = ts.getScreenshotAs(OutputType.FILE);
					File dest = new File("C:/Users/Amol/Desktop/proflie/profileID.png");
					FileUtils.copyFile(src, dest);

					Keyword.driver.switchTo().window(parentwindo);
				}

			} else {

			}

		}
	}

	public void Boys() {
		Boys.click();
	}

	public void Divorced() {
		Divorced.click();
	}

	public void Widow() {
		Widow.click();
	}

	public void Vidur() {
		Vidur.click();
	}

}
