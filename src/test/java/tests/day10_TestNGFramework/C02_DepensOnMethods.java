package tests.day10_TestNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_DepensOnMethods {


    //3 test method'u oluşturun
    //1. amazon'a gidip amazona gittiğimizi test edin
    //2. nutella aratıp, sonucun Nutella içerdiğini test edin
    //3. ilk ürüne click yapip, ürün isminin Nutella içerdiğini test edin

    @Test
    public void amazonTesti(){
        Driver.getDriver().get("https://www.amazon.com");
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));

    }
    @Test
    public void nutellaTesti(){
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }
    @Test
    public void ilkUrunTesti(){

    }
}
