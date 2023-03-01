package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_ConfigReaderKullanimi {

    @Test
    public void test01(){

        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Test datası olarak verilen kelime  için arama yapalım
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        //arama sonuçlarının Nutella içerdiğini test edelim
        String expectedIcerik=ConfigReader.getProperty("amazonAranacakKelime");
        String actualAramaSonucYazisi=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        Driver.closeDriver();
    }
}
