import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import pageObjectModels.ConsentPage;
import testData.DataFile;

public class Helpers {

    public static void launchWebsiteAndAcceptConsent() {
         WebDriver driver = new ChromeDriver();
        driver.get(DataFile.websiteUrl);
        ConsentPage.consentButton(driver).click();
    }
}

