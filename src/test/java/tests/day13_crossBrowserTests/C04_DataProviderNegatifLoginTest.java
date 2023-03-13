package tests.day13_crossBrowserTests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DataProviderNegatifLoginTest {



    /*
        verilen 5 farklı username ve password'u kullanarak
        qdemy uygulamasına girlemediğini test edin
         */

    @DataProvider
    public static Object[][] kullanicilar() {

        String[][] kallaniciList={{"Zafer","12345"},{"Mehmet","34567"},{"Sevilay","67890"},{"Enver","56789"},{"Ahmet Emre","54321"}};
        return kallaniciList;
    }

    @Test(dataProvider = "kullanicilar")
    public void negatifLogin1(String username,String password){
        ReusableMethods.bekle(3);
        QdPage qdPage=new QdPage();
        qdPage= new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(username);
        qdPage.passwordKutusu.sendKeys(password);
        qdPage.loginButonu.click();
        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }

}
