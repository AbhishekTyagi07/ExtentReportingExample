package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("D:\\Qurate\\Alert.html");
		driver.findElement(By.xpath("//button")).click();
		Alert myAlert = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println("Alert text: "+myAlert.getText());
		myAlert.accept();
		driver.quit();

	}

}
