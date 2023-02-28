package tests.day10_TestNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_DependsOnMethods {
    AmazonPage amazonPage = new AmazonPage();

    /*
    Priority öncelik belirler ama testleri birbirine bağlamaz
    Eğer bir test method'unun çalışması başka bir teste bağlı ise
    bu durumda dependsOnMethods kullanmak daha iyidir

    dependOnMethod ile başka bir methoda bağlı olan methodu çalıştırmak istersek
    önce bağlı olduğu methodu çalışştırır sonra kendi çalışır
    ancak 2 method için geçerlidir 3 method için geçerli değildir


     */

    // 3 test method'u olusturun
    // 1. amazona gidip amazona gittigimizi test edin
    // 2. Nutella aratip, sonucun Nutella icerdigini test edin
    // 3. ilk urune click yapip, urun isminin Nutella icerdigini test edin

    @Test
    public void amazonTesti(){

        Driver.getDriver().get("https://www.amazon.com");

        String expectedIcerik="amazon";
        String actualurl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualurl.contains(expectedIcerik));
    }

    @Test(dependsOnMethods = "amazonTesti")
    public void nutellaTesti(){


        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }

    @Test(dependsOnMethods = "nutellaTesti")
    public void ilkUrunTesti(){

    amazonPage.ilkUrun.click();
    String expectedIcerik="Nutella";
    String actualUrunIsmi=amazonPage.ilkUrunIsimElementi.getText();

    Assert.assertTrue(actualUrunIsmi.contains(expectedIcerik));

    Driver.closeDriver();
    }

}