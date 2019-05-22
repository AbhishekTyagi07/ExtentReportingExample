package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class First {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Path: "+System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.newtours.demoaut.com");
		String expTitle = "Welcome: Mercury Tours";
		String actTitle = driver.getTitle();
		if(expTitle.equals(actTitle)){
			System.out.println("PASS: The title is "+actTitle);
		}else{
			System.out.println("FAIL: The title is "+actTitle);
		}
		
		//Get Title
		WebElement username = driver.findElement(By.name("userName"));
		username.sendKeys("mercury");
		
		driver.findElement(By.name("password")).sendKeys("mercury");;
		
		driver.findElement(By.name("login")).click();
		
//		String title = driver.getTitle();
//		if(title.equals("Find a Flight: Mercury Tours:")){
//			System.out.println("PASS: Logged in successfully");
//		}else{
//			System.out.println("FAIL: Not able to log in");
//		}
		
//		if(driver.findElement(By.linkText("SIGN-OFF")).isDisplayed()){
//			System.out.println("PASS: Logged in successfully");
//		}else{
//			System.out.println("FAIL: Not able to log in");
//		}
		
		//Check if user is able to log in
		try{
			if(driver.findElement(By.linkText("SIGN-OFF")).isDisplayed()){
				System.out.println("PASS: Logged in successfully");
			}
		}catch(Exception e){
			System.out.println("FAIL: Not able to log in "+e.getMessage());
		}
		
		//Select value from drop-down
//		Select mySelect = new Select(driver.findElement(By.name("passCount")));
//		mySelect.selectByValue("4");
//		Thread.sleep(2000);
//		mySelect.selectByIndex(2);
//		Thread.sleep(2000);
//		mySelect.selectByVisibleText("2");
		
		//Handle radio button
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		Select Passengers = new Select(driver.findElement(By.name("passCount")));
		Passengers.selectByValue("4");
		
		Passengers = new Select(driver.findElement(By.name("fromPort")));
		Passengers.selectByValue("Frankfurt");
		
		Select DepartOnMonth = new Select(driver.findElement(By.name("fromMonth")));
		DepartOnMonth.selectByValue("2");
		
		Select DepartOnDate = new Select(driver.findElement(By.name("fromDay")));
		DepartOnDate.selectByValue("1");
		
		Select Arrive = new Select(driver.findElement(By.name("toPort")));
		Arrive.selectByValue("London");
		
		Select ArriveOnMonth = new Select(driver.findElement(By.name("toMonth")));
		ArriveOnMonth.selectByValue("3");
		
		Select ArriveOnDate = new Select(driver.findElement(By.name("toDay")));
		ArriveOnDate.selectByValue("1");
		
		driver.findElement(By.xpath("//input[@value='First']")).click();
		
		Select Airline = new Select(driver.findElement(By.name("airline")));
		Airline.selectByValue("Blue Skies Airlines");
		
		driver.findElement(By.name("findFlights")).click();
		
		
//		driver.close();

	}

}
