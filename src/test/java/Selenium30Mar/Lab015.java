package Selenium30Mar;

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
import java.util.List;

public class Lab015 {
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

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement color_options=driver.findElement(By.xpath("//select[@id='colors']"));
        Select drp_options=new Select(color_options);

        //drp_options.selectByVisibleText("Red");
       // drp_options.selectByValue("red");

        List<WebElement>options=drp_options.getOptions();
        System.out.println(options.size());

        for(WebElement op:options){

            System.out.println(op.getText());

            if(op.equals("Red")||op.equals("blue")){
                op.click();
            }
        }



    }
    @AfterTest
    public void closeBrowser(){driver.quit();

    }
}
