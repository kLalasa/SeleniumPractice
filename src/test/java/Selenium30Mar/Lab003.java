package Selenium30Mar;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Lab003 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options=new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver=new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(groups = "QA")
    @Description("Test case Description")
    public void testPositive()throws InterruptedException{
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        String windowid=driver.getWindowHandle();
        System.out.println("window ID :" +windowid);


        driver.findElement(By.partialLinkText("OrangeHRM")).click();
        Set<String>windowIds= driver.getWindowHandles();
        System.out.println(windowIds);
}

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



}

