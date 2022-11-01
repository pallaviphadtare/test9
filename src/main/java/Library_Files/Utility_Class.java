package Library_Files;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Utility_Class
{

		//Automation TE:@Pallavi
		//Day:Thursday
		//Date:20-10-2022
		//Fetch data from property File

	@Test								  // UN  // PSW
	public static String getdatafrompropfile(String key) throws IOException
	{
		// to reach to the properties file
			FileInputStream file=new FileInputStream("C:\\Eclips jun\\Maven_Project\\PropertyFile.properties");
		
		// create an object of properties file
			Properties prop=new Properties();
			
		// open properties file
			prop.load(file);
			
		// fetch data from properties file
								// UN  // PSW
			String value=prop.getProperty(key);		// Admin	//admin123
			
			return value;
		
	}
	
		//Automation TE:@Pallavi
		//Day:Friday
		//Date:21-10-2022
		//Fetch data from Excel sheet
	
	@Test
	public static String getdatfromexcelsheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Eclips jun\\Maven_Project\\TestData\\Parameterization.xlsx");
		Sheet sh=WorkbookFactory.create(file).getSheet("Sheet11");
		String value2=sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
			return value2;
	}
	
	    //Automation TE:@Pallavi
		//Day:Friday
		//Date:21-10-2022
		//Fetch take screenshot of failed TC
	
	@Test
	public static void takeScreenshot(WebDriver driver, int TestCaseID) throws IOException
	{
		File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination=new File("C:\\Eclips jun\\Maven_Project\\Screenshot\\."+TestCaseID+".jpg");
		FileHandler.copy(Source, Destination);
	}
	
	
	
	
	
}
