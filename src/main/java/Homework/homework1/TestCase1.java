package Homework.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameBox = driver.findElement(By.xpath("//input[@id='userName']"));
        fullNameBox.sendKeys("Ahmet Baldir");

        WebElement emailbox = driver.findElement(By.xpath("//input[@type='email']"));
        emailbox.sendKeys("ahmet@gmail.com");

        WebElement currentadress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentadress.sendKeys("50123 midway ");

        WebElement permanentadress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentadress.sendKeys("50123 midway permanent ");

        //   WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        //  button.click();         //it didn't work because of the advertisement was blocking the submit
//button.(check the sublime)

        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();

        WebElement nameValidation = driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(nameValidation.getText());
        String expectedValidation = "Name:Ahmet Baldir";
        String actualValidation = nameValidation.getText();
        if (expectedValidation.equals(actualValidation)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
        WebElement emailvalidation= driver.findElement(By.xpath("//p[@id='email']"));
        String expectedemailvadition="Email:ahmet@gmail.com";
        String actualemailval=emailvalidation.getText();
        if(expectedemailvadition.equals(actualemailval)){
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
        WebElement currentadrvalidation= driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String expectedadrvadition="Current Address :50123 midway";
        String actualadrval=currentadrvalidation.getText();
        if(expectedadrvadition.equals(actualadrval)){
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
        WebElement permanentadrvalidation= driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String expectedpermanentvadition="Permananet Address :50123 midway permanent";
        String actualpermanentval=permanentadrvalidation.getText();
        if(expectedpermanentvadition.equals(actualpermanentval)){
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }



    }
}
