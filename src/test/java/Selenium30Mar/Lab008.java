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
import java.util.Set;

public class Lab008 {

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

    public void  testPositive()throws InterruptedException {

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement textbox = driver.findElement(By.xpath("//input[@class='wikipedia-search-input']"));
        textbox.sendKeys("Selenium");

        driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();

        List<WebElement> links=driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"));
        int links_count= links.size();
        System.out.println("Count of the links " +links_count);

        for(WebElement link:links){
            link.click();
        }

        Set<String> WindowHandles=driver.getWindowHandles();
        System.out.println(WindowHandles);

        for(String WindowId:WindowHandles){

            String title= driver.switchTo().window(WindowId).getTitle();
            System.out.println(title);

            if(title.equals("Selenium dioxide - Wikipedia")||title.equals("Selenium - Wikipedia")){
                driver.close();
            }
        }


    }
    @AfterTest


   public void closeBrowser(){driver.quit();

   }

    }

