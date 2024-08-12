package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab016 {

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

        driver.get("http://www.google.com");

        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("postman");
        List<WebElement> list= driver.findElements(By.xpath(" // div[@class='mkHrUc']//div[@role='presentation']//li[contains(@class,'sbct')]//span[text()='postman']"));
        System.out.println(list.size());

        for(int i=0;i< list.size();i++){

            System.out.println(list.get(i).getText());

            if(list.get(i).getText().equals("postman")) {
                list.get(i).click();
                Thread.sleep(5000);
                break;
            }

        }

    }


    // div[@class='mkHrUc']//div[@role='presentation']//li[contains(@class,'sbct')]//span[text()='postman']


    @AfterTest
    public void closeBrowser(){driver.quit();

    }
}
