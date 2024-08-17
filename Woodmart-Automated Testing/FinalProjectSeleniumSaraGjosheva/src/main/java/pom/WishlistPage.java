package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishlistPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public WishlistPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By productsWishlistTable = By.cssSelector("td.product-name");

    public String getProductFromWishlist () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsWishlistTable));
        return driver.findElement(productsWishlistTable).getText();
    }
}
