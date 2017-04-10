package appModules;

import java.util.List;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import pageObjects.MyAccount_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class MyAccount_Action {
	public static String sTAGNAME;
	public static boolean cResult;

	public static void ProfileUpdateOptions(int iTestCaseRow) throws Exception {

		try {

			MyAccount_Page.ProfilePage.EditProfileBtn().click();
			Thread.sleep(5000);
			Log.info("Edit profile button is clicked");
           // Utils.NewWindowAction();
			String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			LogIn_Page.Profile_update_User_Pwd().sendKeys(sPassword);
			Log.info(sPassword + " is entered in user password field");
			Thread.sleep(2000);
			LogIn_Page.Profile_upt_submit_bt().click();
			Log.info("Button is entered in user password field");
			Thread.sleep(5000);
			if ("FirstName".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				// Selecting the link profile from Home Page under Top
				// Navigation

				String FirstName = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedFirstName);
				MyAccount_Page.ProfilePage.FirstName().clear();
				MyAccount_Page.ProfilePage.FirstName().sendKeys(FirstName);

				Log.info("First Name is entered on Profile Page");

			}

			if ("LastName".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				// Selecting the link profile from Home Page under Top
				// Navigation

				String LastName = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedLastName);
				Utils.scrollingToPageElementAdvanced(MyAccount_Page.ProfilePage.HomeStore());
				MyAccount_Page.ProfilePage.LastName().clear();
				MyAccount_Page.ProfilePage.LastName().sendKeys(LastName);

				Log.info("Last Name is entered on Profile Page");

			}

			if ("MobileNumber".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				String MobileNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedMobile);
				MyAccount_Page.ProfilePage.MobileNumber().clear();
				MyAccount_Page.ProfilePage.MobileNumber().sendKeys(MobileNumber);

				Log.info("MobileNumber is entered on Profile Page");
			}

			if ("HomeStore".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				String HomeStore = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedHomeStore);

				Select store = new Select(MyAccount_Page.ProfilePage.HomeStore());
				store.selectByVisibleText(HomeStore);

				Log.info("HomeStore is selected on Profile Page");
			}

			if ("DOB".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				MyAccount_Page.ProfilePage.DOBCalanderBtn().click();
				String year = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedYear);
				String monthvalue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedMonth);
				String date = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedDate);

				if (!year.equals("")) {
					Select DOBYear = new Select(MyAccount_Page.ProfilePage.Calender.Year());
					DOBYear.selectByValue(year);
					Log.info("Year value is selected on Profile Page");
				}

				if (!monthvalue.equals("")) {
					Select DOBmonth = new Select(MyAccount_Page.ProfilePage.Calender.Month());
					DOBmonth.selectByVisibleText(monthvalue);
					Log.info("Month value is selected on Profile Page");
				}

				if (!date.equals("")) {
					WebElement dateWidget = MyAccount_Page.ProfilePage.Calender.DateTable();
					List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

					// comparing the text of cell with today's date and clicking
					// it.
					for (WebElement cell : columns) {
						if (cell.getText().equals(date)) {
							Utils.mouseHover(cell);
							cell.click();
							Log.info("Date value is selected on Profile Page");
							break;
						}
					}
				}

				Log.info("DOB is entered on Profile Page");
			}

			if ("".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				Log.error("Value for profile page updation attribute is Blank");
				throw new Exception("Value for profile page updation attribute is Blank");

			}

			MyAccount_Page.ProfilePage.ProfileUpdateDetails_Button().click();
			Log.info("Profile update button is clicked");
			Thread.sleep(2000);
			String UpdateMsg = MyAccount_Page.GlobalMsg().getText().trim();

			if (ExcelUtils.getCellData(iTestCaseRow, Constant.message1).equals(UpdateMsg)) {
				Log.info("Verfication Passed :Profile page has been updated successfully");

			} else {
				Log.error("Verfication Failed :Profile page not been been updated successfully");
			}

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method ProfileUpdateOptions");
			Log.error("Issue with Profile updation");
			throw (e);

		}

	}

	public static void Change_Password(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.profileLink().click();
			Log.info("Profile menu is clicked");
			MyAccount_Page.ProfilePage.Settings().click();
			Log.info("Settings link is clicked");
			MyAccount_Page.ProfilePage.ChangePassword().click();
			Log.info("Change password button is clicked");
			String CurrentPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			MyAccount_Page.ProfilePage.ChangePassword_CurrentPassword().sendKeys(CurrentPassword);
			Log.info("Current password value is entered");
			String NewPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedPassword);
			MyAccount_Page.ProfilePage.ChangePassword_NewPassword().sendKeys(NewPassword);
			Log.info("New password value is entered");
			MyAccount_Page.ProfilePage.ChangePassword_NewPasswordConfirm().sendKeys(NewPassword);
			Log.info("Confirm New password value is entered");
			MyAccount_Page.ProfilePage.UpdatePassword_Btn().click();
			Log.info("Update password button is clicked");
			Utils.waitForElement(MyAccount_Page.ProfilePage.ChangePassword());
			
			// Log.info(MyAccount_Page.ProfilePage.ProfileUpdateMeessage);
			Log.info(MyAccount_Page.GlobalMsg().getText());
			if (ExcelUtils.getCellData(iTestCaseRow, Constant.message1).equals(MyAccount_Page.GlobalMsg().getText().trim())) {
				Log.info("Verfication Passed :Profile page has been updated successfully");

			} else {
				Log.info("Verfication Failed :Profile page not been been updated successfully");
				throw new Exception("Profile page not been been updated successfully");
			}

			Log.info("Password changed successfully");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Change_Password");
			Log.error("Password has not been changed");
			throw (e);

		}

	}

	public static void Change_Password_Verify_Fields(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.profileLink().click();
			Log.info("Profile menu link is clicked");
			MyAccount_Page.ProfilePage.Settings().click();
			Log.info("Settings link is clicked");
			MyAccount_Page.ProfilePage.ChangePassword().click();
			Log.info("Change password button is clicked");
			Log.info("Veifying presence of all the fields - Current pwd, New pwd and Confirm new pwd");
			Utils.waitForElement(MyAccount_Page.ProfilePage.ChangePassword_CurrentPassword());
			Utils.waitForElement(MyAccount_Page.ProfilePage.ChangePassword_NewPassword());
			Utils.waitForElement(MyAccount_Page.ProfilePage.ChangePassword_NewPasswordConfirm());

			Log.info("Verification Passed: All fields are present.");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Change_Password_Verify_Fields");
			Log.error("Fields Verification failed");
			throw (e);
		}

	}

	public static void Change_Password_Verify_buttons(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.profileLink().click();
			Log.info("Profile menu link is clicked");
			MyAccount_Page.ProfilePage.Settings().click();
			Log.info("Settings link is clicked");
			MyAccount_Page.ProfilePage.ChangePassword().click();
			Log.info("Change password button is clicked");
			Log.info("Veifying presence of all the buttons - Update password and Cancel");
			Utils.waitForElement(MyAccount_Page.ProfilePage.UpdatePassword_Btn());
			Utils.waitForElement(MyAccount_Page.ProfilePage.Cancel_Btn());

			Log.info("Verification Passed: All buttons are present.");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Change_Password_Verify_buttons");
			Log.error("Button Verification failed");
			throw (e);
		}

	}

	public static void Verify_MyAccountLinks(int iTestCaseRow) throws Exception {

		try {

			MyAccount_Page.MyAccount_LeftMenu.MyShoppersStop().click();
			Log.info("MyShoppersStop button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Orders().click();
			Log.info("Orders button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Alerts().click();
			Log.info("Alerts button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Wishlist().click();
			Log.info("Wishlist button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Profile().click();
			Log.info("Profile button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.FirstCitizenProfile().click();
			Log.info("FirstCitizenProfile button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Personalization().click();
			Log.info("Personalization button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.ReviewsRatings().click();
			Log.info("ReviewsRatings button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Feedback().click();
			Log.info("Feedback button is clicked");

			Log.info("Verification check has been completed for all the present links on the Accounts Menu");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_MyAccountLinks");
			Log.info("Verification check Failed to check presence of links on the Account Menu");

			throw (e);

		}

	}

	public static void Profile_Add_Address(int iTestCaseRow) throws Exception {

		try {
			MyAccount_Page.ProfilePage.AddNewAddress().click();
			Log.info("Add new address button is clicked");

			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			MyAccount_Page.ProfilePage.Address.FirstName().sendKeys(firstName);
			Log.info("First name value is entered");

			String postCode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			MyAccount_Page.ProfilePage.Address.PostCode().sendKeys(postCode);
			Log.info("PostCode value is entered");

			String address = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			MyAccount_Page.ProfilePage.Address.Address1().sendKeys(address);
			Log.info("Address value is entered");

			String city = ExcelUtils.getCellData(iTestCaseRow, Constant.city);
			MyAccount_Page.ProfilePage.Address.City().sendKeys(city);
			Log.info("City value is entered");

			String landmark = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			MyAccount_Page.ProfilePage.Address.Landmark().sendKeys(landmark);
			Log.info("Landmark value is entered");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			MyAccount_Page.ProfilePage.Address.Phone().sendKeys(phone);
			Log.info("Phone value is entered");

			MyAccount_Page.ProfilePage.Address.AddAddressBtn().click();
			Log.info("Add address button is clicked");

			Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Profile_Add_Address");
			Log.error("Address is not entered successfully");
			throw (e);

		}

	}

	public static void Profile_Add_Multiple_Address(int iTestCaseRow) throws Exception {

		try {
			//MyAccount_Action.Profile_Add_Address(iTestCaseRow);

			MyAccount_Page.ProfilePage.AddNewAddress().click();
			Log.info("Add new address button is clicked");

			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeFirstName);
			MyAccount_Page.ProfilePage.Address.FirstName().sendKeys(firstName);
			Log.info("First name value is entered");
			
			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeLastName);
			MyAccount_Page.ProfilePage.Address.LastName().sendKeys(lastName);
			Log.info("First name value is entered");

			String postCode = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativePostCode);
			MyAccount_Page.ProfilePage.Address.PostCode().sendKeys(postCode);
			Log.info("PostCode value is entered");

			String address = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeAddress);
			MyAccount_Page.ProfilePage.Address.Address1().sendKeys(address);
			Log.info("Address value is entered");

			String city = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeCity);
			MyAccount_Page.ProfilePage.Address.City().sendKeys(city);
			Log.info("City value is entered");

			String landmark = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeLandmark);
			MyAccount_Page.ProfilePage.Address.Landmark().sendKeys(landmark);
			Log.info("Landmark value is entered");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeMobile);
			MyAccount_Page.ProfilePage.Address.Phone().sendKeys(phone);
			Log.info("Phone value is entered");

			MyAccount_Page.ProfilePage.Address.AddAddressBtn().click();
			Log.info("Add address button is clicked");

			Log.info("Second Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Profile_Add_Multiple_Address");
			Log.error("Second Address is not entered successfully");
			throw (e);

		}

	}

	public static void Profile_Edit_Address(int iTestCaseRow) throws Exception {

		try {
			MyAccount_Page.ProfilePage.EditAddressBtn().click();

			String updateField = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField);
			String updateValue = "";

			if ("FirstName".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.FirstName().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedFirstName);
				MyAccount_Page.ProfilePage.FirstName().sendKeys(updateValue);

				Log.info("First Name is entered on Profile Page");

			}

			if ("PostCode".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.PostCode().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedPostCode);
				MyAccount_Page.ProfilePage.Address.PostCode().sendKeys(updateValue);

				Log.info("PostCode is entered on Address Page");

			}

			if ("Address".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.Address1().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedAddress);
				MyAccount_Page.ProfilePage.Address.Address1().sendKeys(updateValue);

				Log.info("Address is entered on Address Page");

			}

			if ("City".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.City().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedCity);
				MyAccount_Page.ProfilePage.Address.City().sendKeys(updateValue);

				Log.info("City is entered on Address Page");

			}

			if ("Landmark".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.Landmark().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedLandmark);
				MyAccount_Page.ProfilePage.Address.Landmark().sendKeys(updateValue);

				Log.info("Landmark is entered on Address Page");

			}

			if ("Phone".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.Phone().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedMobile);
				MyAccount_Page.ProfilePage.Address.Phone().sendKeys(updateValue);

				Log.info("Phone is entered on Address Page");

			}

			MyAccount_Page.ProfilePage.Address.AddAddressBtn().click();
			Log.info("Update address button is clicked");
			Log.info("Address is updated successfully");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Profile_Edit_Address");
			Log.error("Address is not updated successfully");
			throw (e);

		}

	}

	

	public static void verifyRecentOrder_MyAccountPage(int iTestCaseRow) throws Exception {

		try {

			Utils.verifyElement(MyAccount_Page.MyAccount.RecentOrderbox());
			Utils.verifyElement(MyAccount_Page.MyAccount.RecentOrderText());

			if (MyAccount_Page.MyAccount.myAccount_OrderId().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Failed: Order ID not present \n";
			}
			if (MyAccount_Page.MyAccount.myAccount_OrderDate().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Date not present \n";
			}
			if (MyAccount_Page.MyAccount.myAccount_AmountPaid().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Amount Paid not present \n";
			}
			if (MyAccount_Page.MyAccount.myAccount_Status().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Status not present \n";
			}

			if (!BaseClass.errorValidation.equals("")) {
				throw new Exception(BaseClass.errorValidation);
			}

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method verifyRecentOrder_MyAccountPage");
			Log.error("Issue in verifying recent order details on My Account page");
			throw (e);
		}
	}
	
	public static void OrderNumber_Verify_OrderDetailPage_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Total Numbers order on Order Detail Page functionality");
			
			System.out.println(MyAccount_Page.OrderHistory.OrderId().size());
			if (MyAccount_Page.OrderHistory.OrderId().size() >= 10) {
				Log.info("Verification check done for Total Numbers order on Order Detail Page ");
			} else {
				BaseClass.errorValidation += "Order Less than 10 while total no of order and 12 \n";
			}
			Log.info("Verification check done for Total Numbers order on Order Detail Page");

		} catch (Exception e) {

			Log.error("Verification check Failed for Wishlist Alert functionality");
			Log.error("Exception in Class HomePage_Action | Method OrderNumber_Verify_OrderDetailPage_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method OrderNumber_Verify_OrderDetailPage_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void Verify_OrderDetailPage_ReturnExchangeToolTip_Functionality(int iTestCaseRow) throws Exception {
		String tooltiptext="";
		String tooltiptext1="";
		String tooltiptext2="";
		boolean check;
		try {
			Log.info("Verification for ToolTip Order Detail Page functionality");
			check = Utils.CheckEnability((MyAccount_Page.OrderHistory.GrayReturnExchangeButton()));
			MyAccount_Page.OrderHistory.ToolTip().click();
	        tooltiptext= MyAccount_Page.OrderHistory.ToolTipText().getText(); 	
			if(!tooltiptext.equals("We don't accept Returns for this item."))
					{
				BaseClass.errorValidation += "'We don't accept Returns for this item.'- is not displayed. \n";
			}
	    
	    	MyAccount_Page.OrderHistory.OrderDetailOnViewDetail().click();
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.OrderAction().get(5).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			MyAccount_Page.OrderHistory.ToolTip().click();
			tooltiptext1= MyAccount_Page.OrderHistory.ToolTipText().getText();
			if(!tooltiptext1.equals("The Item has been cancelled. Hence Return or Exchange is deactivated."))
			{
		BaseClass.errorValidation += "'The Item has been cancelled. Hence Return or Exchange is deactivated.'- is not displayed. \n";
	        }
			
			MyAccount_Page.OrderHistory.OrderDetailOnViewDetail().click();
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.OrderAction().get(3).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			MyAccount_Page.OrderHistory.ToolTip().click();
			tooltiptext2= MyAccount_Page.OrderHistory.ToolTipText().getText();
			if(!tooltiptext2.equals("The product cannot be returned since the 1 days return period has been expired"))
			{
		BaseClass.errorValidation += "'The product cannot be returned since the 1 days return period has been expired'- is not displayed. \n";
	        }
			
			Log.info("Verification check done for tooltip on Order Detail Page");
			MyAccount_Page.OrderHistory.OrderDetailOnViewDetail().click();
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.OrderAction().get(5).sendKeys(Keys.ENTER);
			//check = Utils.CheckEnability((MyAccount_Page.OrderHistory.GrayReturnExchangeButton()));
			if (!check) {
				BaseClass.errorValidation += "ReturnExchangeButton present on Order detail page while it should not be there \n";
			}
	
			Log.info("Verification check done for Return button on Order Detail Page");
			
			
			
			
		} catch (Exception e) {

			Log.error("Verification check Failed for tooltip functionality");
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ReturnExchangeToolTip_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ReturnExchangeToolTip_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void OrderNumber_Verify_OrderDetailPage_RetrunExchangeText_Functionality(int iTestCaseRow) throws Exception {
		String tooltiptext="";
		try {
			Log.info("Verification for ReturnExchange text on Order Detail Page functionality");
			MyAccount_Page.OrderHistory.OrderAction().get(0).sendKeys(Keys.ENTER);
			MyAccount_Page.OrderHistory.OrderDetailWindowImage().click();
			MyAccount_Page.OrderHistory.OrderDetailReturnExchangeLink().click();
	        tooltiptext= MyAccount_Page.OrderHistory.EasyReturnText().getText(); 	
			if(!tooltiptext.contains("If you are not completely satisfied with your purchase, you can return most items to us within 14 days of delivery to get a 100% refund. We offer free and easy returns through courier pickup, or you can exchange most items bought online at any of our stores across India. For More details go to: http://www.shoppersstop.com/returns-policy/."))
					{
				BaseClass.errorValidation += "'Text'- is not displayed. \n";
			}
		}catch (Exception e) {

				Log.error(e.getMessage());
				BaseClass.errorValidation += "ReturnExchange text is not present on Order Detail page\n";
		
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ReturnExchangeToolTip_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}



	public static void Verify_OrderDetailPage_ReturnExchangeWindow_Functionality(int iTestCaseRow) throws Exception {
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ReturnExchangeWindowImage());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Return Exchange Window Image is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ReturnExchangeWindowColour());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Return Exchange Window colour is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ReturnExchangeWindowSize());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Return Exchange Window Size is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ReturnExchangeWindowQuantity());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Return Exchange Window Quantity is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Return Exchange Return Comment box is not present on cart page\n";
		}
		try {
			Utils.verifyElement(MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnReasonBox());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Return Exchange Return reason box is not present on cart page\n";
		}

		try {
			Utils.verifyElement(MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Return Exchange save button is not present on cart page\n";
		}
		try {
			Utils.verifyElement(MyAccount_Page.OrderHistory.ReturnExchangeWindowCancelButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Return Exchange cancel button is not present on cart page\n";
		}
		
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ReturnExchangeToolTip_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void Verify_OrderDetailPage_ExchangeWindow_Functionality(int iTestCaseRow) throws Exception {

		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ExchangeWindowImage());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Exchange Window Image is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ExchangeWindowColour());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Exchange Window colour is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ExchangeWindowSize());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Exchange Window Size is not present on cart page\n";
		}
		try {
			//Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.ExchangeWindowSize());
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ExchangeWindowReturnCommentBox());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Exchange Return Comment box is not present on cart page\n";
		}
		try {
			Utils.verifyElement(MyAccount_Page.OrderHistory.ExchangeWindowReturnReasonBox());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Exchange Return reason box is not present on cart page\n";
		}

		try {
			Utils.verifyElement(MyAccount_Page.OrderHistory.ExchangeWindowSaveButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Exchange save button is not present on cart page\n";
		}
		try {
			Utils.verifyElement(MyAccount_Page.OrderHistory.ExchangeWindowCancelButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Exchange cancel button is not present on cart page\n";
		}
		
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ExchangeWindow_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	/**
	 * @param iTestCaseRow
	 * @throws Exception
	 */
	public static void Verify_OrderDetailPage_ExchangeWindowEditQty_Functionality(int iTestCaseRow) throws Exception {
		Log.info("Verification for edit cart functionality on Retrun and Exchange button page");
		//	String title = ExcelUtils.getCellData(iTestCaseRow, Constant.title);	
		MyAccount_Page.OrderHistory.EditQuantityLink().click();
		Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
		MyAccount_Page.OrderHistory.EditTextBox().clear();
		MyAccount_Page.OrderHistory.EditTextBox().sendKeys("1");
		MyAccount_Page.OrderHistory.EditQuantityLink().click();
		

		Log.info("Edit textbox clicked successfully");
		
		try {
			String ReturnReason;
			String ReturnComment;
			MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnButton().click();
			Utils.SelectDropdownUpdatedReason(MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnReasonBox());
			MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.description));
			ReturnReason = MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnReasonBox().getAttribute("value");
			ReturnComment =MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox().getAttribute("value");
			System.out.println(ReturnReason);
			System.out.println(ReturnComment);
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
			Thread.sleep(3000);
			if ((MyAccount_Page.OrderHistory.ExchangeReasonTextBox().getAttribute("value").equals(ReturnReason))){
				BaseClass.errorValidation += "Reason match for Return and exchange which should not be \n";
			}
			if ((MyAccount_Page.OrderHistory.ExchangeWindowCommentBox().getAttribute("value").equals(ReturnComment))){
				BaseClass.errorValidation += "Comments match for Return and exchange which should not be \n";
			}
			MyAccount_Page.OrderHistory.ReturnExchangeWindowCancelButton().click();
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ExchangeWindowEditQty_Functionality");
			Log.error(e.getMessage());
			throw e;
		}
		
		
		try {
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
			String BeforeSwitchQty;
     		String AfterSwitchQty;
			MyAccount_Page.OrderHistory.EditQuantityLink().click();
			Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
			MyAccount_Page.OrderHistory.EditTextBox().clear();
			MyAccount_Page.OrderHistory.EditTextBox().sendKeys("1");
			MyAccount_Page.OrderHistory.EditQuantityLink().click();
			
			BeforeSwitchQty = MyAccount_Page.OrderHistory.EditTextBox().getAttribute("value");
			System.out.println(BeforeSwitchQty);
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnButton().click();
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
			Thread.sleep(3000);
			AfterSwitchQty = MyAccount_Page.OrderHistory.EditTextBox().getAttribute("value");;
			System.out.println(AfterSwitchQty);
			if (!(MyAccount_Page.OrderHistory.EditTextBox().getAttribute("value").equals(BeforeSwitchQty))){
				BaseClass.errorValidation += "Quantity not match after switch \n";
			}
			MyAccount_Page.OrderHistory.ReturnExchangeWindowCancelButton().click();
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ExchangeWindowEditQty_Functionality");
			Log.error(e.getMessage());
			throw e;
		}
		
		try {
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
			MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			Thread.sleep(3000);
			Utils.verifyElement(MyAccount_Page.OrderHistory.ReasonAlertMessage());
			if (!(MyAccount_Page.OrderHistory.ReasonAlertMessage().getText().equals("Please select size for your Exchange."))) {
				BaseClass.errorValidation += "Size alert not present on page. \n";
			}
			MyAccount_Page.OrderHistory.ReturnExchangeWindowCancelButton().click();	
			Thread.sleep(3000);
			Utils.verifyElement(MyAccount_Page.OrderHistory.WriteAProductReviewButton());
			Utils.verifyElement(MyAccount_Page.OrderHistory.ReturnExchangeButton());
			
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ExchangeWindowEditQty_Functionality");
			Log.error(e.getMessage());
			throw e;
		}
		

		try {
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
			MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
			MyAccount_Page.OrderHistory.EditQuantityLink().click();
			Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
			MyAccount_Page.OrderHistory.EditTextBox().clear();
			MyAccount_Page.OrderHistory.EditTextBox().sendKeys("1");
			MyAccount_Page.OrderHistory.EditQuantityLink().click();
			MyAccount_Action.product_selectSize(MyAccount_Page.OrderHistory.SizeButtons());
			Thread.sleep(5000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			Thread.sleep(5000);
			Utils.verifyElement(MyAccount_Page.OrderHistory.ReasonAlertMessage());
			if (!(MyAccount_Page.OrderHistory.ReasonAlertMessage().getText().equals("Please select a reason for your Exchange."))) {
				BaseClass.errorValidation += "Product remove alert not present on page. \n";
			}
			MyAccount_Page.OrderHistory.ResetSize().click();
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			Thread.sleep(5000);
			Utils.verifyElement(MyAccount_Page.OrderHistory.ReasonAlertMessage());
			if (!(MyAccount_Page.OrderHistory.ReasonAlertMessage().getText().equals("Please select size for your Exchange."))) {
				BaseClass.errorValidation += "Product remove alert not present on page. \n";
			}
			MyAccount_Page.OrderHistory.ReturnExchangeWindowCancelButton().click();	
			Thread.sleep(3000);
			Utils.verifyElement(MyAccount_Page.OrderHistory.WriteAProductReviewButton());
			Utils.verifyElement(MyAccount_Page.OrderHistory.ReturnExchangeButton());
			
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ExchangeWindowEditQty_Functionality");
			Log.error(e.getMessage());
			throw e;
		}
		
		try {
			MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.EditQuantityLink().click();
			Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
			MyAccount_Page.OrderHistory.EditTextBox().clear();
			MyAccount_Page.OrderHistory.EditTextBox().sendKeys("1");
			MyAccount_Page.OrderHistory.EditQuantityLink().click();
			MyAccount_Action.product_selectSize(MyAccount_Page.OrderHistory.SizeButtons());
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			Thread.sleep(5000);
			Utils.verifyElement(MyAccount_Page.OrderHistory.ReasonAlertMessage());
			if (!(MyAccount_Page.OrderHistory.ReasonAlertMessage().getText().equals("Please select a reason for your Exchange."))) {
				BaseClass.errorValidation += "Product remove alert not present on page. \n";
			}
			Utils.SelectDropdownUpdatedReason(MyAccount_Page.OrderHistory.ExchangeReasonTextBox());
			MyAccount_Page.OrderHistory.ExchangeWindowCommentBox().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.description));
			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			Thread.sleep(5000);
			Utils.verifyElement(MyAccount_Page.OrderHistory.PickupDetail());
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ExchangeWindowEditQty_Functionality");
			Log.error(e.getMessage());
			throw e;
		}

		


		
		try {
			
			MyAccount_Page.OrderHistory.CheckBoxButton().click();
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
			MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
			Thread.sleep(3000);
		if (!(MyAccount_Page.OrderHistory.ExchangeWindowCommentBox().getAttribute("value").equals("I would like to increase the quantity of Product."))) {
				BaseClass.errorValidation += "Save changes not present on page. \n";
			}
		MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			//Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.RefundDetail());
		Thread.sleep(5000);
			Utils.verifyElement(MyAccount_Page.OrderHistory.PickupDetail());
			
		} catch (Exception e) {
		Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ExchangeWindowEditQty_Functionality");
			Log.error(e.getMessage());
			throw e;
		}
		
