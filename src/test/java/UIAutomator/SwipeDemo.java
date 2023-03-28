package UIAutomator;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends BaseTest {
    @Test
    public void SwipeGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement el = driver.findElement(By.xpath("//android.widget.ImageView[@index='0']"));
        Assert.assertEquals(el.getAttribute("focusable"), "true");
        //Swipe
        SwipeAction(el, "left");
        Assert.assertEquals(el.getAttribute("focusable"), "false");
    }
}
