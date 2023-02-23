package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driver_navigation_methods {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//1.TO navigate on URL
		driver.navigate().to("https://www.google.com");
		
		driver.findElement(By.xpath("//*[@title='Search']")).click();
		driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("selenium.dev",Keys.ENTER);
		
		//2.TO navigate on back page
		Thread.sleep(5000);
		driver.navigate().back();
		
		//3.To navigate on forward
		Thread.sleep(5000);
		driver.navigate().forward();
		
		//4.To Reload or refresh page
		Thread.sleep(5000);
		driver.navigate().refresh();
		
		
		
		
		
		

	}

}
