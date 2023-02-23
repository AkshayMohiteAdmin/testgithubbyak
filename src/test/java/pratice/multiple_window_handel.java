package pratice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multiple_window_handel {

	public static void main(String[] args) throws InterruptedException {
			
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("http://13.228.194.105:9090/ibase/login/index.html");
	
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='vision-frame']")));
	
	Actions act=new Actions(driver);
	WebElement learn_more=driver.findElement(By.xpath("//*[@class='c-btn c-btn-p']"));
	
	act.moveToElement(learn_more);
	Thread.sleep(5000);
	learn_more.click();
	
	try {   Thread.sleep(5000);
    Set<String> w1=driver.getWindowHandles();
    
    List<String> wids=new ArrayList<>(w1);
    
    String wi1=wids.get(0);
    String wi2=wids.get(1);
    Thread.sleep(5000);
    
    //for learn more page
   driver.switchTo().window(wi2);
   Thread.sleep(5000);
   System.out.println(driver.getTitle());
   String url=driver.getCurrentUrl();
   System.out.println("current url id:"+url);
    
   //for home page
   driver.switchTo().window(wi1);
   Thread.sleep(5000);
   System.out.println(driver.getTitle());
   String url1=driver.getCurrentUrl();
   System.out.println("current url id:"+url1);
    
    }
	
	catch (Exception e) {
		System.out.println("Please check lean more");
	}
	
	
	}

}
