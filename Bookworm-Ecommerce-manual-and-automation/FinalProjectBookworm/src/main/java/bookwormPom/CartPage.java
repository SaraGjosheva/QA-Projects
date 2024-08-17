package bookwormPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By productInCart = By.cssSelector("div.m-w-200-lg-down>a");
    By proceedToCheckoutButton = By.cssSelector("div.wc-proceed-to-checkout");

    public String getProductInCartName () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productInCart));
        return driver.findElement(productInCart).getText();
    }

    public void proceedToCheckout () {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
    }
}
