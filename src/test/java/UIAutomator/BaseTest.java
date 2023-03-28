package UIAutomator;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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
        options.setDeviceName("samsung SM-A325F");
        options.setPlatformVersion("13.0");
        options.setUdid("emulator-5554");
        options.setApp("/Users/HP/Documents/Java_with_Rahul/UIAutomator/src/test/java/resources/resources/ApiDemos-debug.apk");
        options.autoGrantPermissions();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void longPressAction(WebElement el, int duration) {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)el).getId(),
                        "duration", duration));
    }

    public void scrollAction(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"WebView\"));"));
    }

    public void ScrollToEndAction() {
        boolean canScrollMore;
        do{
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while(canScrollMore == true);
    }

    public void SwipeAction(WebElement el, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)el).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    @AfterClass
    public void Teardown() {
        driver.quit();
        service.stop();
    }
}
