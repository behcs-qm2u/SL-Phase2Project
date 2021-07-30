package stepDefs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

	
	WebDriver driver = BaseClass.driver;
	boolean ssFlag = BaseClass.ssFlag;
	WebDriverWait wait = new WebDriverWait(driver, 10);	
	
	// Product info
	List <String> productList = new ArrayList<String>();; 
	

    @And("^User landed at Product page after logged in with standard_user$")
    public void user_landed_at_product_page_after_logged_in_with_standarduser() throws Throwable {

    	// Enter standard_user and click login button
    	driver.findElement(By.id("user-name")).sendKeys("standard_user");
    	driver.findElement(By.id("password")).sendKeys("secret_sauce");
    	driver.findElement(By.name("login-button")).click();

		// Check: ensure we're in the right page after login
	    try {
			WebElement weTitle = driver.findElement(By.xpath("//span[@class='title']"));
			String ActMsg = weTitle.getText();
			String ExpMsg = "PRODUCTS";		    

	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='inventory_container']")));
			assertEquals(ActMsg, ExpMsg);
	    	System.out.println("PASS: User login accepted and landing on PRODUCT page.");
	    }
	    catch (TimeoutException e) {
	    	System.out.println("ERROR: Login Failed. Timeout, not landing on PRODUCT page.");
	    }
		catch (Throwable e) {
			System.out.println("ERROR: Login Failed. Not landed on PRODUCT page.");
		}
    
	    // small delay for Screenshoot
    	Thread.sleep(2500);
	    
    }
    
    
	
    @When("^User click on ADD TO CART button of '(.+)'$")
    public void user_click_on_add_to_cart_button_of_a_particular_(String product) throws Throwable {

    	addProduct(product);
    
    }

    @When("^User selects the following product by clicking their ADD TO CART button$")
    public void user_selects_the_following_product_by_clicking_their_add_to_cart_button(DataTable table) throws Throwable {

    	System.out.println("DEBUG: Table Rows : " + table.height());
    	
    	// Get from the single column Data Table
    	for ( int i = 0 ; i < table.height(); i++ ) {
    		
    		System.out.println("DEBUG: Product Name : " + table.cell(i, 0));	
    		addProduct(table.cell(i, 0));
    	}
    	
    }
    
    
    /* == Helper method ===
     * click the ADD TO CART button of the given productName 
     * store the product added to productList
     */
    private void addProduct(String productName) {
    	
		// construct dynamic xpath
		String dynXpath = new String();

		/* method 1
			// Example: //button[@data-test="add-to-cart-sauce-labs-bike-light"]
			productName.toLowerCase();
			dynXpath="//button[@data-test=\"add-to-cart-" + productName.toLowerCase().replace(" ", "-") +"\"]";
		*/

		/* method 2 */
		dynXpath="//*[text()='"+ productName +"']//following::button[1]";

		// Check if product listed in the page? If yes, click ADD TO CART button
	    try {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynXpath)));
	    	driver.findElement(By.xpath(dynXpath)).click();
	    	
	    	// store the info
	    	productList.add(productName);
	    	
			System.out.println("INFO: Product [" + productName + "] found, clicked ADD TO CART button.");
			
	    } catch (TimeoutException e) {
			System.out.println("ERROR: Product [" + productName + "] not found");
			return;
	    }    	
    	
    }


    @Then("^User should be able to notice the Shopping Cart icon badge changed$")
    public void user_should_be_able_to_notice_the_shopping_cart_icon_badge_changed() throws Throwable {

    	int cartBadgeCount = getCartBadgeItemCount();
    	int expectedBadgeCount = productList.size();		// we added the counter in addProduct()
    	
    	
		assertEquals(cartBadgeCount, expectedBadgeCount);
    	System.out.println("PASS: " + expectedBadgeCount + " item(s) added to the cart.");
    	
    }

    /* == Helper method ===
     * return the number appear on the Shopping Cart Icon's badge 
     */
    private int getCartBadgeItemCount() {

		// Return Cart Badge number 
    	int badgeItemCount = 0;
    	
		// Take note the span won't appear if no item added
		// so, we wait until element valid
	    try {

	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='shopping_cart_badge']")));
			WebElement weCartBadge = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
			badgeItemCount = Integer.parseInt(weCartBadge.getText());
			System.out.println("INFO: " + badgeItemCount + "item(s) indicated on Cart's badge");
			
			// scroll into page top as we are taking screenshot later
			WebElement weCartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
			JavascriptExecutor obj = (JavascriptExecutor) driver;
			obj.executeScript("arguments[0].scrollIntoView();", weCartIcon);

				
	    } catch (TimeoutException e) {
			System.out.println("ERROR: Timeout. Not able to obtain item indication on Cart's badge");
	    } catch (Throwable e ) {
	    	// other potential error
	    	System.out.println("ERROR: Not able to obtain item indication on Cart's badge");
	    }
		
		return badgeItemCount;
    }
    
    
    @And("^User should be able examine the item in Shopping cart$")
    public void user_should_be_able_examine_the_item_in_shopping_cart_icon() throws Throwable {

    	// Access the shopping cart 
    	BaseClass.accessShoppingCart();
    	
	    // Get the inventory info in the Cart
	    List<WebElement> weInventoryList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
	    
	    
		int totalProductAdded= productList.size();

		if ( totalProductAdded > 0 ) {
			
			for ( int i = 0; i < totalProductAdded; i++) {
				
				String cartProductName = weInventoryList.get(i).getText();
				if ( productList.contains(weInventoryList.get(i).getText()) ) {
					System.out.println("INFO: Product  [" + cartProductName + "] found in cart!");	
				}
				else {
					System.out.println("ERROR: Product  [" + cartProductName + "] not found in cart!");	
				}
			}
		} 
		else {
			
			System.out.println("ERROR: Empty cart!?");
		}
		
		
		// Assert number of item in Cart 
		int cartItemCount = weInventoryList.size();
		assertEquals(cartItemCount, totalProductAdded) ;
		System.out.println("PASS: Item(s) added successfully to the CART.");
		
	    // small delay for Screenshoot
    	Thread.sleep(1000);
	
	}
	    	
	
}
