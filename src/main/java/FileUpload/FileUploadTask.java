package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTask {

    @Test
    public void validateFileUploadPractice() throws InterruptedException {
        /*
1)Navigate to the "https://demo.guru99.com/test/upload/'
2)Upload the usa.png file on the website
3)Click the box (I accept terms of service)
4)validate box is selected
5)Click submit button
6)Validate the message "1 file has been successfully uploaded."
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement choosefile= driver.findElement(By.id("uploadfile_0"));
        choosefile.sendKeys("C:\\Users\\diamo\\Desktop\\USA.png");
        WebElement checkbox= driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected()); //****
        WebElement submitfile= driver.findElement(By.id("submitbutton"));
        submitfile.click();

Thread.sleep(3000);
        WebElement message1= driver.findElement(By.id("res"));
        String actualmessage= BrowserUtils.getTextMethod(message1);
        String expectedmessage="1 file\n" +
                "has been successfully uploaded.";

       Assert.assertEquals(actualmessage,expectedmessage);

    }
}