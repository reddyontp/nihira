package nihira.Extentreprots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreportdemo {
	ExtentReports extent;  //here extent is an variable which is globally declared here due to that we can access in our test

	// here configuring the Extent Reports ,beforetest case execution
	@BeforeTest
	public void config()
	{
		// Here "ExtentReports" &"ExtentSparkReporter two important classes to create Report 
		// Here ExtentReports " class is used consolidate the reports which are created by ExtentSparkReporter
		//"here "ExtentSparkReporter" will create the html Report & do some configuration at specified location.
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("showri first test report");
		reporter.config().setDocumentTitle("Appium sample test ");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter); //attaching report 
		extent.setSystemInfo("tester", "Showri");
		
	}
		
	@Test
	public void demo()  // this is  test case
	
	{
		extent.createTest("demo");  //this is very important  step ,because for this test case , this step will create Report
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe" );
		WebDriver driver= new ChromeDriver();                         // chrome storing in "driver" object 
		driver.get("https://proh2r.com/baranwalconsultancyservices/emp/#/services");        // so ,here driver  opening specified website
		System.out.println(driver.getTitle());                         //here getting title of the page
	   extent.flush();
	}
}
