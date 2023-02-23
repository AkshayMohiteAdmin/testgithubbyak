package pratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class stdlogin {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
	   WebDriver driver = new ChromeDriver();
	   Thread.sleep(5000);
	   driver.get("http://155.248.250.99:9090/ibase/login/index.html");
	   Thread.sleep(5000);
	   System.out.println("please check log in page");
	   
	   

	}

}
