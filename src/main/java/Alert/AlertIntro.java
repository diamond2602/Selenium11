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

public class AlertIntro {
    public static String name="Techtorial";
    @Test
    public void JSAlertAcceptMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJSAlert.click();
//        WebElement header= driver.findElement(By.tagName("h3"));// UnhandledAlertException
//        System.out.println(header.getText());
        Alert alert1 = driver.switchTo().alert();
        String actualtext = alert1.getText();
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualtext, expectedText);
        alert1.accept();
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage = BrowserUtils.getTextMethod(message);
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void JSAlertDismissMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickforJSConfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        clickforJSConfirm.click();
        Alert alert2 = driver.switchTo().alert();
        String actualtext = alert2.getText();
        String expectedText = "I am a JS Confirm";
        Assert.assertEquals(actualtext, expectedText);
        alert2.dismiss();
        WebElement message2 = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        String actualMessage2 = BrowserUtils.getTextMethod(message2);
        String expectedMessage2 = "You clicked: Cancel";
        Assert.assertEquals(actualMessage2, expectedMessage2);

    }

    @Test
    public  void AlertClassSendKeys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickforJSPrompt= driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        clickforJSPrompt.click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys(name);
        alert3.accept();
        WebElement message3 = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        String actualMessage3 = BrowserUtils.getTextMethod(message3);
        String expectedMessage3 = "You entered: " +name;
        Assert.assertEquals(actualMessage3, expectedMessage3);

    }
}