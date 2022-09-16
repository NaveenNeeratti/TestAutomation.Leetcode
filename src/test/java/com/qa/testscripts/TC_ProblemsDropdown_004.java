package com.qa.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_ProblemsDropdown_004 extends TC_Leetcode_SignIn_001{
	List<String> actualDropEle;
	List<String> actualResult;
	List<String> expectedResult;
	List<String> expectedListELe;
	List<String> expectedDiffEle;
	List<String> expectedStatusEle;
	List<String> expectedTagELe;
	@Test(priority = 1,dataProvider = "getData")
	public void dropdownSelection(String listElement,String diffELement,String statusElement,String tagElement) throws IOException, InterruptedException {
		initialiseExpectedResult();
		actualDropEle = new ArrayList<String>();
		actualResult = new ArrayList<String>();
		
		//To get WebElements of all dropdowns
		List<WebElement> dropdowns = dropPage.getDropdown();
		
		//For List Dropdown
		WebElement listDropdown = dropdowns.get(0);
		//To Scroll down to the webelement
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", dropdowns.get(0));
		
		if(listDropdown.isDisplayed()) {
			Assert.assertTrue(listDropdown.isDisplayed());
			System.out.println("List dropdown is present");
			listDropdown.click();
			Thread.sleep(2000);
			//To verify whether list dropdown contains all elements
			List<WebElement> listDropdownEle = dropPage.getDropdownEle();
			for(WebElement element : listDropdownEle) {
				actualDropEle.add(element.getText());
			}
			Assert.assertEquals(actualDropEle, expectedListELe,"List dropdown does not contains all ELements");
			System.out.println("List dropdown contains all Elements");
			actualDropEle.clear();
			//To select the dropdown element
			for(int i =0;i<listDropdownEle.size();i++) {
				if(listDropdownEle.get(i).getText().contains(listElement)) {
					listDropdownEle.get(i).click();
					break;
				}
			}
			
		}
		else {
			captureScreenshot(driver,"dropdownSelection");
			Assert.assertTrue(listDropdown.isDisplayed(),"List dropdown is not present");
		}
		Thread.sleep(3000);
		
		
		//For Difficulty Dropdown
				WebElement diffDropdown = dropdowns.get(1);
				if(diffDropdown.isDisplayed()) {
					Assert.assertTrue(diffDropdown.isDisplayed());
					System.out.println("Difficulty dropdown is present");
					diffDropdown.click();
					Thread.sleep(2000);
					//To verify whether difficulty dropdown contains all elements
					List<WebElement> diffDropdownEle = dropPage.getDropdownEle();
					for(WebElement element :diffDropdownEle) {
						actualDropEle.add(element.getText());
					}
					Assert.assertEquals(actualDropEle, expectedDiffEle,"Difficulty dropdown does not contains all ELements");
					System.out.println("Difficulty dropdown contains all Elements");
					actualDropEle.clear();
					//To select the dropdown element
					for(int i =0;i<diffDropdownEle.size();i++) {
						if(diffDropdownEle.get(i).getText().contains(diffELement)) {
							diffDropdownEle.get(i).click();
							break;
						}
					}
					
				}
				else {
					captureScreenshot(driver,"dropdownSelection");
					Assert.assertTrue(diffDropdown.isDisplayed(),"Difficulty dropdown is not present");
				}
				Thread.sleep(3000);
				
				//For Status Dropdown
				WebElement statusDropdown = dropdowns.get(2);
				if(statusDropdown.isDisplayed()) {
					Assert.assertTrue(statusDropdown.isDisplayed());
					System.out.println("Status dropdown is present");
					statusDropdown.click();
					Thread.sleep(2000);
					//To verify whether Status dropdown contains all elements
					List<WebElement> statusDropdownEle = dropPage.getDropdownEle();
					for(WebElement element :statusDropdownEle) {
						actualDropEle.add(element.getText());
					}
					Assert.assertEquals(actualDropEle, expectedStatusEle,"Status dropdown does not contains all ELements");
					System.out.println("Status dropdown contains all Elements");
					actualDropEle.clear();
					//To select the dropdown element
					for(int i =0;i<statusDropdownEle.size();i++) {
						if(statusDropdownEle.get(i).getText().contains(statusElement)) {
							statusDropdownEle.get(i).click();
							break;
						}
					}
					
				}
				else {
					captureScreenshot(driver,"dropdownSelection");
					Assert.assertTrue(statusDropdown.isDisplayed(),"Status dropdown is not present");
				}
				Thread.sleep(3000);
				
				//For Tag Dropdown
				WebElement tagDropdown = dropdowns.get(3);
				if(tagDropdown.isDisplayed()) {
					Assert.assertTrue(tagDropdown.isDisplayed());
					System.out.println("Tag dropdown is present");
					tagDropdown.click();
					Thread.sleep(2000);
					//To verify whether tag dropdown contains all elements
					List<WebElement> tagDropdownEle = dropPage.getTagDropdownEle();
					for(WebElement element :tagDropdownEle) {
						actualDropEle.add(element.getText());
					}
					Assert.assertTrue(actualDropEle.containsAll(expectedTagELe),"Tag dropdown does not contains all ELements");
					System.out.println("Tag dropdown contains all Elements");
					actualDropEle.clear();
					//To select the dropdown element
					for(int i =0;i<tagDropdownEle.size();i++) {
						if(tagDropdownEle.get(i).getText().contains(tagElement)) {
							tagDropdownEle.get(i).click();
							break;
						}
					}
					
				}
				else {
					captureScreenshot(driver,"dropdownSelection");
					Assert.assertTrue(tagDropdown.isDisplayed(),"Tag dropdown is not present");
				}
				Thread.sleep(3000);
				//To check whether it displays correct relevant questions
				List<WebElement> dropdownResult = dropPage.getDropdownResult().subList(0, 3);
				for(WebElement item : dropdownResult) {
					actualResult.add(item.getText());
				}
				if(expectedResult.containsAll(actualResult)) {
					Assert.assertTrue(expectedResult.containsAll(actualResult));
					System.out.println("Displayed relevant questions");
				}
				else {
					captureScreenshot(driver,"dropdownSelection");
					Assert.assertTrue(expectedResult.containsAll(actualResult),"Displayed non relevant questions");
				}
				 
				Thread.sleep(2000);
				//To reset dropdown selections
				dropPage.getResetButton().click();
				
				
	}
	
	@DataProvider
	public String[][] getData() throws IOException{
		String XLPath = "C:\\Users\\neera\\eclipse-workspace\\TestAutomation.Leetcode\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String XSheetName = "Sheet2";
		
		int rowCount = ExcelUtility.getRowCount(XLPath, XSheetName);
		int cellCount = ExcelUtility.getCellCount(XLPath, XSheetName, rowCount);
		String[][] data = new String[rowCount][cellCount];
		
		for(int i = 1;i<=rowCount;i++) {
			for(int j = 0;j<cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellData(XLPath, XSheetName, i, j);
			}
		}
		return data;
		
	}
	
	public void initialiseExpectedResult() {
		expectedListELe = new ArrayList<String>();
		expectedListELe.add("LeetCode Curated Algo 170");
		expectedListELe.add("LeetCode Curated SQL 70");
		expectedListELe.add("Top 100 Liked Questions");
		expectedListELe.add("Top Interview Questions");
		expectedListELe.add("Favorite");
		expectedDiffEle = new ArrayList<String>();
		expectedDiffEle.add("Easy");
		expectedDiffEle.add("Medium");
		expectedDiffEle.add("Hard");
		expectedStatusEle = new ArrayList<String>();
		expectedStatusEle.add("Todo");
		expectedStatusEle.add("Solved");
		expectedStatusEle.add("Attempted");
		expectedTagELe = new ArrayList<String>();
		expectedTagELe.add("Array");
		expectedTagELe.add("String");
		expectedTagELe.add("Hash Table");
		expectedTagELe.add("Dynamic Programming");
		expectedResult = new ArrayList<String>();
		expectedResult.add("1457. Pseudo-Palindromic Paths in a Binary Tree");
		expectedResult.add("163. Missing Ranges");
		expectedResult.add("170. Two Sum III - Data structure design");
		expectedResult.add("534. Game Play Analysis III");
		expectedResult.add("550. Game Play Analysis IV");
		expectedResult.add("13. Roman to Integer");
		expectedResult.add("14. Longest Common Prefix");
		
	}
	
}
