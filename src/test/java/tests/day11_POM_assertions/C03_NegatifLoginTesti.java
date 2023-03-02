package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_NegatifLoginTesti {
    //1- https://www.qualitydemy.com/ anasayfasina gidin
    //2- login linkine basin
    //3- Kullanvalid 3 farkli test method’u olusturun.
    //- gecerli username, gecersiz password
    //- gecersiz username, gecerli password
    //- gecersiz username, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin

    QdPage qdPage=new QdPage();
    @Test
    public void negatifLoginTesti1(){
        ReusableMethods.bekle(3);
        qdPage=new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qualityUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.loginButonu.click();
        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }
    @Test
    public void negatifLoginTesti2(){
        qdPage=new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qualityUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.click();
        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();

    }
    @Test
    public void negatifLoginTesti3(){
        qdPage=new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qualityUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.loginButonu.click();
        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }
}
