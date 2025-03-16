import graphql.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import pageObjectModels.AddToCartPage;
import pageObjectModels.LoginPage;
import pageObjectModels.PlaceOrderPage;
import pageObjectModels.SearchProductPage;
import testData.DataFile;

public class AutomationTestScenario {

    public static void main(String[] args) throws InterruptedException {

      //System.setProperty("webDriver.chrome.driver", "/Users/aj/Downloads/chromedriver-mac-arm64/chromedriver");
        // WebDriver driver = new ChromeDriver();
      System.setProperty("webDriver.gecko.driver", "/Users/aj/Downloads/geckodriver.exe");

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.desktop-notification", 2);
        profile.setPreference("permissions.default.geo", 2);
        profile.setPreference("media.navigator.permission.disabled", true);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        WebDriver driver = new FirefoxDriver(options);
        //login test
        driver.get(DataFile.websiteUrl);
       LoginPage.signUpLoginPage(driver).click();
       LoginPage.emailField(driver).sendKeys(DataFile.emailAddress);
       LoginPage.passwordField(driver).sendKeys(DataFile.password);
       LoginPage.loginButton(driver).click();
       //Assert user is logged in
       String  actualString = LoginPage.loggedUser(driver).getText();
       String  expectedString = DataFile.userName;
       Assert.assertTrue(actualString.contains(expectedString));
       //search for product test
        SearchProductPage.productsPage(driver).click();
        SearchProductPage.searchButton(driver).sendKeys(DataFile.productName);
        SearchProductPage.searchButton(driver).click();
        //add product to cart
        AddToCartPage.addToCartButton(driver).click();
        //assert product has been added to cart
        String confirmationText = AddToCartPage.productAddedToCartConfirmation(driver).getText();
        String expectedText = DataFile.productAddedConfirmationText;
        Assert.assertTrue(actualString.contains(confirmationText));
        //place an oder test
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
