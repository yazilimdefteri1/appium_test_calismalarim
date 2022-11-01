package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumBase {

    public static AndroidDriver   androidDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"E:\\Yazılım projeleri\\intelji IDE\\projelerim\\appiumkurulum\\Apps\\API Demos for Android_v1.9.0_apkpure.com.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<AndroidElement> driver = null;
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return driver;
    }




}
