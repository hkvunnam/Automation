package automation.WebPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingaporeAirlines {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Edu\\Java\\Web Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.singaporeair.com");
		driver.findElement(By.id("flightOrigin1")).click();
		driver.findElement(By.id("flightOrigin1")).sendKeys(Keys.chord(Keys.DELETE,"BO"));
		List<WebElement> origin = driver.findElements(By.xpath("//div[@class='suggest-item']/div/div/div/div[1]"));
		origin.stream().filter(s->s.getText().contains("Boston")).limit(1).forEach(s->s.click());
		driver.findElement(By.id("bookFlightDestination")).sendKeys("ch");
		List<WebElement> dest = driver.findElements(By.xpath("//div[@class='suggestions']/div/div/div/div/div[1]"));
		dest.stream().filter(s->s.getText().contains("Chennai")).limit(1).forEach(s->s.click());
		driver.findElement(By.id("departDate1")).click();
		driver.findElement(By.cssSelector("label[for='oneway_id']")).click();
		driver.findElement(By.cssSelector("input.calendar-date-field.ref--searchinput")).click();
		List<WebElement> month = driver.findElements(By.className("calendar-date-suggestion"));
		month.stream().filter(s->s.getText().contains("August")).limit(1).forEach(s->s.click());
		List<WebElement> date = driver.findElements(By.xpath("//div[@class='calendar_month_left']/ul[@class='calendar_days']/li"));
		date.stream().filter(s->s.getText().equalsIgnoreCase("23")).limit(1).forEach(s->s.click());
		driver.findElement(By.cssSelector("div.primary_action.upper-case")).click();
		driver.findElement(By.id("flightClass1")).click();
		List<WebElement> type = driver.findElements(By.cssSelector("div.suggestions div.suggest-item"));
		type.stream().filter(s->s.getText().contains("Business")).limit(1).forEach(s->s.click());
		driver.findElement(By.id("flightPassengers1")).click();
		int count = 1;
		while(count<3) {
			driver.findElement(By.xpath("(//button[@class='btn--image_icon input__number--ticker-plus'])[1]")).click();
			count++;
		}
		driver.findElement(By.cssSelector("div.form_control button.btn.btn-primary.js-open-loading")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
