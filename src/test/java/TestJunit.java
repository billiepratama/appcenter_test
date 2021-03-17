import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
public class TestJunit {
    private static EnhancedAndroidDriver<MobileElement> driver;

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "");
        capabilities.setCapability("deviceName", "emulator-5554");
//        capabilities.setCapability("app", "D:/PTBC/Android_Demo_App.apk");
        capabilities.setCapability("appPackage", "com.code2lead.kwad");
        capabilities.setCapability("appActivity", "com.code2lead.kwad.MainActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = Factory.createAndroidDriver(url, capabilities);
    }
//    @Test
//    public void testSubmitButton() throws InterruptedException {
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        System.out.println("Test submit button dimulai!!");
//        driver.findElement(By.id("com.code2lead.kwad:id/ContactUs")).click();
//        Thread.sleep(1000);
//        String element = driver.findElement(By.id("com.code2lead.kwad:id/Btn1")).getText();
//        assertEquals("SUBMIT", element);
//    }
//
    @Test
    public void EnterSomeValue() throws InterruptedException, IOException {
        System.out.println("Test Scenario : Enter some value and verify the output");
        driver.label("Home Page");
        driver.findElement(By.id("com.code2lead.kwad:id/EnterValue")).click();
        Thread.sleep(1000);
        driver.label("Enter some Value page");
        driver.findElement(By.id("com.code2lead.kwad:id/Et1")).setValue("billie pratama");
        Thread.sleep(1000);
        driver.label("Enter value : billie pratama");
        boolean button_isDisplayed = driver.findElement(By.id("com.code2lead.kwad:id/Btn1")).isDisplayed();
        assertEquals(false, button_isDisplayed);
        driver.findElement(By.id("com.code2lead.kwad:id/Btn1")).click();
        Thread.sleep(1000);
        driver.label("Display output value");
        String value = driver.findElement(By.id("com.code2lead.kwad:id/Tv1")).getText();
        assertEquals("billie pratama", value);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

//    @AfterClass
//    public void TearDown(){
//        driver.label("Stopping App");
//        driver.quit();
//    }
}