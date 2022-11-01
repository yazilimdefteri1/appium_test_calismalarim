package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {

    @Test
    public  void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\mt\\IdeaProjects\\appium_test_first-master\\Apps\\Calculator.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

Thread.sleep(4000);

         driver.findElementById("com.google.android.calculator:id/digit_7").click();

         Thread.sleep(4000);
    }
}
