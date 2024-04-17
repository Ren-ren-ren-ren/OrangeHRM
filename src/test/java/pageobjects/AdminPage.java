package pageobjects;

import actiondriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends BaseClass {

    Action actions = new Action();

    @FindBy(linkText = "manda user")
    WebElement empName;
    @FindBy(xpath = "//span[@class=\"oxd-userdropdown-tab\"]")
    WebElement menuDropdown;
    @FindBy(xpath = "//a[@href=\"/web/index.php/auth/logout\"]")
    WebElement logoutButton;

    public AdminPage (){
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        String pageTitle = actions.getTitle(driver);
        return pageTitle;
    }

    public boolean validateEmpName(){
        return actions.isDisplayed(driver, empName);
    }

    public LoginPage clickLogout(){
        actions.click(driver, logoutButton);
        return new LoginPage();
    }

}
