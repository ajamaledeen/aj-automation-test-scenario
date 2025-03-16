import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helpers {

    public void launchApplication() {
        System.setProperty("webriver.chrome.driver", "/Users/aj/Downloads/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}

