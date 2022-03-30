package com.test.openChart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartLoginPage {

    public OpenChartLoginPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath ="//button[@type=\"submit\"]")
    WebElement loginbutton;

    public void openchartlogin(String username, String password){
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        this.loginbutton.click();

    }
}
