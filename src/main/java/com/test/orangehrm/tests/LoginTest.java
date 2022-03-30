package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
@BeforeMethod
public void initializePage(){
    loginPage= new LoginPage(driver);
}
    @Test
    public void ValidateLoginPositive() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();

        // all above will be replaced with --> WebDriver driver;
        //
        //    @BeforeMethod
        //    public void setup(){}
        //from TestBase class


     //   LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"), ConfigReader.readProperty("orangehrmpassword"));
//        String actualurl = driver.getCurrentUrl();
//        String expectedurl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
 //       Assert.assertEquals(actualurl, expectedurl);
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard"); // professional version

    }


    @Test(dataProvider ="loginnegativeTestscenario", dataProviderClass = DataForLoginNegativeTest.class)
    public void ValidateLoginNegative1(String username,String lastname, String expectedMessage) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();

    //    LoginPage loginPage = new LoginPage(driver);
   //     loginPage.login("Admin", "ahmet"); // correct username but wrong password
        loginPage.login(username,lastname);
//        String actualErrormessage = loginPage.getErrorMessage();
//        String expectedErrorMessage = expectedMessage;
//        Assert.assertEquals(actualErrormessage, expectedErrorMessage);
        Assert.assertEquals(loginPage.getErrorMessage(), expectedMessage);

    }
    // 2 more negative scenarios (wrong username, correct password
    //(wrong username, wrong password




//    @Test
//    public void ValidateLoginNegative2() {
////        WebDriverManager.chromedriver().setup();
////        WebDriver driver = new ChromeDriver();
////        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
////        driver.manage().window().maximize();
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("", "");
//        String actualErrormessage = loginPage.getErrorMessage();
//        String expectedErrorMessage = "Username cannot be empty";
//        Assert.assertEquals(actualErrormessage, expectedErrorMessage);
//String actualColorOfErroMessage=loginPage.getColorOftheErrorMessage();
//String expectedColorOftheErrorMessage="rgba(221, 119, 0, 1)";
//        Assert.assertEquals(actualColorOfErroMessage,expectedColorOftheErrorMessage);
//    }



// task modify this page according to


}