package tests.day10_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Priority {

    @Test
    public void amazonTesti(){

        //Amazon anasayfaya gidip amazon'a gittiğimizi test edelim
        Driver.getDriver().get("https://www.amazon.com");

        //url amazon içeriyor mu test edelim

        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        Driver.closeDriver();
    }
    @Test
    public void wisequarterTesti(){

        //wisequarter anasayfaya gidip wisequarter'a gittiğimizi test edelim
    }
    @Test
    public void youtubeTesti(){

        //youtube anasayfaya gidip youtube'a gittiğimizi test edelim
    }
}
