package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

public class Q3 {
    /*
     * Navigate to https://www.saucedemo.com/
     * Enter the username as standard_user
     * Enter the password as secret_sauce
     * Click on login button
     *    Test1 : Choose price low to high
     *    Test2 : Verify item prices are sorted from low to high with soft Assert
     */

    @Test
    public void saucedemoTest1(){

        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));

        Driver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");

        Driver.getDriver().findElement(By.id("password")).sendKeys("secret_sauce");

        Driver.getDriver().findElement(By.id("login-button")).click();

        WebElement ddm=Driver.getDriver().findElement(By.className("product_sort_container"));
        Select select=new Select(ddm);

        select.selectByVisibleText("Price (low to high)");

        SoftAssert softAssert=new SoftAssert();

        String expected="Price (low to high)";
        String actual=Driver.getDriver().findElement(By.className("active_option")).getText();

        softAssert.assertEquals(actual,expected);

        softAssert.assertAll();
        Driver.closeDriver();
    }


}
