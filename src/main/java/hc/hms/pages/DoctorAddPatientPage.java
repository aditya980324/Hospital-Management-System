package hc.hms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorAddPatientPage {
    private WebDriver driver;

    public DoctorAddPatientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "patname")
    private WebElement patientNameTxtFld;
    @FindBy(name = "patcontact")
    private WebElement patientContactTxtFld;
    @FindBy(name = "patemail")
    private WebElement patientEmailTxtFld;
    @FindBy(xpath = "//label[contains(text(),'Male')]")
    private WebElement femaleRdoBtn;
    @FindBy(xpath = "//label[contains(text(),'Male')]")
    private WebElement maleRdoBtn;
    @FindBy(name = "pataddress")
    private WebElement patientAddressTxtFld;
    @FindBy(name = "patage")
    private WebElement patientAgeTxtFld;
    @FindBy(name = "medhis")
    private WebElement medicalHistoryTxtFld;
    @FindBy(name = "submit")
    private WebElement addBtn;
    @FindBy(xpath = "//span[text()=' Email available for Registration .']")
    private WebElement emailConfirmationTxt;

    public WebElement getEmailConfirmationTxt() {
        return emailConfirmationTxt;
    }

    public WebElement getPatientNameTxtFld() {
        return patientNameTxtFld;
    }

    public WebElement getPatientContactTxtFld() {
        return patientContactTxtFld;
    }

    public WebElement getPatientEmailTxtFld() {
        return patientEmailTxtFld;
    }

    public WebElement getFemaleRdoBtn() {
        return femaleRdoBtn;
    }

    public WebElement getMaleRdoBtn() {
        return maleRdoBtn;
    }

    public WebElement getPatientAddressTxtFld() {
        return patientAddressTxtFld;
    }

    public WebElement getPatientAgeTxtFld() {
        return patientAgeTxtFld;
    }

    public WebElement getMedicalHistoryTxtFld() {
        return medicalHistoryTxtFld;
    }

    public WebElement getAddBtn() {
        return addBtn;
    }
    public void clickOnMaleRadioButton() {
        getMaleRdoBtn().click();
    }
}
