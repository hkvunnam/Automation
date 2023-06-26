package automation.chromedevtools;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		
		Predicate<URI> predicate = uri -> uri.getHost().contains("herokuapp");
		((HasAuthentication)driver).register(predicate, UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
	}

}
