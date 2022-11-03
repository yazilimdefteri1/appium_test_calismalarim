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

public class Appium05_Chrome_03_Context_NativeApp {

    @Test


    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");

        //desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        //https://chromedriver.storage.googleapis.com/index.html   bu linkten tüm driverlara ulaşabilirim
        //desiredCapabilities.setCapability("chromedriverExecutable", "C:\\Users\\mt\\IdeaProjects\\appium_test_calismasi\\driver\\chromedriver.exe");

        desiredCapabilities.setCapability("appPackage","com.android.chrome");
        desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(2000);


        driver.get("https://www.amazon.com");

        //  Contetxt için link-->    https://appium.io/docs/en/commands/context/get-contexts/
        String contrext = driver.getContext();
        System.out.println("1 " + contrext);
        Set contextList = driver.getContextHandles();

        for (Object contextName : contextList) {
            System.out.println(contextName.toString());
           // Thread.sleep(3000);
           /* if (contextName.toString().contains("NATIVE_APP")){
                //alttaki kodda hangi app turunde çalışacak onu set ediyoruz
                driver.context((String) contextName); // WEB APP DEVAM EDECEĞİZ
                Thread.sleep(1000);
            }
             */
        }
        System.out.println("2 " + driver.getContext());

        // remote device on chrome   linkine git ve tel ile bilgisayardaki chrome bağla
        Thread.sleep(3000);
        AndroidElement signin = driver.findElementByXPath("//android.view.View[@text='Sign in ›']");
        signin.click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElementByXPath("//android.view.View[@text='Welcome']").isDisplayed());
        System.out.println("3 " + driver.getContext());

        driver.quit();

    }
}
