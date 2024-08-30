package Selenium30Mar;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Lab037 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Taking screenshot for full page
//        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
//
//        driver.manage().window().maximize();
//
//        TakesScreenshot ts= (TakesScreenshot) driver;
//        File sourcefile=ts.getScreenshotAs(OutputType.FILE);
//        File targetfile=new File(System.getProperty("user.dir")+"\\src\\test\\java\\Screenshots\\fullpage.png");
//        sourcefile.renameTo(targetfile);

        //capture the screenshot of a specific section


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement OrangeHRM_logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
        File sourcefile= OrangeHRM_logo.getScreenshotAs(OutputType.FILE);
        File targetfile=new File(System.getProperty("user.dir")+"\\src\\test\\java\\Screenshots\\logo.png");

        sourcefile.renameTo(targetfile);
        driver.quit();

    }
}
