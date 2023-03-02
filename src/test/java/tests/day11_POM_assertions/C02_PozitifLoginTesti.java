package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PozitifLoginTesti {

    @Test
    public void positiveLoginTesti(){
        //qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qualityUrl"));

        //Login butonuna basın
        QdPage qdPage=new QdPage();
        qdPage.ilkLoginLinki.click();

        //geçerli kullanıcı adı ve password ile giriş yapın
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.click();

        //basarili bir şekilde giriş yapıldığonı test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());


        Driver.closeDriver();

    }
}
