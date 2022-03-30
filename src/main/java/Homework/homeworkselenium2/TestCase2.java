package Homework.homeworkselenium2;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestCase2 {
    /*
    Steps
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Select Price (low-high)
from drop down box
Validate the pro
ducts are displayed according to their price
and they are displayed low price to high price
     */
    @Test
    public void dropdownbox2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        Thread.sleep(2000);
        WebElement sortingchoise = driver.findElement(By.className("product_sort_container"));
        BrowserUtils.selectBy(sortingchoise, "lohi", "value");

        List<WebElement> allprices= driver.findElements(By.className("inventory_item_price"));
        List<Double> actualpricesOrder= new LinkedList<>();
        List<Double> expectedpricesOrder= new ArrayList<>();
        for (int i=0; i<allprices.size(); i++){
            actualpricesOrder.add(Double.parseDouble(allprices.get(i).getText().substring(1)));
            expectedpricesOrder.add(Double.parseDouble(allprices.get(i).getText().substring(1)));
            Collections.sort(expectedpricesOrder);


        }
        System.out.println(actualpricesOrder);
        System.out.println(expectedpricesOrder);
        Assert.assertEquals(actualpricesOrder,expectedpricesOrder);
    }
}
