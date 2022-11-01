package appium;

import com.github.javafaker.Faker;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AppiumA101UITestChromium {
    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        desiredCapabilities.setCapability("chromedriverExecutable","E:\\Yazılım projeleri\\intelji IDE\\projelerim\\appiumkurulum\\driver\\chromedriver.exe");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.get("https://www.A101.com.tr");

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
      //  Thread.sleep(5000);
       // driver.switchTo().alert().accept();


        //driver.switchTo().frame(1).close();
        // remote device on chrome   linkine git ve tel ile bilgisayardaki chrome bağl
        Thread.sleep(10000);
        driver.findElementByXPath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']").click();//cerez
        Thread.sleep(5000);
        driver.findElementByXPath("//a[@class='menu-toggle js-navigation-toggle visible-xs']").click();//menü11
        Thread.sleep(2000);
        driver.findElementByXPath("//a[@title='GİYİM & AKSESUAR']").click();//giyim ve aksesuar
        Thread.sleep(2000);
        driver.findElementByXPath("(//ul[@class='sub-navigation js-sub-navigation shown']//a)[3]").click();//kadın iç giyim
        Thread.sleep(2000);
        driver.findElementByXPath("//ul[@class='sub-navigation js-sub-navigation shown']//li[9]//a").click();//dizaltı çorap
       // Thread.sleep(2000);
       // driver.findElementByXPath("//a[@class='js-filter-mobile']").click();//filtrele
        Thread.sleep(2000);
        driver.findElementByXPath("//div[@class='filter-mobile visible-xs']").click();
        Thread.sleep(2000);
       /* try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        } catch (InvalidSelectorException e) {
            // ignore
            e.printStackTrace();
        }*/
        JavascriptExecutor js=(JavascriptExecutor)driver;

        List<AndroidElement> filtreRenk=driver.findElementsByXPath("//li[@class='checkbox']");
        for (int i = 0; i <filtreRenk.size() ; i++) {
            Thread.sleep(2000);
            js.executeScript("arguments[0].scrollIntoView(true);",filtreRenk.get(i));
            if (filtreRenk.get(i).getText().contains("SİYAH")){
                filtreRenk.get(i).click();
                break;
            }

        }

        Thread.sleep(5000);
        driver.findElementByXPath("//div[@class='count']").click();//ekleme
        Thread.sleep(2000);
        String actualdata=driver.findElementByXPath("//li[@class='breadcrumb-item active']//span").getText();//siyah Texti
        String expectedData="Siyah";
        Assert.assertTrue(actualdata.contains(expectedData));

        Thread.sleep(2000);
        driver.findElementByXPath("//button[@class='add-to-basket button green block with-icon js-add-basket']").click();//sepet ekle1

        Thread.sleep(2000);
        driver.findElementByXPath("//a[@class='go-to-shop']").click();//sepet görüntüle
        Thread.sleep(2000);
        driver.findElementByXPath("//a[@class='button green checkout-button block js-checkout-button']").click();//sepet onayla
        Thread.sleep(2000);
        driver.findElementByXPath("//a[@class='auth__form__proceed js-proceed-to-checkout-btn']").click();//uye olmadan devam et

        Thread.sleep(2000);
        Faker fk=new Faker();
        driver.findElementByXPath("(//input[@class='js-form-input'])[2]").sendKeys(fk.internet().emailAddress());//email kutusu
        Thread.sleep(2000);
        driver.findElementByXPath("//button[@class='button block green']").click();//devam et buttonu
        Thread.sleep(8000);
        driver.findElementByXPath("(//li[@class='half'])[1]").click();//yeni adres oluştur





        Thread.sleep(2000);
        driver.findElementByXPath("//input[@name='title']").sendKeys("evim");//adres başlığı
        Thread.sleep(2000);
        driver.findElementByXPath("//input[@name='first_name']").sendKeys("kadir");//ad
        Thread.sleep(2000);
        driver.findElementByXPath("//input[@name='last_name']").sendKeys("tepecik");//soyad
        //Thread.sleep(2000);
        driver.findElementByXPath("//input[@name='phone_number']").click();//telefon
        Thread.sleep(2000);
        String no="5443314959";
        String [] no1=no.split("");
        AndroidElement tel=driver.findElementByXPath("//input[@name='phone_number']");//telefon
        Thread.sleep(2000);
        for (int i = 0; i <no1.length ; i++) {
            Thread.sleep(2000);
            tel.sendKeys(no1[i]);

        }

        String il="İSTANBUL";
        String ilce="EYÜPSULTAN";
        String mah="MERKEZ MAH";
        Thread.sleep(10000);
       // driver.findElementByXPath("//select[@name='city']").click();//il
        driver.findElementByXPath("//*[text()='"+il+"']").click();
        Thread.sleep(2000);
       // driver.findElementByXPath("//select[@name='township']").click();//ilçe
        driver.findElementByXPath("//*[text()='"+ilce+"']").click();
        Thread.sleep(2000);
        //driver.findElementByXPath("//select[@name='district']").click();//mahalle
        driver.findElementByXPath("//*[text()='"+mah+"']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//textarea[@class='js-address-textarea']").sendKeys(fk.address().streetAddress());//adress
        Thread.sleep(5000);
        driver.findElementByXPath("//button[@class='button green js-set-country js-prevent-emoji']").click();//kaydet
        Thread.sleep(3000);
        List<AndroidElement> kargolist=driver.findElements(By.xpath("//ul[@class='js-shipping-list']//li//div[2]"));//kargo
        kargolist.get(0).click();
        Thread.sleep(2000);
        driver.findElementByXPath("//button[@class='button block green js-proceed-button']").click();//kaydet ve devam et
        Thread.sleep(2000);
        String adSoyad="";
        String kartno="";
        String sonAy="";
        String sonYil="";
        String CVC="";

        driver.findElementByXPath("(//input[@name='name'])[2]").sendKeys(adSoyad, Keys.TAB);//ad soyad
        Thread.sleep(2000);
        String sayi[]=kartno.split("");
       //AndroidElement kartButton=driver.findElementByXPath("(//div/label/input)[6]");//kredikarto
        //kartButton.click();
       // kartButton.sendKeys(kartno);

       // js.executeScript("arguments[0].click();",kartButton);
       for (int i = 0; i <sayi.length ; i++) {
           new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div/label/input)[5]"))).sendKeys(sayi[i]);


        }
        Thread.sleep(2000);
        AndroidElement sonay=driver.findElementByXPath("(//select[@name='card_month'])[2]");//sonay
        Select sc=new Select(sonay);
        sc.selectByVisibleText(sonAy);
        /*Thread.sleep(2000);
        js.executeScript("arguments[0].click();",sonay);
        Thread.sleep(5000);
        driver.findElementByXPath("//option[@VALUE='"+sonAy+"']").click();//sonaysecim*/
        Thread.sleep(5000);
        AndroidElement sonyil=driver.findElementByXPath("(//select[@name='card_year'])[2]");//sonyıl
        Select sc1=new Select(sonyil);
        sc1.selectByVisibleText(sonYil);
       /* Thread.sleep(5000);
        js.executeScript("arguments[0].click();",sonyil);
        Thread.sleep(5000);
        driver.findElementByXPath("(//option[@value='"+sonYil+"'])[2]");//sonyil seçme*/

        Thread.sleep(2000);
        driver.findElementByXPath("(//input[@class='js-payment-cvv'])[2]").sendKeys(CVC);//cvc input



        //driver.findElementByXPath("(//div[@class='agrement'])[2]").click();//on bilgilendirme metni
       //js.executeScript("arguments[0].scroll(true);");
        //(//div[@class='checkbox'])[2]
        Thread.sleep(5000);
        String el = "document.getElementById('agrement2').click()";
        js.executeScript(el);



       // WebDriverWait wait=new WebDriverWait(driver,5);
      //  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("//input[@id='agrement2']"))).click();
        //new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='agrement'])[2]"))).click();
        Thread.sleep(5000);
        driver.findElementByXPath("(//button[@class='button block green continue-button'])[2]").click();//sipariş tamamla
        //      (//*[text()='Siparişi Tamamla'])[2]

        Thread.sleep(5000);

        driver.switchTo().frame(driver.findElementByXPath("//iframe[@class='checkout-redirect-iframe']"));//11
        //class="checkout-redirect-iframe"
        AndroidElement dogrulama=driver.findElementByXPath("//label[text()='Doğrulama Kodu']");
        Assert.assertTrue(dogrulama.isDisplayed());
        Thread.sleep(5000);
        driver.findElementByXPath("//div[@class='action-col left']").click();
        Thread.sleep(5000);
        driver.findElementByXPath("//div/a[@id='cancelbutton']").click();






    }


}
