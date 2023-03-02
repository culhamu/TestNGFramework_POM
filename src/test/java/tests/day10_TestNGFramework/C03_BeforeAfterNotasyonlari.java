package tests.day10_TestNGFramework;

import org.testng.annotations.*;

public class C03_BeforeAfterNotasyonlari {

    /*
    Smoke test
    Regression Test(bütün testlerin çalıştırılması)
    EndToEnd (E2E)

     Test Suite : Birden fazla Test'in bir amaç için biraraya getirilmesidir

    Test : Bir amaç için bir araya getirilmiş
    test methodlari,classlari,ve/veya package'lari içerir


    Test Hiyerarşisi :
      -Suite
      -Test
      -groups,packages,classes,methods

      içinde bir class ve class'ın sahip olduğu
     */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");

    }
    @BeforeClass
    public void beforeClass(){

        System.out.println("Before Class");

    }
    @BeforeMethod
    public void beforeMethod(){

        System.out.println("Before Method");


    }
    @Test
    public void test01(){
        System.out.println("Test 01");

    }
    @Test
    public void test02(){

        System.out.println("Test 02");

    }
    @Test
    public void test03(){

        System.out.println("Test 03");

    }
    @AfterSuite
    public void afteSuite(){
        System.out.println("After Suite");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterClass(groups = "smoke")
    public void afterClass(){
        System.out.println("After Class");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
}
