package UIAutomator;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class AppiumBasics extends BaseTest {

    @Test
    public void WifiSettingName() throws MalformedURLException {
        // Actual automation
        // Types of locator: Xpath, accessibilityId, id, className. AndroidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
    }
}
