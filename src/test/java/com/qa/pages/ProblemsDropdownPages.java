package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProblemsDropdownPages {
	WebDriver driver;
	public ProblemsDropdownPages(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//To find all dropdowns
	@FindAll(@FindBy(xpath = "//div[@class = 'mb-3 flex flex-col']/descendant::div[@class='relative']"))
	List<WebElement> dropdownELe;
	public List<WebElement> getDropdown(){
		return dropdownELe;
	}

	//To find Elements in the respective dropdown
	@FindAll(@FindBy(xpath = "//div[@role='menu']/descendant::div[@class='truncate overflow-hidden']"))
	List<WebElement> resDropdownELe;
	public List<WebElement> getDropdownEle(){
		return resDropdownELe;
	}

	//To find Elements in tag Dropdown
	@FindAll(@FindBy(xpath = "//div[@class = 'block']/descendant::span"))
	List<WebElement> tagDropdownELe;
	public List<WebElement> getTagDropdownEle(){
		return tagDropdownELe;
	}

	//To find result elements upon selection of a value in dropdown
	@FindAll(@FindBy(xpath = "//div[@role = 'rowgroup']/descendant::div[@class = 'truncate overflow-hidden']"))
	List<WebElement> dropdownResult;
	public List<WebElement> getDropdownResult(){
		return dropdownResult;
	}

	//To get reset button
	@FindBy(xpath = "//body/div[@id = '__next']/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[2]/*[1]")
	WebElement reset;
	public WebElement getResetButton(){
		return reset;
	}

}
