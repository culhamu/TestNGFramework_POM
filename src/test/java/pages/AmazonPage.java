package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    /*
    Pages class'lari sürekli kullandığımız locateleri tekrar tekrar locate etmek zorunda kalmaktan kurtulmak için kullanılır

    Her pages class'ı driver class'ında oluşturulan driver'ı kullanılır

    @FindBy notasyonunun Driver class'ındaki webDriver'ı kullanabilmesi için
    bu class' a tanıtmalıyız

    Bunun için her pages sayfası ilk oluşturulduğunda başına parametresiz bir
    consructor oluşturup içerisinde driver'ı bu class'a tanuturuz
     */

    public AmazonPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")

        public WebElement aramaKutusu;
    @FindBy(xpath = "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")

    public WebElement aramaSonucElementi;

}
