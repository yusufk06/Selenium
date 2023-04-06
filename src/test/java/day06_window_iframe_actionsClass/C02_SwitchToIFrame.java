package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_SwitchToIFrame extends TestBase {


    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/iframe adresine gidin

        driver.get("https://the-internet.herokuapp.com/iframe");
        //"Your content goes here." yazisinin gorunur oldugunu test edin
        /*
        Bazen locate islemimizden emin olmamiza ragmen locator calismaz
        Bunun sebebi kullanmak istedigimiz webelementin bir iframe in child'i olmasi olabilir

        Eger kullanmak istedigimiz webelement anasayfa icine gomulen baska bir websayfasinin elementi ise
        once gomulu sayfaya gecmemiz gerekir

        HTML komutlarinda sayfa icerisine sayfa gomebilmek icin ,iframe> kullanilir
        Biz de istedigimiz elementi kullanmak icin once o frame'e swith yapmaliyiz

        1- gecis yapmak istedigimiz frame locate edin
        2- switchTo() ile o frame'e gecis yapin
        3- sonra istediginiz element ile istediginiz islemi yapn

         */

        WebElement frameElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);
        WebElement yaziElementi= driver.findElement(By.tagName("p"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        // Elemental Selenium linkine click yapin
        /*
        Bir frame'e gecis yaptiktan sonra oradan cikincaya veya baska bir frame'e gecinceye kada
        driver o frame icerisinde kalir

        isimiz bittiginde veya baska frame'e gecmek istedigimizde once calisacagimiz yere gecis yapmaliyiz

         */

       // driver.switchTo().parentFrame(); // icice frame'lerde bir ust seviyeye cikar
        driver.switchTo().defaultContent(); // direkt anasayfaya cikar
        driver.findElement(By.linkText("Elemental Selenium")).click();


        bekle(3);
    }

}
