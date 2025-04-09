package hc.hms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
    private WebDriver driver;
    public AdminLoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "username")
    private WebElement usernameTxtFld;

    @FindBy(name = "password")
    private WebElement passwordTxtFld;

    @FindBy(name = "submit")
    private WebElement loginBtn;

    public WebElement getUsernameTxtFld() {
        return usernameTxtFld;
    }

    public WebElement getPasswordTxtFld() {
        return passwordTxtFld;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    // Login Method
    public void loginAsAdmin(String username, String password) {
        getUsernameTxtFld().sendKeys(username);
        getPasswordTxtFld().sendKeys(password);
        getLoginBtn().click();
    }
}
