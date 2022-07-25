package com.Keyword.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.keywordsFramework.Keyword;

public class HomePage {

	@FindBy(css = "img[alt=\"Firefox Logo\"]")
	public WebElement logo;
	
	@FindBy(css = "a#bikes")
	public WebElement bike;
	
	@FindBy(css = "a#accessories")
	public WebElement accessories;
	
	@FindBy(css = "a[href=\"https://beta.firefoxbikes.com/servicebooking/\"]")
	public WebElement BikeSre ;
	
	@FindBy(css = "a[href=\"https://beta.firefoxbikes.com/gobiking/\"]")
	public WebElement gobiking;
	
	
	public void clickonlogo() {

		logo.click();
		System.out.println("clicked on Logo");
	}
	
	public void clickonbike() {
		
		bike.click();
	}
	
	public void accessories() {
		accessories.click();
	}
	
	public void servicebooking() {
		BikeSre.click();
	}
	public void gobiking() {
		gobiking.click();
		
	}
	public void getTitle() {
		Keyword.gettitel();
	}
	
}
