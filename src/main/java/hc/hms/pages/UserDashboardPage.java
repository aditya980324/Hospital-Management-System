package hc.hms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboardPage {
    private WebDriver driver;

    public UserDashboardPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()=' Dashboard ']")
    private WebElement dashboardLink;

    @FindBy(xpath = "//span[text()=' Book Appointment ']")
    private WebElement bookAppointmentLink;

    @FindBy(xpath = "//span[text()=' Appointment History ']")
    private WebElement appointmentHistoryLink;

    @FindBy(xpath = "//span[text()=' Medical History ']")
    private WebElement medicalHistoryLink;

    @FindBy(xpath = "//span[@class='username']")
    private WebElement profileDrpDwn;

    @FindBy(xpath = "//a[@href='edit-profile.php']")
    private WebElement myProfileLink;

    @FindBy(xpath = "//a[@href='change-password.php']")
    private WebElement changePasswordLink;

    @FindBy(xpath = "//a[@href='logout.php']")
    private WebElement logoutLink;

    public WebElement getDashboardLink() {
        return dashboardLink;
    }

    public WebElement getBookAppointmentLink() {
        return bookAppointmentLink;
    }

    public WebElement getAppointmentHistoryLink() {
        return appointmentHistoryLink;
    }

    public WebElement getMedicalHistoryLink() {
        return medicalHistoryLink;
    }

    public WebElement getProfileDrpDwn() {
        return profileDrpDwn;
    }

    public WebElement getMyProfileLink() {
        return myProfileLink;
    }

    public WebElement getChangePasswordLink() {
        return changePasswordLink;
    }

    public WebElement getLogoutLink() {
        return logoutLink;
    }

    // logout method
    public void logoutAsUser() {
        getProfileDrpDwn().click();
        getLogoutLink().click();
    }

}














