import graphql.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectModels.AddToCartPage;
import pageObjectModels.LoginPage;
import pageObjectModels.PlaceOrderPage;
import pageObjectModels.SearchProductPage;
import testData.DataFile;

import java.time.Duration;

public class AutomationTestScenario {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webDriver.chrome.driver", "/Users/aj/Downloads/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        //launch website and login as existing user
        Helpers.launchWebsiteAndAcceptConsent();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        LoginPage.signUpLoginPage(driver).click();
        LoginPage.emailField(driver).sendKeys(DataFile.emailAddress);
        LoginPage.passwordField(driver).sendKeys(DataFile.password);
        LoginPage.loginButton(driver).click();
        //Assert user is logged in
        String actualString = LoginPage.loggedUser(driver).getText();
        String expectedString = DataFile.userName;
        Assert.assertTrue(actualString.contains(expectedString));
        //search for product
        SearchProductPage.productsPage(driver).click();
        SearchProductPage.searchButton(driver).sendKeys(DataFile.productName);
        SearchProductPage.searchButton(driver).click();
        //add product to cart
        AddToCartPage.addToCartButton(driver).click();
        //assert product has been added to cart
        String confirmationText = AddToCartPage.productAddedToCartConfirmation(driver).getText();
        String expectedText = DataFile.productAddedConfirmationText;
        Assert.assertTrue(actualString.contains(confirmationText));
        //place an oder
        PlaceOrderPage.viewCartButton(driver).click();
        PlaceOrderPage.nameOnCardField(driver).sendKeys(DataFile.cardNumber);
        PlaceOrderPage.cardNumberField(driver).sendKeys(DataFile.cardNumber);
        PlaceOrderPage.cvcField(driver).sendKeys(DataFile.cvc);
        PlaceOrderPage.expiryMonthField(driver).sendKeys(DataFile.expiryMonth);
        PlaceOrderPage.expiryYearField(driver).sendKeys(DataFile.expiryYear);
        PlaceOrderPage.payAndConfirmOrderButton(driver).click();
        //assert order has been placed
        String actualOrderConfirmationText = PlaceOrderPage.orderPlacedConfirmationText(driver).getText();
        String expectedOrderConfirmationText = DataFile.orderPlacedConfirmationText;
        Assert.assertTrue(actualOrderConfirmationText.contains(expectedOrderConfirmationText));
    }
}
