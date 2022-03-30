package Homework.homeworkselenium4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;
import java.util.Set;

public class TestCase2 {
    /*
    Navigate to Navigate to"http://uitestpractice.com/Students/Select#"
Validate the values for Multiple Select are :
India
United States of America
China
England
Select China and England
Validate "China England" is displayed
Deselect all the countries
Select All the countries
Validate "India United states of America ChinaEngland" is
displayed
Deselect the China with index number
Deselect the England with value
     */
    @Test
    public void multipleselect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();
        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='countriesMultiple']//option"));
        String actualValues = "";
        for(int i=0; i<dropDown.size(); i++){
            if(i<dropDown.size()-1){
                actualValues+=BrowserUtils.getTextMethod(dropDown.get(i))+", ";
            }else{
                actualValues+=BrowserUtils.getTextMethod(dropDown.get(i));
            }
        }
        String expectedValues = "India, United states of America, China, England";
        Assert.assertEquals(actualValues,expectedValues);
        WebElement secondchoise= driver.findElement(By.xpath("//select[@id=\"countriesMultiple\"]"));
        Select select= new Select(secondchoise);
        select.selectByIndex(2);
        select.selectByIndex(3);

        WebElement ChinaAndEnglanddisplayed= driver.findElement(By.xpath("//div[@id='result']"));
        boolean isdisplayed=ChinaAndEnglanddisplayed.isDisplayed();
        Assert.assertTrue(isdisplayed);

        select.deselectAll();
        select.selectByIndex(0);
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.deselectByIndex(2);
        select.deselectByValue("england");



    }
}
