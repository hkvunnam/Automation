package automation.chromedevtools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.ConnectionType;
import org.openqa.selenium.devtools.v113.emulation.Emulation;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools dev = driver.getDevTools();
		dev.createSession();
		dev.send(Emulation.setDeviceMetricsOverride(360, 740, 1, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty()));
		dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		dev.send(Network.emulateNetworkConditions(false, (Number) 1000, (Number) 100000, (Number) 100000,
				Optional.of(ConnectionType.CELLULAR2G)));
		driver.get("https://www.samsung.com/in/offer/online/samsung-fest");
		int count = 0;
		while (count <= 7) {
			driver.findElement(By.cssSelector("div.owl-nav button.owl-next")).click();
			count++;
		}
		driver.close();

	}

}
