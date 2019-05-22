package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactoryTest {

	WebDriver driver;
	
	//Class constructor
	public LoginPageFactoryTest(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.NAME, using="userName")
	public WebElement userName;
	
	@FindBy(how=How.NAME, using="password")
	public WebElement password;
	
	@FindBy(how=How.NAME, using="login")
	public WebElement loginbutton;
	
	@FindBy(how=How.LINK_TEXT, using="SIGN-OFF")
	public WebElement signin;
	
	@FindBy(how=How.XPATH, using="//form[@name='home']//tbody//b")
	public WebElement date;
	
}
