package AppiumProject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class MyFirstTest {

    public static void main(String[] args) throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "");
        capabilities.setCapability("deviceName", "emulator-5554");
//        capabilities.setCapability("app", "C:/Users\\Billie Pratama\\Downloads\\Android_Demo_App.apk");
        capabilities.setCapability("appPackage", "com.code2lead.kwad");
        capabilities.setCapability("appActivity", "com.code2lead.kwad.MainActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.findElement(By.id("com.code2lead.kwad:id/EnterValue")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.id("com.code2lead.kwad:id/Btn1")).getText());
    }
}
