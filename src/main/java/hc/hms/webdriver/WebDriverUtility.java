package hc.hms.webdriver;

import hc.hms.thread.ThreadLocalUtilty;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtility {
    private WebDriver driver;
    Actions act;
    Select select=null;
    WebDriverWait wait;
    Alert alert;
    JavascriptExecutor js;
    public WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--disable-notifications-");
            driver=new ChromeDriver(opt);
        }
        else if (browser.equalsIgnoreCase("firefox"))
            driver=new FirefoxDriver();
        else if (browser.equalsIgnoreCase("edge")){
            EdgeOptions opt = new EdgeOptions();
            opt.addArguments("--disable-notifications-");
            driver=new EdgeDriver(opt);
        }
        else if (browser.equalsIgnoreCase("internet explorer"))
            driver=new InternetExplorerDriver();
        else {
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--disable-notifications-");
            driver=new ChromeDriver(opt);
        }
        ThreadLocalUtilty.setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        act=new Actions(driver);
        wait=new WebDriverWait(driver,Duration.ofSeconds(12));
        js=(JavascriptExecutor) driver;
        return driver;
    }
    public void openUrl(String url) {
        driver.get(url);
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public void moveToElementAndClick(WebElement element) {
        act.moveToElement(element).click().perform();
    }
    public void selectElementByText(WebElement element,String text) {
        select = new Select(element);
        select.selectByVisibleText(text);
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    public void waitForAlert() {
        alert = wait.until(ExpectedConditions.alertIsPresent());
    }
    public void closeBrowser() {
        driver.close();
    }
    public void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }
    public void scrollPageByAmount500() {
        act.scrollByAmount(0,500).perform();
    }
}
















