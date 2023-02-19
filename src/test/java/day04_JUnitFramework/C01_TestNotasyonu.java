package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
    Framework= Ortak calisma cercevesi
               Hangi dosyalari nerede olusturacagimizi belirler ve boylece toplu calismayi kolaylastirir
               Her framework, dosya duzeni olusturmanin yaninda,
               islerimizi kolaylastiran yeni ozellikler sunmustur.

               JUnit framework en temel test framework udur.
               bize kazandirdigi en onemli ozellik @Test Annotation (Notasyon)dir

                @Test notasyonu sayesinde her bir method bagimsiz olarak calistirilabilen bir TEST methodu olur

                @Test notasyonu sayesinde istersek her bir test methodunu bagimsiz calistirabildigimiz gibi
                istenirse class level dan calistirip, tum testlerin calismasini saglayabiliriz

                JUnit framework de test methodlarinin hangi sira ile calisacagini ONGOREMEYIZ ve KONTROL EDEMEYIZ
     */
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://wisequarter.com");


        driver.close();
    }

    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://youtube.com");

        driver.close();

    }



}
