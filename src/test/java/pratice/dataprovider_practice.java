package pratice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataprovider_practice {
	
	static WebDriver driver;
	
	@BeforeClass
	
	public static void launchbrower()
	{
		WebDriverManager.chromedriver().setup();
		
		  driver=new ChromeDriver();
		
		
	}
	
  @Test  (dataProvider ="passdata")
  public void loginon_standard (String use,String pass,String resuilt) throws InterruptedException {
	  
	 //ENTER URL
	driver.get("http://13.228.194.105:9090/ibase/login/index.html");
	
	//ENTER USERNAME
	Thread.sleep(2000);
	WebElement user=  driver.findElement(By.xpath("//*[@id=\"id_user\"]"));
	user.click();
	user.clear();
	user.sendKeys(use);
	
	//ENTER PASSWORD
	Thread.sleep(2000);
	WebElement pwd=  driver.findElement(By.xpath("//*[@id=\"id_password\"]"));
	  pwd.click();
	  pwd.clear();
	  pwd.sendKeys(pass);
	  
	  //CLICK ON LOGIN
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"log-button\"]")).click();
	  
	 try { 
		 
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		 
		 wait.until(ExpectedConditions.alertIsPresent());
		 
      Alert alt=driver.switchTo().alert();
	  alt.accept();
	 }
	 catch (Exception e) {
		System.out.println("No alert");
	}
	 Thread.sleep(5000);
	 String pagetitle=driver.getTitle();
	 String excepted_title="Proteus Vision | Home";
	 
	 
	 
	if (resuilt.equals("Passs")){
		
	 if(pagetitle.equals(excepted_title))
		 
	 {
		 Assert.assertTrue(true);
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//*[@id=\"e12HeaderPnl-userNameLbl\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"logout_menuDiv\"]")).click();
		 
		 System.out.println("pass script user:"+resuilt);
	 }
	 else {
		 Assert.assertTrue(false);
		 
	 }
	 
	 
	}
	
	else {
		
		if(pagetitle.equals(excepted_title))
			 
		 {
			 Assert.assertTrue(false);
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//*[@id=\"e12HeaderPnl-userNameLbl\"]")).click();
			 driver.findElement(By.xpath("//*[@id=\"logout_menuDiv\"]")).click();
			 
			 System.out.println("pass script user:"+resuilt);
		 }
		 else {
			 Assert.assertTrue(true);
			 
		 }
		 
		 
		}
		
	}
	
	 
  
  @DataProvider 
  public Object [] [] passdata()
  {
	String pass[][]={
			{"ESCTEST2","Base@123","Passs"},
	        {"VRS01","avg","Fail"},
	        {"62851","Test@4321","Passs"}
	};
	  
	return pass;
	  }
  
  
  
}
