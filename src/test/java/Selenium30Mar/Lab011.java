package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab011 {

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

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        WebElement frame1= driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");

        driver.switchTo().defaultContent();
        WebElement frame2= driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Hello");

        driver.switchTo().defaultContent();
        WebElement frame3= driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hi");

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();

//        WebElement rdButton=driver.findElement(By.xpath("//div[@id='18']//div[@class='AB7Lab Id5V1']"));
//        JavascriptExecutor js=(JavascriptExecutor)driver;
//       js.executeScript("arguments[0].click()",rdButton);

        driver.switchTo().defaultContent();
        WebElement frame5= driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        driver.switchTo().frame(frame5);
        driver.findElement(By.xpath("//a[text()='https://a9t9.com']")).click();

        boolean img_status=driver.findElement(By.xpath("//img[@src='/Content/Images/ui.vision.logo2.webp']")).isDisplayed();
        System.out.println(img_status);





    }

    @AfterTest
    public void closeBrowser(){driver.quit();

    }
}
