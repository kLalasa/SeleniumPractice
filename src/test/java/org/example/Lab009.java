package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab009 {


        EdgeDriver driver;

        @BeforeTest


        public void openBrowser() {
            EdgeOptions options = new EdgeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new EdgeDriver(options);


        }

        @Test(groups = "QA")
        @Description("Test case description")
        public void testNegative() throws InterruptedException {
            driver.get("https://app.vwo.com/#/login");
            driver.manage().window().maximize();
            // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //Global wait which we dont use

            driver.findElement(By.id("login-username")).sendKeys("contact+atb5x@thetestingacademy.com");
            driver.findElement(By.id("login-password")).sendKeys("ATBx@1234");
            driver.findElement(By.id("js-login-btn")).click();


            Wait<EdgeDriver> wait= new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchFrameException.class);

            WebElement loggedin_username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("[data-qa='lufexuloga']"))));





            System.out.println(loggedin_username.getText());

        }

        @AfterTest
        public void closeBrowser() {
            driver.quit();
        }

    }
