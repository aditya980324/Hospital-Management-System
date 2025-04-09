package hc.hms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
    private WebDriver driver;

    public AdminDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()=' Dashboard ']")
    private WebElement dashboardLink;
    @FindBy(xpath = "//span[text()=' Doctor Specialization ']")
    private WebElement doctorSpecializationLink;
    @FindBy(xpath = "//span[text()=' Doctors ']")
    private WebElement doctorsTab;
    @FindBy(xpath = "//span[text()=' Add Doctor']")
    private WebElement addDoctorLink;
    @FindBy(xpath = "//span[text()=' Manage Doctors ']")
    private WebElement manageDoctorLink;
    @FindBy(xpath = "//span[text()=' Users ']")
    private WebElement userTab;
    @FindBy(xpath = "//span[text()=' Manage Users ']")
    private WebElement manageUserLink;
    @FindBy(xpath = "//span[text()=' Patients ']")
    private WebElement PatientsTab;
    @FindBy(xpath = "//span[text()=' Manage Patients ']")
    private WebElement managePatientsLink;
    @FindBy(xpath = "//span[text()=' Appointment History ']")
    private WebElement appointmentHistoryLink;
    @FindBy(xpath = "//span[text()=' Conatctus Queries ']")
    private WebElement contactUsQueriesTab;
    @FindBy(xpath = "//span[text()=' Unread Query ']")
    private WebElement unreadQueryLink;
    @FindBy(xpath = "//span[text()=' Read Query ']")
    private WebElement readQueryLink;
    @FindBy(xpath = "//span[text()=' Doctor Session Logs ']")
    private WebElement doctorSessionLogsLink;
    @FindBy(xpath = "//span[text()=' User Session Logs ']")
    private WebElement userSessionLogsLink;
    @FindBy(xpath = "//span[text()=' Reports ']")
    private WebElement reportsTab;
    @FindBy(xpath = "//span[text()='B/w dates reports ']")
    private WebElement betweenDatesReportsLink;
    @FindBy(xpath = "//span[text()=' Patient Search ']")
    private WebElement patientSearchLink;
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

    public WebElement getDoctorSpecializationLink() {
        return doctorSpecializationLink;
    }

    public WebElement getDoctorsTab() {
        return doctorsTab;
    }

    public WebElement getAddDoctorLink() {
        return addDoctorLink;
    }

    public WebElement getManageDoctorLink() {
        return manageDoctorLink;
    }

    public WebElement getUserTab() {
        return userTab;
    }

    public WebElement getManageUserLink() {
        return manageUserLink;
    }

    public WebElement getPatientsTab() {
        return PatientsTab;
    }

    public WebElement getManagePatientsLink() {
        return managePatientsLink;
    }

    public WebElement getAppointmentHistoryLink() {
        return appointmentHistoryLink;
    }

    public WebElement getContactUsQueriesTab() {
        return contactUsQueriesTab;
    }

    public WebElement getUnreadQueryLink() {
        return unreadQueryLink;
    }

    public WebElement getReadQueryLink() {
        return readQueryLink;
    }

    public WebElement getDoctorSessionLogsLink() {
        return doctorSessionLogsLink;
    }

    public WebElement getUserSessionLogsLink() {
        return userSessionLogsLink;
    }

    public WebElement getReportsTab() {
        return reportsTab;
    }

    public WebElement getBetweenDatesReportsLink() {
        return betweenDatesReportsLink;
    }

    public WebElement getPatientSearchLink() {
        return patientSearchLink;
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
    public void logoutAsAdmin() {
        getProfileDrpDwn().click();
        getLogoutLink().click();
    }
}
