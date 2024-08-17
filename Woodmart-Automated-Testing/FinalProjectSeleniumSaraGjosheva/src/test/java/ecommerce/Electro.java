package ecommerce;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.*;

import java.time.Duration;

public class Electro {

    public static EdgeDriver driver;
    public static WebDriverWait wait;
    public static HomePage homePage;
    public static BasePage basePage;
    public static TrendingStylesPage trendingStylesPage;
    public static WishlistPage wishlistPage;
    public static ContactPage contactPage;


    @BeforeMethod
    public static void setUp() {
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://electro.madrasthemes.com/");
        homePage = new HomePage(driver);
        basePage = new BasePage();
        trendingStylesPage = new TrendingStylesPage(driver);
        wishlistPage = new WishlistPage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test
    public static void finalTest() throws Exception {
        homePage.gettingTrendingStylesMenu();
        trendingStylesPage.addWirelessHeadphonesToWishlist();
        wait.until(ExpectedConditions.textToBe(trendingStylesPage.wirelessHeadphonesAdded, "Product added!"));
        trendingStylesPage.navigateToWishlist(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"));
        Assert.assertEquals(wishlistPage.getProductFromWishlist(), "Purple Solo 2 Wireless");
        wishlistPage.logoLink(driver);
        homePage.navigateToContact(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("contact-v1"));
        contactPage.submitMessage("Sara", "Gjosheva", "saragj@yahoo.com", "Message");
        Assert.assertEquals(contactPage.messageConfirmation(), "Thanks for contacting us! We will be in touch with you shortly.");
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();

    }
}
// BasePage - have locators which contains all the Pages on this Website.