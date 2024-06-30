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

public class Login {

    private WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--disable-notifications");
        driver = new EdgeDriver(options);
    }

    @Test(alwaysRun = true)
    public void Task1() {
        String URL = "https://accounts.google.com/v3/signin/identifier?hl=en-gb&ifkv=" +
                "AS5LTASoWJO4zSciCfSBLlrlFJpmGoaKc5PwujosUATVtFvp_H6nkIPwjIRRsDzuVF82LYxohpi9mA&ddm=0&flowName=" +
                "GlifWebSignIn&flowEntry=ServiceLogin&continue=https%3A%2F%2Faccounts.google.com%2FManageAccount%3Fnc%3D1";
        driver.get(URL);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Enter the email
        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));
        emailInput.sendKeys("momtesting2@gmail.com");

//        WebElement Gmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@jsname='V67aGc' and @data-text='Gmail' and @class='Rq5Gcb']")));
//        Gmail.click();



        WebElement identifierNextButton = driver.findElement(By.id("identifierNext"));
        identifierNextButton.click();

        System.out.println("Enter Password");

        // Wait for the password field to be present
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Passwd")));
        passwordInput.sendKeys("Vishnu09#");

        WebElement passwordNextButton = driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d' and text()='Next']"));
        passwordNextButton.click();

        WebElement Google_Apps=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='gb_d']")));
        Google_Apps.click();

        WebElement Gmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@jsname='V67aGc' and @data-text='Gmail' and @class='Rq5Gcb']")));
        Gmail.click();


        // Add further steps to compose and send the email as described earlier

        // Optional: wait for inbox to load to confirm login
        wait.until(ExpectedConditions.titleContains("Inbox"));
    }
    @Test
    public void Task2() {
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