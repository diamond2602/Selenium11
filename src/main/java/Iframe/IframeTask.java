package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class IframeTask {
    /*
TASK:
    1)Navigate to the website "https://skpatro.github.io/demo/iframes/"
    2)Click Pavilion and click selenium-java and validate the header
    3)Go back to mainPage and click category1
    4)from new webpage validate the title is ending with "qavalidation"
    5)Go back to mainppage and click Category3
    6)validate the new url is equal to "https://qavalidation.com/category/softwaretesting/"
 */


    @Test
    public void iframetask2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion= driver.findElement(By.xpath("//a[@href=\"http://qavalidation.com/\"]"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver,"Home - qavalidation");
        WebElement selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//.."));
        Actions actions= new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement seleniumJava=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']//.."));
  seleniumJava.click();

  WebElement header= driver.findElement(By.tagName("h1"));
  String actualheadertext= BrowserUtils.getTextMethod(header);
  String expectedtecheaderext="Selenium-Java Tutorial – Basic to Advance";
  Assert.assertEquals(actualheadertext,expectedtecheaderext);
        BrowserUtils.switchByTitle(driver,"iframes");
        Thread.sleep(3000);

        driver.switchTo().frame("Frame1");
        WebElement category1= driver.findElement(By.xpath("//a[@href=\"http://qavalidation.com/category/seleniumtesting/\"]"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
       boolean actualendintitle= driver.getTitle().endsWith("qavalidation");
        Assert.assertTrue(actualendintitle);

        BrowserUtils.switchByTitle(driver,"iframes");

        driver.switchTo().frame("Frame2");
        WebElement category3= driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qavalidation.com/category/softwaretesting/"));
        Thread.sleep(2000);


    }

}