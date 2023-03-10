package tests.practice;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class dataProvider {
    QdPage page=new QdPage();

    @DataProvider
    public static Object[][] gonderilecekMail(){

        Object[][] gonderilecekData={{"nevzat","12345"},
                {"nevzat@hotmail.com","123456"},
                {"ahmet@hotmail.com","123456564971651"},
                {"celik@hotmail.com","12345656497165156481"}};

        return gonderilecekData;
    }

    @Test(dataProvider = "gonderilecekMail")
    public void qualityTest(String mail,String password){

        Driver.getDriver().get(ConfigReader.getProperty("qualityUrl"));
        if (page.cookies.isDisplayed()) {
            page.cookies.click();
            page.ilkLoginLinki.click();
            page.emailKutusu.sendKeys(mail);
            page.passwordKutusu.sendKeys(password);
            page.loginButonu.click();
        }else {
            page.ilkLoginLinki.click();
            page.emailKutusu.sendKeys(mail);
            page.passwordKutusu.sendKeys(password);
            page.loginButonu.click();
        }


    }

}
