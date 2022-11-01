package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium02 {


    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidEmulotar");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        //desiredCapabilities.setCapability(MobileCapabilityType.APP,"E:\\Yazılım projeleri\\intelji IDE\\projelerim\\appiumkurulum\\Apps\\gestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        desiredCapabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        desiredCapabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");

        AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(3000);


        driver.findElement(By.xpath("(//android.widget.Button)[1]")).click();
        //driver.findElementByXPath("//div[@class='_highlighter-box_619e8 _inspected-element-box_619e8']").click();
        Thread.sleep(3000);
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("test");
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(3000);
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        Thread.sleep(3000);
        AndroidElement anasayfa=driver.findElementById("android:id/empty");

        Assert.assertFalse(anasayfa.getText().isEmpty());
        String expectedData="No gestures";
        String actualData=anasayfa.getText();
        Assert.assertEquals(actualData,expectedData);









    }
}
