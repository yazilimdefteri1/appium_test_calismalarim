package appium_K;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01_01 {

    @Test

    public void test() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        // setCapability methodu farklı şekillerde yazılmaktadır
       // desiredCapabilities.setCapability("automationName","UiAutomator2");
       //  desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");

       //Mobile Element yazdığımızda tüm cihazlarda kullanmak için yazılmaktadır.
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);


        //http:///localhost:4723/wd/hub
        if ( driver.isDeviceLocked()) {
            driver.unlockDevice();
        }
        /*
        Eger tetelefon kullnamak istiyorsak develooper options aktif hale getirilmeli
        ve USB Debugging açık olmalı ve usb kablosuyla telefonumuz bağlayarak test yapabiliriz.
         */
    }

}
