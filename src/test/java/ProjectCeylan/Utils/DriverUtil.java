package ProjectCeylan.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class DriverUtil {
    private static WebDriver driver = null;

    public static WebDriver getDriver(){

        if (driver == null){

            String browser = PropertiesFileReader.getProperties("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    Assert.fail(String.valueOf("Wrong browser!"));
            }
        }
        return  driver;
    }
}
