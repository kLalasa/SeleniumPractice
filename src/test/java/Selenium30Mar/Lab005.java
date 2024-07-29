package Selenium30Mar;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.function.Function;

import java.time.Duration;

public class Lab005 {

        EdgeDriver driver;
        Wait<WebDriver> wait;
    @BeforeTest

        public void openBrowser(){
        EdgeOptions options=new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver=new EdgeDriver(options);
         wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(30L))
                    .pollingEvery(Duration.ofSeconds(5L))
                    .ignoring(NoSuchElementException.class);

        }
        @Test

        public void testPositive() throws InterruptedException{

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

            WebElement txtUsername = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath("//input[@placeholder='Username']"));
                }
                });
            txtUsername.sendKeys("Admin");



        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
        @AfterTest
        public void closeBrowser(){
        driver.quit();
    }

    }


