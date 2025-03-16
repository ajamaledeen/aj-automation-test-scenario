package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static WebElement signUpLoginPage(WebDriver driver) {
        return driver.findElement(By.xpath("//a[text()='Signup / Login']"));
    }
    public static WebElement emailField(WebDriver driver) {
        return driver.findElement(By.name("email"));
    }
    public static WebElement passwordField(WebDriver driver) {
        return driver.findElement(By.name("password"));
    }
    public static WebElement loginButton(WebDriver driver) {
        return driver.findElement(By.xpath("//button[@data-qa='login-button']"));
    }
    public static WebElement loggedUser(WebDriver driver) {
        return driver.findElement(By.xpath("//b[text()='Adam Jamal']\n"));
    }
}
