package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {
    QdPage qdPage=new QdPage();

    @Test(groups = "smoke")
    public void positiveLoginTesti(){
        extentTest=extentReports.createTest("Pozitif login testi","Geçerli bilgilerle giriş yapılabilmeli");
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




    }
}
