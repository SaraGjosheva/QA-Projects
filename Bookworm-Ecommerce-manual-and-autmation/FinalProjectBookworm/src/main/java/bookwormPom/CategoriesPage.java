package bookwormPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoriesPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public CategoriesPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By allYouCanEverKnowAMemoir = By.xpath("//h2/a[contains(text(),\"All You Can Ever Know: A Memoir\")]");
    By wishlistAllYouCanEverKnowAMemoir = By.cssSelector("a[data-product-id=\"1162\"] i.flaticon-heart");
    By selectOptionsAllYouCanEverKnowAMemoir = By.cssSelector("a[aria-label=\"Select options for “All You Can Ever Know: A Memoir”\"]");

    public void addAllYouCanEverKnowAMemoirToWishlist () throws Exception {
        WebElement allYouCanEverKnowAMemoirBook = wait.until(ExpectedConditions.visibilityOfElementLocated(allYouCanEverKnowAMemoir));

        Actions hover = new Actions(driver);
        hover.moveToElement(allYouCanEverKnowAMemoirBook).perform();

        wait.until(ExpectedConditions.elementToBeClickable(wishlistAllYouCanEverKnowAMemoir)).click();
        Thread.sleep(2000); // without this Thread is not possible
    }

    public void selectOptionsInAllYouCanEverKnowAMemoir () {
        WebElement allYouCanEverKnowAMemoirBook = wait.until(ExpectedConditions.visibilityOfElementLocated(allYouCanEverKnowAMemoir));

        Actions hover = new Actions(driver);
        hover.moveToElement(allYouCanEverKnowAMemoirBook).perform();

        wait.until(ExpectedConditions.elementToBeClickable(selectOptionsAllYouCanEverKnowAMemoir)).click();
    }
}
