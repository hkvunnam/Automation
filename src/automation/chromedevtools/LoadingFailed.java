package automation.chromedevtools;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.fetch.Fetch;
import org.openqa.selenium.devtools.v113.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v113.network.model.ErrorReason;

public class LoadingFailed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools dev = driver.getDevTools();
		driver.manage().window().maximize();
		dev.createSession();
		Optional<List<RequestPattern>> pattern = Optional
				.of(Arrays.asList(new RequestPattern(Optional.of("*css*"), Optional.empty(), Optional.empty())));
		dev.send(Fetch.enable(pattern, Optional.empty()));
		dev.addListener(Fetch.requestPaused(), request -> {
			dev.send(Fetch.failRequest(request.getRequestId(), ErrorReason.ABORTED));
		});
		driver.get("https://www.amazon.in");
	}

}
