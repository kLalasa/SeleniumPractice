package Selenium17July;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab001 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options=new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver=new EdgeDriver(options);

    }
    @Test(groups = "QA")
    @Description("Test case Description")
    public void testPositive()throws InterruptedException{
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
//        WebElement element=driver.findElement(By.name("q"));
//        element.sendKeys("Tshirts");
//        Thread.sleep(10000);
//        WebElement element1=driver.findElement(By.xpath("//button[@type='submit']"));
//        element1.click();

//            driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Mobile phones");
//            driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirts");
//            Thread.sleep(100);


//        driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-shirts");
//        driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-shirts");


//          driver.findElement(By.cssSelector("input[placeholder=\"Search store\"]")).sendKeys("T-shirts");
//             driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("T-shirts");
//
//             driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("T-shirts");
             driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("T-shirts");


    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



}


