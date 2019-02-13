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
	@Given("^the user is on the login screen$")
	public void the_user_is_on_the_login_screen() throws Throwable {
		System.out.println("DEBUG POINT 000000");
		
		driver.manage().window().maximize(); 
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/");
		String PageTitle = driver.getTitle();
        Assert.assertEquals("Web Orders Login", PageTitle);       
	}
    
	@When("^the user enters their username and password$")
	public void the_user_enters_their_username_and_password() throws Throwable {
    	driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	}
	
	@When("^clicks the login button$")
	public void clicks_the_login_button() throws Throwable {
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();   
		Thread.sleep(2000);
		String PageTitle = driver.getTitle();
        Assert.assertNotEquals("Web Orders Login", PageTitle);
	}
	
	@Then("^the user is logged in$")
	public void the_user_is_logged_in() throws Throwable {
		Thread.sleep(2000);
		String PageTitle = driver.getTitle();
		System.out.println("DEBUG POINT 11111111");
        Assert.assertEquals("Web Orders", PageTitle);   
	}
	
	@Given("^the user has logged in$")
	public void the_user_has_logged_in() throws Throwable {
		System.out.println("DEBUG POINT A");
		the_user_is_on_the_login_screen();
		System.out.println("DEBUG POINT B");
		the_user_enters_their_username_and_password();
		System.out.println("DEBUG POINT C");
		clicks_the_login_button();
	}

	
	@When("^the user clicks logout$")
	public void the_user_clicks_logout() throws Throwable {
		System.out.println("DEBUG: User clicks logout!");
		driver.findElement(By.id("ctl00_logout")).click();
		System.out.println("DEBUG: click complete...!");
	}
	
	@Then("^the login screen is shown$")
	public void the_login_screen_is_shown() throws Throwable {
		Thread.sleep(2000);
		String PageTitle = driver.getTitle();
        Assert.assertEquals("Web Orders Login", PageTitle);
	}	
}
