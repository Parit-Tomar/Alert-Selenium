package Cavisson;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import static org.testng.Assert.assertEquals;

public class AlertFirst {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\parit.tomar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://10.10.30.71/UnifiedDashboard/index.html");
		// UI Login
				driver.findElement(By.xpath("//span[contains(.,'TRY OUT THE NEW PLATFORM!')]")).click();
				driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("parit");
				driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Cavisson@123");
				driver.findElement(By.xpath("//span[contains(.,'SIGN IN')]")).click();
				Thread.sleep(5000);
				// Dashboard redirection to Alert
				// driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-clickable
				// icons8 icons8-notification']")).click();
				driver.findElement(By.cssSelector("button[ptooltip='Events']")).click();
				driver.findElement(By.xpath("//span[contains(text(),'View All')]")).click();
				Thread.sleep(5000);
				// Active Alert
				// driver.findElement(By.cssSelector(".ng-tns-c65-338.ui-dropdown.ui-widget.ui-state-default.ui-corner-all.ui-dropdown-open")).click();
				/*
				 * driver.findElement(By.cssSelector("p-dropdown[placeholder$='Level0']")).click
				 * ();
				 * //driver.findElement(By.cssSelector("div[class*='ui-dropdown-open']")).click(
				 * );
				 * //driver.findElement(By.xpath("//span[normalize-space()='Level2']")).click();
				 * driver.findElement(By.cssSelector("li[aria-label='Level2']")).click();
				 * driver.findElement(By.xpath("(//div[@role='checkbox'])[2]")).click();
				 * driver.findElement(By.cssSelector("button[ptooltip='Force clear event']")).
				 * click();
				 */
				// System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Alert
				// event(s) cleared sucessfully')]")).getText());
				// Rule List and rule addition
				driver.findElement(By.xpath("//button[.='RULES LIST']")).click();
				driver.findElement(By.xpath("//span[contains(text(), 'Add Rule')]")).click();
				driver.findElement(By.xpath("//span[contains(text(), 'Select Metric group')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[contains(text(), 'Memory Stats Extended')])")).click();
				driver.findElement(By.xpath("//span[contains(text(), 'Select Metric name')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(), 'Total Memory')]")).click();
				driver.findElement(By.xpath("//span[contains(text(), 'Select Metric attr')]")).click();
				driver.findElement(By.xpath("//span[contains(text(), 'Avg')]")).click();
				driver.findElement(
						By.cssSelector("p-radiobutton[value='Specified'] span[class$='ui-radiobutton-icon ui-clickable']"))
						.click();
				driver.findElement(By.cssSelector("button[label='Select']")).click();
				Thread.sleep(2000);
				/*driver.findElement(
						By.cssSelector("p-radiobutton[name='groupname'] span[class='ui-radiobutton-icon ui-clickable']"))
						.click(); 
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//p-treetabletoggler[@class='ng-star-inserted'])[3]")).click();
				driver.findElement(By.xpath("(//div[@role='checkbox'])[4]")).click(); */
				//driver.findElement(By.xpath("//p-radiobutton[@label='Advance']")).click();
				driver.findElement(By.xpath("//span[contains(text(),'Select Tier')]")).click();
				driver.findElement(By.xpath("//span[contains(text(), 'WebTier')]")).click();
				Thread.sleep(4000);
				driver.findElement(By.xpath("//span[contains(text(),'Select Server')]")).click();
				driver.findElement(By.xpath("//span[contains(text(), 'DevServer4')]")).click();
				
				driver.findElement(By.xpath("//span[contains(text(),'APPLY')]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'ADD METRICS')]")).click();
				// below 2 check later
				// driver.findElement(By.cssSelector("div[role='button']
				// span[class='ui-dropdown-trigger-icon ui-clickable ng-tns-c65-298 icons8
				// icons8-expand-arrow']")).click();
				// driver.findElement(By.xpath("//span[contains(text(),'sum of
				// every')]")).click();
				//WebElement ct= driver.findElement(By.xpath("//div[contains(text(),'Condition Type')]"));
				//driver.findElement(with(By.tagName("p-dropdown")).toRightOf(ct)).click();
				//driver.findElement(By.xpath("//span[contains(text(),'Threshold')]")).click();
				//WebElement tw= driver.findElement(By.xpath("//div[contains(text(),'Trigger when')]"));
				//driver.findElement(with(By.tagName("p-dropdown")).toRightOf(tw)).click();
				//driver.findElement(By.xpath("//span[contains(text(),'average')]")).click();
				//WebElement dl= driver.findElement(By.xpath("//div[contains(text(),'during last')]"));
				//driver.findElement(with(By.tagName("input")).toRightOf(dl)).sendKeys("1");
				driver.findElement(By.xpath("(//input[@id='input'])[2]")).sendKeys("50");
				driver.findElement(By.xpath("(//input[@id='input'])[3]")).sendKeys("25");
				driver.findElement(By.xpath("(//input[@id='input'])[4]")).sendKeys("2");
				driver.findElement(By.cssSelector("input[placeholder='High CPU Utilization']")).sendKeys("RuleAA");
				driver.findElement(By.xpath("//span[contains(text(), 'Apply')]")).click();
				//Back to Active UI for Validation
				driver.findElement(By.cssSelector("button[ptooltip='Settings']")).click();
				driver.findElement(By.xpath("//span[contains(text(), 'Active Alert')]")).click();
				//Validate alert
				Thread.sleep(120000); //wait for alert generation
				driver.findElement(By.cssSelector("button[ptooltip='Refresh events']")).click();
				driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("RuleAA");
				
				List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[8]"));
				// 1 results
				//List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice")).
				//		collect(Collectors.toList());
				List<WebElement> values= driver.findElements(By.xpath("//tr/td[9]"));
				for(int i=0;i<veggies.size();i++) {
					//System.out.println(veggies.get(i).getText());
					//System.out.println(values.get(i).getText());
					if(veggies.get(i).getText().equalsIgnoreCase("WebTier_40_71_work>DevServer4_71_work")){
						String av=values.get(i).getText();
						String ov=av.split(":")[1];
						System.out.println(ov);
					}
				}
				

	}

}
