package appium_K;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03_03 {

    @Test


    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");

        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\mt\\IdeaProjects\\appium_test_first-master\\Apps\\gestureTool.apk");
        //desiredCapabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        //desiredCapabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        // noReset true olursa app i yeniden yüklemez  false der isek app i yeniden yükler

        //AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(4000);

        /*  Test Case
        Launch gestureTool app
        click testButton
        verify title "Test a gesture"
        close app
         */
        // id ile bulduk
        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        Thread.sleep(2000);
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("ayhan");
        Thread.sleep(2000);
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(2000);
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        Thread.sleep(2000);

        String expectedText="ayhan";
        String actualText= driver.findElementByXPath("//android.widget.TextView[@text=\"ayhan\"][1]").getText();

       Assert.assertEquals(actualText,expectedText);



        if ( driver.isDeviceLocked()) {
            driver.unlockDevice();
        }
          }
}
