package hc.hms.thread;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ThreadLocalUtilty {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
        if (driver==null)
            System.out.println("static driver is not initialized");
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
        if (test==null)
            System.out.println("static test is not initialized");
    }
}
