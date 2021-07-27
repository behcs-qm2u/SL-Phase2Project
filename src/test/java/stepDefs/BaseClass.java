package stepDefs;


import static org.junit.Assert.assertEquals;



import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class BaseClass {

	public static WebDriver driver;
	public static Scenario scenario;
	public static boolean ssFlag;		// default enable ScreenShot after each step

	
	/*  === Before hook ===
	 *  Setup the chrome webdriver 
	 */
	
	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		ssFlag = true;

	}
	

	/*  === AfterStep hook ===
	 *  We can perform screen capture, tweaked by the ssFlag from each step methods, default to true (enable) 
	 */
	@AfterStep
	public void afterStep(Scenario scenario){

		System.out.println("DEBUG: afterStep: ssFlag " + BaseClass.ssFlag);
		
		if (BaseClass.ssFlag == true) {
			  scenario.log("Add Screenshot");
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.attach(screenshot, "image/png", "image"); 
		}
		else {
			BaseClass.ssFlag = true;		// toggle back to enable 
		}
	}	
	
	
	/* Common method
	 * 
	 */
	public static void accessShoppingCart() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		// Navigate to the Shopping Cart
		String sCartIconXpath = "//a[@class='shopping_cart_link']";
		driver.findElement(By.xpath(sCartIconXpath)).click();
		System.out.println("INFO: Navigated to Shopping Cart page.");

		// Verify landed at Shopping Cart Page
		try {
			String weCartTitleXPath = "//span[@class='title']";
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(weCartTitleXPath)));

			assertEquals(driver.findElement(By.xpath(weCartTitleXPath)).getText(), "YOUR CART" );
			System.out.print("INFO: Landed at Shopping cart page");

		} catch (TimeoutException e) {
			System.out.println("ERROR: Timeout. Not able to access Shopping Cart");
		} catch (Throwable e ) {
			// other potential error
			System.out.println("ERROR: Not able to access Shopping Cart");
		}		
		
	}
	
	public static boolean validateLandedAtLoginPage() {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		// Check: ensure we're in the login page
		try {
			WebElement weUserName = driver.findElement(By.id("user-name"));
		    wait.until(ExpectedConditions.visibilityOf(weUserName));
		    assertEquals(driver.getTitle(), "Swag Labs"); 
	    	System.out.println("INFO: At login page of SWAGLABS application");
	    	return true;
		} 
		catch (Exception TimeOutException) { 
		    System.out.println("ERROR: Timeout. Login page of SWAGLABS application not visible.");
		    return false;
		}
		catch (Throwable e) {
			System.out.println("ERROR: Login page of SWAGLABS application not visible.");
			return false;
		}
		
	}
	
	
	/*  === After hook ===
	 *  clean up step 
	 */
	@After
    public void teardown() throws InterruptedException {

    	 	
    	Thread.sleep(2000);
		driver.quit();

    }
	
    

    
    
}
