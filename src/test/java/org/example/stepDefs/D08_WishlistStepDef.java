package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_Homepage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D08_WishlistStepDef {
    P03_Homepage Wishlist = new P03_Homepage();
    
    @When("user click on wishlist button on this product HTC One M8 Android L 5.0 Lollipop")
    public void Wishlistbutton(){Wishlist.wishlistbutton().get(2).click();}

    @Then("verify the success message is displayed")
    public void verifyTheSuccessMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();
        boolean successMsg = Wishlist.successMsg().isDisplayed();
        soft.assertTrue(successMsg);
        String actualcolor = Wishlist.successMsg().getCssValue("background-color");
        actualcolor = Color.fromString(actualcolor).asHex();
        soft.assertEquals(actualcolor,"#4bb07a");
        soft.assertAll();}
    @And("user could click on close icon")
    public void userCouldClickOnCloseIcon() {Wishlist.closeicon().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(Wishlist.closeicon()));
    }
    @And("user  click on Wishlist Tab on the top of the page")
    public void userClickOnWishlistTabOnTheTopOfThePage() {Wishlist.WishlistTop().click();}

    @Then("verify that the product appear in wishlist page")
    public void verifyThatTheProductAppearInWishlistPage() {
        SoftAssert soft = new SoftAssert();
        String Qty = Wishlist.Qtyvalue().getAttribute("value");
        int num = Integer.parseInt(Qty);
        soft.assertTrue(num>0);
        soft.assertAll();}

}
