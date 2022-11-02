package appium_K;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium05_Chrome_03_Context {

    @Test


    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

        //https://chromedriver.storage.googleapis.com/index.html   bu linkten tüm driverlara ulaşabilirim
        desiredCapabilities.setCapability("chromedriverExecutable", "C:\\Users\\mt\\IdeaProjects\\appium_test_calismasi\\driver\\chromedriver.exe");

        //desiredCapabilities.setCapability("appPackage","com.android.chrome");
        //desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(2000);


        driver.get("https://www.amazon.com");


        //  Contetxt için link-->    https://appium.io/docs/en/commands/context/get-contexts/
        String contrext = driver.getContext();
        System.out.println("1 " + contrext);
        Set contextList = driver.getContextHandles();

        for (Object context : contextList) {
            System.out.println(context.toString());
        }
        System.out.println("2 " + driver.getContext());

        // remote device on chrome   linkine git ve tel ile bilgisayardaki chrome bağla
        Thread.sleep(5000);
        AndroidElement sigin = driver.findElementById("nav-progressive-greeting");
        sigin.click();
        Thread.sleep(8000);
        Assert.assertTrue(driver.findElementByXPath("//h2").isDisplayed());
        System.out.println("3 " + driver.getContext());

        driver.quit();

    }
}
