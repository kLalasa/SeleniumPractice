package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import  java.util.List;
public class Lab006 {

    EdgeDriver driver;
    @BeforeTest

    public void openBrowser(){
        EdgeOptions options=new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new EdgeDriver(options);
    }
    @Test(groups = "QA")
    @Description("Testcase description")
    public void testPositive()throws InterruptedException{
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        driver.manage().window().maximize();
        WebElement searchbox=driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchbox.sendKeys("macmini");
        WebElement searchboxButton=driver.findElement(By.cssSelector("input[value='Search']"));
        searchboxButton.click();
        Thread.sleep(3000);
        List<WebElement>searchtitles=driver.findElements(By.className("s-item__title"));
        int i=0;
        for (WebElement titles:searchtitles){
            System.out.println(titles.getText());
            if(i==10){
                titles.click();
            }
            i++;
        }


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
