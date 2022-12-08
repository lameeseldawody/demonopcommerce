package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
  public static WebDriver driver;
 @Before
 public  void openbrowser(){
     //step:1
     WebDriverManager.chromedriver().setup();
     //step:2
     driver = new ChromeDriver();
     //step:3
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     //step:4
     driver.navigate().to("https://demo.nopcommerce.com/");
     }
 @After
 public void quitdriver() throws InterruptedException {
     Thread.sleep(3000);
     driver.quit();
}
}
