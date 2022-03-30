package Homework.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testase2 {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        WebElement radioButton = driver.findElement(By.id("yesRadio"));

        //WebElement yes= driver.findElement(By.className("custom-control-label"));  this also works
        //  radioButton.click();
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",radioButton);

        WebElement yesvalidation= driver.findElement(By.xpath("//p[@class=\"mt-3\"]"));
        String expectedyes="You have selected Yes";
        String actualyes=yesvalidation.getText();
        System.out.println(actualyes);
        if(expectedyes.equals(actualyes)){
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
        WebElement radioButton2 = driver.findElement(By.id("impressiveRadio"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",radioButton2);
        WebElement impressivevalidation= driver.findElement(By.xpath("//p[@class=\"mt-3\"]"));
        String expectedimpressive="You have selected Impressive";
        String actualimpressive=yesvalidation.getText();
        System.out.println(actualyes);
        if(expectedimpressive.equals(actualimpressive)){
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

    }


}
