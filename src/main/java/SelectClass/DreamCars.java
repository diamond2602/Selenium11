package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DreamCars {
    // got to https://www.cars.com/
    //choose the options you want for your car
    //Click search button
    // validate the header
    //And validate all the subheaders contains the name of them cars you are looking for
    //.clear--sendkeys
    @Test
    public void Mercedes()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.cars.com/");
        WebElement newused=driver.findElement(By.id("make-model-search-stocktype"));
        BrowserUtils.selectBy(newused, "new", "value");
        WebElement make=driver.findElement(By.id("makes"));
        BrowserUtils.selectBy(make, "mercedes_benz", "value");
        WebElement model=driver.findElement(By.id("models"));
        BrowserUtils.selectBy(model, "mercedes_benz-eqs_580", "value");
        WebElement price=driver.findElement(By.id("make-model-max-price"));
        BrowserUtils.selectBy(price, "175000", "value");
        WebElement distance=driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(distance, "all", "value");
        WebElement distancezip=driver.findElement(By.id("make-model-zip"));
        distancezip.clear();
        distancezip.sendKeys("98012");
        Thread.sleep(2000);
        WebElement searchbutton= driver.findElement(By.xpath("//button[@data-searchtype='make' and @type='submit']"));

        searchbutton.click();

        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'New Mercedes-Benz EQS 580 for sale')]"));
        String actualHeader = BrowserUtils.getTextMethod(header);
        String expectedHeader="New Mercedes-Benz EQS 580 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        List<WebElement> validationForSubheaders= driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement car:validationForSubheaders){
            boolean contains = car.getText().trim().toLowerCase().contains("mercedes-benz");
            Assert.assertTrue(contains);
        }
driver.quit();




    }
    @Test
            public void volvo()throws InterruptedException{
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
    WebElement newUsed= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
    WebElement make=driver.findElement(By.xpath("//select[@id='makes']"));
    WebElement model=driver.findElement(By.xpath("//select[@id='models']"));
    WebElement search=driver.findElement(By.xpath("//button[@type='submit' and @data-searchtype='make']"));
        BrowserUtils.selectBy(newUsed,"new","value");
        BrowserUtils.selectBy(make,"Volvo","text");
        BrowserUtils.selectBy(model,"volvo-s90","value");
        Thread.sleep(2000);
        search.click();
    WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'New Volvo S90 for sale')]"));
    String actualHeader = BrowserUtils.getTextMethod(header);
    String expectedHeader="New Volvo S90 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
    List<WebElement> validationForSubheaders= driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement car:validationForSubheaders){
        boolean contains = car.getText().trim().toLowerCase().contains("volvo");
        Assert.assertTrue(contains);
    }
        driver.quit();
    }
}
