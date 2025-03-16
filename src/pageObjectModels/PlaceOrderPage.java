package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaceOrderPage {
    public static WebElement viewCartButton(WebDriver driver) {
        return driver.findElement(By.xpath("//u[text()='View Cart']"));
    }

    public static WebElement proceedToCheckoutButton(WebDriver driver) {
        return driver.findElement(By.xpath("//a[contains(text(), 'Proceed To Checkout')]"));
    }

    public static WebElement placeOrderButton(WebDriver driver) {
        return driver.findElement(By.xpath("//a[contains(text(), 'Place Order')]\n"));
    }

    public static WebElement nameOnCardField(WebDriver driver) {
        return driver.findElement(By.name("name_on_card"));
    }

    public static WebElement cardNumberField(WebDriver driver) {
        return driver.findElement(By.name("card_number"));
    }

    public static WebElement cvcField(WebDriver driver) {
        return driver.findElement(By.name("cvc"));
    }

    public static WebElement expiryMonthField(WebDriver driver) {
        return driver.findElement(By.name("expiry_month"));
    }

    public static WebElement expiryYearField(WebDriver driver) {
        return driver.findElement(By.name("expiry_year"));
    }

    public static WebElement payAndConfirmOrderButton(WebDriver driver) {
        return driver.findElement(By.xpath("//button[contains(text(), 'Pay and Confirm Order')]\n"));
    }
    public static WebElement orderPlacedConfirmationText(WebDriver driver) {
        return driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']\n"));
    }
}
