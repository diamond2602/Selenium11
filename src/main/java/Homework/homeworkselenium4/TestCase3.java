package Homework.homeworkselenium4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
    /*
    Navigate to "https://www.cars.com/"
Select "Certified Cars" from drop down
Select "Toyota" from All Makes
Select "Corolla" from drop down
Select max price is "$30000"
Select 40 miles from drop down box
Insert 60018 as zip code
Click search button
Validate title has Certified Used
Validate "Certified Used Toyota Corolla for Sale" isdisplayed

    Validate 40 miles selected in dropdown once you clicksearch button
Validate Certified Pre-Owned selected in radio button
Validate Toyota is selected in checkbox
Validate Corolla is selected in drop down
     */
    @Test
    public void toyota() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.cars.com/");
        WebElement newused = driver.findElement(By.id("make-model-search-stocktype"));
        BrowserUtils.selectBy(newused, "cpo", "value");
        WebElement make = driver.findElement(By.id("makes"));
        BrowserUtils.selectBy(make, "toyota", "value");
        WebElement model = driver.findElement(By.id("models"));
        BrowserUtils.selectBy(model, "toyota-corolla", "value");
        WebElement price = driver.findElement(By.id("make-model-max-price"));
        BrowserUtils.selectBy(price, "30000", "value");
        WebElement distance = driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(distance, "40", "value");
        WebElement distancezip = driver.findElement(By.id("make-model-zip"));
        distancezip.clear();
        distancezip.sendKeys("60018");
        Thread.sleep(2000);
        WebElement searchbutton = driver.findElement(By.xpath("//button[@data-searchtype='make' and @type='submit']"));
        searchbutton.click();

        boolean actualendintitle= driver.getTitle().startsWith("Certified used");
        Assert.assertTrue(actualendintitle);

        WebElement header= driver.findElement(By.tagName("h1"));
        boolean isdisplayed=header.isDisplayed();
        Assert.assertTrue(isdisplayed);

        WebElement distanceselected= driver.findElement(By.xpath("//select[@data-activitykey=\"location-distance\"]"));
        String actualdisctanceselected=distanceselected.getText();
        System.out.println(actualdisctanceselected);
    }
}
