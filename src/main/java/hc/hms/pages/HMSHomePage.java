package hc.hms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HMSHomePage {
    private WebDriver driver;
    public HMSHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[text()='Patients']/../div/span/a")
    private WebElement patientLink;

    @FindBy(xpath = "//h3[text()='Doctors Login']/../div/span/a")
    private WebElement doctorLink;

    @FindBy(xpath = "//h3[text()='Admin Login']/../div/span/a")
    private WebElement adminLInk;

    public WebElement getPatientLink() {
        return patientLink;
    }

    public WebElement getDoctorLink() {
        return doctorLink;
    }

    public WebElement getAdminLInk() {
        return adminLInk;
    }
    // business utilities
    // click on user module method
    public void clickOnPatientModule() {
        getPatientLink().click();
    }
    // click on doctor module method
    public void clickOnDoctorModule() {
        getDoctorLink().click();
    }
    // click on admin module method
    public void clickOnAdminModule() {
        getAdminLInk().click();
    }
}
