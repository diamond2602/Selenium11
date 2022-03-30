package com.test.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
        @FindBy(id = "menu_admin_viewAdminModule")
        WebElement adminbutton;

        public void clickAdminButton(){
            adminbutton.click();
        }

    @FindBy(id = "menu_pim_viewPimModule")
    WebElement PIMbutton;

    public void clickPIMButton(){
        PIMbutton.click();
    }



}

