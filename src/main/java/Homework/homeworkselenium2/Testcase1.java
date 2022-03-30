package Homework.homeworkselenium2;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Testcase1 {
        /*
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Select Name (Z-A)
from drop down box
Validate the pro
ducts are displayed in descending order
 */

    @Test
    public void dropdownbox() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement username= driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginbutton= driver.findElement(By.id("login-button"));
        loginbutton.click();
        Thread.sleep(2000);
        WebElement sortingchoise=driver.findElement(By.className("product_sort_container"));
        BrowserUtils.selectBy(sortingchoise, "za", "value");

        List<WebElement> descendingname= driver.findElements(By.className("inventory_item_name"));
        List<String> actualDescendingOrder= new LinkedList<>();
        List<String> expectedDescendingOrder= new ArrayList<>();
        for (int i=0; i<descendingname.size(); i++){
            actualDescendingOrder.add(descendingname.get(i).getText().trim());
            expectedDescendingOrder.add(descendingname.get(i).getText().trim());
            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);
            //  Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);
        }
        Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);


    }
}
