package hc.hms.base;

import hc.hms.config.PropertyUtility;
import hc.hms.excel.ExcelUtility;
import hc.hms.java.JavaUtility;
import hc.hms.pages.*;
import hc.hms.webdriver.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class HMSBase {
    // driver instances
    public WebDriver driver = null;
    // utility classes
    public PropertyUtility pU = new PropertyUtility();
    public ExcelUtility eU = new ExcelUtility();
    public SoftAssert softAssert = new SoftAssert();
    public WebDriverUtility wDU = new WebDriverUtility();
    public JavaUtility ju = new JavaUtility();
    // reading data from command line or property file
    String browser = System.getProperty("browser",pU.getPropertyData("browser"));
    String url = System.getProperty("url",pU.getPropertyData("url"));
    public String patientLoginUrl = pU.getPropertyData("patientLoginUrl");
    public String doctorLoginPageUrl = pU.getPropertyData("doctorLoginPageUrl");
    public String adminLoginPageUrl = pU.getPropertyData("adminLoginPageUrl");
    // object repository
    public AdminAddDoctorPage aADP;
    public AdminDashboardPage aDP;
    public AdminLoginPage aLP;
    public DoctorAddPatientPage dAPP;
    public DoctorAppointmentHistoryPage dAHP;
    public DoctorDashboardPage dDP;
    public DoctorLoginPage dLP;
    public HMSHomePage hmsHP;
    public PatientLoginPage pLP;
    public UserAppointmentHistoryPage uAHP;
    public UserBookAppointmentsPage uBAP;
    public UserDashboardPage uDP;
    @BeforeSuite
    public void openBrowser() {
        // initialize the driver
        driver=wDU.getDriver(browser);
        //initialize pom classes
        aADP=new AdminAddDoctorPage(driver);
        aDP=new AdminDashboardPage(driver);
        aLP=new AdminLoginPage(driver);
        dAPP=new DoctorAddPatientPage(driver);
        dAHP=new DoctorAppointmentHistoryPage(driver);
        dDP=new DoctorDashboardPage(driver);
        dLP=new DoctorLoginPage(driver);
        hmsHP=new HMSHomePage(driver);
        pLP=new PatientLoginPage(driver);
        uAHP=new UserAppointmentHistoryPage(driver);
        uBAP=new UserBookAppointmentsPage(driver);
        uDP=new UserDashboardPage(driver);
    }
    @BeforeMethod
    public void openHMSHomePage() {
        wDU.openUrl(url);
    }
    @AfterSuite
    public void closeBrowser() {
        wDU.closeBrowser();
    }

}











