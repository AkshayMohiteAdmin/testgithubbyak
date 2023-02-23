package pratice;



	
		import org.openqa.selenium.By;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


		import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

		public class keydown_keyup {
		   public static void main(String[] args) throws InterruptedException {
			   
		   WebDriverManager.chromedriver().setup();
		      WebDriver driver = new ChromeDriver();
		      String url = "https://www.tutorialspoint.com/index.htm";
		      driver.get(url);
		      
		      driver.manage().window().maximize();
		      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		      Thread.sleep(3000);
		      // identify element
		      WebElement l = driver.findElement(By.xpath("//*[@id='search-strings']"));
		      // Actions class
		      Actions a = new Actions(driver);
		      // moveToElement() and then click()
		      Thread.sleep(3000);
		      a.moveToElement(l).click();
		      //enter text with keyDown() SHIFT key ,keyUp() then build() ,perform()
		      a.keyDown(Keys.SHIFT);
		      a.sendKeys("hello").keyUp(Keys.SHIFT).build().perform();
//		      driver.quit();
		   }
		

	

}
