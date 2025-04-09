import com.aventstack.extentreports.Status;
import hc.hms.base.HMSBase;
import hc.hms.thread.ThreadLocalUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(hc.hms.listeners.ListenerUtility.class)
public class AdminDoctorTest extends HMSBase {
    int randomNumber=ju.getRandomNum();
    @Test(groups = "system")
    public void verifyAddDoctorTest() {
        // test data
        String adminEmail=eU.getExcelData("Sheet1",8,1);
        String adminPassword=eU.getExcelData("Sheet1",8,3);
        String doctorSpecialization=eU.getExcelData("Sheet1",9,1);
        String doctorName=eU.getExcelData("Sheet1",10,1)+randomNumber;
        String doctorClinicAddress=eU.getExcelData("Sheet1",11,1);
        String doctorFees=eU.getExcelData("Sheet1",12,1);
        String doctorContact=eU.getExcelData("Sheet1",13,1)+randomNumber;
        String doctorEmail=doctorName+"@gmail.com";
        String doctorPassword=eU.getExcelData("Sheet1",14,1);
        // log in as admin
        wDU.openUrl(adminLoginPageUrl);
        ThreadLocalUtility.getTest().log(Status.INFO,"Admin Login Page is Displayed");
        aLP.loginAsAdmin(adminEmail,adminPassword);
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged In as Admin");
        // navigate to add doctor
        aDP.getDoctorsTab().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Clicked on Doctors Tab");
        aDP.getAddDoctorLink().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Add Doctor Page is Displayed");
        // select doctor specialization
        wDU.selectElementByText(aADP.getDoctorSpecializationDrpDwn(), doctorSpecialization);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Specialization is Selected");
        // enter doctor name
        aADP.getDoctorNameTxtFld().sendKeys(doctorName);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Name is Entered");
        // doctor clinic address
        aADP.getDoctorClinicAddressTxtFld().sendKeys(doctorClinicAddress);
        ThreadLocalUtility.getTest().log(Status.INFO,"Add Doctor Page is Displayed");
        // enter doctor fees
        aADP.getDoctorFeesTxtFld().sendKeys(doctorFees);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Fees Is Entered");
        // enter doctor contact number
        aADP.getDoctorContactTxtFld().sendKeys(doctorContact);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Contact is Entered");
        // enter doctor email
        aADP.getDoctorEmailTxtFld().sendKeys(doctorEmail);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Contact is Entered");
        // enter new password
        aADP.getNewPasswordTxtFld().sendKeys(doctorPassword);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor New Password is Entered");
        // enter confirm password
        aADP.getConfirmPasswordTxtFld().sendKeys(doctorPassword);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Confirm Password is Entered");
        // click on submit button
        aADP.getSubmitBtn().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Submit Button is Clicked");
        // wait for the alert
        wDU.waitForAlert();
        ThreadLocalUtility.getTest().log(Status.INFO,"Wait for Alert to Appear");
        // handle the alert
        wDU.acceptAlert();
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor created, Alert is Handled");
        // logout as admin
        aDP.logoutAsAdmin();
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged Out as Admin");
        // open doctor login page
        wDU.openUrl(doctorLoginPageUrl);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Login Page is Displayed");
        // login as doctor
        dLP.loginAsDoctor(doctorEmail,doctorPassword);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Dashboard Page is Displayed");
        // verifying the doctor dashboard page
        String pageTitle= wDU.getPageTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle,"Doctor | Dashboard");
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Dashboard Page is Verified");
        // logout as doctor
        dDP.logoutAsDoctor();
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged Out as Doctor");
    }
    @Test(groups = "system")
    public  void verifyPatientMedicalHistoryTest() {
        // test data
        String patientName=eU.getExcelData("Sheet1",16,1)+randomNumber;
        String patientContact=eU.getExcelData("Sheet1",17,1)+randomNumber;
        String patientEmail=patientName+"@gmail.com";
        String patientAddress=eU.getExcelData("Sheet1",18,1);
        String patientAge=eU.getExcelData("Sheet1",19,1);
        String medicalHistory=eU.getExcelData("Sheet1",17,1);
        String doctorEmail=eU.getExcelData("Sheet1",21,1);
        String doctorPassword=eU.getExcelData("Sheet1",21,3);
        String adminEmail=eU.getExcelData("Sheet1",22,1);
        String adminPassword=eU.getExcelData("Sheet1",22,3);
        // open doctor login page
        wDU.openUrl(doctorLoginPageUrl);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Login Page is Displayed");
        // login as doctor
        dLP.loginAsDoctor(doctorEmail,doctorPassword);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Dashboard Page is Displayed");
        // click on patient tab
        dDP.getPatientsTab().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Patients Tab is Clicked");
        // click on add Patient
        dDP.getAddPatientLink().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Add Patient Link is Clicked");
        // enter patient name
        dAPP.getPatientNameTxtFld().sendKeys(patientName);
        ThreadLocalUtility.getTest().log(Status.INFO,"Patient Name is Entered");
        // enter patient contact
        dAPP.getPatientContactTxtFld().sendKeys(patientContact);
        ThreadLocalUtility.getTest().log(Status.INFO,"Patient Contact is Entered");
        // enter patient email
        dAPP.getPatientEmailTxtFld().sendKeys(patientEmail);
        ThreadLocalUtility.getTest().log(Status.INFO,"Patient Email is Entered");
        // scroll the page
        wDU.scrollPageByAmount500();
        ThreadLocalUtility.getTest().log(Status.INFO,"Page is Scroll by Amount 500");
        // wait for radio button to be clickable
        wDU.waitForElementToBeClickable(dAPP.getMaleRdoBtn());
        ThreadLocalUtility.getTest().log(Status.INFO,"Wait for Radio Button to be Clickable");
        // gender radio button is clicked
        dAPP.getMaleRdoBtn().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Patient Gender Radio Button is Clicked");
        // enter patient address
        dAPP.getPatientAddressTxtFld().sendKeys(patientAddress);
        ThreadLocalUtility.getTest().log(Status.INFO,"Patient Address is Entered");
        // enter patient age
        dAPP.getPatientAgeTxtFld().sendKeys(patientAge);
        ThreadLocalUtility.getTest().log(Status.INFO,"Patient Age is Entered");
        // enter patient medical history
        dAPP.getMedicalHistoryTxtFld().sendKeys(medicalHistory);
        ThreadLocalUtility.getTest().log(Status.INFO,"Patient Medical History is Entered");
        // click on add button
        wDU.moveToElementAndClick(dAPP.getAddBtn());
        ThreadLocalUtility.getTest().log(Status.INFO,"Add Button is Clicked");
        // logout as doctor
        dDP.logoutAsDoctor();
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged Out as Doctor");
        // open admin log in page
        wDU.openUrl(adminLoginPageUrl);
        ThreadLocalUtility.getTest().log(Status.INFO,"Admin Login Page is Displayed");
        // log in as admin
        aLP.loginAsAdmin(adminEmail,adminPassword);
        ThreadLocalUtility.getTest().log(Status.INFO,"Admin Dashboard Page is Displayed");
        // click on patients tab
        aDP.getPatientsTab().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Patients Tab is Clicked");
        // click on manage patients link
        aDP.getManagePatientsLink().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Manage Patients Link is Clicked");
        // dynamic web element
        WebElement patientNameInList=ThreadLocalUtility.getDriver().findElement(By.xpath("//table[@class='table table-hover']/tbody/tr//td[text()='"+patientName+"']"));
        String patientNameInListText=patientNameInList.getText();
        Assert.assertEquals(patientNameInListText,patientName);
        ThreadLocalUtility.getTest().log(Status.INFO,"Patient name is Verified");
        // log out as admin
        aDP.logoutAsAdmin();
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged Out as Admin");

    }
}











