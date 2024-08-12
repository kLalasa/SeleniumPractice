package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab012 {


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

        WebElement drp_Country=driver.findElement(By.xpath("//select[@id='country']"));
        Select drp=new Select(drp_Country);
       // drp.selectByVisibleText("United Kingdom");
        //drp.selectByValue("usa");
        //drp.selectByIndex(1);

        List<WebElement> options=drp.getOptions();

        System.out.println("No.of Options in dropdown" +options.size());

//        for(int i=0;i<options.size();i++){
//
//            System.out.println(options.get(i).getText());
//        }

        for(WebElement op:options){
            System.out.println(op.getText());
        }


    }

    @AfterTest
    public void closeBrowser(){driver.quit();

    }
}
