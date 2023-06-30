package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger; 
	public Properties prop;
	String URL;
	
	public BaseClass()  {
		logger=LogManager.getLogger();
		try {
		FileInputStream fis=new FileInputStream("C:\\Users\\john3\\eclipse-workspace\\Demo\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(fis);
	    URL= prop.getProperty("url");}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	

	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) throws IOException {
		logger.info("Launching browser");	
		if(br.equals("chrome")) {
			driver=new ChromeDriver();	
		}else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("Closing browser");
		driver.close();
	}
	
	public static String generateRandomString() {
	String randomString=RandomStringUtils.randomAlphabetic(5);
	return randomString;
	}
	
	public static String generateRamdomNumber() {
		String randomNumber=RandomStringUtils.randomNumeric(5);
		return randomNumber;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
