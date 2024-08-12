package Selenium30Mar;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab010 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver=new EdgeDriver(edgeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void testPositive()throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.manage().window().maximize();

//        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//        Thread.sleep(5000);
//        Alert alert=driver.switchTo().alert();
//
//        System.out.println(alert.getText());
//        alert.accept();
        //To cancel the alert

        //driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Alert myalert=driver.switchTo().alert();
        myalert.sendKeys("Welcome");
        myalert.accept();

        WebElement Result= driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println("Entered Text is" +Result.getText());
    }

    @AfterTest
    public void closeBrowser(){driver.quit();

    }
}
