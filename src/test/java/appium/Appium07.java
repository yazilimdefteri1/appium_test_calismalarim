package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium07 {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"E:\\Yazılım projeleri\\intelji IDE\\projelerim\\appiumkurulum\\Apps\\API Demos for Android_v1.9.0_apkpure.com.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        Thread.sleep(5000);

        //driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"API Demos\")").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        Thread.sleep(2000);

        MobileElement box=driver.findElementById("android:id/checkbox");

        if (!(box.isSelected())){
            System.out.println("seçili");
        }else {
            box.click();
        }

        Thread.sleep(4000);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        Thread.sleep(2000);
        driver.findElementById("android:id/edit").sendKeys("test");
        Thread.sleep(2000);
        driver.findElementById("android:id/button1").click();

        driver.navigate().refresh();

    }

}
