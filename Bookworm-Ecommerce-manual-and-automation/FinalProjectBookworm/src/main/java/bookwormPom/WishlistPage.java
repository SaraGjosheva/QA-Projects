package bookwormPom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    By editTitleButton = By.cssSelector("a.show-title-form");
    By editTitleInputField = By.cssSelector("input[name='wishlist_name']");
    By confirmTitleButton = By.cssSelector("i.fa-check");
    By removeTitleButton = By.cssSelector("i.fa-remove");
    By removeBookButton = By.cssSelector("a.remove_from_wishlist");
    By productInWishlist = By.cssSelector("td.product-name");
    By titleText = By.cssSelector("div.wishlist-title h2");

    public void clickOnEditTitleButton () {
        wait.until(ExpectedConditions.elementToBeClickable(editTitleButton)).click();
    }

    public void fillInWishlistTitle (String wishlistTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editTitleInputField)).sendKeys(Keys.CONTROL + "a");
        driver.findElement(editTitleInputField).sendKeys(Keys.DELETE);
        driver.findElement(editTitleInputField).sendKeys(wishlistTitle);
    }

    public void confirmWishlistTitle () {
        wait.until(ExpectedConditions.elementToBeClickable(confirmTitleButton)).click();
    }

    public void hideEditTitleInputField () {
        wait.until(ExpectedConditions.elementToBeClickable(removeTitleButton)).click();
    }

    public void removeBookFromWishlist () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeBookButton)).click();
    }

    public String getBookNameInWishlist () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productInWishlist));
        return driver.findElement(productInWishlist).getText();
    }

    public String getWishlistTitle () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleText));
        return driver.findElement(titleText).getText();
    }
}
