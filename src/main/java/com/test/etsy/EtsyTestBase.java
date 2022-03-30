package com.test.etsy;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EtsyTestBase {
    public WebDriver driver;    // public WebDriver driver=  Driver.getDriver();  same also works
    @BeforeMethod
    public void setup(){

      driver=  DriverHelper.getDriver();


//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
//        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(){
DriverHelper.tearDown();
      //  driver.quit();
    }
}