try {
			
			MyAccount_Page.OrderHistory.CheckBoxButton().click();
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.CheckBoxButton().click();
			MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
			MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
			Thread.sleep(3000);
			if (!(MyAccount_Page.OrderHistory.ExchangeWindowCommentBox().getAttribute("value").equals("I would like to increase the quantity of Product."))) {
				BaseClass.errorValidation += "Save changes not present on page. \n";
			}
			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			//Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.RefundDetail());
			Thread.sleep(5000);
			Utils.verifyElement(MyAccount_Page.OrderHistory.PickupDetail());
			
		} catch (Exception e) {			
			Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality");
		Log.error(e.getMessage());
		throw e;
		}
		
try {
     //Utils.scrollingToPageElementAdvanced( MyAccount_Page.OrderHistory.OrderDetailOnViewDetail());
             Thread.sleep(3000);
            Utils.mouseHover(Home_Page.LoginRegister());
             //Utils.scrollingToPageElementAdvanced( Home_Page.MyAccount());
             Home_Page.MyAccount().click();
	         
	         MyAccount_Page.MyAccount_LeftMenu.Orders().click();
	         //MyAccount_Page.OrderHistory.OrderDetailOnViewDetail().sendKeys(Keys.ENTER);
	         //Thread.sleep(2000);
	         MyAccount_Page.OrderHistory.OrderAction().get(0).sendKeys(Keys.ENTER);
	         Thread.sleep(2000);
             MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
	         Thread.sleep(3000);
	         MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();

			if ((MyAccount_Page.OrderHistory.ExchangeWindowCommentBox().getAttribute("value").equals("I would like to increase the quantity of Product."))) {
				BaseClass.errorValidation += "Save changes present on page. \n";
			}


			
	} catch (Exception e) {
		Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality");

			Log.error(e.getMessage());
		throw e;
		}
	if (!BaseClass.errorValidation.isEmpty()) {
		Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality");
		throw new Exception(BaseClass.errorValidation);
	}
}
	
	public static void Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality(int iTestCaseRow) throws Exception {
		Log.info("Verification for edit cart functionality on Retrun and Exchange button page");
			String title = ExcelUtils.getCellData(iTestCaseRow, Constant.title);	
			MyAccount_Page.OrderHistory.EditQuantityLink().click();
			Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
			MyAccount_Page.OrderHistory.EditTextBox().sendKeys(title);
			
	
			Log.info("Edit textbox clicked successfully");
			
			try {
				MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
				Utils.verifyElement(MyAccount_Page.OrderHistory.ReasonAlertMessage());
				if (!(MyAccount_Page.OrderHistory.ReasonAlertMessage().getText().equals("Please select a reason for your Return."))) {
					BaseClass.errorValidation += "Product remove alert not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality");
				Log.error(e.getMessage());
				throw e;
			}

			
			try {
				MyAccount_Page.OrderHistory.ReturnExchangeWindowCancelButton().click();	
				Thread.sleep(3000);
				Utils.verifyElement(MyAccount_Page.OrderHistory.WriteAProductReviewButton());
				Utils.verifyElement(MyAccount_Page.OrderHistory.ReturnExchangeButton());
				
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality");
				Log.error(e.getMessage());
				throw e;
			}
			
		
			
			try {
				MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
				MyAccount_Page.OrderHistory.EditQuantityLink().click();
				Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
				MyAccount_Page.OrderHistory.EditTextBox().clear();
				MyAccount_Page.OrderHistory.EditTextBox().sendKeys(title);
				Utils.SelectDropdownUpdatedReason(MyAccount_Page.OrderHistory.ReasonTextBox());
				MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox()
				.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.description));
				MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
				//Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.RefundDetail());
				Thread.sleep(5000);
				Utils.verifyElement(MyAccount_Page.OrderHistory.PickupDetail());
				Utils.verifyElement(MyAccount_Page.OrderHistory.RefundDetail());
				
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality");
				Log.error(e.getMessage());
				throw e;
			}
			
			try {
				
				MyAccount_Page.OrderHistory.CheckBoxButton().click();
				Thread.sleep(3000);
				MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
				System.out.println(MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox().getAttribute("value"));
				if (!(MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox().getAttribute("value").equals("I would like to increase the quantity of Product."))) {
					BaseClass.errorValidation += "Save changes not present on page. \n";
				}
				MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
				//Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.RefundDetail());
				Thread.sleep(5000);
				Utils.verifyElement(MyAccount_Page.OrderHistory.PickupDetail());
				Utils.verifyElement(MyAccount_Page.OrderHistory.RefundDetail());
				
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality");
				Log.error(e.getMessage());
				throw e;
			}
			
