package automation.chromedevtools;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.Request;
import org.openqa.selenium.devtools.v113.network.model.Response;

public class NetworkMock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools dev = driver.getDevTools();
		driver.manage().window().maximize();
		dev.createSession();
		dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		dev.addListener(Network.requestWillBeSent(), request->{
			Request req = request.getRequest();
			System.out.println(req.getUrl());
		});
		dev.addListener(Network.responseReceived(), response->{
			Response res = response.getResponse();
			if(res.getStatus()<400) {
				System.out.println(res.getUrl()+": "+ res.getStatus());
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.close();
	}

}
