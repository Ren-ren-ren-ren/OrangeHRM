package testcases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class LoginTest extends BaseClass {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        launchApp();
    }

    @Test
    public void verifyLogo(){
        loginPage = new LoginPage();
        Boolean result = loginPage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test
    public void verifyPageTitle(){
        String result = loginPage.getPageTitle();
        Assert.assertEquals(result, "OrangeHRM");
    }

//    @Test
//    public void validLogin(){
//        loginPage.validLogin();
//    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
