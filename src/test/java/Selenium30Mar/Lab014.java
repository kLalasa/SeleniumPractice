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

public class Lab014 {
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
        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
        driver.manage().window().maximize();
        WebElement  drp_country= driver.findElement(By.xpath("//select[@id='country-list']"));
        Select drp= new Select(drp_country);
       // drp.selectByVisibleText("Brazil");
       // drp.selectByValue("3");
        //drp.selectByIndex(2);
       // Thread.sleep(2000);
        List<WebElement> options=drp.getOptions();

        System.out.println("no of options " +options.size());

//        for(WebElement op:options){
//
//            System.out.println(op.getText());
//        }

        for(int i=1;i<options.size();i++){
            System.out.println(options.get(i).getText());


        }


    }

    @AfterTest
    public void closeBrowser(){driver.quit();

    }
}