try {
				
				MyAccount_Page.OrderHistory.CheckBoxButton().click();
				Thread.sleep(3000);
				MyAccount_Page.OrderHistory.CheckBoxButton().click();
				MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
				System.out.println(MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox().getAttribute("value"));
				if (!(MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox().getAttribute("value").equals("I would like to increase the quantity of Product."))) {
					BaseClass.errorValidation += "Save changes not present on page. \n";
				}
				MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
				//Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.RefundDetail());
				Thread.sleep(5000);
				Utils.verifyElement(MyAccount_Page.OrderHistory.PickupDetail());
				Utils.verifyElement(MyAccount_Page.OrderHistory.RefundDetail());
				
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality");
				Log.error(e.getMessage());
				throw e;
			}
			
	try {
		Thread.sleep(3000);
        Utils.mouseHover(Home_Page.LoginRegister());
        //Utils.scrollingToPageElementAdvanced( Home_Page.MyAccount());
        Home_Page.MyAccount().click();
        
        MyAccount_Page.MyAccount_LeftMenu.Orders().click();
		       MyAccount_Page.OrderHistory.OrderAction().get(0).sendKeys(Keys.ENTER);
		       Thread.sleep(2000);
		       MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
		       Thread.sleep(3000);
				if ((MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox().getAttribute("value").equals("I would like to increase the quantity of Product."))) {
					BaseClass.errorValidation += "Save changes present on page. \n";
				}
	
				
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality");
				Log.error(e.getMessage());
				throw e;
			}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchangeWindowupdates_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void Verify_OrderDetailPage_ReturnExchange_Save_Functionality(int iTestCaseRow) throws Exception {
		String title = ExcelUtils.getCellData(iTestCaseRow, Constant.title);
		MyAccount_Page.OrderHistory.EditQuantityLink().click();
		Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
		MyAccount_Page.OrderHistory.EditTextBox().clear();
		MyAccount_Page.OrderHistory.EditTextBox().sendKeys(title);
		Utils.SelectDropdownUpdatedReason(MyAccount_Page.OrderHistory.ReasonTextBox());
		MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox()
		.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.description));
		MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
		try {
			Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.ReturnExchangeButton());
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.PickupRadioButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Pickup button is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.PickupRadioButtonText());
			if (!(MyAccount_Page.OrderHistory.PickupRadioButtonText().getText().equals("The parcel will be picked up by our courier partner from the address it was delivered to."))) {
				BaseClass.errorValidation += "Pickup Button text not matching on page. \n";
			}
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Pickupbutton Text is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.IwillCourierButton());
			
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "I will courier button is not present on cart page\n";
		}
		try {
			//Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.ShopperStopCreditButton());
			Thread.sleep(5000);
			MyAccount_Page.OrderHistory.IwillCourierButton().click();
			Thread.sleep(5000);
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.IwillCourierButtonText());
			if (!(MyAccount_Page.OrderHistory.IwillCourierButtonText().getText().contains("You can send the item along with the return label."))) {
				BaseClass.errorValidation += "I will courier Button text not matching on page. \n";
			}
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "I will courier button text is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ShopperStopCreditButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Shopper Stop CreditButton is not present on cart page\n";
		}
		try {
			Thread.sleep(5000);
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.NEFTbutton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "NEFT not present on cart page\n";
		}
		try {
			MyAccount_Page.OrderHistory.NEFTbutton().click();
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.AccountName());
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.AccountNumber());
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.BankName());
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.IFSCCode());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "NEFT options are not present on cart page\n";
		}

	
		
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ReturnExchangeToolTip_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	
	public static void Verify_OrderDetailPage_Exchange_Save_Functionality(int iTestCaseRow) throws Exception {
		//String title = ExcelUtils.getCellData(iTestCaseRow, Constant.title);
		MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
		Thread.sleep(3000);
		MyAccount_Page.OrderHistory.EditQuantityLink().click();
		Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
		MyAccount_Page.OrderHistory.EditTextBox().clear();
		MyAccount_Page.OrderHistory.EditTextBox().sendKeys("1");
		MyAccount_Page.OrderHistory.EditQuantityLink().click();
		MyAccount_Action.product_selectSize(MyAccount_Page.OrderHistory.SizeButtons());
		Thread.sleep(3000);

		MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
	
		Utils.verifyElement(MyAccount_Page.OrderHistory.ReasonAlertMessage());
		if (!(MyAccount_Page.OrderHistory.ReasonAlertMessage().getText().equals("Please select a reason for your Exchange."))) {
			BaseClass.errorValidation += "Product remove alert not present on page. \n";
		}
		
		
		Utils.SelectDropdownUpdatedReason(MyAccount_Page.OrderHistory.ExchangeReasonTextBox());
		MyAccount_Page.OrderHistory.ExchangeWindowCommentBox().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.description));
		MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
		try {
			Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.ReturnExchangeButton());
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.PickupRadioButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Pickup button is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.PickupRadioButtonText());
			if (!(MyAccount_Page.OrderHistory.PickupRadioButtonText().getText().equals("The parcel will be picked up by our courier partner from the address it was delivered to."))) {
				BaseClass.errorValidation += "Pickup Button text not matching on page. \n";
			}
					
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Pickupbutton Text is not present on cart page\n";
		}
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.IwillCourierButton());
			
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "I will courier button is not present on cart page\n";
		}
		try {
			//Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.ShopperStopCreditButton());
			Thread.sleep(5000);
			MyAccount_Page.OrderHistory.IwillCourierButton().click();
			Thread.sleep(5000);
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.IwillCourierButtonText());
			System.out.println(MyAccount_Page.OrderHistory.IwillCourierButtonText().getText());
			if (!(MyAccount_Page.OrderHistory.IwillCourierButtonText().getText().contains("You can send the item along"))) {
				BaseClass.errorValidation += "I will courier Button text not matching on page. \n";
			}
			Thread.sleep(5000);
			Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.WriteAProductReviewButton());
	        MyAccount_Page.OrderHistory.ReturnExchangeButton().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			//MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
			MyAccount_Page.OrderHistory.EditQuantityLink().click();
			Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
			MyAccount_Page.OrderHistory.EditTextBox().clear();
			MyAccount_Page.OrderHistory.EditTextBox().sendKeys("4");
			MyAccount_Page.OrderHistory.EditQuantityLink().click();
			Thread.sleep(3000);
			MyAccount_Action.product_selectSize(MyAccount_Page.OrderHistory.SizeButtons());
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			Thread.sleep(3000);
			MyAccount_Action.product_selectSizeSecond(MyAccount_Page.OrderHistory.SecondWindowSizeButtons());
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			//Thread.sleep(3000);
			MyAccount_Action.product_selectSizeThird(MyAccount_Page.OrderHistory.ThirdWindowSizeButtons());
			Thread.sleep(3000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			//Thread.sleep(3000);
			MyAccount_Action.product_selectSizeFourth(MyAccount_Page.OrderHistory.FourtWindowSizeButtons());
			Thread.sleep(5000);
			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
			//Thread.sleep(3000);
			//Utils.waitForElementPresence(MyAccount_Page.OrderHistory.IwillCourierButtonText());
			//Utils.verifyElement(MyAccount_Page.OrderHistory.WriteAProductReviewButton());
			
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "I will courier button text is not present on cart page\n";
		}
		
