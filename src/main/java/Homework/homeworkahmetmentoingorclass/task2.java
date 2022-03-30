package Homework.homeworkahmetmentoingorclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task2 {
    public static void main(String[] args) throws InterruptedException {
        /*
         TASK 2:Creating an account for nopcommerce and validation
1-NAVIGATE TO THE WEBSITE https://demo.nopcommerce.com/
2-Click Register
3-Fill the information
4-Newsletter box should be left unclicked
5-Click Register
6-Validate “Your registration completed”
7-Click Continue (edited)
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(3000);
        WebElement register= driver.findElement(By.xpath("//a[@href=\"/register?returnUrl=%2F\"]"));
        register.click();
        WebElement gender= driver.findElement(By.xpath("//input[@id=\"gender-male\"]"));
        gender.click();
WebElement firstname= driver.findElement(By.xpath("//input[@data-val-required=\"First name is required.\"]"));
firstname.sendKeys("John");
        WebElement lasttname= driver.findElement(By.xpath("//input[@data-val-required=\"Last name is required.\"]"));
        lasttname.sendKeys("Smith");
WebElement day= driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"));
day.sendKeys("5");
        WebElement month= driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"));
        month.sendKeys("May");
        WebElement year= driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"));
        year.sendKeys("2000");

        WebElement email= driver.findElement(By.xpath("//input[@data-val-required=\"Email is required.\"]"));
        email.sendKeys("example5@gmail.com");
       WebElement newsletter= driver.findElement(By.xpath("//input[@data-val-required=\"The Newsletter field is required.\"]"));
      if(newsletter.getAttribute("value").equals("true")){
          newsletter.click();
        }
        WebElement passwd= driver.findElement(By.xpath("//input[@type=\"password\" and @name=\"Password\"]"));
        passwd.sendKeys("somepasswd1");
        WebElement passwdcheck= driver.findElement(By.xpath("//input[@type=\"password\" and @name=\"ConfirmPassword\"]"));
        passwdcheck.sendKeys("somepasswd1");
        WebElement register1= driver.findElement(By.id("register-button"));
        register1.click();
        WebElement regcomplet= driver.findElement(By.xpath("//div[@class=\"result\"]"));
        String expected="Your registration completed";
        if(regcomplet.getText().equals(expected)){
            System.out.println("properly completed registration --> "+regcomplet.getText());
        }
WebElement continuebutton= driver.findElement(By.xpath("//a[@href=\"/\" and @class=\"button-1 register-continue-button\"]"));
continuebutton.click();
    }
}
