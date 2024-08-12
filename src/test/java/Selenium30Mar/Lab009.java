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

public class Lab009 {

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


    public void positiveTest()throws InterruptedException{

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        List<WebElement> checkboxes= driver.findElements(By.xpath("//input[@class='form-check-input'  and @type='checkbox']"));

//        for(int i=0;i<checkboxes.size();i++){
//
//            checkboxes.get(i).click();
//        }

//        for(WebElement Checkbox:checkboxes)
//            Checkbox.click();

        //Selecting last three checkboxes

//        for(int i=4;i<checkboxes.size();i++){
//
//            checkboxes.get(i).click();
//        }
        //Select first three checkboxes

//        for(int i=0;i<3;i++)
//            checkboxes.get(i).click();

        //Unselect checkbox if thy are selected


        for(int i=0;i<3;i++){

            checkboxes.get(i).click();
        }
        Thread.sleep(5000);

        for(int i=0;i<checkboxes.size();i++) {
            if(checkboxes.get(i).isSelected()) {

                checkboxes.get(i).click();
            }

        }





    }
    @AfterTest
    public void closeBrowser(){driver.quit();

    }

}
