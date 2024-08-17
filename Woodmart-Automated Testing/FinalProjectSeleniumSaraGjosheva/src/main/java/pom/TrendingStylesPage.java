package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrendingStylesPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public TrendingStylesPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By wirelessHeadphones = By.xpath("//a/h2[text()=\"Purple Solo 2 Wireless\"]");
    By wishlistWirelessHeadphones = By.cssSelector("a[data-product-id=\"2608\"][data-title=\"Wishlist\"]");
    public By wirelessHeadphonesAdded = By.cssSelector("div#yith-wcwl-message");

    public void addWirelessHeadphonesToWishlist () throws Exception {
        WebElement wirelessHeadphonesElement = wait.until(ExpectedConditions.presenceOfElementLocated(wirelessHeadphones));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", wirelessHeadphonesElement);
        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.moveToElement(wirelessHeadphonesElement).perform(); // hover

        wait.until(ExpectedConditions.elementToBeClickable(wishlistWirelessHeadphones)).click();
    }
}
