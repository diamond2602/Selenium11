package com.test.etsy.pages;

import com.test.etsy.EtsyTestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

/*)1)First of all navigate to website "https://www.etsy.com/'
   2)take care of your TestBase
   3)Find searchBox and type iphone 13 case and click searchbox or enter
     I would store my all elements inside of mainPage
   4)I would create a test class and validate all of the headers from search
   includes either iphone,13 or case. If all of them includes it should assert pass

   5)Your search name(iphone 13 case) should come from parameter.xml
   6)You can run your class at the end from TestNG runner.xml

 */

public class EtsyMainPage {

    public EtsyMainPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "global-enhancements-search-query")
    WebElement searchBox;

    public void searchItem(String searchItem)  {
        searchBox.sendKeys(searchItem, Keys.ENTER);
    }

    @FindBy(xpath = "//li//h3")
    List<WebElement> allheaders;

    public boolean validateHeader(){

        for(WebElement header: allheaders){
            String headr= header.getText().trim().toLowerCase();
            if(!(headr.contains("iphone")||headr.contains("13")||headr.contains("case"))){
    return  false;
            }

        }
        return  true;
    }
}
