package org.example.pages;
import static org.example.stepDefs.Hooks.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class P02_Login {
    // valid Scenario

    public WebElement Loginpage(){return driver.findElement(By.className("ico-login"));}
    public WebElement Email(){return driver.findElement(By.className("email"));}
    public WebElement Password(){return driver.findElement(By.className("password"));}
    public WebElement LoginButton(){return driver.findElement(By.className("login-button"));}
    public WebElement MyaccountButton(){return driver.findElement(By.className("ico-account"));}
   // invalid Scenario
    public WebElement email(){return driver.findElement(By.id("Email"));}
    public WebElement password(){return driver.findElement(By.id("Password"));}
    public WebElement errormessage(){return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));}
}
