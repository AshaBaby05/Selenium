package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase {

	
	@Test (priority=2)
	public void search() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://google.com");
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/div/div[2]")).click();
		//driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3")).click();
		driver.findElement(By.partialLinkText("Selenium")).click();
		
		Assert.assertEquals(driver.getTitle(), "SeleniumHQ Browser Automation");
			driver.quit();

}




@Test (priority=1)
public void register() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://magento.com");
	//driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.className("account-icon")).click();
	driver.findElement(By.id("register")).click();
	driver.findElement(By.id("firstname")).clear();
	driver.findElement(By.id("firstname")).sendKeys("asha");
	driver.findElement(By.id("lastname")).clear();
	driver.findElement(By.id("lastname")).sendKeys("baby");
	driver.findElement(By.id("email_address")).clear();
	driver.findElement(By.id("email_address")).sendKeys("ashamerlinbby@gmail.com");
	
	Select cp=new Select(driver.findElement(By.id("company_type")));
	cp.selectByValue("deployment");
	Select role=new Select(driver.findElement(By.id("individual_role")));
	//role.selectByValue("technical/developer");
	role.selectByIndex(2);
	Select country=new Select(driver.findElement(By.id("country")));
	//country.selectByValue("IN");
	country.selectByVisibleText("United States");
	
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys("Douglas");
	driver.findElement(By.id("password-confirmation")).clear();
	driver.findElement(By.id("password-confirmation")).sendKeys("Douglas");
	if(!driver.findElement(By.id("agree_terms")).isSelected())
			{
		driver.findElement(By.id("agree_terms")).click();
			}
			
driver.quit();
}

}


