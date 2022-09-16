package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
@Test(priority = 0)
public class TC_Leetcode_SignIn_001 extends TestBase {
	public void SignIn() throws InterruptedException{
		signIn.getSignInLink().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		signIn.getUserEmail().sendKeys(prop.getProperty("mailId"));
		signIn.getPassword().sendKeys(prop.getProperty("Password"));
		signIn.getSignInBtn().click();
		String homeTitle = driver.getTitle();
		if(homeTitle.equals("Account Login - LeetCode")) {
			Assert.assertTrue(homeTitle.equals("Account Login - LeetCode"));
			System.out.println("User signed in successfully");
		}
		else {
			System.out.println("Invalid! user signed in failed");
			Assert.assertTrue(homeTitle.equals("Account Login - LeetCode"));
		}
		Thread.sleep(5000);
		signIn.getProblemsLink().click();
		Thread.sleep(5000);
		
		String title = driver.getTitle();
		if(title.equals("Problems - LeetCode")) {
			Assert.assertTrue(title.equals("Problems - LeetCode"));
			System.out.println("User is on Problems page");
		}
		else {
			System.out.println("User is not on Problems page");
			Assert.assertTrue(title.equals("Problems - LeetCode"));
		}
	}

}
