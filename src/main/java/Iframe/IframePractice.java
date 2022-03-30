package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice {
    @Test
    public  void iframetest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        // do not forget to switch your frame before you find the element
        WebElement box= driver.findElement(By.id("tinymce"));
        box.clear();
        box.sendKeys("I love selenium");
        driver.switchTo().parentFrame();
        WebElement header= driver.findElement(By.tagName("h3"));  //(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        String actualtextheader= BrowserUtils.getTextMethod(header);
        String expectedtextheader="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualtextheader,expectedtextheader);
    }

}
