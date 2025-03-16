package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProductPage {
    public static WebElement productsPage(WebDriver driver) {
        return driver.findElement(By.xpath("//a[@href='/products']"));
    }
    public static WebElement searchTextField(WebDriver driver) {
        return driver.findElement(By.name("Search"));
    }
    public static WebElement searchButton(WebDriver driver) {
        return driver.findElement(By.xpath("//a/i[@class='fa fa-search']"));
    }
}
