package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiSelect {
    @Test
    public void MultipleSelectAndFirstSelectPractice()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("file:///C:/Users/diamo/Downloads/Techtorial%20(3).html");
        driver.manage().window().maximize();
        WebElement header= driver.findElement(By.id("techtorial1"));
        BrowserUtils.getTextMethod(header);// header.getText().trim();
        WebElement  multiselectbox= driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.selectBy(multiselectbox, "Two", "text");
        BrowserUtils.selectBy(multiselectbox, "3", "index");
        BrowserUtils.selectBy(multiselectbox, "1", "value");
        Select select=new Select(multiselectbox);
        Thread.sleep(2000);
        select.selectByIndex(3);

        //trim()-- it removes the space from both side of the string.
        WebElement countrylist= driver.findElement(By.name("country"));
        Select country=new Select(countrylist);
//String actualFirstSelectedoption=country.getFirstSelectedOption().getText().trim();
        String actualFirstSelectedoption=BrowserUtils.getTextMethod(country.getFirstSelectedOption());

String expectedFirstSelectedoption="UNITED STATES";
        Assert.assertEquals(actualFirstSelectedoption,expectedFirstSelectedoption);


       // select.deselectAll();

    }
}
