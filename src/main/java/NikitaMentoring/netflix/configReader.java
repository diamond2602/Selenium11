package NikitaMentoring.netflix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader  {

    public static String returnKey (String key) {


        File file = new File("C:\\Users\\diamo\\Desktop\\SeleniumB11\\src\\main\\java\\NikitaMentoring\\netflix\\Data.properties");

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);

    }
}