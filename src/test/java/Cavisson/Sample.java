package Cavisson;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Cavisson.rulePageObject;
import resources.excelOutput;
import resources.testSample;


public class Sample {
	
	public WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		
		// TODO Auto-generated method stub
		
		
	}
	
	@Test
	public void alertsample() throws IOException, InterruptedException
	{
		excelOutput eo = new excelOutput();
		ArrayList<testSample> arr=eo.getData("df");
		
		ChromeOptions handlingSSL = new ChromeOptions();
		handlingSSL.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\parit.tomar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver(handlingSSL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://10.10.30.71/UnifiedDashboard/index.html");
		driver.get("https://10.10.30.71/UnifiedDashboard/index.html");
		// UI Login
		//driver.findElement(By.xpath("//span[contains(.,'TRY OUT THE NEW PLATFORM!')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("parit");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Cavisson@123");
		driver.findElement(By.xpath("//span[contains(.,'SIGN IN')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[ptooltip='Events']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'View All')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='RULES LIST']")).click();
		
		
	    for(int i=0; i<arr.size();i++) {
	    	
	    	System.out.println(arr.get(i));
	    	Thread.sleep(2000);
	    	rulePageObject r = new rulePageObject(driver,arr.get(i));
			r.addRule().click();
			Thread.sleep(2000);
			r.metricsgroup().click();
			Thread.sleep(2000);
			r.metricsname().click();
			Thread.sleep(2000);
			r.metricsattr().click();
			Thread.sleep(2000);
			r.tier().click();
			Thread.sleep(2000);
			r.server().click();
			Thread.sleep(2000);
			r.apply().click();
			Thread.sleep(2000);
			r.addMetrics().click();
			Thread.sleep(2000);
			r.criticalThreshold().sendKeys(arr.get(i).getCriticalThreshold());
			r.majorThreshold().sendKeys(arr.get(i).getMajorThreshold());
			r.minorThreshold().sendKeys(arr.get(i).getMinorThreshold());
			//System.out.println(arr.get(i).getRuleName());
			//r.ruleName().sendKeys(arr.get(i).getRuleName());
			r.ruleNamee().sendKeys(arr.get(i).getRuleName());
			r.applyrule().click();
			Thread.sleep(2000);
			String addedrule=r.addedRule().getText();
			assertEquals(arr.get(i).getRuleName(), addedrule);
			
	    }
		
	}
	
	@AfterTest
	public void aftertest() {
		//logout code
		driver.findElement(By.cssSelector("button[ptooltip='User Options']")).click();
		driver.findElement(By.cssSelector("a[routerlink='/logout']")).click();
		driver.close();
	}

}