package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSMethods {
    //Whenever normal methods are not working then last decision should be javaScript.

    @Test
    public void TitleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle()+"from driver");
     //   JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
     //   String title= javascriptExecutor.executeScript("return document.title").toString();
      //  System.out.println(title+"from javascript");
     String actualTitle=BrowserUtils.GetTitleWithJS(driver);
String expectedTitle="Home Page - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test //i use this method often
    public void ClickWithJS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com");

        WebElement browserCourse= driver.findElement(By.xpath("//a[.='Browse Course']"));
      //  JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
      //  javascriptExecutor.executeScript("arguments[0].click()",browserCourse);
        BrowserUtils.ClickWithJS(driver,browserCourse);

        WebElement studentloginbutton= driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
  BrowserUtils.ClickWithJS(driver,studentloginbutton);

    }

    @Test //***
    public void ScrollintoView(){
     WebDriverManager.chromedriver().setup();
     WebDriver driver= new ChromeDriver();
     driver.get("http://www.techtorialacademy.com");
     WebElement copyright= driver.findElement(By.xpath("//p[contains(text(),'Copy')]"));

     JavascriptExecutor js= (JavascriptExecutor) driver;
   //  js.executeScript("arguments[0].scrollIntoView(true)",copyright);

    }

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com");
        WebElement browse= driver.findElement(By.xpath("//a[contains(text(),'Browse Course')]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
    //    js.executeScript("arguments[0].click()",browse);
        BrowserUtils.ClickWithJS(driver,browse);
        WebElement GetStarted= driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a"));
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)",GetStarted);
        BrowserUtils.ScrollWthJS(driver,GetStarted);
        BrowserUtils.ClickWithJS(driver,GetStarted);

    }

    @Test
    public  void ScrollWithXandYCordinateTest(){
        //this is interview question
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com");
        WebElement copyright= driver.findElement(By.xpath("//p[contains(text(),'Copy')]"));
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        Point location= copyright.getLocation();
//        System.out.println(location.x);
//        System.out.println(location.y);
//        int xCord= location.getX();
//        int yCord= location.getY();
//        js.executeScript("window.scrollTo("+xCord+","+yCord+")");
      BrowserUtils.ScrollWthXandYCord(driver,copyright);

    }
}
