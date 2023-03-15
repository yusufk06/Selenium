package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_ZeroTest {

    @Test
    public void test01() throws InterruptedException {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver(ops);



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

    //2. Signin buttonuna tiklayin
        driver.findElement(By.className("icon-signin")).click();
    //3. Login alanine  “username” yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");
    //4. Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");
    //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();
    //6. Pay Bills sayfasina gidin
      //  driver.findElement(By.id("pay_bills_tab")).click();
    //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("200");
    //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("2020-09-10");
    //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    //10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement actualyazi= driver.findElement(By.xpath("//span[@title='$ 200 payed to payee sprint']"));

        if (actualyazi.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        Thread.sleep(3000);
        driver.close();
}

}
