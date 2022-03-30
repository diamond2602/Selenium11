package Homework.homeworkahmetmentoingorclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1 {
    public static void main(String[] args) throws InterruptedException {
        /*TASK: CREATING AN ACCOUNT FOR AMAZON:
1-NAVIGATE TO THE WEBSITE https://www.amazon.com/
2_Click Hello, Sign in Button
3-Click Create your amazon account button
4-Fill the information and click Continue Button
5-If there is an error or message. Validate it, if not then you completed the task

*/
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebElement signin= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        signin.click();
Thread.sleep(3000);
WebElement create= driver.findElement(By.id("createAccountSubmit"));
create.click();
WebElement name= driver.findElement(By.xpath("//input[@id='ap_customer_name' and @name='customerName']"));
name.sendKeys("Almaz Tol");
WebElement emailpn= driver.findElement(By.xpath("//input[@id=\"ap_email\" and @name=\"email\"]"));
emailpn.sendKeys("example1@gmail.com");
WebElement passwd= driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"ap_password\"]"));
passwd.sendKeys("Aamazonpasswd1");

        WebElement passwdcheck= driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"ap_password_check\"]"));
        passwdcheck.sendKeys("Aamazonpasswd1");
        WebElement verifyemnail= driver.findElement(By.xpath("//input[@id=\"continue\" and @type=\"submit\"]"));
        verifyemnail.click();


    }
}
