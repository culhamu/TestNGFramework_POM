package tests.practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QdTest {






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

            ReusableMethods.bekle(5);

            // sag taraf bulunan kullanici menusunden User Profile kismina gider
            Actions actions=new Actions(Driver.getDriver());

            actions.moveToElement(qdPage.userProfilImg).perform();
            actions.click(qdPage.userProfil).build().perform();

            // FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
            Assert.assertTrue(qdPage.profilName.getText().contains("Ahmet Bulutluoz"));

            Driver.getDriver().switchTo().frame(qdPage.iframe);

            Assert.assertFalse(qdPage.biography.getText().isEmpty());

            Driver.getDriver().switchTo().defaultContent();

            // Bu kutucuklarda degisiklik yaparak kaydeder degisiklikleri dogrular

            qdPage.profileFirstNameBox.clear();
            qdPage.profileFirstNameBox.sendKeys("Nevzat");
            qdPage.profileLastNameBox.clear();
            qdPage.profileLastNameBox.sendKeys("Celik");
            Driver.getDriver().switchTo().frame(qdPage.iframe);
            qdPage.biography.clear();
            qdPage.biography.sendKeys("Wisequarter ");
            Driver.getDriver().switchTo().defaultContent();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            actions.sendKeys(Keys.PAGE_DOWN).perform();

            ReusableMethods.bekle(2);

            qdPage.saveButon.click();


            Driver.quitDriver();

        }



}
