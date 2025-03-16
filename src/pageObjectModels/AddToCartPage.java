package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {
    public static WebElement addToCartButton(WebDriver driver) {
        return driver.findElement(By.xpath("//a[contains(@class, 'add-to-cart')]"));
    }
    public static WebElement productAddedToCartConfirmation(WebDriver driver) {
        return driver.findElement(By.xpath("//p[contains(text(), 'Your product has been added')]\n"));
    }
}