//		try {
//			Thread.sleep(2000);
//			Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.ReturnExchangeButton());
//	        MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
//			Thread.sleep(3000);
//			//MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
//			MyAccount_Page.OrderHistory.EditQuantityLink().click();
//			Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
//			MyAccount_Page.OrderHistory.EditTextBox().clear();
//			MyAccount_Page.OrderHistory.EditTextBox().sendKeys("4");
//			MyAccount_Page.OrderHistory.EditQuantityLink().click();
//			Thread.sleep(3000);
//			MyAccount_Action.product_selectSize(MyAccount_Page.OrderHistory.SizeButtons());
//			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
//			MyAccount_Action.product_selectSize(MyAccount_Page.OrderHistory.SizeButtons());
//			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
//			MyAccount_Action.product_selectSize(MyAccount_Page.OrderHistory.SizeButtons());
//			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
//			MyAccount_Action.product_selectSize(MyAccount_Page.OrderHistory.SizeButtons());
//			MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
//			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.IwillCourierButtonText());
//			Utils.verifyElement(MyAccount_Page.OrderHistory.PickupDetail());
//			
//		} catch (Exception e) {
//
//			Log.error(e.getMessage());
//			BaseClass.errorValidation += "I will courier button text is not present on cart page\n";
//		}
		
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ReturnExchangeToolTip_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_OrderDetailPage_Exchange_Unapproved_Functionality(int iTestCaseRow) throws Exception {
		//String title = ExcelUtils.getCellData(iTestCaseRow, Constant.title);
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ItemUnapprovedText());
			if (!(MyAccount_Page.OrderHistory.ItemUnapprovedText().getText().equals("Product is not available right now. Please go for Return option"))) {
				BaseClass.errorValidation += "Item Unapproved text not matching on page. \n";
			}
					
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Item Unapproved Text is not present on cart page\n";
		}
		
		
		
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_Exchange_Unapproved_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	public static void Verify_OrderDetailPage_Exchange_OutOfStock_Functionality(int iTestCaseRow) throws Exception {
		//String title = ExcelUtils.getCellData(iTestCaseRow, Constant.title);
		MyAccount_Page.OrderHistory.ReturnExchangeWindowExchangeButton().click();
		Thread.sleep(3000);
		MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
	
		Utils.verifyElement(MyAccount_Page.OrderHistory.ReasonAlertMessage());
		if (!(MyAccount_Page.OrderHistory.ReasonAlertMessage().getText().equals("All Variants are out of Stock. Please return your order"))) {
			BaseClass.errorValidation += "size alert not present on page. \n";
		}
		
		
			
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_Exchange_OutOfStock_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	

	public static void MyAccount_Registereduser_Track_Order_Details(int iTestCaseRow) throws Exception {
	

		Home_Page.headerTrackOrder().click();
		String Email = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
		MyAccount_Page.OrderHistory.TrackOrderEmail().sendKeys(Email);
		Log.info("Email Id is entered successfully");
		MyAccount_Page.OrderHistory.TrackOrderNo().sendKeys("67949026");
		Log.info("Order Id is entered successfully");
		MyAccount_Page.OrderHistory.TrackSubmittBtn().click();
		
		try {
	
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ReturnExchangeButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Retrun/Exchange button is not present on cart page\n";
		}
		try {
			MyAccount_Page.OrderHistory.ReturnExchangeButton().click();
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ReturnExchangeWindowFull());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Retrun/Exchange window is not present on cart page\n";
		}
		

	
		
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ReturnExchangeToolTip_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void MyAccount_Guestuser_Track_Order_Details(int iTestCaseRow) throws Exception {
		

		Home_Page.headerTrackOrder().click();
		String Email = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
		MyAccount_Page.OrderHistory.TrackOrderEmail().sendKeys(Email);
		Log.info("Email Id is entered successfully");
		MyAccount_Page.OrderHistory.TrackOrderNo().sendKeys("70644029");
		Log.info("Order Id is entered successfully");
		MyAccount_Page.OrderHistory.TrackSubmittBtn().click();

		
		try {
			


			
			if (MyAccount_Page.OrderHistory.ExchangeButtons().size()>0) {
				BaseClass.errorValidation += "Exchange buttons present on page which should not be. \n";
			}
				
			} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Retrun/Exchange window is not present on cart page\n";
		}	
		
		try{
		if (MyAccount_Page.OrderHistory.ReviewRatingButtons().size()>0) {
			BaseClass.errorValidation += "Review Rating buttons present on page which should not be. \n";
		}
			
		} catch (Exception e) {

		Log.error(e.getMessage());
		BaseClass.errorValidation += "Retrun/Exchange window is not present on cart page\n";
	}

	
		
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ReturnExchangeToolTip_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}



