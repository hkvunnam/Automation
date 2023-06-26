package automation.chromedevtools;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools dev = driver.getDevTools();
		driver.manage().window().maximize();
		dev.createSession();
		dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		dev.send(Network.setBlockedURLs(ImmutableList.of("*.css",".jpeg",".jpg","*.png")));
		driver.get("https://www.flipkart.com");
	}

}
