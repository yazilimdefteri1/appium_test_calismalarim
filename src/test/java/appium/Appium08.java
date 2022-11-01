package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class Appium08 extends AppiumBase {


    @Test
    public void test() throws InterruptedException {

        AndroidDriver driver=androidDriver();

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        Thread.sleep(2000);
        List list=driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)");

        if (list.size()>0){
            String isEnable=driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)").getAttribute("enabled");
            if (isEnable.equals("false")){
                driver.findElementById("android:id/checkbox").click();
            }
        }

        Thread.sleep(4000);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        Thread.sleep(2000);
        driver.findElementById("android:id/edit").sendKeys("test");
        Thread.sleep(2000);
        driver.findElementById("android:id/button1").click();




    }


}
