package Homework.homeworkselenium3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase3 {
    /*
    Navigate to "https://demos.telerik.com/kendo-ui/websushi#"
Click picture of the Salmon Teriyaki
Click Add to cart button 2 times
Validate total price is $26
Validate item number is 1
Click > arrow button
Click add to cart for Gohan
Validate total price is $29
Validate total items 2
     */
    @Test
    public void SalmonTeriyakivalidate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement salmonTeriyaki = driver.findElement(By.xpath("//a[@href=\"#/menu/16\"]"));
        salmonTeriyaki.click();
        WebElement addcartbutton= driver.findElement(By.xpath("//button[@class=\"buy\"]"));
        addcartbutton.click();
        Thread.sleep(2000);
        addcartbutton.click();
        WebElement shoppingcartamount= driver.findElement(By.xpath("//p[@class=\"total-price\"]"));
        String actualcartamount=shoppingcartamount.getText().substring(0,3);
        String expectedamountofshoppingcart="$26";
        Assert.assertEquals(actualcartamount,expectedamountofshoppingcart);
        WebElement cartinfo= driver.findElement(By.xpath("//span[@data-bind=\"text: cart.contentsCount\"]"));
        String actualcartinfo= cartinfo.getText();
        String exptedcartinfo="1";
        Assert.assertEquals(actualcartinfo,exptedcartinfo);
        Thread.sleep(2000);
        WebElement nextarrowbutton= driver.findElement(By.id("navigate-next"));
        nextarrowbutton.click();
        Thread.sleep(2000);
        WebElement addcartbutton2= driver.findElement(By.xpath("//button[@class=\"buy\"]"));
        addcartbutton2.click();
        Thread.sleep(2000);
        WebElement shoppingcartamount2= driver.findElement(By.xpath("//p[@class=\"total-price\"]"));
        String actualcartamount2=shoppingcartamount2.getText().substring(0,3);
        String expectedamountofshoppingcart2="$29";
        Assert.assertEquals(actualcartamount2,expectedamountofshoppingcart2);
        WebElement cartinfo2= driver.findElement(By.xpath("//span[@data-bind=\"text: cart.contentsCount\"]"));
        String actualcartinfo2= cartinfo2.getText();
        String exptedcartinfo2="2";
        Assert.assertEquals(actualcartinfo2,exptedcartinfo2);

    }
}
