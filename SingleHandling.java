package windowhandling.com;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleHandling {

	public static void main(String[] args) {
		
		//configure the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\SeleniumCofiguration\\driver\\chromedriver.exe");
		
		//launch the browser
		WebDriver driver = new ChromeDriver();
		
		//launch the url
		
		driver.get("http://testleaf.herokuapp.com/home.html");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//slct windows
		driver.findElement(By.xpath("//*[@alt='Windows']")).click();
		
		//click homepage
		
		driver.findElement(By.id("home")).click();
		
		//window handle
		
		String parent = driver.getWindowHandle();
		
		System.out.println(parent);
		
		//win handles
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		
		
//		driver.findElement(By.xpath("(//*[@class='wp-categories-icon svg-image'])[1]")).click();
		
		
		// loop 
		
		for (String eachwindow : windowHandles) {
			if (parent.equals(eachwindow)) {
				driver.switchTo().window(parent).manage().window().maximize();
		
		
			}
		
		}
		
	}
	
}

