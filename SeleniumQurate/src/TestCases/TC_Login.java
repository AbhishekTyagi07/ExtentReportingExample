package TestCases;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import MyUtils.MyUtils;
import PageObjects.LoginPageFactoryTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TC_Login {

	WebDriver driver;
	LoginPageFactoryTest objLogin;
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}

	@BeforeMethod
	public void initializeDriver() throws IOException {
		
		//Launch chrome browser and open application
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(MyUtils.getDataFromConfig("url"));
		
	}

	@Test(priority = 1)
	public void Login() throws IOException{
		
		//Fetch username and password from excel and enter into application
		objLogin = new LoginPageFactoryTest(driver);
		objLogin.userName.sendKeys(MyUtils.getDataFromExcel("username","Sheet1"));
		objLogin.password.sendKeys(MyUtils.getDataFromExcel("password","Sheet1"));
		objLogin.loginbutton.click();
		
		//Check if application logged in successfully
		if(objLogin.signin.isDisplayed()){
			
			test.log(LogStatus.PASS, "User logged in successfully to the application");
			
		}else{
			
			test.log(LogStatus.FAIL, "User is not able to login to the application");

		}
		
	}
	
	@Test(priority = 0)
	public void DateCheck(){
		
		//Verify if date displayed on application matches with system date
		objLogin = new LoginPageFactoryTest(driver);
		String date = objLogin.date.getText();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String systemDt = dtf.format(now);
		if(date.equals(systemDt)){
			
			test.log(LogStatus.PASS, "System and application dates are matching");
			
		}else{
			
			test.log(LogStatus.PASS, "System and application dates are not matching");
			
		}
		
	}
	
	@AfterMethod
	public void quitDriver(){
		driver.quit();
	}
	
	@AfterClass
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}

	
}
