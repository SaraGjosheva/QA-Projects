package bookworm;

import bookwormPom.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistAndCheckout {

    public static EdgeDriver driver;
    public static WebDriverWait wait;
    public static HomePage homePage;
    public static BasePage basePage; // have locators which contains all the Pages on this Website.
    public static CategoriesPage categoriesPage;
    public static WishlistPage wishlistPage;
    public static ProductPage productPage;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;

    @BeforeMethod
    public static void setUp () {
        driver = new EdgeDriver(); // opening Edge browser
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize(); // maximizing the window of the browser
        driver.get("https://bookworm.madrasthemes.com/"); // opening the webpage
        homePage = new HomePage(driver);
        basePage = new BasePage();
        categoriesPage = new CategoriesPage(driver);
        wishlistPage = new WishlistPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test (description = "Adding a book in wishlist and validating that the chosen book is in wishlist. Also editing the title of the wishlist and validating that.")
    public static void task1EditTitleInWishlist () throws Exception {
        homePage.navigateToCategoriesPage();
        categoriesPage.addAllYouCanEverKnowAMemoirToWishlist();
        basePage.navigateToWishlist(driver);
        Assert.assertEquals(wishlistPage.getBookNameInWishlist(), "All You Can Ever Know: A Memoir");
        wishlistPage.clickOnEditTitleButton();
        wishlistPage.fillInWishlistTitle("Favorite Books");
        wishlistPage.confirmWishlistTitle();
        Assert.assertEquals(wishlistPage.getWishlistTitle(), "Favorite Books");
    }

    @Test (description = "Adding a book in cart and placing an order after filling in all fields, also validating that the order is placed successful.")
    public static void task2CheckoutProcess () {
        homePage.navigateToCategoriesPage();
        categoriesPage.selectOptionsInAllYouCanEverKnowAMemoir();
        productPage.chooseAvailableFormat();
        productPage.selectPaperback();
        productPage.addToCart();
        productPage.viewCart();
        Assert.assertEquals(cartPage.getProductInCartName(), "All You Can Ever Know: A Memoir - Paperback");
        cartPage.proceedToCheckout();
        checkoutPage.placeOrder("Sara", "Gjosheva", "Brainster", "Centar 102",
                "second floor", "Veles", "North Macedonia", "1420",
                "+389176663344", "saragj@yahoo.com", "If not home please deliver it to the neighbour.");
        Assert.assertEquals(checkoutPage.confirmationMessage(), "Thank you. Your order has been received.");
    }

    @AfterMethod
    public static void tearDown () {
        driver.quit(); // closing the browser
    }
}
