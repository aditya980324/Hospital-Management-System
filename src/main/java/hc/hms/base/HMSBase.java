package hc.hms.base;

import hc.hms.config.PropertyUtility;
import hc.hms.excel.ExcelUtility;
import hc.hms.java.JavaUtility;
import hc.hms.pages.*;
import hc.hms.thread.ThreadLocalUtility;
import hc.hms.webdriver.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class HMSBase {

    // Utility classes
    public PropertyUtility pU = new PropertyUtility();
    public ExcelUtility eU = new ExcelUtility();
    public WebDriverUtility wDU = new WebDriverUtility();
    public JavaUtility ju = new JavaUtility();
    public SoftAssert softAssert = new SoftAssert();

    // URLs and config
    String browser = System.getProperty("browser", pU.getPropertyData("browser"));
    String url = System.getProperty("url", pU.getPropertyData("url"));
    public String patientLoginUrl = pU.getPropertyData("patientLoginUrl");
    public String doctorLoginPageUrl = pU.getPropertyData("doctorLoginPageUrl");
    public String adminLoginPageUrl = pU.getPropertyData("adminLoginPageUrl");

    // Page object references
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

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriver driver = wDU.getDriver(browser); // get driver
        ThreadLocalUtility.setDriver(driver);      // store it in ThreadLocal

        // Initialize Page Object Model classes
        aADP = new AdminAddDoctorPage(driver);
        aDP = new AdminDashboardPage(driver);
        aLP = new AdminLoginPage(driver);
        dAPP = new DoctorAddPatientPage(driver);
        dAHP = new DoctorAppointmentHistoryPage(driver);
        dDP = new DoctorDashboardPage(driver);
        dLP = new DoctorLoginPage(driver);
        hmsHP = new HMSHomePage(driver);
        pLP = new PatientLoginPage(driver);
        uAHP = new UserAppointmentHistoryPage(driver);
        uBAP = new UserBookAppointmentsPage(driver);
        uDP = new UserDashboardPage(driver);

        wDU.openUrl(url); // open HMS URL
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver driver = ThreadLocalUtility.getDriver();
        if (driver != null) {
            driver.quit();
        }
        ThreadLocalUtility.removeDriver(); // clear thread-local storage
    }
}
