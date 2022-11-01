package appium;

import com.github.javafaker.Faker;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppiumA101 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        desiredCapabilities.setCapability("autoAcceptAlert",true);
        //desiredCapabilities.setCapability(MobileCapabilityType.APP,"E:\\Yazılım projeleri\\intelji IDE\\projelerim\\appiumkurulum\\Apps\\org.studionord.a101_128_7488874.apk");
        desiredCapabilities.setCapability("appPackage","org.studionord.a101");
        desiredCapabilities.setCapability("appActivity","org.studionord.a101.MainActivity");
        AndroidDriver<MobileElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        MobileElement acilirMenu= driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView");
         acilirMenu.click();
        MobileElement giyimButton=driver.findElementByXPath("//android.widget.TextView[@text='GİYİM & AKSESUAR']");
         giyimButton.click();
        MobileElement kadinIcgiyimButton=driver.findElementByXPath("//android.widget.TextView[@text='Kadın İç Giyim']");
       kadinIcgiyimButton.click();
        MobileElement dizAltiCorap=driver.findElementByXPath("//android.widget.TextView[@text='Dizaltı Çorap']");
       dizAltiCorap.click();

        MobileElement filtre=driver.findElementByXPath("//android.widget.TextView[@text='Filtrele']");
       filtre.click();



       Thread.sleep(4000);
       List<MobileElement> filtreRenkler=driver.findElementsByXPath("//android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.TextView");

        for (int i = 0; i < filtreRenkler.size() ; i++) {
            Thread.sleep(3000);
            if (filtreRenkler.get(i).getText().contains("SİYAH")){

                System.out.println(filtreRenkler.get(i).getText());
                filtreRenkler.get(i).click();
                break;
            }

        }



       // MobileElement siyahCorapYazisi=driver.findElementByXPath("//android.widget.TextView[@text='Penti Kadın 50 Denye Pantolon Çorabı Siyah']");

        Thread.sleep(2000);
       /* try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        } catch (InvalidSelectorException e) {
            // ignore
            e.printStackTrace();
        }
*/
        List<MobileElement> siyahCorapYazisi=driver.findElementsByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]");

       // System.out.println(siyahCorapYazisi.getText());
       // Assert.assertTrue(siyahCorapYazisi.getText().contains("Siyah"));


        for (int i = 0; i <siyahCorapYazisi.size() ; i++) {
            Thread.sleep(3000);
            System.out.println(siyahCorapYazisi.get(i).getText());
            Assert.assertTrue(siyahCorapYazisi.get(i).getText().contains("Siyah"));

        }



        Thread.sleep(3000);
      /*  try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        } catch (InvalidSelectorException e) {
            // ignore
            e.printStackTrace();
        }*/
       // MobileElement sepet1=driver.findElementByXPath("(//android.widget.TextView[@text='SEPETE EKLE'])[1]");
        List<MobileElement> sepetler=driver.findElementsByXPath("//android.widget.TextView[@text='SEPETE EKLE']");
        for (int i = 0; i <sepetler.size() ; i++) {
            Thread.sleep(3000);
            if (sepetler.get(i).isEnabled()){
                sepetler.get(i).click();
                break;
            }

        }
       // sepet1.click();
        Thread.sleep(3000);
        //MobileElement sepet2=driver.findElementByXPath("//android.widget.TextView[@text='SEPETE EKLE']");
        MobileElement sepet2=driver.findElementByXPath("(//android.view.ViewGroup[2])[5]");
         sepet2.click();
        /*JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sepet2);*/
        Thread.sleep(2000);

        MobileElement sepetGit=driver.findElementByXPath("//android.widget.TextView[@text='SEPETE GİT']");
        sepetGit.click();

        Thread.sleep(8000);
        //MobileElement sepetOnayla=driver.findElementByXPath("(//android.view.ViewGroup)[36]");
        MobileElement sepetOnayla=driver.findElementByXPath("(//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2])[2]");
        sepetOnayla.click();

        Thread.sleep(2000);
        MobileElement uyeOlmadan=driver.findElementByXPath("//android.widget.TextView[@text='ÜYE OLMADAN DEVAM ET']");
        uyeOlmadan.click();

        Thread.sleep(2000);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        MobileElement emailButton=driver.findElementByXPath("//android.widget.EditText");
        emailButton.sendKeys(email);

        MobileElement kisiselButon=driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
        kisiselButon.click();


        Thread.sleep(2000);
        MobileElement gonderButton=driver.findElementByXPath("//android.widget.TextView[@text='GÖNDER']");
        gonderButton.click();

        Thread.sleep(2000);
        MobileElement yeniAdres=driver.findElementByXPath("(//android.widget.ListView/android.view.View)[5]");
        yeniAdres.click();
        Thread.sleep(2000);
        MobileElement adresAdi=driver.findElementByXPath("(//android.widget.EditText)[1]");
        adresAdi.sendKeys("evim");

        Thread.sleep(2000);
        MobileElement Adi=driver.findElementByXPath("(//android.widget.EditText)[2]");
        Adi.sendKeys("kadir");

        Thread.sleep(2000);
        MobileElement soyAdi=driver.findElementByXPath("(//android.widget.EditText)[3]");
        soyAdi.sendKeys("tepecik");

        Thread.sleep(2000);
        MobileElement telefon=driver.findElementByXPath("(//android.widget.EditText)[4]");
        telefon.sendKeys("5443314959");

        Thread.sleep(2000);
        MobileElement il=driver.findElementByXPath("(//android.widget.Spinner)[1]");
        il.click();
        Thread.sleep(2000);
        MobileElement ilsecme=driver.findElementByXPath("//android.widget.CheckedTextView[@text='İSTANBUL']");
        ilsecme.click();

        Thread.sleep(2000);
        MobileElement ilce=driver.findElementByXPath("(//android.widget.Spinner)[2]");
        ilce.click();
        Thread.sleep(2000);
        MobileElement ilcesecme=driver.findElementByXPath("//android.widget.CheckedTextView[@text='ARNAVUTKÖY']");
        ilcesecme.click();
        Thread.sleep(2000);
        MobileElement mahalle=driver.findElementByXPath("(//android.widget.Spinner)[3]");
        mahalle.click();
        Thread.sleep(2000);
        MobileElement mahallesecme=driver.findElementByXPath("//android.widget.CheckedTextView[@text='ARNAVUTKÖY MERKEZ MAH']");

        mahallesecme.click();


        Thread.sleep(2000);
        MobileElement adres=driver.findElementByXPath("(//android.widget.EditText)[5]");
        adres.sendKeys(faker.address().streetAddress());
        Thread.sleep(2000);

       /* TouchActions action = new TouchActions(driver);
        action.scroll(adres, 10, 100);
        action.perform();
*/
     //WebElement kaydet1 = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)) .scrollIntoView(new UiSelector().textContains(\"(//android.widget.Button)[2]\").instance(0))");
     // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))");
     //kaydet1.click();
        //WebElement kaydet=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"(//android.widget.Button)[2]\"))");
        try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        } catch (InvalidSelectorException e) {
            // ignore
        }
     MobileElement kaydet1=driver.findElementByXPath("(//android.widget.Button)[2]");
        kaydet1.click();

        Thread.sleep(3000);
        List<MobileElement> kargo=driver.findElementsByXPath("//android.widget.RadioButton");
        for (int i = 1; i <kargo.size() ; i++) {
            if (kargo.get(i).isDisplayed()){
                kargo.get(i).click();
            }

        }


        Thread.sleep(2000);
        MobileElement kaydetDevamEt=driver.findElementByXPath("//android.widget.Button");
        kaydetDevamEt.click();

        /*
        Thread.sleep(2000);
        MobileElement garantiPay=driver.findElementByXPath("//android.view.View[@text='Garanti Pay']");
        garantiPay.click();

        Thread.sleep(2000);
        MobileElement onBilgilendirme=driver.findElementByXPath("//android.view.View[@text='']");
        onBilgilendirme.click();
        Thread.sleep(2000);
        MobileElement garantiPayOde=driver.findElementByXPath("//android.view.View[@text='Garanti Pay ile Öde']");
        garantiPayOde.click();*/

        Thread.sleep(2000);
        //lutfen  kart bilgilerini girip test ediniz
        String adSoyad="";
        String kartno="";
        String sonAy="";
        String sonYil="";
        String CVC="";
        MobileElement adSoyadi=driver.findElementByXPath("(//android.widget.EditText)[1]");
        adSoyadi.sendKeys(adSoyad);




        Thread.sleep(2000);
        MobileElement kartNumara=driver.findElementByXPath("(//android.widget.EditText)[2]");
      //  new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.EditText)[2]"))).sendKeys(kartno);
        //kartNumara.click();
        String[] sayi=kartno.split("");
       /* JavascriptExecutor js = (JavascriptExecutor) driver;
       WebDriverWait wait=new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.EditText)[2]")));*/
        kartNumara.click();

       // driver.getKeyboard().sendKeys(Keys.NUMPAD5);
        TouchAction touchAction = new TouchAction<>(driver);

       // touchAction.tap(PointOption.point(570,2750)).perform();


       /* String[]sayi=kartno.split("");
        for (int i = 0; i <sayi.length ; i++) {
            kartNumara.sendKeys(sayi[i],Keys.SPACE);

        }
        kartNumara.sendKeys(kartno);*/
        Thread.sleep(4000);

        for (int i = 0; i <kartno.length() ; i++) {
            Thread.sleep(2000);
            switch (kartno.charAt(i)){
                case '0':
                    Thread.sleep(2000);
                    touchAction.tap(PointOption.point(570,2750)).perform();
                    break;
                case '1':
                    Thread.sleep(2000);
                    touchAction.tap(PointOption.point(220,2075)).perform();
                    break;
                case '2':
                    Thread.sleep(2000);
                    touchAction.tap(PointOption.point(580,2075)).perform();
                    break;
                case '3':
                    Thread.sleep(2000);
                    touchAction.tap(PointOption.point(975,2075)).perform();
                    break;
                case '4':
                    Thread.sleep(2000);
                    touchAction.tap(PointOption.point(220,2300)).perform();
                    break;
                case '5':
                    Thread.sleep(2000);
                    touchAction.tap(PointOption.point(580,2300)).perform();
                    break;
                case '6':
                    Thread.sleep(2000);
                    touchAction.tap(PointOption.point(975,2300)).perform();
                    break;
                case '7':
                    Thread.sleep(2000);
                    touchAction.tap(PointOption.point(220,2530)).perform();
                    break;
                case '8':
                    Thread.sleep(2000);
                    touchAction.tap(PointOption.point(580,2530)).perform();
                    break;
                case '9':
                    Thread.sleep(2000);
                    touchAction.tap(PointOption.point(975,2530)).perform();
                    break;



            }

        }

        touchAction.press(PointOption.point(940,1500)).perform();



        Thread.sleep(4000);
        MobileElement sonaySec=driver.findElementByXPath("(//android.widget.Spinner)[1]");
        sonaySec.click();
        Thread.sleep(2000);
        MobileElement sonAyEkle=driver.findElementByXPath("//android.widget.CheckedTextView[@text='"+sonAy+"']");
        sonAyEkle.click();


        Thread.sleep(2000);
        MobileElement sonYilSec=driver.findElementByXPath("(//android.widget.Spinner)[2]");
        sonYilSec.click();
        Thread.sleep(2000);
        MobileElement sonYilEkle=driver.findElementByXPath("//android.widget.CheckedTextView[@text='"+sonYil+"']");
        sonYilEkle.click();
        Thread.sleep(2000);
        MobileElement cvc=driver.findElementByXPath("(//android.widget.EditText)[3]");
        cvc.sendKeys(CVC);

        Thread.sleep(2000);
     //MobileElement onbilgi=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"//android.view.View[@text='']\"))");
     //WebElement onBilgilendirme = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)) .scrollIntoView(new UiSelector().textContains(\"//android.view.View[@text='']\").instance(0))");
    // onBilgilendirme.click();
        try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        } catch (InvalidSelectorException e) {
            // ignore
        }
        MobileElement onBilgilendirme=driver.findElementByXPath("//android.view.View[@text='']");
        onBilgilendirme.click();

     Thread.sleep(2000);
     MobileElement siparisTamamla=driver.findElementByXPath("//android.widget.Button[@text='Siparişi Tamamla']");
     siparisTamamla.click();

        //Thread.sleep(2000);
        //MobileElement siparisTamamla2=driver.findElementByXPath("//android.widget.Button[@text='İşleniyor.. spinner']");
        //siparisTamamla.click();

        Thread.sleep(2000);
        MobileElement dogrulamaKoduBaslık=driver.findElementByXPath("//android.view.View[@text='Doğrulama kodunu giriniz']");
        Assert.assertTrue(dogrulamaKoduBaslık.isDisplayed());

        Thread.sleep(2000);
        MobileElement iptalEt=driver.findElementByXPath("//android.view.View[@text='İşlemi İptal Et']");
        iptalEt.click();

        Thread.sleep(2000);
        MobileElement iptalEt2=driver.findElementByXPath("(//android.view.View[@text='İşlemi İptal Et'])[2]");
        iptalEt2.click();


















    }
}