public static void MyAccount_Guestuser_Track_Order_returned_Details(int iTestCaseRow) throws Exception {
	

	Home_Page.headerTrackOrder().click();
	String Email = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
	MyAccount_Page.OrderHistory.TrackOrderEmail().sendKeys(Email);
	Log.info("Email Id is entered successfully");
	MyAccount_Page.OrderHistory.TrackOrderNo().sendKeys("67949043");
	Log.info("Order Id is entered successfully");
	MyAccount_Page.OrderHistory.TrackSubmittBtn().click();
	
	try {

		Utils.waitForElementPresence(MyAccount_Page.OrderHistory.TrackReturnExchangeButton());
	} catch (Exception e) {

		Log.error(e.getMessage());
		BaseClass.errorValidation += "Track Retrun/Exchange button is not present on cart page\n";
	}
	try {
		MyAccount_Page.OrderHistory.TrackReturnExchangeButton().click();
		Utils.waitForElementPresence(MyAccount_Page.OrderHistory.TrackReturnExchangeButtonWindow());
	} catch (Exception e) {

		Log.error(e.getMessage());
		BaseClass.errorValidation += "Track Retrun/Exchange window is not present on cart page\n";
	}
	


	
	if (!BaseClass.errorValidation.isEmpty()) {
		Log.error("Exception in Class MyAccount_Action | Method MyAccount_Guestuser_Track_Order_returned_Details");
		throw new Exception(BaseClass.errorValidation);
	}
}
	public static void Verify_OrderDetailPage_ReturnExchange_Save_Bank_Functionality(int iTestCaseRow) throws Exception {
		String title = ExcelUtils.getCellData(iTestCaseRow, Constant.title);
		MyAccount_Page.OrderHistory.EditQuantityLink().click();
		Utils.verifyElement(MyAccount_Page.OrderHistory.EditTextBox());
		MyAccount_Page.OrderHistory.EditTextBox().clear();
		MyAccount_Page.OrderHistory.EditTextBox().sendKeys(title);
		Utils.SelectDropdownUpdatedReason(MyAccount_Page.OrderHistory.ReasonTextBox());
		MyAccount_Page.OrderHistory.ReturnExchangeWindowReturnCommentBox()
		.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.description));
		MyAccount_Page.OrderHistory.ReturnExchangeWindowSaveButton().click();
		Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.ReturnExchangeButton());
		Thread.sleep(3000);

        try {
				
				MyAccount_Page.OrderHistory.NEFTbutton().click();
				Utils.scrollingToPageElementAdvanced(MyAccount_Page.OrderHistory.NEFTbutton());
				Thread.sleep(3000);
				MyAccount_Page.OrderHistory.AccountNumber().clear();
				String AccountNo = ExcelUtils.getCellData(iTestCaseRow, Constant.cardNumber);
				MyAccount_Page.OrderHistory.AccountNumber().sendKeys(AccountNo);
				Log.info("Account Number is entered successfully");


				String Bank = ExcelUtils.getCellData(iTestCaseRow, Constant.bank);
				MyAccount_Page.OrderHistory.BankName().sendKeys(Bank);
				Log.info("Bank Name is entered successfully");

				String IFSC = ExcelUtils.getCellData(iTestCaseRow, Constant.CVV);
				MyAccount_Page.OrderHistory.IFSCCode().sendKeys(IFSC);
				Log.info("ifsc is entered successfully");

				MyAccount_Page.OrderHistory.SaveSubmittbutton().click();
				Log.info("Submitt button clicked successfully");
					
					if (!(MyAccount_Page.OrderHistory.AccountHolderMsg().getText().equals("Please enter a valid account holder name."))) {
						BaseClass.errorValidation += " name field not mandatory on page. \n";
					}
				
					String Name = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedFirstName);
					MyAccount_Page.OrderHistory.AccountName().sendKeys(Name);
					Log.info(" Wrong Account Name is entered successfully");
					
					if (!(MyAccount_Page.OrderHistory.AccountHolderMsg().getText().equals("Please enter a valid account holder name."))) {
						BaseClass.errorValidation += " name field taking special char on page. \n";
					}

					
				} catch (Exception e) {
					Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchange_Save_Bank_Functionality");
					Log.error(e.getMessage());
					throw e;
				}
        
				Thread.sleep(5000);
				
			
				try {

					MyAccount_Page.OrderHistory.AccountNumber().clear();
					MyAccount_Page.OrderHistory.BankName().clear();
					MyAccount_Page.OrderHistory.IFSCCode().clear();
					MyAccount_Page.OrderHistory.AccountName().clear();
					
					String CorrectName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
					MyAccount_Page.OrderHistory.AccountNumber().sendKeys(CorrectName);
					Log.info("Correct Name is entered successfully");
					
					
                    String Bank = ExcelUtils.getCellData(iTestCaseRow, Constant.bank);
					MyAccount_Page.OrderHistory.BankName().sendKeys(Bank);
					Log.info("Bank Name is entered successfully");

					String IFSC = ExcelUtils.getCellData(iTestCaseRow, Constant.CVV);
					MyAccount_Page.OrderHistory.IFSCCode().sendKeys(IFSC);
					Log.info("ifsc is entered successfully");

					MyAccount_Page.OrderHistory.SaveSubmittbutton().click();
					Log.info("Submitt button clicked successfully");
						
						if (!(MyAccount_Page.OrderHistory.AccountNumberMsg().getText().equals("Please enter a valid bank account number."))) {
							BaseClass.errorValidation += " Account number field not mandatory on page. \n";
						}

						
						
					} catch (Exception e) {
						Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchange_Save_Bank_Functionality");
						Log.error(e.getMessage());
						throw e;
					}
				
				try {
					
					MyAccount_Page.OrderHistory.AccountNumber().clear();
					MyAccount_Page.OrderHistory.BankName().clear();
					MyAccount_Page.OrderHistory.IFSCCode().clear();
					MyAccount_Page.OrderHistory.AccountName().clear();
					
					String CorrectName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
					MyAccount_Page.OrderHistory.AccountNumber().sendKeys(CorrectName);
					Log.info("Correct Name is entered successfully");
					
					String AccountNo = ExcelUtils.getCellData(iTestCaseRow, Constant.cardNumber);
					MyAccount_Page.OrderHistory.AccountNumber().sendKeys(AccountNo);
					Log.info("Account Number is entered successfully");
					
                    String IFSC = ExcelUtils.getCellData(iTestCaseRow, Constant.CVV);
					MyAccount_Page.OrderHistory.IFSCCode().sendKeys(IFSC);
					Log.info("ifsc is entered successfully");

					MyAccount_Page.OrderHistory.SaveSubmittbutton().click();
					Log.info("Submitt button clicked successfully");
						
						if (!(MyAccount_Page.OrderHistory.BankNameMsg().getText().equals("Please enter a valid bank name."))) {
							BaseClass.errorValidation += " Bank Name field not mandatory on page. \n";
						}
						
						String IncorrectBankName = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedLastName);
						MyAccount_Page.OrderHistory.BankName().sendKeys(IncorrectBankName);
						Log.info(" Wrong Bank Name is entered successfully");
						
						if (!(MyAccount_Page.OrderHistory.BankNameMsg().getText().equals("Please enter a valid bank name."))) {
							BaseClass.errorValidation += " name field taking special char on page. \n";
						}

						
						
					} catch (Exception e) {
						Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchange_Save_Bank_Functionality");
						Log.error(e.getMessage());
						throw e;
					}
				
				try {
					
					MyAccount_Page.OrderHistory.AccountNumber().clear();
					MyAccount_Page.OrderHistory.BankName().clear();
					MyAccount_Page.OrderHistory.IFSCCode().clear();
					MyAccount_Page.OrderHistory.AccountName().clear();
					
					String CorrectName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
					MyAccount_Page.OrderHistory.AccountNumber().sendKeys(CorrectName);
					Log.info("Correct Name is entered successfully");
					
					String AccountNo = ExcelUtils.getCellData(iTestCaseRow, Constant.cardNumber);
					MyAccount_Page.OrderHistory.AccountNumber().sendKeys(AccountNo);
					Log.info("Account Number is entered successfully");
					
					String Bank = ExcelUtils.getCellData(iTestCaseRow, Constant.bank);
					MyAccount_Page.OrderHistory.BankName().sendKeys(Bank);
					Log.info("Bank Name is entered successfully");
					
                   

					MyAccount_Page.OrderHistory.SaveSubmittbutton().click();
					Log.info("Submitt button clicked successfully");
						
						if (!(MyAccount_Page.OrderHistory.IFSCMsg().getText().equals("Please enter a valid IFSC code."))) {
							BaseClass.errorValidation += " Bank Name field not mandatory on page. \n";
						}
						
						String IncorrectIFSCCode = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedMobile);
						MyAccount_Page.OrderHistory.IFSCCode().sendKeys(IncorrectIFSCCode);
						Log.info(" Wrong IFSC code is entered successfully");
						
						if (!(MyAccount_Page.OrderHistory.IFSCMsg().getText().equals("Please enter a valid IFSC code."))) {
							BaseClass.errorValidation += " name field taking more than 11 digit on page. \n";
						}
						
						
					} catch (Exception e) {
						Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchange_Save_Bank_Functionality");
						Log.error(e.getMessage());
						throw e;
					}
				
        try {
					Thread.sleep(3000);
					MyAccount_Page.OrderHistory.AccountNumber().clear();
					MyAccount_Page.OrderHistory.BankName().clear();
					MyAccount_Page.OrderHistory.IFSCCode().clear();
					MyAccount_Page.OrderHistory.AccountName().clear();
					
					String CorrectName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
					MyAccount_Page.OrderHistory.AccountNumber().sendKeys(CorrectName);
					Log.info("Correct Name is entered successfully");
					
					String AccountNo = ExcelUtils.getCellData(iTestCaseRow, Constant.cardNumber);
					MyAccount_Page.OrderHistory.AccountNumber().sendKeys(AccountNo);
					Log.info("Account Number is entered successfully");
					
					String Bank = ExcelUtils.getCellData(iTestCaseRow, Constant.bank);
					MyAccount_Page.OrderHistory.BankName().sendKeys(Bank);
					Log.info("Bank Name is entered successfully");
					
					   String IFSC = ExcelUtils.getCellData(iTestCaseRow, Constant.CVV);
						MyAccount_Page.OrderHistory.IFSCCode().sendKeys(IFSC);
						Log.info("ifsc is entered successfully");
					
						Thread.sleep(3000);

					MyAccount_Page.OrderHistory.SaveCanceltbutton().click();
					Log.info("Cancel button clicked successfully");
					Utils.verifyElement(MyAccount_Page.OrderHistory.ViewMoreButton());
					
						
						
					} catch (Exception e) {
						Log.error("Exception in Class Cart_Action | Method Verify_OrderDetailPage_ReturnExchange_Save_Bank_Functionality");
						Log.error(e.getMessage());
						throw e;
					}
				
				if (!BaseClass.errorValidation.isEmpty()) {
					Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ReturnExchange_Save_Bank_Functionality");
					throw new Exception(BaseClass.errorValidation);
				}
	         
			}

	


	public static void Verify_OrderDetailPage_ReviewRatingWindow_Functionality(int iTestCaseRow) throws Exception {
		try {
			Utils.waitForElementPresence(MyAccount_Page.OrderHistory.ReturnExchangeWindow());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Return Exchange Window Image is not present on cart page\n";
		}
		
		
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_OrderDetailPage_ReturnExchangeToolTip_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void product_selectSize(List<WebElement> ProductSizeButtons1)
			throws Exception {
		
		try {
			if (ProductSizeButtons1.size()>0){
				for (int i=0; i<=ProductSizeButtons1.size()-1;i++){
					
					if (!(ProductSizeButtons1.get(i).getAttribute("class").contains("grey-background"))){
						ProductSizeButtons1.get(i).click();
						return;
					}
				}
			}

		} catch (Exception e) {
			Log.error("Exception in Class PDP_Action | Method productcode_MatchinMiniCart");
			Log.error("Issue in matching product code in mini cart window");
			throw (e);

		}
		
		
		
	}
	
	public static void product_selectSizeSecond(List<WebElement> ProductSizeButtons2)
			throws Exception {
		
		try {
			if (ProductSizeButtons2.size()>0){
				for (int i=0; i<=ProductSizeButtons2.size()-1;i++){
					
					if (!(ProductSizeButtons2.get(i).getAttribute("class").contains("grey-background"))){
						ProductSizeButtons2.get(i).click();
						return;
					}
				}
			}

		} catch (Exception e) {
			Log.error("Exception in Class PDP_Action | Method productcode_MatchinMiniCart");
			Log.error("Issue in matching product code in mini cart window");
			throw (e);

		}
		
		
		
	}
	
	public static void product_selectSizeThird(List<WebElement> ProductSizeButtons3)
			throws Exception {
		
		try {
			if (ProductSizeButtons3.size()>0){
				for (int i=0; i<=ProductSizeButtons3.size()-1;i++){
					
					if (!(ProductSizeButtons3.get(i).getAttribute("class").contains("grey-background"))){
						ProductSizeButtons3.get(i).click();
						return;
					}
				}
			}

		} catch (Exception e) {
			Log.error("Exception in Class PDP_Action | Method productcode_MatchinMiniCart");
			Log.error("Issue in matching product code in mini cart window");
			throw (e);

		}
		
		
		
	}
	
	public static void product_selectSizeFourth(List<WebElement> ProductSizeButtons4)
			throws Exception {
		
		try {
			if (ProductSizeButtons4.size()>0){
				for (int i=0; i<=ProductSizeButtons4.size()-1;i++){
					
					if (!(ProductSizeButtons4.get(i).getAttribute("class").contains("grey-background"))){
						ProductSizeButtons4.get(i).click();
						return;
					}
				}
			}

		} catch (Exception e) {
			Log.error("Exception in Class PDP_Action | Method productcode_MatchinMiniCart");
			Log.error("Issue in matching product code in mini cart window");
			throw (e);

		}
		
		
		
	}
	
	

	public static void verifyOrderDetails_OrderHistoryPage(int iTestCaseRow) throws Exception {

		try {

			if (MyAccount_Page.OrderHistory.OrderId().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Failed: Order ID not present \n";
			}
			if (MyAccount_Page.OrderHistory.OrderDate().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Date not present \n";
			}
			if (MyAccount_Page.OrderHistory.AmountPaid().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Amount Paid not present \n";
			}
			if (MyAccount_Page.OrderHistory.Tracking().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Tracking number not present \n";
			}
			if (MyAccount_Page.OrderHistory.OrderAction().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Action not present \n";
			}
			if (MyAccount_Page.OrderHistory.Status().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Status not present \n";
			}
			

			if (!BaseClass.errorValidation.equals("")) {
				throw new Exception(BaseClass.errorValidation);
			}

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method verifyOrderDetails_OrderHistoryPage");
			Log.error("Issue in verifying order details on Order history page");
			throw (e);
		}
		
		
	}
}
