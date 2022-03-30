package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("file:///C:/Users/diamo/Downloads/Techtorial%20(2).html");
        //LOCATOR: ID
//getText()--> it gives you the text of the element.
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualText=header.getText();//from the system
        String expectedText="Techtorial Academy"; //from the business requirement
        if(actualText.equals(expectedText)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());
        //LOCATOR: ClassName

        WebElement tools= driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());
        //LOCATOR: Name
        WebElement firstname= driver.findElement(By.name("firstName"));
        firstname.sendKeys("Almaz");
        WebElement lastname= driver.findElement(By.name("lastName"));
        lastname.sendKeys("Tolonov");
        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("1234567890");
        WebElement email= driver.findElement(By.name("userName"));
        email.sendKeys("1234@gmail.com");


        WebElement javabox= driver.findElement(By.id("cond1"));
        javabox.click();
        System.out.println(javabox.isDisplayed()); //return true
        System.out.println(javabox.isSelected());//return true

        WebElement testng= driver.findElement(By.id("cond3"));
        testng.click();
        System.out.println(testng.isDisplayed()); //return true
        System.out.println(testng.isSelected());//return true

        WebElement cucumber= driver.findElement(By.id("cond4"));
       cucumber.click();
        System.out.println(cucumber.isDisplayed()); //return true
        System.out.println(cucumber.isSelected());//return true





    }
}
