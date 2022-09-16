package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;
	
	public SignInPage(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(linkText = "Sign in")
	WebElement signInLink;
	
	public WebElement getSignInLink() {
		return signInLink;
	}
	
	@FindBy(id = "id_login")
	WebElement UserEmail;
	
	public WebElement getUserEmail() {
		return UserEmail;
		
	}
	
	@FindBy(id = "id_password")
	WebElement password;
	 
	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]")
	WebElement SignInBtn;
	
	public WebElement getSignInBtn() {
		return SignInBtn;
	}
	
	@FindBy(linkText = "Problems")
	WebElement problemsLink;
	
	public WebElement getProblemsLink() {
		return problemsLink;
	}
}
