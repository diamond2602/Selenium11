package com.test.orangehrm.tests;

import org.testng.annotations.DataProvider;

public class DataForLoginNegativeTest {
    @DataProvider(name = "loginnegativeTestscenario")
    public Object[][] getData() {
        return new Object[][]{
                {"Admin", "wrongpassword", "Invalid credentials"},
                {"wrongusername", "admin123", "Invalid credentials"},
                {"wrongusername", "wrongpassword", "Invalid credentials"}
        };
    }

    @DataProvider(name = "UserRoles")
    public Object[][] getUserRolesData() {
        return new Object[][]{
                {"Admin"},
                {"ESS"}
        };
    }
}