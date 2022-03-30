package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PimPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PimPage pimPage;

    @BeforeMethod
    public void initiliazingPages(){
         loginPage= new LoginPage(driver);
         mainPage= new MainPage(driver);
         pimPage=new PimPage(driver);
    }


    @Test
    public void validateThecreationofEmployee() throws InterruptedException {
       // LoginPage loginPage= new LoginPage(driver);
        loginPage.login("Admin", "admin123");
     //   MainPage mainPage= new MainPage(driver);
        mainPage.clickPIMButton();
    //    PIMPage pimPage=new PIMPage(driver);
        pimPage.addEmployeeForPIM("ahmet9","Baldir9","1991", "C:\\Users\\diamo\\Desktop\\USA.png");
        Assert.assertEquals(pimPage.validateFirstName(),"ahmet9");
        Assert.assertEquals(pimPage.validateLastName(),"Baldir9");
        Thread.sleep(1000);
        Assert.assertTrue(pimPage.validatEmployeeid("1991"));
    }

    @Test
    public  void ValidatePersonalDetailElement() throws InterruptedException {
        loginPage.login("Admin", "admin123");
        mainPage.clickPIMButton();
        pimPage.addEmployeeForPIM("ahmet9","Baldir9","1991", "C:\\Users\\diamo\\Desktop\\USA.png");
        pimPage.editPersonalDetails("Turkish", "1991-09-01", "Single");
        Assert.assertEquals(pimPage.validateTheNationality(),"Turkish");
    }


}
