package appModules;

import java.util.List;

import org.openqa.selenium.WebElement;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.ProductDetails_Page;
import utility.Log;
import utility.Utils;

// This is called Modularization, when we club series of actions in to one Module

public class PDP_Action {

	// iTestcaseRow is the row number of our Testcase name in the Test Data
	// sheet

	public static void Product_VerifyDetails() throws Exception {

		try {
			Utils.verifyElement(ProductDetails_Page.Product.Product_Name());
			Log.info("Verification Pass: Product Name found");

		} catch (Exception e) {
			Log.error("Product name is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product name is not present \n";
		}
		
		try {
			Utils.verifyElement(ProductDetails_Page.Product.Brand_Name());
			Log.info("Verification Pass: Brand Name found");

		} catch (Exception e) {
			Log.error("Brand name is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Brand name is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.Product.txt_Price());
			Log.info("Verification Pass: Product Text found");

		} catch (Exception e) {
			Log.error("Product price is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product price is not present \n";
		}
/*
		try {
			Utils.verifyElement(ProductDetails_Page.Product.Product_Star_Rating());
			Log.info("Verification Pass: Product Star Rating found");

		} catch (Exception e) {
			Log.error("Product Star Rating is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product Star Rating is not present \n";
		}*/

		try {
			Utils.verifyElement(ProductDetails_Page.Product.color_variant());
			Log.info("Verification Pass: Product Color Variant found");

		} catch (Exception e) {
			Log.error("Product color is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product color is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.Product.size_variant());
			Log.info("Verification Pass: Product Size Variant found");

		} catch (Exception e) {
			Log.error("Product size variant is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product size variant is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.Product.description_tabs());
			Log.info("Verification Pass: Product Description tabs found");

		} catch (Exception e) {
			Log.error("Product description tabs are not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product description tabs are not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.Product.description_content());
			Log.info("Verification Pass: Product Description content found");

		} catch (Exception e) {
			Log.error("Product description content are not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product description content are not present \n";
		}
/*
		try {
			Utils.verifyElement(ProductDetails_Page.Product.Product_Unit());
			Log.info("Verification Pass: Product Unit content found");

		} catch (Exception e) {
			Log.error("Product Unit content are not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product Unit content are not present \n";
		}*/
       
		try {
			Utils.verifyElement(ProductDetails_Page.Product.Authentic_Content());
			Log.info("Verification Pass: Product Authentic content found");

		} catch (Exception e) {
			Log.error("Product Authentic content are not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product Authentic content are not present \n";
		}
		
		try {
			Utils.verifyElement(ProductDetails_Page.Product.Free_shipping());
			Log.info("Verification Pass: Product Free shipping content found");
			Utils.mouseHover(ProductDetails_Page.Product.Free_shipping());
			//Utils.verifyElement(ProductDetails_Page.Product.Free_shippingContent());
			//System.out.println(ProductDetails_Page.Product.Free_shipping().getAttribute("title"));
			if (!(ProductDetails_Page.Product.Free_shipping().getAttribute("title").contains("Free Delivery On Orders Of Rs 900 & above"))) {
					BaseClass.errorValidation += "Free Shipping alert not present on page. \n";
				}

		} catch (Exception e) {
			Log.error("Product Free shipping content are not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product Free shipping content are not present \n";
		}
		
		
		if (ProductDetails_Page.Product.Product_Unit().getAttribute("value").equals("1")) {
			Log.info("Verification Pass: Product Unit defaulted to 1");
		} else {
			Log.error("Product Unit not defaulted to 1");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "Verification Fail: Product Unit not defaulted to 1 \n";
		}

		if (!BaseClass.errorValidation.equals("")) {
			Log.error("Exception in Class PDP_Action | Method Product_VerifyDetails");
			throw (new Exception(BaseClass.errorValidation));
		}

	}


	public static void PersistentProduct_VerifyDetails() throws Exception {

		try {
			Utils.verifyElement(ProductDetails_Page.PersistenceProduct.productName());
			Log.info("Verification Pass: Product Name found");

		} catch (Exception e) {
			Log.error("Product name is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product name is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.PersistenceProduct.productSize());
			Log.info("Verification Pass: Product Size Variant found");

		} catch (Exception e) {
			Log.error("Product size variant is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product size variant is not present \n";
		}

/*		try {
			Utils.verifyElement(ProductDetails_Page.PersistenceProduct.productPicture());
			Log.info("Verification Pass: Product Picture found");

		} catch (Exception e) {
			Log.error("Product Picture is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product Picture is not present \n";
		}*/

		try {
			Utils.verifyElement(ProductDetails_Page.PersistenceProduct.productAddToCart());
			Log.info("Verification Pass: Add to cart button is found");

		} catch (Exception e) {
			Log.error("Add to cart button is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Add to cart button is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.PersistenceProduct.productQty());
			Log.info("Verification Pass: Product quantity content found");

		} catch (Exception e) {
			Log.error("Product quantity content is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product quantity content is not present \n";
		}

		if (!BaseClass.errorValidation.equals("")) {
			Log.error("Exception in Class PDP_Action | Method PersistentProduct_VerifyDetails");
			throw (new Exception(BaseClass.errorValidation));
		}

	}

	public static boolean productcode_MatchinMiniCart(List<WebElement> productcodeObjectMiniCart, String productCode)
			throws Exception {
		boolean match = false;
		try {
			if (productcodeObjectMiniCart.size() == 1) {
				if (productcodeObjectMiniCart.get(0).getAttribute("value").equals(productCode)) {
					match = true;
					Log.info("Product code is found in mini cart window");
				}

			} else if (productcodeObjectMiniCart.size() > 1) {
				for (int i = 0; i < productcodeObjectMiniCart.size(); i++) {
					if (productcodeObjectMiniCart.get(i).getAttribute("value").equals(productCode)) {
						match = true;
						Log.info("Product code is found in mini cart window");
					}
				}
			}else{
				Log.info("Product code is not found in mini cart window");
			}

		} catch (Exception e) {
			Log.error("Exception in Class PDP_Action | Method productcode_MatchinMiniCart");
			Log.error("Issue in matching product code in mini cart window");
			throw (e);

		}
		return match;
	}

	public static void Product_Verify_SocialShare() throws Exception {

		try {
			Utils.verifyElement(ProductDetails_Page.Product.Social_TwitterLink());
			Log.info("Verification Pass: Twitter link found");

		} catch (Exception e) {
			Log.error("Twitter link is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Twitter link is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.Product.Social_FacebookLink());
			Log.info("Verification Pass: Facebook link found");

		} catch (Exception e) {
			Log.error("Facebook link is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Facebook link is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.Product.Social_GooglePlusLink());
			Log.info("Verification Pass: Google Plus link found");

		} catch (Exception e) {
			Log.error("Google plus link is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Google Plus link is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.Product.Social_PinterestLink());
			Log.info("Verification Pass: Pinterest link is found");

		} catch (Exception e) {
			Log.error("Pinterest link is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Pinterest link is not present \n";
		}

		if (!BaseClass.errorValidation.equals("")) {
			Log.error("Exception in Class PDP_Action | Method Product_Verify_SocialShare");
			throw (new Exception(BaseClass.errorValidation));
		}

	}
	
	public static void PDP__Size_Msg_Functionality() throws Exception {

		
		PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
		String text= ProductDetails_Page.Product.SizeAlert().getAttribute("value");
		System.out.println(text);

		try {
			//Utils.verifyElement(ProductDetails_Page.Product.SizeAlert());
			if (!(ProductDetails_Page.Product.SizeAlert().getText().contains("Only"))) {
				BaseClass.errorValidation += "Size alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method PDP__Size_Msg_Functionality");
			Log.error(e.getMessage());
			throw e;
		}
        Thread.sleep(3000);
		PDP_Action.product_selectDifferentSize(ProductDetails_Page.Product.size_variant_buttonlist());
		Thread.sleep(3000);
		try {
			//Utils.verifyElement(ProductDetails_Page.Product.SizeAlert());
			if (!(ProductDetails_Page.Product.SizeAlert().getText().contains("In Stock"))) {
				BaseClass.errorValidation += "Size alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method PDP__Size_Msg_Functionality");
			Log.error(e.getMessage());
			throw e;
		}

		if (!BaseClass.errorValidation.equals("")) {
			Log.error("Exception in Class PDP_Action | Method PDP__Size_Msg_Functionality");
			throw (new Exception(BaseClass.errorValidation));
		}

	}
	
	public static void product_selectDifferentSize(List<WebElement> productSizeButtonList)
			throws Exception {
		
		try {
			if (productSizeButtonList.size()>0){
				for (int i=0; i<=productSizeButtonList.size()-1;i++){
					
					if (!(productSizeButtonList.get(i).getAttribute("class").contains("grey-background"))){
						productSizeButtonList.get(i+1).click();
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
	
	public static void product_selectSize(List<WebElement> productSizeButtonList)
			throws Exception {
		
		try {
			if (productSizeButtonList.size()>0){
				for (int i=0; i<=productSizeButtonList.size()-1;i++){
					
					if (!(productSizeButtonList.get(i).getAttribute("class").contains("grey-background"))){
						productSizeButtonList.get(i).click();
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

}
