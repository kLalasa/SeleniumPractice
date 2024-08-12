package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab013 {
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

        driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[contains(@class,'multiselect ')]")).click();

        //driver.findElement(By.xpath("//input[@value='Java']")).click();

        List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//li"));
        System.out.println("No of options" +options.size());

//        for(WebElement op:options){
//            System.out.println(op.getText());
//        }

        for(WebElement op:options){

            String option= op.getText();
            if(option.equals("Java")||option.equals("Python")||option.equals("Oracle")){
                op.click();
            }
        }

    }

    @AfterTest
    public void closeBrowser(){driver.quit();

    }
}
