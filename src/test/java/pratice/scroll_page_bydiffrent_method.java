package pratice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scroll_page_bydiffrent_method {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://proteustech.in");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		//1.Scroll by using webElement
		
		WebElement wer=driver.findElement(By.xpath("//*[@class='e-font-icon-svg e-fas-vector-square']"));
		
		js.executeScript("argument[0].click();", wer); 
		
		//2.Scroll by using webElement
		
		WebElement wer2=driver.findElement(By.xpath("//*[@class='e-font-icon-svg e-fas-vector-square']"));
				
		js.executeScript("arguments[0].scrollIntoView();", wer2); 
		
		Thread.sleep(4000);
				
		//3.scroll Upto end of the page
				
		 js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); 
	
		
		//4.By using pixal (to find pixal go into console of page and enter window.scrollBy(0,5000)
		
		js.executeScript("window.scrollBy(0,5000)", "");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-5000)", "");
		
		//5.by using send keys upto end of page
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		//6.by robot class
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	
	}

}
