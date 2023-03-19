package UIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public AndroidDriver driver;
    public  AppiumDriverLocalService service;
    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        // first create a class for the Android Driver or IOSDriver
        File serverPath = new File("/Users/HP/AppData/Roaming/npm/node_modules/appium/build/lib/main.js");
        service = new AppiumServiceBuilder().withAppiumJS(serverPath).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start(); //Start appium server
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Toyinemulator");
        options.setApp("/Users/HP/Documents/Java_with_Rahul/UIAutomator/src/test/java/resources/resources/ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @AfterClass
    public void Teardown() {
        driver.quit();
        service.stop();
    }
}
