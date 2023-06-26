package automation.chromedevtools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;

public class GeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools dev = driver.getDevTools();
		driver.manage().window().maximize();
		dev.createSession();
		dev.send(Emulation.clearGeolocationOverride());
		dev.send(Emulation.setGeolocationOverride(Optional.of(35), Optional.of(135), Optional.of(1)));
		driver.get("https://www.google.com/maps");
		driver.findElement(By.name("q")).sendKeys(Keys.chord("Current Location",Keys.ENTER));
		

	}

}
