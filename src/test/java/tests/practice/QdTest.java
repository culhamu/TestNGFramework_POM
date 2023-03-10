package tests.practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QdTest {




    // Bu kutucuklarda degisiklik yaparak kaydeder degisiklikleri dogrular

        QdPage qdPage=new QdPage();
        @Test
        public void qualityProfilTest(){
            // Kullanici https://qualitydemy.com/ sayfasina gider
            Driver.getDriver().get(ConfigReader.getProperty("qualityUrl"));

            // Siteye basarili bir sekilde giris yapar
            qdPage.cookies.click();
            qdPage.ilkLoginLinki.click();
            qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliMail"));
            qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
            qdPage.loginButonu.click();

            ReusableMethods.bekle(4);

            // sag taraf bulunan kullanici menusunden User Profile kismina gider
            Actions actions=new Actions(Driver.getDriver());

            actions.moveToElement(qdPage.userProfilImg).perform();
            actions.click(qdPage.userProfil).build().perform();

            // FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
        }



}
