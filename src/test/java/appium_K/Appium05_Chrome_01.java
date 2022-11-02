package appium_K;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05_Chrome_01 {

    @Test


    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

        //https://chromedriver.storage.googleapis.com/index.html   bu linkten tüm driverlara ulaşabilirim
        desiredCapabilities.setCapability("chromedriverExecutable","C:\\Users\\mt\\IdeaProjects\\appium_test_calismasi\\driver\\chromedriver.exe");

        //desiredCapabilities.setCapability("appPackage","com.android.chrome");
        //desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        Thread.sleep(2000);

        /*
        www.amazon.com  a git
        sign in butonuna bas
        welcome mesajını verify edelim
         */
        driver.get("https://www.amazon.com");

        driver.findElementById("nav-logobar-greeting").click();

        String expectedMesaj="Welcome";
        String actualMesaj=driver.findElementByXPath("//div[@id=\"outer-accordion-signin-signup-page\"]/h2").getText();

        Assert.assertEquals(actualMesaj,expectedMesaj);
    }
}
