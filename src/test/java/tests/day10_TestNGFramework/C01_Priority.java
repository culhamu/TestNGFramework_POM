package tests.day10_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Priority {

    //TestNG test methodlarını çalıştırırken standart olarak harf sıralamasına bakarak çalıştırır
    //Ancak sıralamayı bizim kontrol etmemize imkan sağlar

    //istediğimiz test methoduna istediğimiz önceliği verebiliriz
    //TestNG priority'yi küçükten büyüğe doğru olacak şekilde sıralar

    //Priority'leri aynı olan testlerde harf sırasına göre çalıştırır

    //Prority'nin default değeri 0'dır ve değer atamazsak bu değere göre çalıştırır

    @Test(priority =20 )
    public void amazonTesti(){

        //Amazon anasayfaya gidip amazon'a gittiğimizi test edelim
        Driver.getDriver().get("https://www.amazon.com");

        //url amazon içeriyor mu test edelim

        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        Driver.closeDriver();
    }
    @Test(priority = 30)
    public void wisequarterTesti(){

        //wisequarter anasayfaya gidip wisequarter'a gittiğimizi test edelim


        Driver.getDriver().get("https://www.wisequarter.com");
        Driver.getDriver().navigate().refresh();
        String expectedIcerik="wisequarter";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        Driver.closeDriver();
    }
    @Test(priority = 30)
    public void youtubeTesti(){

        //youtube anasayfaya gidip youtube'a gittiğimizi test edelim
        Driver.getDriver().get("https://www.youtube.com");
        String expectedIcerik="youtube";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        Driver.closeDriver();
    }
}
