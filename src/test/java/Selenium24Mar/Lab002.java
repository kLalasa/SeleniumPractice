package Selenium24Mar;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab002 {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){

        EdgeOptions options=new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver=new EdgeDriver(options);
    }
    @Test
    @Description("Testcase description")


    public void testPositive(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        WebElement element=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        element.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert= driver.switchTo().alert();
        alert.accept();


        String result=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");

    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
