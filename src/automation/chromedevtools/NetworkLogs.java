package automation.chromedevtools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.fetch.Fetch;
import org.openqa.selenium.devtools.v113.network.model.Request;

public class NetworkLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools dev = driver.getDevTools();
		driver.manage().window().maximize();
		dev.createSession();
		dev.send(Fetch.enable(Optional.empty(), Optional.empty()));
		dev.addListener(Fetch.requestPaused(), request -> {
			Request req = request.getRequest();
			System.out.println(req.getUrl());
			if (req.getUrl().contains("shetty")) {
				String url = req.getUrl().replace("=shetty", "=BadGuy");
				System.out.println(url);
				dev.send(Fetch.continueRequest(request.getRequestId(), Optional.of(url), Optional.empty(),
						Optional.empty(), Optional.empty(), Optional.empty()));
			} else {
				dev.send(Fetch.continueRequest(request.getRequestId(), Optional.of(req.getUrl()), Optional.empty(),
						Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}

}
