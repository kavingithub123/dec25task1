package windowhandling.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MingleHandlingAmazon {

	public static void main(String[] args) throws InterruptedException {
		
		//configure the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\SeleniumCofiguration\\driver\\chromedriver.exe");
		
		//launch the browser
		WebDriver driver = new ChromeDriver();
		
		//launch the url
		
		driver.get("https://www.amazon.in/");	
		
		//maximize the window
		driver.manage().window().maximize();
		
		//slct windows
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 12");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (64GB) - White']")).click();

		
		Thread.sleep(3000);
		
		//to get parent windwow id
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		
		//win handles
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
				
		// loop

		for (String childwindow : windowHandles) {
			if (!parent.equals(childwindow)) {
				driver.switchTo().window(childwindow);		
		
			}
		
		}
		Thread.sleep(3000);
		//click add to cart
		
		WebElement clickaddtocart = driver.findElement(By.id("add-to-cart-button"));
		clickaddtocart.click();
		
		
		Thread.sleep(3000);
		
		//go to parent window
		driver.switchTo().window(parent);
		
		WebElement a =driver.findElement(By.id("twotabsearchtextbox"));
		a.clear();
		a.sendKeys("iphone 12");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(3000);
		WebElement b = driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (64GB) - Blue']"));
		b.click();
		
		Thread.sleep(3000);
		
		Set<String> second = driver.getWindowHandles();
		System.out.println(second);
		
		Thread.sleep(3000);
		
		List<String> li = new ArrayList<>();
		li.addAll(second);
		String third = li.get(2);
		driver.switchTo().window(third);
		
		Thread.sleep(3000);
		
		//click add to cart
		WebElement clickaddtocart1 = driver.findElement(By.id("add-to-cart-button"));
		clickaddtocart1.click();
		
		//end
		System.out.println("end");
		
	}
}

