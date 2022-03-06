package Cavisson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.testSample;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class rulePageObject {
	public rulePageObject(WebDriver driver, testSample sample) {
		this.driver=driver;
		this.sample=sample;
		addingrule= By.xpath("//span[contains(text(), 'Add Rule')]");
		//private By selectingmetricsgroup1 = By.xpath("//span[contains(text(), 'Select Metric group')]");
		selectingmetricsgroup= By.xpath("//span[contains(text(), '"+ sample.getMetricGroup() +"')]");
		//private By selectingmetricsname1=By.xpath("//span[contains(text(), 'Select Metric name')]");
		selectingmetricsname= By.xpath("//span[contains(text(), '"+sample.getMetricName()+"')]");
		//private By selectingmetricsattr1= By.xpath("//span[contains(text(), 'Select Metric attr')]");
		selectingmetricattr = By.xpath("//span[contains(text(), 'Avg')]");
		selectingtier = By.xpath("//span[contains(text(), 'Cavisson')]");
		selectingserver = By.xpath("//span[contains(text(), 'NDAppliance')]");
		applying= By.xpath("//span[contains(text(),'APPLY')]");
		addingmetrics = By.xpath("//span[contains(text(),'ADD METRICS')]");
		addingT = By.tagName("input");
		addingRuleName = By.tagName("input");
		addingRuleNamee= By.cssSelector("input[placeholder='High CPU Utilization']");
		applyingrule = By.xpath("//span[contains(text(),'Apply')]");
		addedrulename= By.xpath("//div[contains(text(),'"+sample.RuleName+"')]");
	}
	
	
	public testSample sample = null;
	

	public WebDriver driver;
	
	private By addingrule= null;
	//private By selectingmetricsgroup1 = By.xpath("//span[contains(text(), 'Select Metric group')]");
	private By selectingmetricsgroup= null;
	//private By selectingmetricsname1=By.xpath("//span[contains(text(), 'Select Metric name')]");
	private By selectingmetricsname= null;
	//private By selectingmetricsattr1= By.xpath("//span[contains(text(), 'Select Metric attr')]");
	private By selectingmetricattr = null;
	private By selectingtier = null;
	private By selectingserver = null;
	private By applying= null;
	private By addingmetrics = null;
	private By addingT =null;
	private By addingRuleName = null;
	private By addingRuleNamee = null;
	private By applyingrule = null;
	private By addedrulename=null;
	
	public WebElement addRule()
	{
		return driver.findElement(addingrule);
	}
	public WebElement metricsgroup()
	{
		driver.findElement(By.xpath("//span[contains(text(), 'Select Metric group')]")).click();
		//System.out.println(MetricName);
		return driver.findElement(selectingmetricsgroup);
	}
	public WebElement metricsname()
	{
		driver.findElement(By.xpath("//span[contains(text(), 'Select Metric name')]")).click();
		return driver.findElement(selectingmetricsname);
	}
	public WebElement metricsattr()
	{
		driver.findElement(By.xpath("//span[contains(text(), 'Select Metric attr')]")).click();
		return driver.findElement(selectingmetricattr);
	}
	public WebElement tier() throws InterruptedException
	{
		driver.findElement(
				By.cssSelector("p-radiobutton[value='Specified'] span[class$='ui-radiobutton-icon ui-clickable']"))
				.click();
		driver.findElement(By.cssSelector("button[label='Select']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Select Tier')]")).click();
		Thread.sleep(2000);
		return driver.findElement(selectingtier);
	}
	public WebElement server()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Select Server')]")).click();
	    return driver.findElement(selectingserver);
	}
	public WebElement apply()
	{
		return driver.findElement(applying);
	}
	public WebElement addMetrics()
	{
		return driver.findElement(addingmetrics);
	}
	public WebElement criticalThreshold()
	{
		WebElement ct= driver.findElement(By.xpath("//label[contains(text(),'Critical')]"));
		return driver.findElement(with(addingT).below(ct));
	}
	public WebElement majorThreshold()
	{
		WebElement mt= driver.findElement(By.xpath("//label[contains(text(),'Major')]"));
		return driver.findElement(with(addingT).below(mt));
	}
	public WebElement minorThreshold()
	{
		WebElement mnt= driver.findElement(By.xpath("//label[contains(text(),'Minor')]"));
		return driver.findElement(with(addingT).below(mnt));
	}
	public WebElement ruleName()
	{
		WebElement rn=driver.findElement(By.xpath("//div[contains(text(),'Rule Name')]"));
		System.out.println(driver.findElement(with(addingRuleName).toRightOf(rn)));
		return driver.findElement(with(addingRuleName).toRightOf(rn));
		
	}
	public WebElement ruleNamee()
	{
		
		return driver.findElement(addingRuleNamee);
		
	}
	public WebElement applyrule()
	{
		return driver.findElement(applyingrule);
	}
	public WebElement addedRule()
	{
		driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(sample.RuleName);
		return driver.findElement(addedrulename);
	}
	
}