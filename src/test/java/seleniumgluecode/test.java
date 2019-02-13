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

import org.hamcrest.CoreMatchers;
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
	
	@Given("^the user is logged in$")
	public void the_user_is_logged_in() throws Throwable {
		the_user_is_on_the_login_screen();
		the_user_enters_their_username_and_password();
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
	
	@Given("^the user has loaded the order page$")
	public void the_user_has_loaded_the_order_page() throws Throwable {
		driver.findElement(By.linkText("Order")).click();
	}
	
	@Given("^the user has completed the order form$")
	public void the_user_has_completed_the_order_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("1");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Ninja Bunnington");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("Melbourne Street");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Melbourne");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("0123");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("4111111111111111");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("01/19");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
		
	}
	
	@When("^the user clicks process$")
	public void the_user_clicks_process() throws Throwable {
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	}
	
	@Then("^the order will be added to the system$")
	public void the_order_will_be_added_to_the_system() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).getText();
		String PageText = driver.findElement(By.tagName("tbody")).getText();
		//System.out.println("Page text is: " + PageText);
		Assert.assertThat(PageText, CoreMatchers.containsString("New order has been successfully added."));	  
	}
		
	@Given("^the user has placed an order$")
	public void the_user_has_placed_an_order() throws Throwable {
	    // login
		the_user_is_on_the_login_screen();
		the_user_enters_their_username_and_password();
		clicks_the_login_button();
		the_user_has_loaded_the_order_page();
		
		// place an order
		the_user_has_loaded_the_order_page();
		the_user_has_completed_the_order_form();
		the_user_clicks_process();
		the_order_will_be_added_to_the_system();
	}
	
	@When("^the user switches to the view orders form$")
	public void the_user_switches_to_the_view_orders_form() throws Throwable {
	    // View all orders
		driver.findElement(By.linkText("View all orders")).click();
	}
	
	
	@When("^the user updates the order using the form$")
	public void the_user_updates_the_order_using_the_form() throws Throwable {
	    // Click the edit icon (assume they want to edit the first order in the list):
		driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid > tbody > tr:nth-child(2) > td:nth-child(13) > input[type=\"image\"]")).click();   
		Thread.sleep(2000);
		
		//Update the post/zip code:
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("3210");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
		}
	
	@Then("^the order is updated$")
	public void the_order_is_updated() throws Throwable {
	    // Check the list all orders page is shown
		
	}
	
	
	

	

}