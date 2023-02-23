package pratice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class copy_past_by_Roboatclass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		
		driver.get("https://www.diffchecker.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		
		try {
			driver.findElement(By.xpath("//*[@class='close-icon_stroke__jw7oE']")).click();
		}
		
		catch (Exception e) {
			System.out.println("no alert");
		}
		
		WebElement tyu=driver.findElement(By.xpath("(//*[@role='textbox'])[1]"));
		
	tyu.click();
	tyu.clear();
	tyu.sendKeys("It is Copy Past method please review code");
	
	Robot robot=new Robot();
	
	robot.keyPress(KeyEvent.VK_CONTROL);
	Thread.sleep(3000);
	robot.keyPress(KeyEvent.VK_A);
	robot.keyRelease(KeyEvent.VK_A);
	Thread.sleep(3000);
	robot.keyPress(KeyEvent.VK_C);
	robot.keyRelease(KeyEvent.VK_C);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	
	Thread.sleep(3000);
	
	WebElement tyu1=driver.findElement(By.xpath("(//*[@role='textbox'])[2]"));
	
	tyu1.click();
	tyu1.clear();
	Thread.sleep(3000);
	robot.keyPress(KeyEvent.VK_CONTROL);
	Thread.sleep(3000);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(3000);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	Thread.sleep(3000);
	robot.keyRelease(KeyEvent.VK_V);
	
	Thread.sleep(3000);
	WebElement tyu2=driver.findElement(By.xpath("//*[@name='Find Difference']"));
	
	JavascriptExecutor execute=(JavascriptExecutor) driver;
	
	execute.executeScript("arguments[0].click();", tyu2);
	Thread.sleep(3000);
	
	tyu2.click();
	Thread.sleep(3000);
	
	
	
	}

}
