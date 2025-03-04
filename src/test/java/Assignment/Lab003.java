package Assignment;


import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Lab003 {
    EdgeDriver driver;
   @BeforeTest


    public  void openBrowser(){

       EdgeOptions edgeOptions=new EdgeOptions();
       edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
       edgeOptions.addArguments("--guest");
       driver=new EdgeDriver(edgeOptions);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


   }
   @Test

    public void test_pagination()throws  InterruptedException{

       driver.get("https://testautomationpractice.blogspot.com/");
       driver.manage().window().maximize();

      int pages= driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();

        System.out.println("No of pages"  +pages);

        for(int p=1; p<=pages;p++){

            if(p>1){

                WebElement page_no=driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()="+p+"]"));
                page_no.click();
                Thread.sleep(10);
            }
        }


    }


    @AfterTest
    public void closeBrowser(){driver.quit();

    }




}
