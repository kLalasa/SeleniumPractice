package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab001 {
    EdgeDriver driver;
    @BeforeTest

    public void openBrowser(){


        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver= new EdgeDriver(edgeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test

    public void test ()throws InterruptedException{

        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Bhagya");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Lalasa");

        driver.findElement(By.xpath("//input[@id='job-title']")).sendKeys("QA Analyst");
        driver.findElement(By.xpath("//input[@id='radio-button-1']")).click();

        driver.findElement(By.xpath("//input[@id='checkbox-2']")).click();

        WebElement year_dropdown=driver.findElement(By.xpath("//select[@id='select-menu']"));
        Select year_options=new Select(year_dropdown);

        year_options.selectByVisibleText("2-4");

        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("20/11/2024");
        driver.findElement(By.xpath("//a[@role='button']")).click();

        WebElement text=driver.findElement(By.xpath("//div[@class='alert alert-success']"));

        String success= text.getText();

        if(success== " The form was successfully submitted!")
            System.out.println("Form succssfully submitted");
        else
            System.out.println("Form not filled properly");

        Thread.sleep(10);


    }
    @AfterTest

    public void closeBrower(){
        driver.quit();


    }




}
