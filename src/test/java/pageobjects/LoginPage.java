package pageobjects;

import actiondriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{

    @FindBy(xpath = "//input[@name=\"username\"]")
    WebElement usernameField;
    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement passwordField;
    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")
    WebElement loginButton;
    @FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p orangehrm-login-forgot-header\"]")
    WebElement forgotPassword;
    @FindBy(xpath = "//img[@alt=\"company-branding\"]")
    WebElement orangeLogo;

    Action actions = new Action();
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean validateLogo(){
        return actions.isDisplayed(driver, orangeLogo);
    }

    public DashboardPage validLogin(){
        actions.type(usernameField, prop.getProperty("username"));
        actions.type(passwordField, prop.getProperty("password"));
        actions.click(driver, loginButton);
        return new DashboardPage();
    }

    public String getPageTitle(){
        String pageTitle = actions.getTitle(driver);
        return pageTitle;
    }
}
