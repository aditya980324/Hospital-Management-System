import com.aventstack.extentreports.Status;
import hc.hms.base.HMSBase;
import hc.hms.thread.ThreadLocalUtilty;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(hc.hms.listeners.ListenerUtility.class)
public class DoctorTest extends HMSBase {
    @Test(groups = "integration")
    public void cancelAppointmentTest() {
        // test data
        String doctorEmail=eU.getExcelData("Sheet1",6,1);
        String doctorPassword=eU.getExcelData("Sheet1",6,4);
        //click on doctor login page
        wDU.openUrl(doctorLoginPageUrl);
        ThreadLocalUtilty.getTest().log(Status.INFO,"Doctor Login Page is Displayed");
        // doctor login method
        dLP.loginAsDoctor(doctorEmail,doctorPassword);
        ThreadLocalUtilty.getTest().log(Status.INFO,"Logged In as Doctor");
        // navigate to appointment history
        dDP.getAppointmentHistoryLink().click();
        ThreadLocalUtilty.getTest().log(Status.INFO,"Appointment History Page is Displayed");
        // click on cancel button
        dAHP.getAppointmentCancelBtn().click();
        ThreadLocalUtilty.getTest().log(Status.INFO,"Appointment Cancel Button is Clicked");
        // wait for alert
        wDU.waitForAlert();
        ThreadLocalUtilty.getTest().log(Status.INFO,"Wait for Alert");
        // handle the alert
        wDU.acceptAlert();
        ThreadLocalUtilty.getTest().log(Status.INFO,"Confirmation Alert is Accepted");
        // verify the msg
        String msg = dAHP.getAppointmentCancellationText().getText();
        Assert.assertEquals(msg,"Appointment canceled !!");
        ThreadLocalUtilty.getTest().log(Status.INFO,"Appointment Confirmation Message is Verified");
        // logout as doctor
        dDP.logoutAsDoctor();
        ThreadLocalUtilty.getTest().log(Status.INFO,"Logged Out as Doctor");
    }
    @Test(groups = "smoke")
    public void doctorLoginFunctionalityTest() {
        // test data
        String doctorEmail=eU.getExcelData("Sheet1",6,1);
        String doctorPassword=eU.getExcelData("Sheet1",6,4);
        //click on doctor login page
        wDU.openUrl(doctorLoginPageUrl);
        ThreadLocalUtilty.getTest().log(Status.INFO,"Doctor Login Page is Displayed");
        // doctor login method
        dLP.loginAsDoctor(doctorEmail,doctorPassword);
        ThreadLocalUtilty.getTest().log(Status.INFO,"Logged In as Doctor");
        // logout as doctor
        dDP.logoutAsDoctor();
        ThreadLocalUtilty.getTest().log(Status.INFO,"Logged Out as Doctor");
    }
}
