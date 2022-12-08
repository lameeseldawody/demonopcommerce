package org.example.stepDefs;
import static org.example.stepDefs.Hooks.driver;

import io.cucumber.java.en.*;
import org.example.pages.P01_Register;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_Register {
    P01_Register register =new P01_Register();
    @Given("user go to register page")
    public void Step1(){
        register.reglink().click();}

    @When("user select gender type")
    public void userSelectGenderType() {
        register.Gender().click();}

    @And("user enter first name and last name")
    public void userEnterFirstNameAndLastName() {
        register.FirstName().sendKeys("automation");
        register.LastName().sendKeys("tester");}

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
    Select Day = new Select(register.DayList());
    Day.selectByValue("22");
    Select Month = new Select(register.MonthList());
    Month.selectByValue("11");
    Select Year = new Select(register.YearList());
    Year.selectByValue("1992");}

    @And("user enter email  field")
    public void userEnterEmailField() {
        register.Email().sendKeys("test@example.com");}

    @And("user fills Password fields")
    public void userFillsPasswordFields() {
        register.Password().sendKeys("P@ssw0rd");
        register.ConfirmPassword().sendKeys("P@ssw0rd");}

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.RegisterButton().click();}

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();
        String actualUrl =driver.getCurrentUrl();
        soft.assertEquals(actualUrl,"https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
        String MSG = register.SuccessMSG().getText();
        soft.assertEquals(MSG,"Your registration completed");
        String actualcolor = register.SuccessMSG().getCssValue("color");
        actualcolor = Color.fromString(actualcolor).asHex();
        soft.assertEquals(actualcolor,"#4cb17c");
        boolean statusbtn = register.Continue().isDisplayed();
        soft.assertTrue(statusbtn);
        soft.assertAll();
    }
}
