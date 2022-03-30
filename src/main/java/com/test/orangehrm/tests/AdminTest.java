package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {

    @Test
    public void validateTheCreatinOfEmployeeMessage() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        MainPage mainPage= new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage= new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();
        Assert.assertTrue(adminPage.ValidationTheEmployeeIsCreated("ahmetnewahmet4512"));

    }
@DataProvider(name = "UserRoles")
public Object[][] getUserRolesData(){
        return  new Object[][]{
                {"Admin"},
                {"ESS"}
        };
}

    @Test(dataProvider = "UserRoles", dataProviderClass = DataForLoginNegativeTest.class)
    public void ValidateTheSelectRoleFunction(String roleName){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"), ConfigReader.readProperty("orangehrmpassword"));
    MainPage mainPage= new MainPage(driver);
    mainPage.clickAdminButton();
    AdminPage adminPage= new AdminPage(driver);
    adminPage.selectUserRole(roleName, driver);
    Assert.assertTrue(adminPage.validateRoleText(roleName));
    }

//    @Test
//    public void ValidateTheSelectRoleFunction2(){
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.login(ConfigReader.readProperty("orangehrmusername"), ConfigReader.readProperty("orangehrmpassword"));
//        MainPage mainPage= new MainPage(driver);
//        mainPage.clickAdminButton();
//        AdminPage adminPage= new AdminPage(driver);
//        adminPage.selectUserRole("ESS", driver);
//        Assert.assertTrue(adminPage.validateRoleText("ESS"));
//    }
}
