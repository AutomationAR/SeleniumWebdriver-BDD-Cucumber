package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPage {

	public WebDriver driver;
	By UserName = By.cssSelector("#usernameInput");
	By Password = By.cssSelector("#passwordInput");
	By KeepmeIn = By.xpath("//label[contains(text(),'Keep me signed in for today')]");
	By signIn = By.cssSelector("button[type='button']");
	By ErrorText = By.xpath("//span[contains(text(),'Your email or password is incorrect. After 5 attem')]");
	By ForgotPass = By.cssSelector("a[class*='color-login-links']");
	By donthaveAccount= By.xpath("//a[contains(text(),\"Don't have an account?\")]");
	By sendButtonEmaiForgotPassword= By.cssSelector("button[data-group='forgotPasswordForm']");
	
	public SigninPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
}
	public WebElement getUsername()
	{
		return driver.findElement(UserName);
	}
	public WebElement getPassword()
	{
		return driver.findElement(Password);
	}
	public WebElement getKeepmein()
	{
		return driver.findElement(KeepmeIn);
	}
	public WebElement getsignIn()
	{
		return driver.findElement(signIn);
	}
	public WebElement getErrorText()
	{
		return driver.findElement(ErrorText);
	}
	public WebElement getForgotPass()
	{
		return driver.findElement(ForgotPass);
	}
	public WebElement getdonthaveAccount()
	{
		return driver.findElement(donthaveAccount);
	}
	public WebElement getsendbuttonEmailofForgotPass()
	{
		return driver.findElement(sendButtonEmaiForgotPassword);
	}
	
	
}
