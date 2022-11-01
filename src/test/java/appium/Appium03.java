package appium;

import com.sun.org.apache.xpath.internal.operations.And;
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

public class Appium03 {


    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"192.168.109.101:5555");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
       desiredCapabilities.setCapability("chromedriverExecutable","E:\\Yazılım projeleri\\intelji IDE\\projelerim\\appiumkurulum\\driver\\chromedriver.exe");
      // desiredCapabilities.setCapability("appPackage","com.android.chrome");
       //desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        Thread.sleep(2000);
        driver.get("https://www.amazon.com");

        String contrext=driver.getContext();
        System.out.println("1 "+contrext);
        Set contextList=driver.getContextHandles();

        for (Object context:contextList) {
            System.out.println(context.toString());
            Thread.sleep(2000);
            if (context.toString().contains("CHROMIUM")){
                driver.context((String) context);
                Thread.sleep(10000);

            }

        }
        System.out.println("2 "+driver.getContext());

        // remote device on chrome   linkine git ve tel ile bilgisayardaki chrome bağla
        Thread.sleep(3000);
        AndroidElement sigin=driver.findElement(By.xpath("//a[@class='nav-a nav-show-sign-in']"));
        sigin.click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementByXPath("//h2").isDisplayed());
        System.out.println("3 "+driver.getContext());

        driver.quit();



    }
}
