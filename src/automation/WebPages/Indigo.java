package automation.WebPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Indigo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.goindigo.in");
		driver.findElement(By.cssSelector("i.icon-close")).click();
		driver.findElement(By.cssSelector("div.flightWays")).click();
		List<WebElement> ways = driver.findElements(By.cssSelector("div.dropdown-menu.show ul li"));
		ways.stream().filter(s->s.getText().equalsIgnoreCase("Round Trip")).limit(1).forEach(s->s.click());
		driver.findElement(By.cssSelector("input.or-src-city")).sendKeys("Tir");
		List<WebElement> city = driver.findElements(By.xpath("//div[@class='wrap']/div/div[@class='airport-city']"));
		city.stream().filter(s->s.getText().contains("Tirupati")).limit(1).forEach(s->s.click());		
		driver.findElement(By.cssSelector("input.or-dest-city")).sendKeys("H");
		List<WebElement> to = driver.findElements(By.xpath("//div[@class='wrap']/div/div[@class='airport-city']"));
		to.stream().filter(s->s.getText().contains("Hyderabad")).limit(1).forEach(s->s.click());
		String month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText();
		while(!(month.equalsIgnoreCase("August"))){
			driver.findElement(By.cssSelector("span.ui-icon-circle-triangle-e")).click();
			month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText();
		}
		List<WebElement> date = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]/tbody/tr/td"));
		date.stream().filter(s->s.getText().equalsIgnoreCase("20")).limit(1).forEach(s->s.click());
		driver.findElement(By.xpath("//input[@class='form-control or-return igInitCalendar']")).click();
		driver.findElement(By.className("hp-src-btn")).click();
		

	}

}
