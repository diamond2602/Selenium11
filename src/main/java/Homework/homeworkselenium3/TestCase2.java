package Homework.homeworkselenium3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
    /*
    Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Click Add to cart for Edamame
Validate Item number is 1
Validate price of the product is $4
Click empty cart
Validate item number is 0
     */

    @Test
    public void Edamamevalidate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        Thread.sleep(3000);
        WebElement edamameaddcarbutton = driver.findElement(By.xpath("//body/div[@id='application']/div[1]/div[1]/div[2]/section[2]/div[1]/ul[1]/div[1]/li[4]/button[1]"));
    //path for webelement is too long needs to be changed

         edamameaddcarbutton.click();
        WebElement cartinfo= driver.findElement(By.xpath("//span[@data-bind=\"text: cart.contentsCount\"]"));
        String actualcartinfo= cartinfo.getText();
        String exptedcartinfo="1";
        Assert.assertEquals(actualcartinfo,exptedcartinfo);
        WebElement shoppingcartamount= driver.findElement(By.xpath("//p[@class=\"total-price\"]"));
        String actualcartamount=shoppingcartamount.getText().substring(0,2);
        String expectedamountofshoppingcart="$4";
        Assert.assertEquals(actualcartamount,expectedamountofshoppingcart);
        Thread.sleep(3000);
         WebElement emptycartbutton= driver.findElement(By.xpath("//a[@id=\"empty-cart\"]"));
         emptycartbutton.click();
        WebElement cartinfo2= driver.findElement(By.xpath("//span[@data-bind=\"text: cart.contentsCount\"]"));
        String actualcartinfo2= cartinfo2.getText();
        String exptedcartinfo2="0";
        Assert.assertEquals(actualcartinfo2,exptedcartinfo2);
    }
}