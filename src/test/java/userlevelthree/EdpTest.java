package userlevelthree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EdpTest {
	WebDriver driver; 
	public String code = "904059"; 
	public String IR_ID = "AA002298";
	
	@DataProvider
	public Object[][] test1(){
		return new Object[][]{{"vk_Thili", "1qaz2wsx"}};
		}
	 
	
	@BeforeClass
	public void seturl(){
	driver = new FirefoxDriver();
	driver.get("https://global.qntest.com/EDPSite/");
	}

	
	@Test(dataProvider= "test1")
	public void logIn(String logIn, String password){
		WebElement login = driver.findElement(By.id("loginname")); 
		login.sendKeys(logIn);
		
		WebElement pwd = driver.findElement(By.id("password")); 
		pwd.sendKeys(password);
		
		WebElement submit1 = driver.findElement(By.id("Button1"));
		submit1.click();
	}
	
	@Test
	public void verifyToken(){
		WebElement secCode = driver.findElement(By.id("TextBox1"));
		secCode.sendKeys(code);
		
		WebElement submit2 = driver.findElement(By.id("btnsubmit"));
		submit2.click();
	}
	
	@Test
	public void searchIR(){
		WebElement irID = driver.findElement(By.id("txtTCO"));
		irID.sendKeys(IR_ID);
		
		WebElement submit3 = driver.findElement(By.id("btnsearch"));
		submit3.click();
	}
	
	@Test
	public void testIR(String ir){
		WebElement irid = driver.findElement(By.xpath(".//*[@id='lbTCO']"));
		Assert.assertEquals(IR_ID,irid.getText() , "test passed");
	}
	
	@Test
	public void checkName(){
		WebElement chequeName = driver.findElement(By.id("lbCheque"));
		System.out.println(chequeName.getText());
	}
	
	@Test
	public void genReport(){
		WebElement menu1 = driver.findElement(By.id("Menu1-menuItem001"));
		menu1.click();
		
		WebElement subMenu = driver.findElement(By.id("Menu1-menuItem001-subMenu-menuItem001"));
		subMenu.click();
		
		WebElement report1 = driver.findElement(By.id("Menu1-menuItem001-subMenu-menuItem001-subMenu-menuItem000"));
		report1.click();
	}
}
