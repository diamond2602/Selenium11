package Homework.homeworkselenium3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase4 {
    /*
    Navigate to "https://demos.telerik.com/kendo-ui/websushi#"
Validate price of all the products are less than $25
     */
    @Test
    public void allproductspricevalidate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
//       List<WebElement> alproductprices= driver.findElements(By.xpath("//span[@data-bind=\"text: price\"]"));
//       String allprices= alproductprices.
//        System.out.println(allprices);
    }


}
