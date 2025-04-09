package hc.hms.thread;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ThreadLocalUtility {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // WebDriver
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void removeDriver() {
        driver.remove();
    }

    // ExtentTest
    public static ExtentTest getTest() {
        return test.get();
    }

    public static void setTest(ExtentTest extentTestInstance) {
        test.set(extentTestInstance);
    }

    public static void removeTest() {
        test.remove();
    }

    // Clear all
    public static void clearAll() {
        removeDriver();
        removeTest();
    }
}
