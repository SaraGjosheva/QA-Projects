package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait (driver, Duration.ofSeconds(10));
    }

    By featuredBrands = By.xpath("//a [text() = \"Featured Brands\"]");
    By trendingStyles = By.xpath("//a [text() = \"Trending Styles\"]");
    By giftCards = By.xpath("//a [text() = \"Gift Cards\"]");

    public void gettingFeaturedBrandsMenu () {
        wait.until(ExpectedConditions.elementToBeClickable(featuredBrands)).click();
    }

    public void gettingTrendingStylesMenu () {
        wait.until(ExpectedConditions.elementToBeClickable(trendingStyles)).click();
    }

    public void gettingGiftCardsMenu () {
        wait.until(ExpectedConditions.elementToBeClickable(giftCards)).click();
    }
}
