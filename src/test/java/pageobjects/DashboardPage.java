package pageobjects;

import actiondriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseClass {

    Action actions = new Action();

    @FindBy(xpath = "//img[@alt=\"client brand banner\"]")
    WebElement logoBanner;
    @FindBy(xpath = "//a[@href=\"/web/index.php/admin/viewAdminModule\"]")
    WebElement adminButton;



    public DashboardPage (){
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        String pageTitle = actions.getTitle(driver);
        return pageTitle;
    }

    public boolean validateBanner(){
        return actions.isDisplayed(driver, logoBanner);
    }

    public AdminPage clickAdminButton(){
        actions.click(driver, adminButton);
        return new AdminPage();
    }

}
