package day09_excel_screenshot_jsexecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        /*

        Biz kodlarimizla bilgisayardaki bir dosyaya direkt erisim saglayip
        anlik o dosyadan bilgi almayiz
        Bunun yerine kod ortamimizda bilgisayarimizdaki excel dosyanin
        1-bir kopyasini olusturur
        2- excel deki tum bilgileri kopya workbook a yukler
        3- workbook uzerinde yapacagimiz tum islemleri yapariz
        4- eger olusturdugumuz workbook da update yaparsak
           son halini excel e islemek icin
           class'in sonunda kopya workbook daki bilgileri excel e kayderderiz
         */

        //1- bilgisayardaki excel e ulasabilmek icindosya yolu gerekir
        String dosyaYolu="src/test/java/day09_excel_screenshot_jsexecutor/ulkeler.xlsx";

        //2- Dosya yolunu olusturdugumuz excelden bilgileri almak icin
        //      FileInputStream objesi olusturmaliyiz
        FileInputStream fis= new FileInputStream(dosyaYolu);

        //3- Bilgilerini aldigimiz excel'de calisma yapabilmek icin kod ortamimizda
        //  kopya bir workbook olusturmaliyiz

        Workbook workbook= WorkbookFactory.create(fis);

        // Bilgisayarimizda ki excel'in icinde bulunan tum bilgiler
        // artik workbook objesinde kayitli
        // excel'in yapisi geregi sirayla
        //- istnene sayfa
        //- istenen satir
        //-istenen hucre
        //olusturulmalidir / okunmalidir

        //12.satirin,3.hucresinin "Azerbaycan oldgunu test edin
        Sheet sayfa1= workbook.getSheet("Sayfa1");
        /// excel index kullanir yani 0 dan baslar
        Row row=sayfa1.getRow(11);
        Cell cell=row.getCell(2);

        String expectedData="Azerbaycan";
        String actualData=cell.toString();

        Assert.assertEquals(expectedData,actualData);

    }
}
