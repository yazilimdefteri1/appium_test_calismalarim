package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AppiumA101UiNative_app {

    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        //desiredCapabilities.setCapability("chromedriverExecutable","E:\\Yazılım projeleri\\intelji IDE\\projelerim\\appiumkurulum\\driver\\chromedriver.exe");
        desiredCapabilities.setCapability("appPackage","com.android.chrome");
        desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        //com.android.chrome/com.google.android.apps.chrome.Main
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.navigate().to("https://www.A101.com.tr");



        String contrext=driver.getContext();
        System.out.println("1 "+contrext);
       /* Set<String> windows=driver.getWindowHandles();
        for (String window:windows) {
            System.out.println(window);

        }*/
        Set contextList=driver.getContextHandles();

        for (Object context:contextList) {
            Thread.sleep(2000);
            System.out.println(context.toString());


        }
        System.out.println("2 "+driver.getContext());
        Thread.sleep(5000);
       //AndroidElement menu= driver.findElement(By.xpath("(//android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View)[1]"));
       AndroidElement menu= driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Menü')]"));
       menu.click();
        Thread.sleep(8000);
       // AndroidElement giyim=driver.findElement(By.xpath("(//android.widget.ListView/android.view.View[4])[1]"));
        AndroidElement giyim=driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'AKSESUAR')]"));
        giyim.click();
        Thread.sleep(5000);
        //AndroidElement kadinIc=driver.findElementByXPath("(//android.widget.ListView/android.view.View)[2]");
        AndroidElement kadinIc=driver.findElementByXPath("//android.view.View[contains(@content-desc,'Kadın İç')]");
        kadinIc.click();
        Thread.sleep(5000);
        //AndroidElement dizAlti=driver.findElementByXPath("(//android.widget.ListView/android.view.View)[9]");
        AndroidElement dizAlti=driver.findElementByXPath("//android.view.View[contains(@content-desc,'Dizaltı')]");
        dizAlti.click();
        Thread.sleep(5000);
        AndroidElement filtrele=driver.findElementByXPath("//android.view.View[@content-desc='Filtrele']");
        filtrele.click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        List<AndroidElement> renkSecimi=driver.findElementsByXPath("//android.widget.ListView[2]/android.view.View");
        for (int i = 0; i <renkSecimi.size() ; i++) {
            Thread.sleep(2000);
            js.executeScript("arguments[0].scrollIntoView(true);",renkSecimi.get(i));
            if (renkSecimi.get(i).getText().contains("SİYAH")){
                renkSecimi.get(i).click();
                break;
            }

        }
    }
}
