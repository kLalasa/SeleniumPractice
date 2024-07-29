package Selenium30Mar;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Lab006 {

    EdgeDriver driver;
    @BeforeTest

    public void openBorwser(){
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver=new EdgeDriver(edgeOptions);


    }
    @Test

    public void testPositive() throws InterruptedException, MalformedURLException {

       // driver.get("https://demo.nopcommerce.com");
       // driver.navigate().to("https://demo.nopcommerce.com/");
//        URL myurl=new URL("https://demo.nopcommerce.com/");
//        driver.navigate().to(myurl);
        driver.get("https://demo.nopcommerce.com");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());




    }
    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }
}
