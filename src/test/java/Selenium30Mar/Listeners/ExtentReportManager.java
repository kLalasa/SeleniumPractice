package Selenium30Mar.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;


    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/myreport.html");
        sparkReporter.config().setDocumentTitle("Automation report");
        sparkReporter.config().setReportName("Functional testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("ComputerName", "Localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("TesterName" ,"Lalasa");
        extent.setSystemInfo("OS","Windows10");
        extent.setSystemInfo("BrowserName","Chrome");
    }

    public void onTestSuccess(ITestResult result){

        test= extent.createTest(result.getName());
        test.log(Status.PASS,"Test case passed is:"+result.getName());
    }

    public void onTestFailure(ITestResult result){

        test=extent.createTest(result.getName());
        test.log(Status.FAIL,"Test case failed is:"+result.getName());
        test.log(Status.FAIL,"Test case failed cause is:"+result.getThrowable());
    }

    public void onTestSkipped(ITestResult result){

        test= extent.createTest(result.getName());
        test.log(Status.SKIP,"Test case skipped is:"+result.getName());

    }

    public void onFinish(ITestContext context){
        extent.flush();
    }

}
