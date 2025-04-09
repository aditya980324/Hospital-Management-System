package hc.hms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddDoctorPage {
    private WebDriver driver;

    public AdminAddDoctorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "Doctorspecialization")
    private WebElement doctorSpecializationDrpDwn;
    @FindBy(name = "docname")
    private WebElement doctorNameTxtFld;
    @FindBy(name = "clinicaddress")
    private WebElement doctorClinicAddressTxtFld;
    @FindBy(name = "docfees")
    private WebElement doctorFeesTxtFld;
    @FindBy(name = "doccontact")
    private WebElement doctorContactTxtFld;
    @FindBy(name = "docemail")
    private WebElement doctorEmailTxtFld;
    @FindBy(name = "npass")
    private WebElement newPasswordTxtFld;
    @FindBy(name = "cfpass")
    private WebElement confirmPasswordTxtFld;
    @FindBy(name = "submit")
    private WebElement submitBtn;

    public WebElement getDoctorSpecializationDrpDwn() {
        return doctorSpecializationDrpDwn;
    }

    public WebElement getDoctorNameTxtFld() {
        return doctorNameTxtFld;
    }

    public WebElement getDoctorClinicAddressTxtFld() {
        return doctorClinicAddressTxtFld;
    }

    public WebElement getDoctorFeesTxtFld() {
        return doctorFeesTxtFld;
    }

    public WebElement getDoctorContactTxtFld() {
        return doctorContactTxtFld;
    }

    public WebElement getDoctorEmailTxtFld() {
        return doctorEmailTxtFld;
    }

    public WebElement getNewPasswordTxtFld() {
        return newPasswordTxtFld;
    }

    public WebElement getConfirmPasswordTxtFld() {
        return confirmPasswordTxtFld;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }
}
