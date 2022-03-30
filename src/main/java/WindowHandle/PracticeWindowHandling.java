package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeWindowHandling {
    /*
1)navigate to the "https://www.hyrtutorials.com/p/window-handles-practice.html"
    2)Click open multiple tabs under button 4
    3)switch back to Basic Controls and validate the header(Basic Controls)
    4)Fill all the boxes and click register
    5)validate the message"Registration is Successful";
    6)Go back to Alert tabs and click the one of the click me box
    7)Close all the tabs

     */
    @Test
    public void practiceMultipleWindowHandling(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement newtabbutton= driver.findElement(By.id("newTabsBtn"));
        newtabbutton.click();
        BrowserUtils.switchByTitle(driver,  "Basic Controls - H Y R Tutorials");
       WebElement header= driver.findElement(By.xpath("//h1[@class=\"post-title entry-title\"]"));
       String actualheadertext= header.getText();
       String expected= "Basic Controls";
        Assert.assertEquals(actualheadertext, expected);
        WebElement firstname= driver.findElement(By.id("firstName"));
        firstname.sendKeys("John");
        WebElement lastname= driver.findElement(By.id("lastName"));
        lastname.sendKeys("Smith");
        WebElement gender= driver.findElement(By.id("malerb"));
       gender.click();
        WebElement languageeng= driver.findElement(By.id("englishchbx"));
        languageeng.click();
        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("example1@gmail.com");
        WebElement password= driver.findElement(By.id("password"));
        email.sendKeys("123456");
        WebElement registerbutton= driver.findElement(By.id("registerbtn"));
        registerbutton.click();
        WebElement message= driver.findElement(By.id("msg"));
        String actualmessagetext= message.getText();
        String expectedtextmessage= "Registration is Successful";
        Assert.assertEquals(actualmessagetext,expectedtextmessage);
BrowserUtils.switchByTitle(driver, "AlertsDemo - H Y R Tutorials");

        WebElement clickme= driver.findElement(By.id("alertBox"));
        clickme.click();
driver.quit();


    }

}
