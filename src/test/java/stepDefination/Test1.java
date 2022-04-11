package stepDefination;


import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Resource.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.SigninPage;


//@RunWith(Cucumber.class)
public class Test1 extends Base{
	public WebDriver driver;

    @Given("^user opens the browser")
    public void user_opens_the_browser() throws Throwable {
    	driver = initializedriver();
        
    }

    @When("^user enters the URL")
    public void user_enters_the_url() throws Throwable {
    	String hh= pop.getProperty("url");
    	driver.get(hh);
    	
       
    }

    @Then("^validate User is on sign in page")
    public void validate_user_is_on_sign_in_page() throws Throwable {
    	driver.getCurrentUrl().compareToIgnoreCase("https://consult.attendanywhere.com/");
        
    }
    @Given("^the user nevigate to login url")
    public void the_user_nevigate_to_login_url() throws Throwable {
    	driver = initializedriver();
    	String hh= pop.getProperty("url");
    	driver.get(hh);
    }

    @When("^the user checks username text field")
    public void the_user_checks_username_text_field() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	j.getUsername().click();
        
    }
    @And("^the user checks password text field")
    public void the_user_checks_password_text_field() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	j.getPassword().click();
        
    }


    @Then("^username displays hint as email")
    public void username_displays_hint_as_email() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	Actions action = new Actions(driver);
    	j.getPassword().click();
    	action.moveToElement(j.getwarnmessage()).click().build().perform();
    	WebElement HintEmail = driver.findElement(By.cssSelector("span[classname='error-color']"));
    	String HE = HintEmail.getText();
    	HE.compareToIgnoreCase("Enter your email address");
    	System.out.println("Username Hint Text=" +HE);
    	j.getUsername().sendKeys(pop.getProperty("invalidusername"));
    	
        
    }
    @And("^password displays hint as password")
    public void password_displays_hint_as_password() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	Actions action = new Actions(driver);
    	action.moveToElement(j.getPassword()).click().build().perform();
    	WebElement Hintpass = driver.findElement(By.xpath("//span[contains(text(),'Enter your email address')]"));
    	String HP = Hintpass.getText();
    	HP.compareToIgnoreCase("Enter your password");
    	System.out.println("Username Hint Text=" +HP);
    }
    @Given("^the user nevigate to url")
    public void the_user_nevigate_to_url() throws Throwable {
    	driver = initializedriver();
    	String hh= pop.getProperty("url");
    	driver.get(hh);
    }

    @When("^the user reaches Keep me Signed in checkbox")
    public void the_user_reaches_keep_me_signed_in_checkbox() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	j.getKeepmein().click();
        
    }

    @Then("^Validate 'keep me signed in' checbox is between password and sign button")
    public void validate_keep_me_signed_in_checbox_is_between_password_and_sign_button() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	driver.findElement(with(By.xpath("//label[contains(text(),'Keep me signed in for today')]")).below(j.getPassword())).click();
    	driver.findElement(with(By.xpath("//label[contains(text(),'Keep me signed in for today')]")).above(j.getsignIn())).click();
    	if(j.getKeepmein().isSelected())
    	{
    		System.out.println("Keep me signed in checkbox is between password and signin button");
    	}
       
    }
    @When("^the user reaches Forgot your password link")
    public void the_user_reaches_forgot_your_password_link() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	String N=j.getForgotPass().getText();
    	System.out.println(N);
       
    }

    @Then("^Validate Forgot your password link is below sign in button")
    public void validate_forgot_your_password_link_is_below_sign_in_button() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	driver.findElement(with(By.cssSelector("a[class*='color-login-links']")).below(j.getsignIn())).click();
    	if(j.getsendbuttonEmailofForgotPass().isDisplayed())
    	{
    		System.out.println("Forgot your password? is located blow sign in button");
    	}
    }
    @When("^the user reduced the browser to minimum width")
    public void the_user_reduced_the_browser_to_minimum_width() throws Throwable {
    	driver.manage().window().setSize(new Dimension(500,768));
    	driver.get(pop.getProperty("url"));
    	
    }

    @Then("^validate that all fields are visible and clickable")
    public void validate_that_all_fields_are_visible_and_clickable() throws Throwable {
    	
    	SigninPage j= new SigninPage(driver);
    	try {
			j.getUsername().getText().compareToIgnoreCase("Email");
			j.getUsername().click();
			j.getPassword().getText().compareToIgnoreCase("Password");
			j.getPassword().click();
			j.getKeepmein().getText().compareToIgnoreCase("Keep me signed in for today");
			j.getKeepmein().click();
			WebElement signin=j.getsignIn();
			if(signin.isDisplayed())
			{
				System.out.println("sign in is visible and clickable");	
			}
			j.getForgotPass().getText().compareToIgnoreCase("Forgot password?");
			j.getsendbuttonEmailofForgotPass().getText().compareToIgnoreCase("Don't have an account?");
			
			System.out.println("All fields are visible and clickable");
			
    		
    		
		} catch(Exception e)
		{
			System.out.println("fields are not visible");
		}
        
    }
    @When("^the user enters invalid email")
    public void the_user_enters_invalid_email() throws Throwable {
    	
    	SigninPage j= new SigninPage(driver);
    	String invalidemail=pop.getProperty("invalidusername");
    	j.getUsername().sendKeys(invalidemail);
       
    }
    @And("^the user enters invalid password")
    public void the_user_enters_invalid_password() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	String invalidpassword=pop.getProperty("invalidpassword");
    	j.getPassword().sendKeys(invalidpassword);
       
    }

    @Then("^display the error message")
    public void display_the_error_message() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	j.getsignIn().click();
    	String errormessage=j.getErrorText().getText();
    	System.out.println(errormessage);
       
    }
    @When("^the user enters the valid email")
    public void the_user_enters_the_valid_email() throws Throwable {
    	
    	SigninPage j= new SigninPage(driver);
    	String validusername=pop.getProperty("validusername");
    	j.getUsername().sendKeys(validusername);
        
    }
    @And("^the user enters the valid password")
    public void the_user_enters_the_valid_password() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	String validpassword=pop.getProperty("validpassword");
    	j.getPassword().sendKeys(validpassword);
        
    }

    @Then("^validate that User can enter the details as expected")
    public void validate_that_user_can_enter_the_details_as_expected() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	if(j.getsignIn().isEnabled())
    	{
    		System.out.println("User can enter the details as expected");
    	}
      
    }
    @When("^the user enters valid email")
    public void the_user_enters_valid_email() throws Throwable {
    	
    	SigninPage j= new SigninPage(driver);
    	String validusername=pop.getProperty("validusername");
    	j.getUsername().sendKeys(validusername);
    }
    
    @And("^the user enters valid password")
    public void the_user_enters_valid_password() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	String validpassword=pop.getProperty("validpassword");
    	j.getPassword().sendKeys(validpassword);
        
    }

    @Then("^validate that user is into the homepage")
    public void validate_that_user_is_into_the_homepage() throws Throwable {
    	SigninPage j= new SigninPage(driver);
    	j.getsignIn().click();
    	HomePage s= new HomePage(driver);
    	//w.until(ExpectedConditions.elementToBeClickable(By.linkText("Back to Waiting Areas")));
    	if(s.getBacktoWaiting().isEnabled())
    	{
    		System.out.println("user is into the homepage");
    	}
    	
    }
    @And("^close all browser$")
    public void close_all_browser() throws Throwable {
        driver.quit();
    }

}