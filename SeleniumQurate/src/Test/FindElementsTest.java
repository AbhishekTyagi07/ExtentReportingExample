package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.newtours.demoaut.com");
		
		List<WebElement> elementList = driver.findElements(By.xpath("//a"));
		System.out.println("Number of Links: "+elementList.size());
		for(int i=0 ; i<elementList.size() ; i++){
//			System.out.println("Link Clicked: "+driver.findElements(By.xpath("//a")).get(i).getText());
//			driver.findElements(By.xpath("//a")).get(i).click();
//			elementList.get(i).click();
//			driver.navigate().back();
			String link = driver.findElements(By.xpath("//a")).get(i).getText();
			String[] links = link.split(" ");
			if (links.length>1){
				System.out.println("Link Clicked: "+driver.findElements(By.xpath("//a")).get(i).getText());
			}
		}
		

	}

}
