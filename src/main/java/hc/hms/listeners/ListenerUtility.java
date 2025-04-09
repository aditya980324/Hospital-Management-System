package hc.hms.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import hc.hms.thread.ThreadLocalUtilty;
import hc.hms.webdriver.WebDriverUtility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerUtility implements ITestListener, ISuiteListener {
    public ExtentSparkReporter spark;
    public ExtentTest test;
    public static ExtentReports report;
    String timeStamp;
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onStart(ISuite suite) {
        String title = suite.getName();
        timeStamp = new SimpleDateFormat("HH-mm_dd-MM-yyyy").format(new Date());
        String path = "./advanceReports/"+title+"_"+timeStamp+".html";
        spark = new ExtentSparkReporter(path);
        report = new ExtentReports();
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Hospital Management System Automation Test Reports");
        spark.config().setReportName("Hospital Management System - UI Test Results");
        spark.config().setEncoding("utf-8");
        report.attachReporter(spark);
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
        String testName= result.getMethod().getMethodName();
        test= report.createTest(testName, result.id());
        test.log(Status.INFO,testName+" is started");
        ThreadLocalUtilty.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        test.log(Status.PASS,testName+" is Passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String element = result.getInstanceName();
        String testName = result.getMethod().getMethodName();
        test.log(Status.FAIL,testName+" is Failed");
        WebDriver pdriver = ThreadLocalUtilty.getDriver();
        TakesScreenshot ts = (TakesScreenshot) pdriver;
        String src = ts.getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(src,element);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        test.log(Status.SKIP,testName+" is Skipped.");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
