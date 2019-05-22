package Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.newtours.demoaut.com");
		
		WebElement date = driver.findElement(By.xpath("//form[@name='home']//tbody//b"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String systemDt = dtf.format(now);
		System.out.println(date.getText());
		if(date.equals(systemDt)){
			System.out.println("System and Application date matches successfully");
		}else{
			System.out.println("System and Application date doesn't match");
		}
		
	}

}
