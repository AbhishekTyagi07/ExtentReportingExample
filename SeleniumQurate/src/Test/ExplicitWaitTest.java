package Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWaitTest {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.newtours.demoaut.com");
		
		//Take screenshot
		File myFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(myFile, new File("D:\\Qurate\\Screenshot.jpg"));
		
		//Use of Explicit Wait
		WebElement username = driver.findElement(By.name("userName"));
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.visibilityOf(username));
		explicitWait(driver, username);
		username.sendKeys("mercury");

	}
	
	public static boolean explicitWait(WebDriver driver, WebElement element){
		
		boolean status = true;
		try{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e){
			status = false;
			System.out.println("Unable to wait for the element "+element);
			System.out.println("Exception occured - "+e.getMessage());
		}
		return status;
	}

}
