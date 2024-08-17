package bookwormPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By productChooseAvailableFormat = By.cssSelector("select#pa_format");
    By optionHardcover = By.cssSelector("select option[value=\"hardcover\"]");
    By optionKindle = By.cssSelector("select option[value=\"kindle\"]");
    By optionPaperback = By.cssSelector("select option[value=\"paperback\"]");
    By addToCartButton = By.xpath("//div/button[text() = 'Add to cart']");
    By viewCartButton = By.xpath("//div/a[text() = \"View cart\"]");

    public void chooseAvailableFormat () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productChooseAvailableFormat)).click();
    }

    public void selectHardcover () {
        wait.until(ExpectedConditions.elementToBeClickable(optionHardcover)).click();
    }

    public void selectKindle () {
        wait.until(ExpectedConditions.elementToBeClickable(optionKindle)).click();
    }

    public void selectPaperback () {
        wait.until(ExpectedConditions.elementToBeClickable(optionPaperback)).click();
    }

    public void addToCart () {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void viewCart () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton)).click();
    }
}
