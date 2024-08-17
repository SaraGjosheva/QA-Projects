package bookwormPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By categories = By.cssSelector("li#menu-item-170");
    By shop = By.cssSelector("li#menu-item-188");
    By blog = By.cssSelector("li#menu-item-173");

    public void navigateToCategoriesPage () {
        wait.until(ExpectedConditions.elementToBeClickable(categories)).click();
    }

    public void navigateToShopPage () {
        wait.until(ExpectedConditions.elementToBeClickable(shop)).click();
    }

    public void navigateToBlogPage () {
        wait.until(ExpectedConditions.elementToBeClickable(blog)).click();
    }
}
