package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public ContactPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By firstName = By.cssSelector("input#wpforms-5460-field_0");
    By lastName = By.cssSelector("input#wpforms-5460-field_0-last");
    By email = By.cssSelector("input#wpforms-5460-field_1");
    By message = By.cssSelector("textarea#wpforms-5460-field_2");
    By sendMessageButton = By.cssSelector("button#wpforms-submit-5460");
    By feedbackMessage = By.cssSelector("div#wpforms-confirmation-5460 >p");

    public void fillInFirstName (String inputFirstName)  {
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(inputFirstName);
    }

    public void fillInLastName (String inputLastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lastName)).sendKeys(inputLastName);
    }

    public void fillInEmail (String inputEmail) {
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(inputEmail);
    }

    public void fillInMessage (String inputMessage) {
        wait.until(ExpectedConditions.elementToBeClickable(message)).sendKeys(inputMessage);
    }

    public void clickSendMessage () throws Exception {
        WebElement submitMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(sendMessageButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", submitMessageElement);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(submitMessageElement)).click();
    }

    public void submitMessage (String inputFirstName, String inputLastName, String inputEmail, String inputMessage) throws Exception {
        fillInFirstName(inputFirstName);
        fillInLastName(inputLastName);
        fillInEmail(inputEmail);
        fillInMessage(inputMessage);
        clickSendMessage();
    }

    public String messageConfirmation () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackMessage)).getText();
    }
}
