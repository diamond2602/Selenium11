package Alert;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {

        @Test
        public void JSAlert(){
    /*(ALERT CLASS)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom left one)
    3)Validate the text on pop-up
    4)Handle the pop up

     */
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://sweetalert.js.org/");
            WebElement preview1= driver.findElement(By.xpath("//button[@onclick=\"alert('Oops, something went wrong!')\"]"));
            preview1.click();
            Alert alert1=driver.switchTo().alert();
            String actualtext = alert1.getText();
            String expectedText = "Oops, something went wrong!";
            Assert.assertEquals(actualtext, expectedText);
            alert1.accept();

        }

        @Test
        public void TrialForAlertToHandleHTMLpopup(){
    /* TASK 2 (ALERT CLASS)
     1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://sweetalert.js.org/");
            WebElement preview2= driver.findElement(By.xpath("//button[@onclick=\"swal('Oops', 'Something went wrong!', 'error')\"]"));
            preview2.click();
            Alert alert2=driver.switchTo().alert();
            String actualtext2 = alert2.getText();
            String expectedText2 = "Something went wrong!";
            Assert.assertEquals(actualtext2, expectedText2);
            alert2.accept();

            //THIS WILL FAIL

        }
        @Test
        public void HTMLALERT () throws InterruptedException {
    /*
    TASK 3 (HTML ALERT)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://sweetalert.js.org/");
            driver.manage().window().maximize();
         //   Thread.sleep(2000); or you need to use this for browserutils
            WebElement preview2= driver.findElement(By.xpath("//button[@onclick=\"swal('Oops', 'Something went wrong!', 'error')\"]"));
            preview2.click();
            WebElement popuphtml= driver.findElement(By.xpath("//div[@class=\"swal-text\"]"));
            String actualtext= BrowserUtils.getTextMethod(popuphtml);
            String expectectedtext="Something went wrong!";
            Assert.assertEquals(actualtext,expectectedtext);
            WebElement okbutton= driver.findElement(By.xpath("//button[@class=\"swal-button swal-button--confirm\"]"));
            okbutton.click();
        }
    }