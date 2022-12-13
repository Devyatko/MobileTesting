package framework.driver;

import framework.utils.ConfigManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static final String AUTOMATION_NAME = ConfigManager.readerStr("automationName", "configdata.json");
    private static final String REMOTE_URL = ConfigManager.readerStr("remoteURL", "configdata.json");

    public static WebDriver createDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName",AUTOMATION_NAME );
        capabilities.setCapability("platformName", ConfigManager.readerStr("platformName", "configdata.json"));
        capabilities.setCapability("platformVersion", ConfigManager.readerStr("platformVersion", "configdata.json"));
        capabilities.setCapability("deviceName", ConfigManager.readerStr("deviceName", "configdata.json"));
        capabilities.setCapability("app", ConfigManager.readerStr("app", "configdata.json"));
        switch (AUTOMATION_NAME) {
            case "XCUITest":
                return new IOSDriver(new URL(REMOTE_URL), capabilities);
            case "UiAutomator2":
                return new AndroidDriver(new URL(REMOTE_URL), capabilities);
            default:
                return null;
        }
    }
}