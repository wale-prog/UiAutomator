package UIAutomator;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;


public class ScrollDemo extends BaseTest {
    @Test
    public void ScrollGesture () throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        // Use this if there is a particular element you want to scroll to
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
//        ScrollToEndAction();
        // Use this to scroll when there is not defined spot on the page to scroll to
        Thread.sleep(2000);
    }
}
