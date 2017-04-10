package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class MyAccount_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> elementList = null;

	public MyAccount_Page(WebDriver Driver) {
		super(Driver);
	}

	public static WebElement GlobalMsg() throws Exception {

		try {
			Log.info("Locating GlobalMsg element");
			element = Driver.findElement(By.xpath("//*[@class='global-alerts']/div"));

			Log.info(" Message field is found on the Page");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method GlobalMsg");
			Log.error("Message field is not found on the Page");
			throw e;
		}

		return element;

	}

	public static class MyAccount {
		public static WebElement FirstCitizenLink() throws Exception {

			try {
				Log.info("Locating First Citizen link element");
				element = Driver.findElement(By.xpath("//a[text()= 'Be a First Citizen']"));

				Log.info("First Citizen link is found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstCitizenLink");
				Log.error("First Citizen link is not found on the My Account Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement RecentOrderbox() throws Exception {

			try {
				Log.info("Locating Recent Order box element");
				element = Driver.findElement(By.xpath("//section[@class='my-account-wpr']//div[@class='recent-order-box']"));

				Log.info("Recent Order box is found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RecentOrderbox");
				Log.error("Recent Order box is not found on the My Account Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement RecentOrderText() throws Exception {

			try {
				Log.info("Locating RecentOrderText element");
				element = Driver.findElement(By.xpath("//section[@class='my-account-wpr']//div[@class='recent-order-box']/h2[contains(text(),'Recent Order')]"));

				Log.info("Recent Order text is found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RecentOrderText");
				Log.error("Recent Order text is not found on the My Account Page");
				throw e;
			}

			return element;

		}
		
		public static List<WebElement> myAccount_OrderId() throws Exception {

			try {
				Log.info("Locating OrderId elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Order ID']"));

				Log.info("Order Id elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_OrderId");
				Log.error("Order Id elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> myAccount_OrderDate() throws Exception {

			try {
				Log.info("Locating Order Date elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Order Date']"));

				Log.info("Order Date elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_OrderDate");
				Log.error("Order Date elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
		
		
		public static List<WebElement> myAccount_AmountPaid() throws Exception {

			try {
				Log.info("Locating Amount paid elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Amount paid']"));

				Log.info("Amount paid elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_AmountPaid");
				Log.error("Amount paid elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> myAccount_Status() throws Exception {

			try {
				Log.info("Locating Status elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Status']"));

				Log.info("Status elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_Status");
				Log.error("Status elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
	}

	public static class FirstCitizen_Profile {
		public static WebElement FirstCitizenButton() throws Exception {

			try {
				Log.info("Locating First Citizen button element");
				element = Driver.findElement(By.xpath("//button[text()= 'BECOME A FIRST CITIZEN']"));

				Log.info("First Citizen button is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstCitizenButton");
				Log.error("First Citizen button is not found on the Home Page");
				throw e;
			}

			return element;

		}
	}

	public static class WishList {

		static WebElement mainElement;

		public static WebElement WishListHeading() throws Exception {

			try {
				Log.info("Locating WishListHeading element");
				element = Driver.findElement(By.xpath("//div[@class='wishlist-heading']/div/h1"));

				Log.info("WishListHeading is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListHeading");
				Log.error("WishListHeading is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItems() throws Exception {

			try {
				Log.info("Locating WishListItems element");
				element = Driver.findElement(By.xpath("//div[@class='wishlist-heading']/div/h1/span"));

				Log.info("WishList Item is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItems");
				Log.error("WishList Item is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItemCloseBtn() throws Exception {

			try {
				Log.info("Locating WishListItemCloseBtn element");
				element = Driver.findElement(By.xpath("//*[@id='qv-drop']/li[1]/a/div"));

				Log.info("WishList Item Close button is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItemCloseBtn");
				Log.error("WishList Item Close button is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItemImg() throws Exception {

			try {
				Log.info("Locating WishListItemImg element");
				element = Driver.findElement(By.xpath("//*[@id='qv-drop']/li[1]/div[@class='pro-img']"));

				Log.info("Item image is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItemImg");
				Log.error("Item image is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItemURL() throws Exception {

			try {
				Log.info("Locating WishListItemURL element");
				element = Driver.findElement(By.xpath("//*[@id='qv-drop']/li[1]/div[@class='pro-img']/a"));

				Log.info("Item URL is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItemURL");
				Log.error("Item URL is not found on the Home Page");
				throw e;
			}

			return element;

		}

	}

	public static class ProfilePage {

		static WebElement mainElement;
		static WebElement subElement;
		static String element1;

		public static WebElement PersonalInfoText() throws Exception {

			try {
				Log.info("Locating PersonalInfoText element");
				element = Driver.findElement(By.xpath("//div[@class='my-acc-heading']/div/h1"));

				Log.info("PersonalInfoText field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method PersonalInfoText");
				Log.error("PersonalInfoText field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement EditProfileBtn() throws Exception {

			try {
				Log.info("Locating EditProfileBtn element");
				element = Driver.findElement(By.xpath("//a[contains(text(), 'Edit Profile')]"));

				Log.info("EditProfileBtn is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditProfileBtn");
				Log.error("EditProfileBtn is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement FirstName() throws Exception {

			try {
				Log.info("Locating FirstName element");
				element = Driver.findElement(By.id("profile.firstName"));

				Log.info("FirstName field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstName");
				Log.error("FirstName field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement LastName() throws Exception {

			try {
				Log.info("Locating LastName element");
				element = Driver.findElement(By.id("profile.lastName"));

				Log.info("LastName field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method LastName");
				Log.error("LastName field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Email_Address() throws Exception {

			try {
				Log.info("Locating Email_Address element");
				element = Driver.findElement(By.xpath("profile.email"));

				Log.info("Email_Address field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Email_Address");
				Log.error("Email_Address field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement MobileNumber() throws Exception {

			try {
				Log.info("Locating MobileNumber element");
				element = Driver.findElement(By.id("profile.moibile"));

				Log.info("MobileNumber field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MobileNumber");
				Log.error("MobileNumber field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement HomeStore() throws Exception {

			try {
				Log.info("Locating HomeStore element");
				element = Driver.findElement(By.id("profile.homeStore.name"));

				Log.info("HomeStore field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method HomeStore");
				Log.error("HomeStore field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement DOBCalanderBtn() throws Exception {

			try {
				Log.info("Locating DOBCalanderBtn element");
				element = Driver.findElement(By.xpath("//*[@id='profile.dob']/following-sibling::button"));

				Log.info("DOB calender button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method DOBCalanderBtn");
				Log.error("DOB calender button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static class Calender {

			public static WebElement Year() throws Exception {

				try {
					Log.info("Locating Year element");
					element = Driver.findElement(
							By.xpath("//*[@id='ui-datepicker-div']/div/div/select[@class='ui-datepicker-year']"));

					Log.info("Year dropdown is found on the profile Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Year");
					Log.error("Year dropdown is not found on the profile Page");
					throw e;
				}

				return element;

			}

			public static WebElement Month() throws Exception {

				try {
					Log.info("Locating Month element");
					element = Driver.findElement(
							By.xpath("//*[@id='ui-datepicker-div']/div/div/select[@class='ui-datepicker-month']"));

					Log.info("Month dropdown is found on the profile Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Month");
					Log.error("Month dropdown is not found on the profile Page");
					throw e;
				}

				return element;

			}

			public static WebElement DateTable() throws Exception {

				try {
					Log.info("Locating DateTable element");
					element = Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody"));

					Log.info("DateTable is found on the profile Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method DateTable");
					Log.error("DateTable is not found on the profile Page");
					throw e;
				}

				return element;

			}

		}

		public static WebElement ProfileUpdateDetails_Button() {

			try {
				Log.info("Locating ProfileUpdateDetails_Button element");
				element = Driver.findElement(By.xpath("//button[contains(text(), 'Save Updates')]"));

				Log.info("Profile UpdateDetails Button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ProfileUpdateDetails_Button");
				Log.error("Profile UpdateDetails Button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Settings() throws Exception {

			try {
				Log.info("Locating Settings element");
				element = Driver.findElement(By.linkText("Settings"));

				Log.info("Settings Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Settings");
				Log.error("Settings Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Addresses() throws Exception {

			try {
				Log.info("Locating Addresses element");
				element = Driver.findElement(By.linkText("Addresses"));

				Log.info("Addresses Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Addresses");
				Log.error("Addresses Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement AddNewAddress() throws Exception {

			try {
				Log.info("Locating AddNewAddress element");
				element = Driver.findElement(By.linkText("Add a new address"));

				Log.info("New Address Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AddNewAddress");
				Log.error("New Address Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static List<WebElement> DefaultShippingAddresstext() throws Exception {

			try {
				Log.info("Locating DefaultShippingAddresstext elements");
				elementList = Driver.findElements(By.xpath("//p[starts-with(text(), 'Default Shipping')]"));

				Log.info("Default shipping list element is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method DefaultShippingAddresstext");
				Log.error("Default shipping list element is not found on the profile Page");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> AddressList() throws Exception {

			try {
				Log.info("Locating AddressList elements");
				elementList = Driver.findElements(By.xpath("//div[@class='list_address']/ul/li"));

				Log.info("Address list element is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AddressList");
				Log.error("Address list element is not found on the profile Page");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> MakeItAsDefaultShippingAddresstext() throws Exception {

			try {
				Log.info("Locating MakeItAsDefaultShippingAddresstext elements");
				elementList = Driver
						.findElements(By.xpath("//a[starts-with(text(), 'Make this my default shipping')]"));

				Log.info("Make this my default shipping element is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MakeItAsDefaultShippingAddresstext");
				Log.error("Make this my default shipping element is not found on the profile Page");
				throw e;
			}

			return elementList;

		}

		public static WebElement EditAddressBtn() throws Exception {

			try {
				Log.info("Locating EditAddressBtn element");
				//element = Driver.findElement(By.xpath("//div[@class='list_address']/ul/li[1]//a[@class='edit']"));
				element = Driver.findElement(By.xpath("html/body/main/section/div/div/div[2]/div[2]/div/div/ul/li[1]/ul/li[3]/a[2]"));

				Log.info("Edit Address button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditAddressBtn");
				Log.error("Edit Address button is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement CheckoutEditAddressBtn() throws Exception {

			try {
				Log.info("Locating EditAddressBtn element");
				element = Driver.findElement(By.xpath("//div[@class='checkoutAddressID']decendent::a[@class='edit']"));
				//element = Driver.findElement(By.xpath("html/body/main/section/div/div/div[2]/div[2]/div/div/ul/li[1]/ul/li[3]/a[2]"));

				Log.info("Edit Address button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditAddressBtn");
				Log.error("Edit Address button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement DeleteAddressBtn() throws Exception {

			try {
				Log.info("Locating DeleteAddressBtn element");
				//element = Driver.findElement(By.xpath("//div[@class='list_address']/ul/li[1]//a[@class='remove']"));
				element = Driver.findElement(By.xpath("html/body/main/section/div/div/div[2]/div[2]/div/div/ul/li[2]/ul/li[3]/a[1]"));
				Log.info("Delete address button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method DeleteAddressBtn");
				Log.error("Delete address button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static class Address {

			public static WebElement FirstName() throws Exception {

				try {
					Log.info("Locating FirstName element");
					element = Driver.findElement(By.id("address.firstName"));

					Log.info("FirstName field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method FirstName");
					Log.error("FirstName field is not found on the address Page");
					throw e;
				}

				return element;
			}
				
				public static WebElement LastName() throws Exception {

					try {
						Log.info("Locating LastName element");
						element = Driver.findElement(By.id("address.lastName"));

						Log.info("LastName field is found on the address Page");

					} catch (Exception e) {
						Log.error("Exception in Class MyAccount_Page | Method LastName");
						Log.error("FirstName field is not found on the address Page");
						throw e;
					}

					return element;

			}

			public static WebElement PostCode() throws Exception {

				try {
					Log.info("Locating PostCode element");
					element = Driver.findElement(By.id("address.postcode"));

					Log.info("PostCode field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method PostCode");
					Log.error("PostCode field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement Address1() throws Exception {

				try {
					Log.info("Locating Address1 element");
					element = Driver.findElement(By.id("address.line1"));

					Log.info("Address field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Address1");
					Log.error("Address field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement City() throws Exception {

				try {
					Log.info("Locating City element");
					element = Driver.findElement(By.id("address.townCity"));

					Log.info("City field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method City");
					Log.error("City field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement Phone() throws Exception {

				try {
					Log.info("Locating Phone element");
					element = Driver.findElement(By.id("address.phone"));

					Log.info("Phone field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Phone");
					Log.error("Phone field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement Landmark() throws Exception {

				try {
					Log.info("Locating Landmark element");
					element = Driver.findElement(By.id("address.line2"));

					Log.info("Landmark field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Landmark");
					Log.error("Landmark field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement DefaultAddressCheckbox() throws Exception {

				try {
					Log.info("Locating DefaultAddressCheckbox element");
					element = Driver.findElement(By.id("myShippingAddress"));

					Log.info("DefaultAddress Checkbox is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method DefaultAddressCheckbox");
					Log.error("DefaultAddress Checkbox is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement AddAddressBtn() throws Exception {

				try {
					Log.info("Locating AddAddressBtn element");
					element = Driver.findElement(By.id("accountAddAddress"));

					Log.info("AddAddress Button is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method AddAddressBtn");
					Log.error("AddAddress Button is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement CancelBtn() throws Exception {

				try {
					Log.info("Locating CancelBtn element");
					element = Driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]"));

					Log.info("Cancel Button is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method CancelBtn");
					Log.error("Cancel Button is not found on the address Page");
					throw e;
				}

				return element;

			}

		}

		public static WebElement NewsletterandSubscription() throws Exception {

			try {
				Log.info("Locating NewsletterandSubscription element");
				element = Driver.findElement(By.linkText("Newsletters & Subscriptions"));

				Log.info(" NewsletterandSubscription Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterandSubscription");
				Log.error("NewsletterandSubscription Link is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement NewsletterServices(String category) throws Exception {

			try {
				Log.info("Locating NewsletterServices element");
				element = Driver.findElement(By.xpath("//*[@class='catergies']//*[@id='"+category+"']"));

				Log.info(" NewsletterServices "+category+ " option is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterServices");
				Log.error("NewsletterServices "+category+ " option is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement NewsletterFrequency(String freq) throws Exception {

			try {
				Log.info("Locating NewsletterFrequency element");
				element = Driver.findElement(By.xpath("//*[@class='weekly_main']//*[@id='"+freq+"']"));

				Log.info(" NewsletterFrequency "+freq+ " option is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterFrequency");
				Log.error("NewsletterFrequency "+freq+ " option is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement NewsletterUpdateBtn() throws Exception {

			try {
				Log.info("Locating NewsletterUpdate Button element");
				element = Driver.findElement(By.id("updateBtnId"));

				Log.info(" NewsletterUpdate button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterUpdateBtn");
				Log.error("NewsletterUpdate button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword() throws Exception {

			try {
				Log.info("Locating ChangePassword element");
				element = Driver.findElement(By.id("chngbtn"));

				Log.info(" Change password Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword");
				Log.error("Change password Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword_CurrentPassword() throws Exception {

			try {
				Log.info("Locating ChangePassword_CurrentPassword element");
				element = Driver.findElement(By.id("profile.currentPassword"));

				Log.info("Profile currentPassword field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword_CurrentPassword");
				Log.error("Profile currentPassword field  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword_NewPassword() throws Exception {

			try {
				Log.info("Locating ChangePassword_NewPassword element");
				element = Driver.findElement(By.id("profile-newPassword"));

				Log.info("NewPassword field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword_NewPassword");
				Log.error("NewPassword field  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword_NewPasswordConfirm() throws Exception {

			try {
				Log.info("Locating ChangePassword_NewPasswordConfirm element");
				element = Driver.findElement(By.id("profile.checkNewPassword"));

				Log.info(" ChangePassword Confirm NewPassword field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword_NewPasswordConfirm");
				Log.error(" ChangePassword Confirm NewPassword field  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement UpdatePassword_Btn() throws Exception {

			try {
				Log.info("Locating UpdatePassword_Btn element");
				element = Driver.findElement(By.xpath("//button[@class='sbt-button']"));

				Log.info("Update button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method UpdatePassword_Btn");
				Log.error("Update button  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Cancel_Btn() throws Exception {

			try {
				Log.info("Locating Cancel_Btn element");
				element = Driver.findElement(By.xpath("//button[@id='canclbtn']"));

				Log.info("Cancel button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Cancel_Btn");
				Log.error("Cancel button is not found on the profile Page");
				throw e;
			}

			return element;

		}

	}

	public static class OrderHistory {

		public static WebElement NoOrderText() throws Exception {

			try {
				Log.info("Locating NoOrderText element");
				element = Driver.findElement(By.xpath("//div[@class='content-wpr']/h3"));

				Log.info("No Order message found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NoOrderText");
				Log.error("No Order message not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ToolTip() throws Exception {

			try {
				Log.info("Locating ToolTip element");
				element = Driver.findElement(By.xpath("//*[@class='infoTooltip']/span"));

				Log.info("ToolTip found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ToolTip");
				Log.error("ToolTip element not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ImageCheckBox() throws Exception {

			try {
				Log.info("Locating Image checkbox element");
				element = Driver.findElement(By.xpath("//*[@class='checkboxClass']"));

				Log.info("Image checkbox found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ImageCheckBox");
				Log.error("Image checkbox not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement PickupRadioButton() throws Exception {

			try {
				Log.info("Locating Pickup Radio Button element");
				element = Driver.findElement(By.xpath(".//*[@id='orderDetailPickUp']/ul/li[1]//span"));

				Log.info("Pickup Radio Button found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method PickupRadioButton");
				Log.error("Pickup Radio Button not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement PickupRadioButtonText() throws Exception {

			try {
				Log.info("Locating Pickup Radio Button text element");
				element = Driver.findElement(By.xpath(".//*[@id='orderDetailPickUp']/div[1]/p"));

				Log.info("Pickup Radio Button text found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method PickupRadioButtonText");
				Log.error("Pickup Radio Button text not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement IwillCourierButton() throws Exception {

			try {
				Log.info("Locating I will Courier button element");
				element = Driver.findElement(By.xpath(".//*[@id='orderDetailPickUp']/ul/li[2]/div/label"));

				Log.info("I will Courier button found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method IwillCourierButton");
				Log.error("I will Courier button not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement IwillCourierButtonText() throws Exception {

			try {
				Log.info("Locating I will Courier Button Text element");
				element = Driver.findElement(By.xpath(".//*[@id='orderDetailPickUp']/div[2]/p"));

				Log.info("I will Courier Button Text found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method IwillCourierButtonText");
				Log.error("I will Courier Button Text not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ShopperStopCreditButton() throws Exception {

			try {
				Log.info("Locating  Shopper Stop Credit Button element");
				element = Driver.findElement(By.xpath(".//*[@id='orderDetailRefund']/ul/li[1]/div/label"));

				Log.info(" ShopperStopCreditButton found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ShopperStopCreditButton");
				Log.error(" ShopperStopCreditButton not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement NEFTbutton() throws Exception {

			try {
				Log.info("Locating NEFTbutton element");
				element = Driver.findElement(By.xpath(".//*[@id='orderDetailRefund']/ul/li[2]/div/label"));

				Log.info("NEFTbutton found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NEFTbutton");
				Log.error("NEFTbutton element not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		
		public static WebElement SaveSubmittbutton() throws Exception {

			try {
				Log.info("Locating Submitt element");
				element = Driver.findElement(By.xpath(".//*[@id='returnSubmit']/button"));

				Log.info("Submitt button found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method SaveSubmittbutton");
				Log.error("Submitt button not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement SaveCanceltbutton() throws Exception {

			try {
				Log.info("Locating Cancel element");
				element = Driver.findElement(By.xpath(".//*[@id='CancelReturnRequest']/button"));

				Log.info("Cancel button found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method SaveSubmittbutton");
				Log.error("Cancel button not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement AccountHolderMsg() throws Exception {

			try {
				Log.info("Locating AccountHolderMsg element");
				element = Driver.findElement(By.xpath(".//*[@id='accountHolderMessage']"));

				Log.info("AccountHolderMsg found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AccountHolderMsg()");
				Log.error("AccountHolderMsg not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement AccountNumberMsg() throws Exception {

			try {
				Log.info("Locating AccountNumberMsg element");
				element = Driver.findElement(By.xpath(".//*[@id='accountNumberMessage']"));

				Log.info("AccountNumberMsg found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AccountNumberMsg");
				Log.error("AccountNumberMsg not found on the Orders Page");
				throw e;
			}

			return element;

		}
		public static WebElement BankNameMsg() throws Exception {

			try {
				Log.info("Locating BanknameMsg element");
				element = Driver.findElement(By.xpath(".//*[@id='bankNameMessage']"));

				Log.info("BankNameMsg found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method BankNameMsg");
				Log.error("BankNameMsg not found on the Orders Page");
				throw e;
			}

			return element;

		}
		public static WebElement IFSCMsg() throws Exception {

			try {
				Log.info("Locating ifsc code Msg element");
				element = Driver.findElement(By.xpath(".//*[@id='IFSCCodeMessage']"));

				Log.info("ifsc code Msg found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method IFSCMsg");
				Log.error("Aifsc code Msg not found on the Orders Page");
				throw e;
			}

			return element;

		}
		public static WebElement IFSCCode() throws Exception {

			try {
				Log.info("Locating IFCS code element");
				element = Driver.findElement(By.xpath(".//*[@id='IFSCCode']"));

				Log.info("IFCS code found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method IFSCCode");
				Log.error("IFCS code not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement AccountName() throws Exception {

			try {
				Log.info("Locating AccountHolder text element");
				element = Driver.findElement(By.xpath(".//*[@id='accountHolder']"));

				Log.info("AccountHolder found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AccountName");
				Log.error("AccountHolder not found on the Orders Page");
				throw e;
			}

			return element;

		}
		public static WebElement AccountNumber() throws Exception {

			try {
				Log.info("Locating Account Number element");
				element = Driver.findElement(By.xpath(".//*[@id='accountNumber']"));

				Log.info("Account Number found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AccountNumber");
				Log.error("Account Number not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement BankName() throws Exception {

			try {
				Log.info("Locating Bank Name element");
				element = Driver.findElement(By.xpath(".//*[@id='bankName']"));

				Log.info("Bank Name found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method BankName");
				Log.error("Bank name element not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement TrackOrderEmail() throws Exception {

			try {
				Log.info("Locating email element");
				element = Driver.findElement(By.xpath(".//*[@id='emailAddress']"));

				Log.info("email field found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method TrackOrderEmail");
				Log.error("email field not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement TrackOrderNo() throws Exception {

			try {
				Log.info("Locating order number field element");
				element = Driver.findElement(By.xpath(".//*[@id='orderCode']"));

				Log.info("Order number field found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method TrackOrderNo");
				Log.error("Order number field not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement TrackSubmittBtn() throws Exception {

			try {
				Log.info("Locating Submitt button on track page field element");
				element = Driver.findElement(By.xpath(".//*[@id='trackOrderForm']//*[@class='sbt-button']"));

				Log.info("Submitt button on track page  found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method TrackSubmittBtn");
				Log.error("Submitt button on track page not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ToolTipText() throws Exception {

			try {
				Log.info("Locating ToolTipText element");
				element = Driver.findElement(By.xpath("//*[@class='infoTooltip']//*[@class='arrow_box']"));

				Log.info("ToolTipText found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ToolTipText");
				Log.error("ToolTipText element not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement OrderDetailOnViewDetail() throws Exception {

			try {
				Log.info("Locating OrderDetail element");
				element = Driver.findElement(By.xpath("//*[@class='detail-page clearfix']//*[@href='/my-account/orders']"));

				Log.info("OrderDetail found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderDetailOnViewDetail");
				Log.error("OrderDetail element not found on the Orders Page");
				throw e;
			}

			return element;

		}
		public static WebElement RecentOrdersTab() throws Exception {

			try {
				Log.info("Locating RecentOrdersTab element");
				element = Driver.findElement(By.xpath("//a[text()='Recent Orders']"));
				

				Log.info("Recent Orders tab is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RecentOrdersTab");
				Log.error("Recent Orders tab is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		
		public static WebElement OrderHistoryTab() throws Exception {

			try {
				Log.info("Locating Order History Tab element");
				element = Driver.findElement(By.xpath("//a[text()='Order History']"));
				

				Log.info("Order History Tab is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RecentOrdersTab");
				Log.error("Recent Orders tab is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		public static WebElement OldOrdersTab() throws Exception {

			try {
				Log.info("Locating OldOrdersTab element");
				element = Driver.findElement(By.xpath("//a[text()='Old Orders']"));

				Log.info("Old Orders tab is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OldOrdersTab");
				Log.error("Old Orders tab is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeOrdersTab() throws Exception {

			try {
				Log.info("Locating Return/ExchangeTab element");
				element = Driver.findElement(By.xpath("//a[text()='Return/Exchange Orders']"));

				Log.info("Return/Exchange Tab is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OldOrdersTab");
				Log.error("Return/Exchange Tab is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ViewMoreButton() throws Exception {

			try {
				Log.info("Locating VIEWMORE button element");
				element = Driver.findElement(By.xpath(".//*[@id='loadmoreorders']"));

				Log.info("VIEWMORE button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ViewMoreButton");
				Log.error("VIEWMORE button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ItemUnapprovedText() throws Exception {

			try {
				Log.info("Locating Unapproved text element");
				element = Driver.findElement(By.xpath(".//*[@id='retExchangeRadio']//*[@class='unapprovedMsg']"));

				Log.info("Unapproved text is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ItemUnapprovedText");
				Log.error("Unapproved text is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement WriteAProductReviewButton() throws Exception {

			try {
				Log.info("Locating WRITE A PRODUCTRE VIEW button element");
				element = Driver.findElement(By.xpath("//*[@href='#write_review']"));

				Log.info("WRITE A PRODUCTRE VIEW button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WriteAProductReviewButton");
				Log.error("WRITE A PRODUCTRE VIEW button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeButton() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE button element");
				element = Driver.findElement(By.xpath(".//*[@id='initiateReturn']"));

				Log.info("RETURN AND EXCHANGE button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeButton");
				Log.error("RETURN AND EXCHANGE button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
	
		
		public static WebElement ReturnExchangeWindowImage() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window Image element");
				element = Driver.findElement(By.xpath(".//*[@id='return-modal-class']/div[2]/div[2]/div//img[contains(@src,'sys-master')]"));

				Log.info("RETURN AND EXCHANGE Window Image is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowImage");
				Log.error("RETURN AND EXCHANGE Window Image is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement OrderDetailWindowImage() throws Exception {

			try {
				Log.info("Locating Order Detail Window Image element");
				element = Driver.findElement(By.xpath("//*[@class='shop-listing']//img"));

				Log.info("Order Detail Window Window Image is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderDetailWindowImage");
				Log.error("Order Detail Window is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement OrderDetailReturnExchangeLink() throws Exception {

			try {
				Log.info("Locating Order Detail ReturnExchange Link element");
				element = Driver.findElement(By.xpath(".//*[@id='desc-tabs']/ul/li[2]/a/span"));

				Log.info("Order Detail ReturnExchange Link is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderDetailReturnExchangeLink");
				Log.error("Order Detail ReturnExchange Link is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement EasyReturnText() throws Exception {

			try {
				Log.info("Locating Order Detail EasyReturnText element");
				element = Driver.findElement(By.xpath(".//*[@id='desc2']//li[1]"));

				Log.info("Order Detail EasyReturnText is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EasyReturnText");
				Log.error("Order Detail EasyReturnText is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement TrackReturnExchangeButton() throws Exception {

			try {
				Log.info("Locating Track RETURN AND EXCHANGE button element");
				element = Driver.findElement(By.xpath(".//*[@id='trackReturn']"));

				Log.info("Track RETURN AND EXCHANGE button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeButton");
				Log.error("Track RETURN AND EXCHANGE button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement TrackReturnExchangeButtonWindow() throws Exception {

			try {
				Log.info("Locating Track RETURN AND EXCHANGE window element");
				element = Driver.findElement(By.xpath(".//*[@id='resultsList']//*[@class='order-traking-wpr return-traking-wpr consignment-traking-wpr']"));

				Log.info("Track RETURN AND EXCHANGE window is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method TrackReturnExchangeButtonWindow");
				Log.error("Track RETURN AND EXCHANGE window is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindowFull() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE full Window  element");
				element = Driver.findElement(By.xpath(".//*[@id='return-modal-class']"));

				Log.info("RETURN AND EXCHANGE full Window is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowImage");
				Log.error("RETURN AND EXCHANGE full Window is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindowColour() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window Image element");
				element = Driver.findElement(By.xpath(".//*[@id='return-modal-class']//li[1]//*[@class='lbl-bag']"));

				Log.info("RETURN AND EXCHANGE Window colour is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowImage");
				Log.error("RETURN AND EXCHANGE Window colour is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindowSize() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window Image element");
				element = Driver.findElement(By.xpath(".//*[@id='return-modal-class']//li[2]//li[2]//*[@class='lbl-bag']"));

				Log.info("RETURN AND EXCHANGE Window size is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowImage");
				Log.error("RETURN AND EXCHANGE Window size is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindowQuantity() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window Image element");
				element = Driver.findElement(By.xpath(".//*[@id='return-modal-class']//li[2]//li[3]//*[@class='lbl-bag']"));

				Log.info("RETURN AND EXCHANGE Window Quantity icon is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowImage");
				Log.error("RETURN AND EXCHANGE Window Quantity icon is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		
		public static WebElement ReturnExchangeWindowDelivery() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window delivery detail element");
				element = Driver.findElement(By.xpath(".//*[@id='return-modal-class']/div[2]/div[2]/div/div[3]"));

				Log.info("RETURN AND EXCHANGE Window delivery detail is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowDelivery");
				Log.error("RETURN AND EXCHANGE Window delivery detail is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindowReturnButton() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Return button detail element");
				element = Driver.findElement(By.xpath(".//*[@id='retExchangeRadio']//*[@value='return' and @type='radio']"));

				Log.info("RETURN AND EXCHANGE Return button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowReturnButton");
				Log.error("RETURN AND EXCHANGE Return button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindowExchangeButton() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window exchange button detail element");
				element = Driver.findElement(By.xpath(".//*[@id='retExchangeRadio']//*[@value='exchange' and @type='radio']"));

				Log.info("RETURN AND EXCHANGE Window exchange button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowExchangeButton");
				Log.error("RETURN AND EXCHANGE Window exchange button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindowReturnCommentBox() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window comment box element");
				element = Driver.findElement(By.xpath(".//*[@id='ReturnComments']"));

				Log.info("RETURN AND EXCHANGE Window comment box is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowReturnCommentBox");
				Log.error("RETURN AND EXCHANGE Window comment box is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ExchangeWindowCommentBox() throws Exception {

			try {
				Log.info("Locating EXCHANGE Window comment box element");
				element = Driver.findElement(By.xpath(".//*[@id='ExchangeComments']"));

				Log.info("EXCHANGE Window comment box is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowReturnCommentBox");
				Log.error("EXCHANGE Window comment box is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindowReturnReasonBox() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window exchange button detail element");
				element = Driver.findElement(By.xpath(".//*[@id='custom-form-id-return']"));

				Log.info("RETURN AND EXCHANGE Window reason box is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowReturnReasonBox");
				Log.error("RETURN AND EXCHANGE Window Reason box is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindowSaveButton() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window save button detail element");
				element = Driver.findElement(By.xpath(".//*[@id='return-modal-class']//*[@class='bttn redBtn popUpRedBtn']"));

				Log.info("RETURN AND EXCHANGE Window save button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowSaveButton");
				Log.error("RETURN AND EXCHANGE Window save button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindowCancelButton() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window cancel button detail element");
				element = Driver.findElement(By.xpath(".//*[@id='return-modal-class']//*[@class='bttn grayBtn']"));

				Log.info("RETURN AND EXCHANGE Window cancel button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindowCancelButton");
				Log.error("RETURN AND EXCHANGE Window cancel button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReturnExchangeWindow() throws Exception {

			try {
				Log.info("Locating Review AND Rating Window detail element");
				element = Driver.findElement(By.xpath(".//*[@id='write-review-wrapper']"));

				Log.info("Review AND Rating Window is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnExchangeWindow");
				Log.error("Review AND Rating Window is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement EditQuantityLink() throws Exception {

			try {
				Log.info("Locating Edit Quantity element");
				element = Driver.findElement(By.xpath(".//*[@id='exchangeQtyEditId']"));

				Log.info("Edit Quantity link is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditQuantityLink");
				Log.error("Edit Quantity link not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement EditTextBox() throws Exception {

			try {
				Log.info("Locating Edit textbox element");
				element = Driver.findElement(By.xpath(".//*[@id='qt_exc_id']"));

				Log.info("Edit textbox is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditTextBox");
				Log.error("Edit textbox not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReasonAlertMessage() throws Exception {

			try {
				Log.info("Locating Reason AlertMessage element");
				element = Driver.findElement(By.xpath(".//*[@id='exchange-error_msgId']"));

				Log.info("Reason AlertMessage is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReasonAlertMessage");
				Log.error("Reason AlertMessage not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ReasonTextBox() throws Exception {

			try {
				Log.info("Locating Reason TextBox element");
				element = Driver.findElement(By.xpath(".//*[@id='custom-form-id-return']"));

				Log.info("Reason Textbox is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReasonTextBox");
				Log.error("ReasonTextBox not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		
		public static WebElement ExchangeReasonTextBox() throws Exception {

			try {
				Log.info("Locating Exchange window Reason TextBox element");
				element = Driver.findElement(By.xpath(".//*[@id='custom-form-id-exchange']"));

				Log.info("Exchange window Reason Textbox is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ExchangeReasonTextBox");
				Log.error("Exchange window ReasonTextBox not found on the Orders Page");
				throw e;
			}

			return element;

		}
		public static WebElement PickupDetail() throws Exception {

			try {
				Log.info("Locating Pickup detail window element");
				element = Driver.findElement(By.xpath(".//*[@id='orderDetailPickUp']"));

				Log.info("Pickup detail is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method PickupDetail");
				Log.error("Pickup detail not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement RefundDetail() throws Exception {

			try {
				Log.info("Locating Refund detail window element");
				element = Driver.findElement(By.xpath(".//*[@id='orderDetailRefund']"));

				Log.info("Refund detail window is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RefundDetail");
				Log.error("Refund detail window not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement CheckBoxButton() throws Exception {

			try {
				Log.info("Locating checkbox button element");
				element = Driver.findElement(By.xpath("//*[@class='checkboxClass']"));

				Log.info("checkbox button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method CheckBoxButton");
				Log.error("checkbox button not found on the Orders Page");
				throw e;
			}

			return element;

		}
		public static WebElement GrayReturnExchangeButton() throws Exception {

			try {
				Log.info("Locating GarycolorRETURN AND EXCHANGE button element");
				element = Driver.findElement(By.xpath("//*[@class='bttn gray-button btn-block' and @type='button']"));

				Log.info(" GRAY RETURN AND EXCHANGE button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method GrayReturnExchangeButton");
				Log.error("GrayReturnExchange button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ExchangeWindowImage() throws Exception {

			try {
				Log.info("Locating  EXCHANGE Window Image element");
				element = Driver.findElement(By.xpath(".//*[@id='exchange-slider-id']/div/li/div[2]/a/img"));

				Log.info("EXCHANGE Window Image is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ExchangeWindowImage");
				Log.error("EXCHANGE Window Image is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ExchangeWindowColour() throws Exception {

			try {
				Log.info("Locating EXCHANGE Window colour element");
				element = Driver.findElement(By.xpath(".//*[@id='return-window-close']//*[@class='variant-name']"));

				Log.info("EXCHANGE Window colour is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ExchangeWindowColour");
				Log.error("EXCHANGE Window colour is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ExchangeWindowSize() throws Exception {

			try {
				Log.info("Locating EXCHANGE Window size element");
				element = Driver.findElement(By.xpath(".//*[@id='return-window-close']//*[@class='exchange_size_width size_button clearfix']"));

				Log.info("EXCHANGE Window size is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ExchangeWindowSize");
				Log.error("size is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ResetSize() throws Exception {

			try {
				Log.info("Locating Reset size element");
				element = Driver.findElement(By.xpath(".//*[@class='resetExcSizeLink']"));

				Log.info("Reset size is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ExchangeWindowSize");
				Log.error("Reset size is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static List<WebElement> SizeButtons() throws Exception {

			try {
				Log.info("Locating SizeButtons elements");
				elementList = Driver.findElements(By.xpath(".//*[@id='wish-to-exchange-content']//div[1]/li/div[3]//*[@id='exchangeButton']//button"));

				Log.info("SizeButtons elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method SizeButtons");
				Log.error("SizeButtons are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}	
		
		
		public static List<WebElement> ExchangeButtons() throws Exception {

			try {
				Log.info("Locating SizeButtons elements");
				elementList = Driver.findElements(By.xpath(".//*[@id='initiateReturn']"));

				Log.info("Return and exchange Buttons elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ExchangeButtons");
				Log.error("Return and exchange Buttons elements not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> ReviewRatingButtons() throws Exception {

			try {
				Log.info("Locating Review rating elements");
				elementList = Driver.findElements(By.xpath("//a[@title='Reviews & Ratings']"));

				Log.info("Review rating Buttons elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReviewRatingButtons");
				Log.error("Review rating Buttons elements not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> SecondWindowSizeButtons() throws Exception {

			try {
				Log.info("Locating SizeButtons elements");
				elementList = Driver.findElements(By.xpath(".//*[@id='wish-to-exchange-content']//div[2]/li/div[3]//*[@id='exchangeButton']//button"));

				Log.info("SizeButtons elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method SizeButtons");
				Log.error("SizeButtons are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		public static List<WebElement> ThirdWindowSizeButtons() throws Exception {

			try {
				Log.info("Locating SizeButtons elements");
				elementList = Driver.findElements(By.xpath(".//*[@id='wish-to-exchange-content']//div[3]/li/div[3]//*[@id='exchangeButton']//button"));

				Log.info("SizeButtons elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method SizeButtons");
				Log.error("SizeButtons are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> FourtWindowSizeButtons() throws Exception {

			try {
				Log.info("Locating SizeButtons elements");
				elementList = Driver.findElements(By.xpath(".//*[@id='wish-to-exchange-content']//div[4]/li/div[3]//*[@id='exchangeButton']//button"));

				Log.info("SizeButtons elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method SizeButtons");
				Log.error("SizeButtons are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}

		public static WebElement ExchangeWindowReturnCommentBox() throws Exception {

			try {
				Log.info("Locating EXCHANGE Window comment box element");
				element = Driver.findElement(By.xpath(".//*[@id='ExchangeComments']"));

				Log.info("EXCHANGE Window comment box is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ExchangeWindowReturnCommentBox");
				Log.error("EXCHANGE Window comment box is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ExchangeWindowReturnReasonBox() throws Exception {

			try {
				Log.info("Locating EXCHANGE Window exchange button detail element");
				element = Driver.findElement(By.xpath(".//*[@id='custom-form-id-exchange']"));

				Log.info("EXCHANGE Window reason box is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ExchangeWindowReturnReasonBox");
				Log.error("EXCHANGE Window Reason box is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ExchangeWindowSaveButton() throws Exception {

			try {
				Log.info("Locating RETURN AND EXCHANGE Window save button detail element");
				element = Driver.findElement(By.xpath(".//*[@id='return-modal-class']//*[@class='bttn redBtn popUpRedBtn']"));

				Log.info("EXCHANGE Window save button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ExchangeWindowSaveButton");
				Log.error("EXCHANGE Window save button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ExchangeWindowCancelButton() throws Exception {

			try {
				Log.info("Locating EXCHANGE Window cancel button detail element");
				element = Driver.findElement(By.xpath(".//*[@id='return-modal-class']//*[@class='bttn grayBtn']"));

				Log.info("EXCHANGE Window cancel button is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ExchangeWindowCancelButton");
				Log.error("EXCHANGE Window cancel button is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		

		public static List<WebElement> OrderId() throws Exception {

			try {
				Log.info("Locating OrderId elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Order ID']"));

				Log.info("Order Id elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderId");
				Log.error("Order Id elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> OrderDate() throws Exception {

			try {
				Log.info("Locating Order Date elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Order Date']"));

				Log.info("Order Date elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderDate");
				Log.error("Order Date elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> TotalQuantity() throws Exception {

			try {
				Log.info("Locating TotalQuantity elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Total Quantity']"));

				Log.info("Total Quantity elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method TotalQuantity");
				Log.error("Total Quantity elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> AmountPaid() throws Exception {

			try {
				Log.info("Locating Amount paid elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Amount paid']"));

				Log.info("Amount paid elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AmountPaid");
				Log.error("Amount paid elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> Status() throws Exception {

			try {
				Log.info("Locating Status elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Status']"));

				Log.info("Status elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Status");
				Log.error("Status elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> Tracking() throws Exception {

			try {
				Log.info("Locating Tracking elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[contains(text(),'Tracking')]"));

				Log.info("Tracking elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Tracking");
				Log.error("Tracking elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> OrderAction() throws Exception {

			try {
				Log.info("Locating OrderAction elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//a[contains(@class, 'sbt-button')]"));

				Log.info("Order Action elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderAction");
				Log.error("Order Action elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static class orderDetails{
			
			public static WebElement orderDetailsSection() throws Exception {

				try {
					Log.info("Locating orderDetailsSection element");
					element = Driver.findElement(By.xpath("//section[@class='my-account-wpr order-detail-page']"));
					Log.info("Order details section is found on Orders page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method orderDetailsSection");
					Log.error("Order details section is not found on Orders page");

					throw (e);

				}

				return element;
			}
		}

	}

	public static class MyAccount_LeftMenu {

		static WebElement mainElement;

		public static WebElement MyShoppersStop() throws Exception {

			try {
				Log.info("Locating MyShoppersStop element");
				mainElement = Driver.findElement(By.xpath("//a[@title='My Shoppers Stop']"));
				Log.info("My Shoppers Stop link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MyShoppersStop");
				Log.error("My Shoppers Stop link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Orders() throws Exception {

			try {
				Log.info("Locating Orders element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Orders']"));
				Log.info("Orders link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Orders");
				Log.error("Orders link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Alerts() throws Exception {

			try {
				Log.info("Locating Alerts element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Alerts']"));
				Log.info("Orders link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Alerts");
				Log.error("Orders link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Wishlist() throws Exception {

			try {
				Log.info("Locating Wishlist element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Wishlist']"));
				Log.info("Wishlist link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Wishlist");
				Log.error("Wishlist link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Profile() throws Exception {

			try {
				Log.info("Locating Profile element");
				mainElement = Driver.findElement(By.xpath("//div[@class='my-menu']/ul/li[5]/a"));
				Log.info("Profile link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Profile");
				Log.error("Profile link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Personalization() throws Exception {

			try {
				Log.info("Locating Personalization element");
				mainElement = Driver.findElement(By.xpath("//div[@class='my-menu']/ul/li[7]/a"));
				Log.info("Personal link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Personalization");
				Log.error("Personal link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement FirstCitizenProfile() throws Exception {

			try {
				Log.info("Locating FirstCitizenProfile element");
				mainElement = Driver.findElement(By.xpath("//a[@title='First Citizen Profile']"));
				Log.info("First Citizen Profile link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstCitizenProfile");
				Log.error("First Citizen Profile link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Feedback() throws Exception {

			try {
				Log.info("Locating Feedback element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Feedback']"));
				Log.info("Feedback link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Feedback");
				Log.error("Feedback link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement ReviewsRatings() throws Exception {

			try {
				Log.info("Locating ReviewsRatings element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Reviews & Ratings']"));
				Log.info("Reviews & Ratings link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReviewsRatings");
				Log.error("Reviews & Ratings link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement ShoppingList() throws Exception {

			try {
				Log.info("Locating ShoppingList element");
				mainElement = Driver.findElement(By.linkText("Saved Shopping Lists"));
				Log.info("ShoppingList link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ShoppingList");
				Log.error("ShoppingList link is not found on MyAccount left menu");

				throw (e);

			}
			return mainElement;
		}


	}
}
