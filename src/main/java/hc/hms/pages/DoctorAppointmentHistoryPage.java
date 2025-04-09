package hc.hms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorAppointmentHistoryPage {
    private WebDriver driver;

    public DoctorAppointmentHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@title='Cancel Appointment']")
    private WebElement appointmentCancelBtn;
    @FindBy(xpath = "//p[contains(.,'Appointment canceled !!')]")
    private WebElement appointmentCancellationText;

    public WebElement getAppointmentCancellationText() {
        return appointmentCancellationText;
    }

    public WebElement getAppointmentCancelBtn() {
        return appointmentCancelBtn;
    }
}
