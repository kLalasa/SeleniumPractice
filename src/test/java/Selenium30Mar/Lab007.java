package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lab007 {


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
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        Set<String>WindowHandles= driver.getWindowHandles();
//        List<String>WindowIDs=new ArrayList<String>(WindowHandles);
//
//        String Parent=WindowIDs.get(0);
//        String Child=WindowIDs.get(1);
//
//        driver.switchTo().window(Child);
//        System.out.println(driver.getTitle());
//
//        driver.switchTo().window(Parent);
//        System.out.println(driver.getTitle());

        for(String WindowIds:WindowHandles){
            String title= driver.switchTo().window(WindowIds).getTitle();
            System.out.println(title);
            if(title.equals("OrangeHRM")){
                driver.close();
            }


        }




    }
    @AfterTest

    public void closeBrowser(){
        driver.quit();
    }
}
