package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QdPage {

   public QdPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[.='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//a[text()='Instructor']")
    public WebElement basariliGirisElementi;

    @FindBy(xpath = "//*[text()='Accept']")
     public WebElement cookies;

    @FindBy(xpath = "/html/body/section[1]/div/nav/div[6]/div[1]/a")
     public WebElement userProfilImg;

    @FindBy(xpath = "/html/body/section[1]/div/nav/div[6]/div[2]/ul/li[6]/a/i")
    public WebElement userProfil;
}
