package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProblemsSearchTagPages {
WebDriver driver;
	
	public ProblemsSearchTagPages(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath = "//body/div[@id='__next']/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/input[1]")
	WebElement searchTagField;
	
	public WebElement getSearchTagField() {
		return searchTagField;
	}
	
	@FindAll(@FindBy(xpath = "//div[@class = 'swiper-wrapper']/descendant::a/descendant::span[@class = 'font-medium text-label-2 dark:text-dark-label-2']"))
	List<WebElement> searchedTagEle;
	
	public List<WebElement> getSearchedTagEle(){
		return searchedTagEle;
	}
}
