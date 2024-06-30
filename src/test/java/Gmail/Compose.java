package Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Compose{
         WebDriver driver;

        @BeforeTest
        public void openBrowser() {
            EdgeOptions options = new EdgeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--disable-notifications");
            driver = new EdgeDriver(options);
        }

        @Test
        public void testPositive() {
            String URL = "https://mail.google.com/mail/u/1/#inbox";
            driver.get(URL);
            driver.manage().window().maximize();
            WebElement composeButton = driver.findElement(By.xpath("//div[@role='button' and @gh='cm' and text()='Compose']"));
            composeButton.click();
            // Wait for the compose window to open

            // Enter the recipient email
            WebElement toField = driver.findElement(By.id(":jm"));
            toField.sendKeys("momtesting2@gmail.com");

            // Enter the subject
            WebElement subjectField = driver.findElement(By.name("subjectbox"));
            subjectField.sendKeys("Test Mail");

            // Enter the email body
            WebElement bodyField = driver.findElement(By.xpath("//*[@class='Am Al editable LW-avf tS-tW']"));
            bodyField.sendKeys("Test Email Body");

            // Click the Send button
            WebElement sendButton = driver.findElement(By.xpath("//div[@id=\":fp\"]]"));
            sendButton.click();

        }

        @AfterTest
        public void closeBrowser() {
            if (driver != null) {
                driver.quit();
            }
        }
}