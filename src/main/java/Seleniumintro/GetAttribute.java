package Seleniumintro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement googlsearch= driver.findElement(By.name("btnK"));
       // System.out.println(googlsearch.getText());
        System.out.println(googlsearch.getAttribute("value"));
        System.out.println(googlsearch.getAttribute("aria-label"));
       if(googlsearch.getAttribute("value").equals("Google Search")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
