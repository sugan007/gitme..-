package utils;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
    MethodListener.class })
public class dumb {

{
    System.setProperty("atu.reporter.config", "./config/atu.properties");
}

private WebDriver driver;
private String baseUrl;

@BeforeMethod
public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.co.in";
    driver.get(baseUrl + "/");

    // ATU Reports
    ATUReports.setWebDriver(driver);
    ATUReports.indexPageDescription = "Test Project";
}

@Test
public void GoogleTooltip() throws Exception, SQLException {
    Actions ToolTip1 = new Actions(driver);
    WebElement googleLogo = driver.findElement(By
            .xpath("//div[@id='hplogo']"));
    ToolTip1.clickAndHold(googleLogo).perform();
    String ToolTipText = googleLogo.getAttribute("title");
    Assert.assertEquals(ToolTipText, "Google");
    System.out.println("Tooltip value is: " + ToolTipText);
}

// ATU Reports Method
@Test
public void testNewLogs() throws AWTException, IOException {

    ATUReports.add("INfo Step", LogAs.INFO, new CaptureScreen(
            ScreenshotOf.BROWSER_PAGE));
    ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
            ScreenshotOf.DESKTOP));
    WebElement element = driver
            .findElement(By.xpath("/html"));
    ATUReports.add("Warning Step", LogAs.WARNING,
            new CaptureScreen(element));
    ATUReports.add("Fail step", LogAs.FAILED, new CaptureScreen(
            ScreenshotOf.DESKTOP));
}

@AfterMethod
public void tearDown() throws Exception {
    driver.quit();
}
}
