package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {
    @Test
    public  void validateFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement choosefile= driver.findElement(By.id("file-upload"));
choosefile.sendKeys("C:\\Users\\diamo\\Desktop\\USA.png");
WebElement uploadbutton= driver.findElement(By.id("file-submit"));
uploadbutton.click();
WebElement message1= driver.findElement(By.tagName("h3"));
String actualmessage= BrowserUtils.getTextMethod(message1);
String expectedmessage="File Uploaded!";
        Assert.assertEquals(actualmessage,expectedmessage);
        WebElement message2= driver.findElement(By.id("uploaded-files"));
        String actualmessage2= BrowserUtils.getTextMethod(message2);
        String expectedmessage2="USA.png";
        Assert.assertEquals(actualmessage2,expectedmessage2);


    }
}
