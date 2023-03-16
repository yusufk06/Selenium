package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_SwitchToWindows extends TestBase {

    @Test
    public void test01(){

        //amazon anasayfaya gidip, arama kutusunun erisilebilir oldugunu test edin
        driver.get("https://amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        String amazonWindowHandleDegeri= driver.getWindowHandle();
        bekle(2);
        //yeni bir tab olarak wisequarter.com a gidin
        //url'in wisequarter icerdigini test edin
        /*
        once yeni bir tab olusturup driveri o sayfaya gecirmeliyiz (switch)
         */
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");

        String expectedIcerik="wisequarter";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        String wiseWindowHandleDegeri=driver.getWindowHandle();



        // amazon'un acik oldugu tab'a geri donup
        /*
        Daha once acilmis olan bir window a gecis yapmak icin o sayfanin windowHandle degerine ihtiyacimiz var

        Testimiz boyle bir gorevi iceriyorsa o sayfada iken windowHandle degerini alip kayit yapmaliyiz
         */
        driver.switchTo().window(amazonWindowHandleDegeri);

        //Nutella icin arama yapin
        //sonuclarin Nutella icerdigini test edin

        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String actualSonucYazisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        String expectedIcerikk="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerikk));
        //yeni bir window olarak youtube.com'a gidin
        //url'in youtube icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com");
        String expectedIceriks="youtube";
        String actuallUrl=driver.getCurrentUrl();
        Assert.assertTrue(actuallUrl.contains(expectedIceriks));
        bekle(2);
        //wisequarter'in acik oldugu sayfaya donun
        driver.switchTo().window(wiseWindowHandleDegeri);

        //title'in Wise Quarter icerdigini test edin
        expectedIcerik="Wise Quarter";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        bekle(3);
    }

}
