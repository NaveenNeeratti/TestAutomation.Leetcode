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

public class TC_ProblemsSearchTag_008 extends TC_Leetcode_SignIn_001{
	List<String> actualResult;
	List<String> expectedResult;
	
	@Test(priority = 2,dataProvider = "getData")
	public void searchTag(String searchTerm) throws InterruptedException, IOException{
		initExpectedResult();
		actualResult = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", searchTag.getSearchTagField());
		Thread.sleep(3000);
		searchTag.getSearchTagField().clear();
		boolean searchField = searchTag.getSearchTagField().isDisplayed();
		if(searchField) {
			Assert.assertTrue(searchField);
			System.out.println("SearchTag field is present");
			searchTag.getSearchTagField().sendKeys(searchTerm);
			List<WebElement> searchedResult = searchTag.getSearchedTagEle();
			for(int i = 0;i<searchedResult.size();i++) {
				actualResult.add(searchedResult.get(i).getText());
			}
		}
		else {
			captureScreenshot(driver,"searchTag");
			Assert.assertTrue(searchField,"searchTag field is not present");
		}
		
		Assert.assertTrue(expectedResult.containsAll(actualResult));
		actualResult.clear();
	}
	
	@DataProvider
	public String[][] getData() throws IOException{
		String XLPath = "C:\\Users\\neera\\eclipse-workspace\\TestAutomation.Leetcode\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String XSheetName ="Sheet1";
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
	
	public void initExpectedResult() {
		expectedResult = new ArrayList<String>();
		expectedResult.add("Apple");
		expectedResult.add("AppDynamics");
		expectedResult.add("Works Applications");
		expectedResult.add("Zappos");
		expectedResult.add("Dell");
		expectedResult.add("Deloitte");
		expectedResult.add("Citadel");
		expectedResult.add("Oracle");
		expectedResult.add("Quora");
		expectedResult.add("Pure Storage");
		expectedResult.add("Salesforce");
		expectedResult.add("Quip (Salesforce)");
		
	}
}
