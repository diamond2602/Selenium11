package Homework.homeworkselenium3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase5 {

    /*
    Navigate to "https://demos.telerik.com/kendo-ui/websushi#"
Add 3 items to your cart
Click X button on the top added items
Validate items number is 2
     */
    @Test
    public void itemsnumbersi2validate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
//        List<WebElement> allProducts = driver.findElements(By.xpath("//button[@class=\"add-to-cart\"]"));
//
//        for(int i=0; i<3; i++){
//            allProducts.
//        }


    }


}
