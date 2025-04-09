package hc.hms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {
    private WebDriver driver;

    public DoctorDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()=' Dashboard ']")
    private WebElement dashboardLink;
    @FindBy(xpath = "//span[text()=' Appointment History ']")
    private WebElement appointmentHistoryLink;
    @FindBy(xpath = "//span[text()=' Patients ']")
    private WebElement patientsTab;
    @FindBy(xpath = "//span[text()=' Add Patient']")
    private WebElement addPatientLink;
    @FindBy(xpath = "//span[text()=' Manage Patient']")
    private WebElement managePatientLink;
    @FindBy(xpath = "//span[text()=' Search ']")
    private WebElement searchLink;
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

    public WebElement getAppointmentHistoryLink() {
        return appointmentHistoryLink;
    }

    public WebElement getPatientsTab() {
        return patientsTab;
    }

    public WebElement getAddPatientLink() {
        return addPatientLink;
    }

    public WebElement getManagePatientLink() {
        return managePatientLink;
    }

    public WebElement getSearchLink() {
        return searchLink;
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
    public void logoutAsDoctor() {
        getProfileDrpDwn().click();
        getLogoutLink().click();
    }
}
