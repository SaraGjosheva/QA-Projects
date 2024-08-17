package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    By logo = By.cssSelector("a.header-logo-link");
    By storeLocator = By.cssSelector("a[title=\"Store Locator\"]");
    By trackYourOrder = By.cssSelector("a[title=\"Track Your Order\"]");
    By shop = By.cssSelector("a[title=\"Shop\"]");
    By myAccount = By.cssSelector("a[title=\"My Account\"]");
    By wishlist = By.cssSelector("div[data-bs-title=\"Wishlist\"]");
    By cart = By.cssSelector("div[data-bs-title=\"Cart\"]");
    By contact = By.cssSelector("li#menu-item-5397>a");

    public void logoLink (WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoElement = wait.until(ExpectedConditions.presenceOfElementLocated(logo));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", logoElement);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(logoElement)).click();
    }

    public void navigateToStoreLocator (WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement storeLocatorElement = wait.until(ExpectedConditions.presenceOfElementLocated(storeLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", storeLocatorElement);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(storeLocatorElement)).click();
    }

    public void navigateToTrackYourOrder (WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement trackYourOrderElement = wait.until(ExpectedConditions.presenceOfElementLocated(trackYourOrder));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", trackYourOrderElement);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(trackYourOrderElement)).click();
    }

    public void navigateToShop (WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shopElement = wait.until(ExpectedConditions.presenceOfElementLocated(shop));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", shopElement);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(shopElement)).click();
    }


    public void navigateToMyAccount (WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myAccountElement = wait.until(ExpectedConditions.presenceOfElementLocated(myAccount));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", myAccountElement);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(myAccountElement)).click();
    }

    public void navigateToWishlist (WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement wishlistElement = wait.until(ExpectedConditions.presenceOfElementLocated(wishlist));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", wishlistElement);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(wishlistElement)).click();
    }

    public void navigateToCart (WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartElement = wait.until(ExpectedConditions.presenceOfElementLocated(cart));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", cartElement);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(cartElement)).click();
    }

    public void navigateToContact (WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contactElement = wait.until(ExpectedConditions.presenceOfElementLocated(contact));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", contactElement);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(contactElement)).click();
    }
}
