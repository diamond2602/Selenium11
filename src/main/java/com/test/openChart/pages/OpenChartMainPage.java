package com.test.openChart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartMainPage {

    public OpenChartMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[@class=\"fa fa-shopping-cart\"]//following-sibling::h2")
    WebElement totalorders;

    @FindBy (xpath = "//i[@class=\"fa fa-credit-card\"]//following-sibling::h2")
    WebElement totalsales;

    @FindBy (xpath = "//i[@class=\"fa fa-user\"]//following-sibling::h2")
    WebElement  totalcustomers;

    @FindBy(xpath = "//i[@class=\"fa fa-users\"]//following-sibling::h2")
    WebElement peopleonline;




}
