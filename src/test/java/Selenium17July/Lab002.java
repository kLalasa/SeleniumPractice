package Selenium17July;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab002 {
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

//        driver.findElement(By.xpath("//input[@name='q' and @placeholder='Search store']")).sendKeys("phones");
//        boolean Displayed_Status= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
//        System.out.println(Displayed_Status);
        Thread.sleep(20);

//       String Displayed_status=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText();
//        System.out.println(Displayed_status);

//        String link =driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[3]/a")).getText();
//        System.out.println(link);
            driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("Phones");




    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



}




