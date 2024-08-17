package bookwormPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    By logo = By.cssSelector("div.site-branding");
    By storeLocator = By.cssSelector("i.flaticon-pin");
    By productComparison = By.cssSelector("i.flaticon-switch");
    By wishlist = By.cssSelector("i.flaticon-heart");
    By account = By.cssSelector("i.flaticon-user");
    By cart = By.cssSelector("span.cart-contents-count");

    public void navigateToHomePageWithLogoLink (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logo)).click();
    }

    public void navigateToStoreLocator (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(storeLocator)).click();
    }

    public void navigateToProductComparison (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(productComparison)).click();
    }

    public void navigateToWishlist (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(wishlist)).click();
    }

    public void navigateToAccount (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(account)).click();
    }

    public void  navigateToCart (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
    }
}
