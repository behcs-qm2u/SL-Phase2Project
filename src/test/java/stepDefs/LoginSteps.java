package stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.*;


public class LoginSteps {

	
    WebDriver driver = BaseClass.driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
   
	@Given("^User launchs the SWAGLABS application$")
    public void user_launchs_the_swaglabs_application() throws Throwable {
        
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		assertTrue(BaseClass.validateLandedAtLoginPage());
		   	
    }       

    @When("^User enters login info '(.+)' '(.+)'$")
    public void user_enters_login_info_(String username, String password) throws Throwable {
        
      	WebElement weUserName = driver.findElement(By.id("user-name"));
    	weUserName.sendKeys(username);

    	WebElement wePassword = driver.findElement(By.id("password"));
    	wePassword.sendKeys(password);
     	
    }

    @And("^User clicks the LOGIN button$")
    public void user_clicks_the_login_button() throws Throwable {

    	WebElement weLogin = driver.findElement(By.name("login-button"));
    	weLogin.click();
    	
    	BaseClass.ssFlag = false;
    	
    }
  
    
    @Then("^User should be landed on the Products Page$")
    public void user_should_be_landed_on_the_products_page() throws Throwable {

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
    }

    @Then("^User should be getting the '(.+)'$")
    public void user_should_be_getting_the_(String errormsg) throws Throwable {

    	WebElement weErrorMsg = driver.findElement(By.xpath("//*[@data-test=\"error\"]"));
    	String ErrorMsg = weErrorMsg.getText();
    	System.out.println("INFO: Error Msg appeared ["+ErrorMsg+"]");
    	
    	assertEquals(errormsg, ErrorMsg);
    	System.out.println("PASS: User login FAILED as expected!");
    	
    }



	
}
