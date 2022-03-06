package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import resources.excelOutput;
import resources.testSample;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Cavisson.Sample;
import Cavisson.rulePageObject;

@RunWith(Cucumber.class)
public class stepDefination {

	public WebDriver driver;
	ArrayList<testSample> arr;
	@Given("^User logged in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_logged_in_with_username_and_password(String user, String pass) throws Throwable {
		
		excelOutput eo = new excelOutput();
		arr=eo.getData("df");
		ChromeOptions handlingSSL = new ChromeOptions();
		handlingSSL.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\parit.tomar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver(handlingSSL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://10.10.30.71/UnifiedDashboard/index.html");
		driver.get("https://10.10.30.71:4431/UnifiedDashboard/index.html");
		// UI Login
		//driver.findElement(By.xpath("//span[contains(.,'TRY OUT THE NEW PLATFORM!')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("//span[contains(.,'SIGN IN')]")).click();
		Thread.sleep(2000);
	}

	@Given("^User switched to Alert Rule UI$")
	public void user_switched_to_Alert_Rule_UI() throws Throwable {
		driver.findElement(By.cssSelector("button[ptooltip='Events']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'View All')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='RULES LIST']")).click();
	}

	@When("^Added rules from excel details$")
	public void added_rules_from_excel_details() throws Throwable {
		
		for(int i=0; i<arr.size();i++) {
	    	
	    	System.out.println(arr.get(i));
	    	Thread.sleep(2000);
	    	rulePageObject r = new rulePageObject(driver,arr.get(i));
			r.addRule().click();
			Thread.sleep(1000);
			r.metricsgroup().click();
			Thread.sleep(1000);
			r.metricsname().click();
			Thread.sleep(1000);
			r.metricsattr().click();
			Thread.sleep(1000);
			r.tier().click();
			Thread.sleep(1000);
			r.server().click();
			Thread.sleep(1000);
			r.apply().click();
			Thread.sleep(1000);
			r.addMetrics().click();
			Thread.sleep(1000);
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

	@Then("^Validate added rules$")
	public void validate_added_rules() throws Throwable {
	    
	}

	@Then("^Logout from UI$")
	public void logout_from_UI() throws Throwable {
		driver.findElement(By.cssSelector("button[ptooltip='User Options']")).click();
		driver.findElement(By.cssSelector("a[routerlink='/logout']")).click();
		driver.close();
	}

}