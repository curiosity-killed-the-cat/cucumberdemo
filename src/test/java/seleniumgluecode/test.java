package seleniumgluecode;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class test {
    
	WebDriver driver = new SafariDriver();
	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	@Given("^the user is on the login screen$")
	public void the_user_is_on_the_login_screen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions	
		//WebDriver driver = new SafariDriver();
		driver.manage().window().maximize(); 
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/");
		String PageTitle = driver.getTitle();
        Assert.assertEquals("Web Orders Login", PageTitle);
        String CurrentURL = driver.getCurrentUrl();        
	    //throw new PendingException();
	}
    
	@When("^the user enters their username and password$")
	public void the_user_enters_their_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
    	driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		//throw new PendingException();
	}
	
	@When("^clicks the login button$")
	public void clicks_the_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("CKTC Debug: 6");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();   
        System.out.println("CKTC Debug: 66");
		Thread.sleep(3000);
		String PageTitle = driver.getTitle();
        Assert.assertNotEquals("Web Orders Login", PageTitle);
		//throw new PendingException();
	}
	
	@Then("^the user is logged in$")
	public void the_user_is_logged_in() throws Throwable {
		System.out.println("CKTC Debug: 7");
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Given("^Given the user is logged in$")
	public void given_the_user_is_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("CKTC Debug: 777777");
		the_user_is_on_the_login_screen();
		System.out.println("CKTC Debug: 777778");
		the_user_enters_their_username_and_password();
		System.out.println("CKTC Debug: 777779");
		clicks_the_login_button();
		System.out.println("CKTC Debug: 777780");
		
	    //throw new PendingException();
	}
	
	@When("^the user clicks logout$")
	public void the_user_clicks_logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		System.out.println("CKTC Debug: Clicking logout...");
		driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();   
        System.out.println("CKTC Debug: Logout clicked....");
		
		//throw new PendingException();
	}
	
	@Then("^the login screen is shown$")
	public void the_login_screen_is_shown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		String PageTitle = driver.getTitle();
        Assert.assertEquals("XXXXXX", PageTitle);
        
	   // throw new PendingException();
	}
	
}
