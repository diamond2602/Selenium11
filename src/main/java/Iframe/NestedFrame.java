package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class NestedFrame {
        @Test
        public void NestedFrameValidation() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/nested_frames");
            driver.manage().window().maximize();
            //this is example of using index to switch frame
            driver.switchTo().frame(0);// I am on the top frame
            //this is example of using webelement to switch frame
            WebElement middleFrame= driver.findElement(By.name("frame-middle"));
            driver.switchTo().frame(middleFrame);//I am on the middle frame
            WebElement textbox= driver.findElement(By.xpath("//div[@id=\"content\"]"));
            String actualname=BrowserUtils.getTextMethod(textbox);
            String expectedanme="MIDDLE";
            Assert.assertEquals(actualname,expectedanme);

            driver.switchTo().parentFrame();//top
            driver.switchTo().frame("frame-left");//left
            WebElement leftbox= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
            String actualtext= leftbox.getText().trim();
            String expextectext= "LEFT";
            Assert.assertEquals(actualtext,expextectext);
//            driver.switchTo().parentFrame();//top
//            driver.switchTo().parentFrame();//html
            driver.switchTo().defaultContent(); // means it directly goes to the HTML
            driver.switchTo().frame("frame-bottom");//bottom
            WebElement bottombox= driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
            String actualtextbottom= BrowserUtils.getTextMethod(bottombox);
            String expextectextbottom= "BOTTOM";
            Assert.assertEquals(actualtextbottom,expextectextbottom);
        }
    }