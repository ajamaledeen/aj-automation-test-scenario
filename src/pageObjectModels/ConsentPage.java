package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsentPage {
    public static WebElement consentButton (WebDriver driver) {
        return driver.findElement(By.xpath("//p[text()='Consent']\n"));
    }
}
