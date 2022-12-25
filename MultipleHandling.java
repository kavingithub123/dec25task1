package windowhandling.com;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleHandling {

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

		//click OPEN MULTIPLE WINDOWS

		driver.findElement(By.xpath("//*[@onclick='openWindows()']")).click();

		//take parent id
		String parent = driver.getWindowHandle();
		System.out.println("parent window id is " + parent);

		//window handles

		Set<String> handles = driver.getWindowHandles();
		System.out.println("multiple id is " + handles);
		

				
				for (String eachwindow : handles)  {
					if (!parent.equals(eachwindow)) {
					driver.switchTo().window(parent);
					}
				}

	}
}
