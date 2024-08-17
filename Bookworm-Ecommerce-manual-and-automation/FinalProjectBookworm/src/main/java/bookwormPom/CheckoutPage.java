package bookwormPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By firstNameInputField = By.cssSelector("input#billing_first_name");
    By lastNameInputField = By.cssSelector("input#billing_last_name");
    By companyNameOptionalInputField = By.cssSelector("input#billing_company");
    By selectCountyOrRegion = By.cssSelector("select#billing_country option[value=\"MK\"]");
    By streetAddressOneInputField = By.cssSelector("input#billing_address_1");
    By streetAddressTwoOptionalInputField = By.cssSelector("input#billing_address_2");
    By cityOrTownInputField = By.cssSelector("input#billing_city");
    By stateOrCountryInputField = By.cssSelector("input#billing_state");
    By postcodeOrZipInputField = By.cssSelector("input#billing_postcode");
    By phoneInputField = By.cssSelector("input#billing_phone");
    By emailInputField = By.cssSelector("input#billing_email");
    By orderNotesOptionalInputField = By.cssSelector("textarea#order_comments");
    By placeOrderButton = By.cssSelector("button#place_order");
    By orderConfirmation = By.cssSelector("div.woocommerce-order h6");

    public void fillInFirstName (String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInputField)).sendKeys(firstName);
    }

    public void fillInLastName (String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lastNameInputField)).sendKeys(lastName);
    }

    public void fillInCompanyName (String companyName) {
        wait.until(ExpectedConditions.elementToBeClickable(companyNameOptionalInputField)).sendKeys(companyName);
    }

    public void chooseCountryOrRegion () {
        wait.until(ExpectedConditions.elementToBeClickable(selectCountyOrRegion)).click();
    }

    public void fillInStreetAddress (String streetAddress) {
        wait.until(ExpectedConditions.elementToBeClickable(streetAddressOneInputField)).sendKeys(streetAddress);
    }

    public void fillInAdditionalStreetAddress (String additionalStreetAddress) {
        wait.until(ExpectedConditions.elementToBeClickable(streetAddressTwoOptionalInputField)).sendKeys(additionalStreetAddress);
    }

    public void fillInCityOrTown (String cityOrTown) {
        wait.until(ExpectedConditions.elementToBeClickable(cityOrTownInputField)).sendKeys(cityOrTown);
    }

    public void fillInStateOrCountry (String stateOrCounty) {
        wait.until(ExpectedConditions.elementToBeClickable(stateOrCountryInputField)).sendKeys(stateOrCounty);
    }

    public void fillInPostcodeOrZip (String postcodeOrZip) {
        wait.until(ExpectedConditions.elementToBeClickable(postcodeOrZipInputField)).sendKeys(postcodeOrZip);
    }

    public void fillInPhone (String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(phoneInputField)).sendKeys(phone);
    }

    public void fillInEmail (String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailInputField)).sendKeys(email);
    }

    public void fillInOrderNotes (String orderNotes) {
        wait.until(ExpectedConditions.elementToBeClickable(orderNotesOptionalInputField)).sendKeys(orderNotes);
    }

    public void clickPlaceOrderButton () {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public void placeOrder (String firstName, String lastName, String companyName, String streetAddress, String additionalStreetAddress,
                            String cityOrTown, String stateOrCounty, String postcodeOrZip, String phone, String email, String orderNotes) {

        fillInFirstName(firstName);
        fillInLastName(lastName);
        fillInCompanyName(companyName);
        chooseCountryOrRegion();
        fillInStreetAddress(streetAddress);
        fillInAdditionalStreetAddress(additionalStreetAddress);
        fillInCityOrTown(cityOrTown);
        fillInStateOrCountry(stateOrCounty);
        fillInPostcodeOrZip(postcodeOrZip);
        fillInPhone(phone);
        fillInEmail(email);
        fillInOrderNotes(orderNotes);
        clickPlaceOrderButton();
    }

    public String confirmationMessage () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmation));
        return driver.findElement(orderConfirmation).getText();
    }
}
