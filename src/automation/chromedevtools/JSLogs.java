package automation.chromedevtools;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class JSLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.xpath("//button[@class='add-to-cart btn btn-default']")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(Keys.DELETE,Keys.NUMPAD2);
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> entry = entries.getAll();
		for(var e : entry) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}

}
