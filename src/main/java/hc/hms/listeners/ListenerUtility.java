package hc.hms.listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import hc.hms.thread.ThreadLocalUtility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerUtility implements ITestListener, ISuiteListener {

    private static ExtentReports report;
    private static ExtentSparkReporter spark;

    @Override
    public void onStart(ISuite suite) {
        String suiteName = suite.getName();
        String timeStamp = new SimpleDateFormat("HH-mm_dd-MM-yyyy").format(new Date());
        String path = "./advanceReports/" + suiteName + "_" + timeStamp + ".html";

        spark = new ExtentSparkReporter(path);
        report = new ExtentReports();
        report.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Hospital Management System Automation Test Reports");
        spark.config().setReportName("Hospital Management System - UI Test Results");
        spark.config().setEncoding("utf-8");

        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Tester", "Aditya Goswami");
        report.setSystemInfo("Environment", "QA Server");
    }

    @Override
    public void onFinish(ISuite suite) {
        report.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();

        // Get browser from ITestContext or parameters
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        ExtentTest test = report.createTest(testName + " [" + browser + "]", description);

        test.log(Status.INFO, "Test started on browser: " + browser);
        ThreadLocalUtility.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ThreadLocalUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " is Passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ThreadLocalUtility.getTest();
        WebDriver driver = ThreadLocalUtility.getDriver();

        String testName = result.getMethod().getMethodName();
        test.log(Status.FAIL, testName + " is Failed");
        test.log(Status.FAIL, result.getThrowable());

        if (driver != null) {
            String src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            test.addScreenCaptureFromBase64String(src, testName);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ThreadLocalUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " is Skipped.");
    }

    // Optional overrides
    @Override public void onTestFailedWithTimeout(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}
