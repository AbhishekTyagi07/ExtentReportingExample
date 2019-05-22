package Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("D:\\Qurate\\Window.html");
		String win1 = driver.getWindowHandle();
		System.out.println("Current window ID: "+win1);
		driver.findElement(By.id("button1")).click();
		Set<String> winIds = driver.getWindowHandles();
		for(String win:winIds){
			driver.switchTo().window(win);
			System.out.println(driver.getTitle());
		}
		driver.quit();

	}

}
