package Seleniumintro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {

        //go to yahoo. news. find heares with covid word
        WebDriver driver= new ChromeDriver();
       driver.get("https://www.yahoo.com/");
WebElement news= driver.findElement(By.xpath("//a[@class=\"_yb_hu5ch  rapid-noclick-resp\" and @id=\"root_2\"]"));
   news.click();
        List<WebElement> headers= driver.findElements(By.xpath("//h3")); //tagname("h3")
        int counter=0;
        for (int i=0; i<headers.size();i++){
            headers.get(i).getText();
         //   System.out.println(headers.get(i).getText());
            if(headers.get(i).getText().toUpperCase().contains("COVID")){
                System.out.println(headers.get(i).getText());
                counter++;
            }
        }
        System.out.println(counter);
    }
}
