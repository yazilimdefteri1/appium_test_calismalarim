package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium06UiSelector {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\mt\\IdeaProjects\\appium_test_first-master\\Apps\\gestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        Thread.sleep(5000);
        //uiselectorda '  kullanılamaz   " kullanılmak gerekir
        // resourceId () ile

        //driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();

        // className
      //  driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")").click();
        //classname() text ile
       // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Add gesture\")").click();
        //className() index() ile
        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(1)").click();
        // className()

        List<MobileElement> buttons=driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")");
        for (MobileElement button:buttons
             ) {
            if (button.getText().equals("test")){
                button.click();
                break;
            }
        }


        //driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").textContains(\"load\")").click();
       // driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").textStartsWith(\"Te\")").click();


        //
        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").checkable(false)");
        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").clickable(true)");

    }
}
