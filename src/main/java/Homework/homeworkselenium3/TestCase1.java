package Homework.homeworkselenium3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {

    /*
    Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Click on top of Shiromi picture
Click > arrow
validate next item is Tekka maki
Click < arrow
Validate the item is Shiromi
Validate number of item 0 in the cart
     */
    @Test
    public  void Tekkamakivalidate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        WebElement shiromi= driver.findElement(By.xpath("//a[@href=\"#/menu/8\"]"));
        shiromi.click();
        WebElement nextarrowbutton= driver.findElement(By.id("navigate-next"));
        nextarrowbutton.click();
        Thread.sleep(2000);
        WebElement tekkamaki= driver.findElement(By.xpath("//h1[@data-bind=\"text: current.name\"]"));
        String actualtext=tekkamaki.getText().trim();
        String expectedtext="Tekka maki";
        Assert.assertEquals(actualtext,expectedtext);
        WebElement previousarrowbutton= driver.findElement(By.id("navigate-prev"));
        previousarrowbutton.click();
        Thread.sleep(2000);
        WebElement shiromiback= driver.findElement(By.xpath("//h1[@data-bind=\"text: current.name\"]"));
        String actualtext2=shiromiback.getText().trim();
        String expectedtext2="Shiromi";
        Assert.assertEquals(actualtext2,expectedtext2);
        WebElement cartinfo= driver.findElement(By.xpath("//span[@data-bind=\"text: cart.contentsCount\"]"));
        String actualcartinfo= cartinfo.getText();
        String exptedcartinfo="0";
        Assert.assertEquals(actualcartinfo,exptedcartinfo);

    }
}
