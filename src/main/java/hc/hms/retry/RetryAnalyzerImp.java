package hc.hms.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImp implements IRetryAnalyzer {
    public static int retryCount=0;
    public static final int maxRetryCount=5;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount<maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
