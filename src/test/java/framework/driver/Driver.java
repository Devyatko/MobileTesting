package framework.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Driver {
    private static WebDriver driver = null;

    private Driver() throws MalformedURLException {
        driver = DriverFactory.createDriver();
    }

    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null){
            new Driver();
        }
        return driver;
    }

    public static void clearSingleton(){
        driver.quit();
        driver = null;
    }
}
