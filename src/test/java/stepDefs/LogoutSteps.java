package stepDefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {

	WebDriver driver = BaseClass.driver;
	WebDriverWait wait = new WebDriverWait(driver, 10);
	boolean ssFlag = BaseClass.ssFlag;
	
	@And("^User accessed the Shopping Cart$")
	public void user_accessed_the_shopping_cart() throws Throwable {
		
		BaseClass.accessShoppingCart();
	
	}


	@When("^User click on the top-left burger menu$")
	public void user_click_on_the_topleft_burger_menu() throws Throwable {
		
    	// Click the Burger Menu
		String sBurgerMenuXpath = "//button[@id='react-burger-menu-btn']";
		driver.findElement(By.xpath(sBurgerMenuXpath)).click();
		
		// Ensure Burger Menu loaded
	    try {
	    	String sBMXpath = "//div[@class='bm-menu']";	
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sBMXpath)));
			System.out.println("INFO: Accessed to top-left burger menu.");
	    } catch (TimeoutException e) {
			System.out.println("ERROR: Timeout. Not able to accessed to top-left burger menu.");
	    } catch (Throwable e ) {
	    	// other potential error
	    	System.out.println("ERROR: Not able to accessed to top-left burger menu.");
	    }
		
	    // small delay for Screenshoot
    	Thread.sleep(1000);
	    
	}


	@And("^User click on the LOGOUT$")
	public void user_click_on_the_logout() throws Throwable {
		
    	String sSiderBarXpath = "//a[@id='logout_sidebar_link']";	
    	driver.findElement(By.xpath(sSiderBarXpath)).click();
    	System.out.println("INFO: LOGOUT sidebar clicked from the top-left burger menu");
    	
    	// Screenshoot no needed for this step
    	BaseClass.ssFlag = false;	
		
		
	}

	@Then("^User should be logged out and redirect to login page$")
	public void user_should_be_logged_out_and_redirect_to_login_page() throws Throwable {
		
		assertTrue(BaseClass.validateLandedAtLoginPage());
		System.out.println("PASS: User has ben logged out and return to login page.");
		
	}

}
