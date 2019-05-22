package MyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyUtils {

	//Get Data from Excel
	@SuppressWarnings("resource")
	public static String getDataFromExcel(String Property, String sheetName) throws IOException{
		
		String Value = null;
		File file = new File(System.getProperty("user.dir")+"\\TestData.xls");
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook myWorkbook = new  HSSFWorkbook(fis);
		Sheet mySheet = myWorkbook.getSheet(sheetName);
		int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
		for(int i = 0; i < rowCount+1; i++){
			Row myRow = mySheet.getRow(i);
			if(myRow.getCell(0).getStringCellValue().equals(Property)){
				Value = myRow.getCell(1).getStringCellValue();
			}
		}
		return Value;
		
	}
	
	//Write data in excel
	@SuppressWarnings("resource")
	public void writeInExcel() throws IOException{
		
		File myFile = new File(System.getProperty("user.dir")+"\\TestData.xls");
		FileInputStream fis = new FileInputStream(myFile);
		HSSFWorkbook myWorkbook = new HSSFWorkbook(fis);
		Sheet mySheet = myWorkbook.getSheet("Sheet1");
		Row row = mySheet.createRow(0);
		row.createCell(0).setCellValue("xyz");
		FileOutputStream fileOut = new FileOutputStream(myFile);
		myWorkbook.write(fileOut);
		fileOut.close();
		
	}
	
	//Get data from Config file
	public static String getDataFromConfig(String key) throws IOException{
		
		String data = null;
		Properties prop = new Properties();
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\Config.properties");
		prop.load(file);
		data = prop.getProperty(key);
		return data;
		
	}
	
	//explicit wait
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
