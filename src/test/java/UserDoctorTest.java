import com.aventstack.extentreports.Status;
import hc.hms.base.HMSBase;
import hc.hms.thread.ThreadLocalUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(hc.hms.listeners.ListenerUtility.class)
public class UserDoctorTest extends HMSBase {
    @Test(groups = "system")
    public void verifyBookAppointmentTest() {
        // test data
        String userEmail=eU.getExcelData("Sheet1",1,1);
        String userPassword=eU.getExcelData("Sheet1",1,4);
        String doctorSpecialization=eU.getExcelData("Sheet1",2,1);
        String doctorName=eU.getExcelData("Sheet1",3,1);
        String date=eU.getExcelData("Sheet1",4,1);
        String time=eU.getExcelData("Sheet1",5,1);
        String doctorEmail=eU.getExcelData("Sheet1",6,1);
        String doctorPassword=eU.getExcelData("Sheet1",6,4);
        // open user login page
        wDU.openUrl(patientLoginUrl);
        ThreadLocalUtility.getTest().log(Status.INFO,"User Login Page is Displayed");
        // login as user
        pLP.loginAsUser(userEmail,userPassword);
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged In as User");
        // click on book appointment link
        uDP.getBookAppointmentLink().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Book Appointments Page is Displayed");
        // select doctors specialization
        wDU.selectElementByText(uBAP.getDoctorSpecializationDrpDwn(),doctorSpecialization);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Specialization is Selected");
        // select the doctor of the specialization
        wDU.selectElementByText(uBAP.getDoctorsDrpDwn(),doctorName);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Name is Selected");
        // enter the date
        uBAP.getDateTxtFld().sendKeys(date);
        ThreadLocalUtility.getTest().log(Status.INFO,"Date is Entered in Date TextField");
        // clear the time text field
        uBAP.getTimeTxtFld().clear();
        ThreadLocalUtility.getTest().log(Status.INFO,"Time TextField is Cleared");
        // enter the time
        uBAP.getTimeTxtFld().sendKeys(time);
        ThreadLocalUtility.getTest().log(Status.INFO,"Time is Entered in Time TextField");
        // click on submit button
        uBAP.getSubmitBtn().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Submit Button is Clicked");
        // wait for alert
        wDU.waitForAlert();
        ThreadLocalUtility.getTest().log(Status.INFO,"Wait for Alert");
        // handle alert
        wDU.acceptAlert();
        ThreadLocalUtility.getTest().log(Status.INFO,"Alert is Handled");
        // logout as user
        uDP.logoutAsUser();
        ThreadLocalUtility.getTest().log(Status.INFO,"Logout as User");
        //click on doctor login page
        wDU.openUrl(doctorLoginPageUrl);
        ThreadLocalUtility.getTest().log(Status.INFO,"Doctor Login Page is Displayed");
        // doctor login method
        dLP.loginAsDoctor(doctorEmail,doctorPassword);
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged In as Doctor");
        // navigate to appointment history
        dDP.getAppointmentHistoryLink().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Appointment History Page is Displayed");
        // verify the appointment history
        WebElement appointmentName =ThreadLocalUtility.getDriver().findElement(By.xpath("//th[text()='Patient  Name']/../../following-sibling::tbody//td[text()='forgot']"));
        String appointmentNameText= appointmentName.getText();
        Assert.assertEquals(appointmentNameText,"forgot");
        // logout as doctor
        dDP.logoutAsDoctor();
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged Out as Doctor");
    }

}
