package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.effect.SepiaTone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {

    @Test
    public void practice1() throws InterruptedException {
        // it its failing beacuse my driver still  pointing last tab. it throws the NoSuchElementExepction
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickherebutton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickherebutton.click();
        WebElement header = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(header.getText());
    }

    @Test
    public void switchWindow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getWindowHandle());
        WebElement clickherebutton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickherebutton.click();
        System.out.println(driver.getWindowHandle());
        // WebElement header= driver.findElement(By.xpath("//h3[.='New Window']"));
        String mainpageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();

        //this implementation for only 2 tabs
        for (String id : allPagesId) {
            System.out.println(id);
            if (!id.equals(mainpageId)) {
                driver.switchTo().window(id);
            }
        }
        WebElement header = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(header.getText());
        String actiualtext = header.getText();
        String exoectedtext = "New Window";
        Assert.assertEquals(actiualtext, exoectedtext);

    }

    @Test
    public void WindowHandlepractice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        String mainpageId = driver.getWindowHandle();
        WebElement opennewtabbutton = driver.findElement(By.id("newTabBtn"));
        opennewtabbutton.click();
        BrowserUtils.SwitchOnlyFor2Tabs(driver,mainpageId);
//        Set<String> allPagesId = driver.getWindowHandles();
//        for (String id : allPagesId) {
//            if (!id.equals(mainpageId)) {
//                driver.switchTo().window(id);
//            }
//        }

        WebElement header = driver.findElement(By.xpath("//h1[@class=\"post-title entry-title\"]"));
        String actiualHeader = BrowserUtils.getTextMethod(header);//it gets test and trim it
        String expectedHeader = "AlertsDemo";
        Assert.assertEquals(actiualHeader, expectedHeader);
        WebElement clickmebutton= driver.findElement(By.id("alertBox"));
        clickmebutton.click();
    }
}