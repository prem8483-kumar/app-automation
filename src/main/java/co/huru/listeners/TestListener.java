package co.huru.listeners;

import com.epam.reportportal.service.ReportPortal;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class TestListener implements ITestListener {

    private static final Logger log = LogManager.getLogger(TestListener.class);
    AppiumDriver driver;

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

        log.info("Test Failed, Capturing Screenshot");

        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {

            //push screenshot to report portal

            //String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            //LoggingUtils.log(screenshotBase64, "Screenshot attached");

            //ReportPortalMessage message = new ReportPortalMessage(screenshotFile, "Screenshot attached");
            //log.info(message);

            ReportPortal.emitLog("Screenshot attached", "INFO", Calendar.getInstance().getTime(), screenshotFile);

            //store screenshot locally
            File destinationFile = new File(System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png");
            if(destinationFile.exists()) {
                destinationFile.delete();
            }
            FileUtils.copyFile(screenshotFile, destinationFile);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }


    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }
}
