package UIAutomator;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class AppiumBasics extends BaseTest {

    @Test
    public void WifiSettingName() throws MalformedURLException {
        // Actual automation
        // Types of locator: Xpath, accessibilityId, id, className. AndroidUIAutomator
        //xpath is //tagName[@attr="value"]
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Wale Wifi");
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }
}
