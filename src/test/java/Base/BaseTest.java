package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    public WebDriver driver;
    public static ExtentReports extent;
    public ExtentTest test;
    public ExtentSparkReporter reporter;

    @BeforeSuite
    public void setupExtentReport() {
        reporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "extentReport" + File.separator + "report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Initialize logger
        String testName = getClass().getSimpleName(); // Append thread ID to differentiate tests in report
        test = extent.createTest(testName);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Take screenshot
            String screenshotPath = null;
            try {
                screenshotPath = takeScreenshot(result.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (screenshotPath != null) {
                System.out.println("HI" + screenshotPath);
                System.out.println("Hello" + (takeScreenshot(result.getMethod().getMethodName())));
                test.log(Status.FAIL, "Test Case Failed is " + result.getName());

                // get path of captured screenshot using custom failedTCTakeScreenshot method
                try {
                    // Attach screenshot to the Extent report
                    test.fail(result.getThrowable().getMessage(),
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                extent.flush();
            }
            if (driver != null) {
                driver.quit();
            }
        }


    }

    // Method to take a screenshot
    private String takeScreenshot(String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + testName + "_" + timeStamp + ".png";
        Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
        return screenshotPath;
    }

    // Method to retrieve WebDriver instance
    public WebDriver getDriver() {
        return driver;
    }

    @AfterSuite
    public void tearDownExtentReport() {
        extent.flush();
    }
}
