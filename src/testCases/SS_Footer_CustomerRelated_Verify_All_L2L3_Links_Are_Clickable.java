package testCases;

import javax.mail.internet.InternetAddress;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import appModules.HomePage_Action;
import appModules.PLP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.PDFReport;
import utility.Utils;
import utility.JyperionListener;


/**
 * 
 * <h2 style="text-align:center;">SS_Footer_CustomerRelated_Verify_All_Links_Are_Clickable</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies Customer Related Footer links</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */ 
@Listeners(JyperionListener.class)
public class SS_Footer_CustomerRelated_Verify_All_L2L3_Links_Are_Clickable {

	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeSuite
	public void setSnapShotFolder() throws Exception {
		Utils.setSnapshotFolder();

	}

	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");

		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info(sTestCaseName + " Test case to be excuted");
		ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
				+ Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);

		Log.info("New driver instantiated " + iTestCaseRow);
		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}

	@Test
	public void main() throws Exception {
		try {
			Log.info("Verification check has been completed for FooterLinks related to Customer- Public View started");
			
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product category selected successfully");
			HomePage_Action.FooterLinkVerification_AppDownload_Public(iTestCaseRow);
			Thread.sleep(3000);
			PLP_Action.PLP_Verify_Select_Brand_Functionality(iTestCaseRow);
			HomePage_Action.FooterLinkVerification_AppDownload_Public(iTestCaseRow);
			Thread.sleep(3000);
			PLP_Action.PLP__Select_Color_Functionality(iTestCaseRow);
			HomePage_Action.FooterLinkVerification_AppDownload_Public(iTestCaseRow);
			Thread.sleep(3000);
			Home_Page.Footer_Section.Brand_Link().click();
			HomePage_Action.FooterLinkVerification_AppDownload_Public(iTestCaseRow);
			Thread.sleep(2000);
			Home_Page.Footer_Section.Discover_Link().click();
			HomePage_Action.FooterLinkVerification_AppDownload_Public(iTestCaseRow);
			Thread.sleep(2000);
			Home_Page.Footer_Section.Offers_Link().click();
			HomePage_Action.FooterLinkVerification_AppDownload_Public(iTestCaseRow);
			
			

			if (BaseClass.bResult == true) {

				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			} else {

				throw new Exception("Test Case Failed because of Verification");
			}

		} catch (Exception e) {
			Log.info("Verification check has been completed for FooterLinks related to Customer- Public View failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
			Log.error(e.getMessage());
			throw e;
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);

		Driver.close();
		Driver.quit();
	}

	@AfterSuite
	public void tearDown() throws Exception {
		PDFReport.sendPDFReportByGMail(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("from"),
				Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("password"),
				InternetAddress.parse(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("to")),
				Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("subject"), "");
	}

}
