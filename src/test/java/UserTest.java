import com.aventstack.extentreports.Status;
import hc.hms.base.HMSBase;
import hc.hms.thread.ThreadLocalUtility;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(hc.hms.listeners.ListenerUtility.class)
public class UserTest extends HMSBase {

    @Test(groups = "integration")
    public void bookAppointmentTest() {
        // test data
        String userEmail=eU.getExcelData("Sheet1",1,1);
        String userPassword=eU.getExcelData("Sheet1",1,4);
        String doctorSpecialization=eU.getExcelData("Sheet1",2,1);
        String doctorName=eU.getExcelData("Sheet1",3,1);
        String date=eU.getExcelData("Sheet1",4,1);
        String time=eU.getExcelData("Sheet1",5,1);
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
        // verify the alert text
        String text= wDU.getAlertText();
        Assert.assertEquals(text,"Your appointment successfully booked");
        ThreadLocalUtility.getTest().log(Status.INFO,"Alert Text is Verified");
        // handle the alert
        wDU.acceptAlert();
        ThreadLocalUtility.getTest().log(Status.INFO,"Alert is Handled");
        // logout as user
        uDP.logoutAsUser();
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged Out as User");
    }
    @Test(groups = "integration")
    public void appointmentHistoryTest() {
        // test data
        String userEmail=eU.getExcelData("Sheet1",1,1);
        String userPassword=eU.getExcelData("Sheet1",1,4);
        String doctorSpecialization=eU.getExcelData("Sheet1",2,1);
        String doctorName=eU.getExcelData("Sheet1",3,1);
        String date=eU.getExcelData("Sheet1",4,1);
        String time=eU.getExcelData("Sheet1",5,1);
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
        // handle the alert
        wDU.acceptAlert();
        ThreadLocalUtility.getTest().log(Status.INFO,"Alert is Handled");
        // click on appointment history
        uDP.getAppointmentHistoryLink().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Appointment History Page is Displayed");
        // verify the appointment history
        String appointmentListText=uAHP.getAppointmentHistoryList().getText();
        Assert.assertEquals(appointmentListText,"Active");
        ThreadLocalUtility.getTest().log(Status.INFO,"Appointment History Page is Verified");
        // logout as user
        uDP.logoutAsUser();
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged Out as User");
    }
    @Test(groups = "integration")
    public void cancelAppointmentTest() {
        // test data
        String userEmail=eU.getExcelData("Sheet1",1,1);
        String userPassword=eU.getExcelData("Sheet1",1,4);
        // open user login page
        wDU.openUrl(patientLoginUrl);
        ThreadLocalUtility.getTest().log(Status.INFO,"User Login Page is Displayed");
        // login as user
        pLP.loginAsUser(userEmail,userPassword);
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged In as User");
        // click on appointment history
        uDP.getAppointmentHistoryLink().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Appointment History Page is Displayed");
        // cancel an appointment
        uAHP.getCancelButton().click();
        ThreadLocalUtility.getTest().log(Status.INFO,"Cancel an Appointment");
        // wait for alert
        wDU.waitForAlert();
        ThreadLocalUtility.getTest().log(Status.INFO,"Wait for Alert");
        // handle the alert
        wDU.acceptAlert();
        ThreadLocalUtility.getTest().log(Status.INFO,"Confirmation Alert is Accepted");
        // verify the cancellation message
        String msg=uAHP.getAppointmentCancellationText().getText();
        Assert.assertEquals(msg,"Your appointment canceled !!");
        ThreadLocalUtility.getTest().log(Status.INFO,"Appointment Confirmation Message is Verified");
        // logout as user
        uDP.logoutAsUser();
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged Out as User");
    }
    @Test(groups = "smoke")
    public void userLoginFunctionalityTest() {
        // test data
        String userEmail=eU.getExcelData("Sheet1",1,1);
        String userPassword=eU.getExcelData("Sheet1",1,4);
        // open user login page
        wDU.openUrl(patientLoginUrl);
        ThreadLocalUtility.getTest().log(Status.INFO,"User Login Page is Displayed");
        // login as user
        pLP.loginAsUser(userEmail,userPassword);
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged In as User");
        // logout as user
        uDP.logoutAsUser();
        ThreadLocalUtility.getTest().log(Status.INFO,"Logged Out as User");
    }
}
