package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.MyAccount_Page;
import appModules.Login_App;
import appModules.MyAccount_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * 
 * <h2 style="text-align:center;">SS_ProfilePage_PersonalInfo_Update</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies updating details on Profile page</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>Email id of the registered user</td></tr>
 * <tr><td>password</td><td>Password for the registered user</td></tr> 
 * <tr><td>updatedField</td><td>Field to be updated(e.g First Name, DOB etc.)</td></tr> 
 * <tr><td>Column name = "updated" appended with field to be updated(e.g updatedFirstName in case of FirstName updation)</td><td>Updated value for that field</td></tr>
 * <tr><td>message1</td><td>Confirmation message after updation</td></tr> 
 * </table>
 * <br>
 * <br>
 * 
 */


public class SS_ProfilePage_PersonalInfo_Update {

	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;


	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info("Test case to be executed: " + sTestCaseName);
		ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
				+ Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);

		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}

	@Test
	public void main() throws Exception {
		try {
			Login_App.execute(iTestCaseRow);
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.profileLink().click();
			Utils.waitForElement(MyAccount_Page.ProfilePage.EditProfileBtn());
			MyAccount_Action.ProfileUpdateOptions(iTestCaseRow);

			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");

		} catch (Exception e) {
			Log.error("Issue in updating details on Profile page");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
			Log.error(e.getMessage());
			throw (e);
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);

		Driver.close();
		Driver.quit();
	}

}
