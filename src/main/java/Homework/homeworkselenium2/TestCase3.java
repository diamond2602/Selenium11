package Homework.homeworkselenium2;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class TestCase3 {
    /*
    Steps
    Navigate to "https://www.saucedemo.com/"
    Enter username "standard_user"
    Enter password "secret_sauce"
    Click Login button
    Find the cheapest two product on the page
    Add them to the cart
    Click cart button
    Validate these two products is added to the cart
     */
    @Test
    public void cheapestproducts() throws InterruptedException {
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




    }
}
