package appium_K;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;

public class Appium04_01 {
    @Test


    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");

        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\mt\\IdeaProjects\\appium_test_calismasi\\Apps\\Calculator.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);


        Thread.sleep(4000);

         /*
        install app
        do any mathematical operation  15*3
        and  "45" verify are result and final result
         */
        AndroidElement num0=driver.findElementById("com.google.android.calculator:id/digit_0");
        AndroidElement num1=driver.findElementById("com.google.android.calculator:id/digit_1");
        AndroidElement num2=driver.findElementById("com.google.android.calculator:id/digit_2");
        AndroidElement num3=driver.findElementById("com.google.android.calculator:id/digit_3");
        AndroidElement num4=driver.findElementById("com.google.android.calculator:id/digit_4");
        AndroidElement num5=driver.findElementById("com.google.android.calculator:id/digit_5");
        AndroidElement num6=driver.findElementById("com.google.android.calculator:id/digit_6");
        AndroidElement num7=driver.findElementById("com.google.android.calculator:id/digit_7");
        AndroidElement num8=driver.findElementById("com.google.android.calculator:id/digit_8");
        AndroidElement num9=driver.findElementById("com.google.android.calculator:id/digit_9");

        AndroidElement carpma=driver.findElementById("com.google.android.calculator:id/op_mul");
        AndroidElement esittir=driver.findElementById("com.google.android.calculator:id/eq");

        num1.click();
        num5.click();
        carpma.click();
        num3.click();

        String expectedSonuc="45";

        String actualSonuc1= driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        Assert.assertEquals(actualSonuc1,expectedSonuc);

        esittir.click();

        String actualSonuc2= driver.findElementById("com.google.android.calculator:id/result_final").getText();
        Assert.assertEquals(actualSonuc2,expectedSonuc);

        if ( driver.isDeviceLocked()) {
            driver.unlockDevice();
        }

    }
}
