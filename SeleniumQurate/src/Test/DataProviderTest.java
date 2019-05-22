package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider(name="data1")
	public static Object[][] data1(){
		
		return new Object[][]{
			
			{1,"2",3},
			{2,"2",3},
			{3,"2",3}
		};
	}
	
	@Test(dataProvider = "data1")
	public void dataProviderTest(int a, String b, int c){
		
		System.out.println(a+" "+b+" "+c);
		
	}
}
