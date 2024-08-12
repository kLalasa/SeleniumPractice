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

public class Lab019 {

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

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        int pages= driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        System.out.println("No of Pages  " +pages);

        for(int p=1;p<=pages;p++) {

            if(p>1){
                WebElement page_no=driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()="+p+"]"));
                page_no.click();
            }

            int rows = driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
           //System.out.println("No of Rows  " + rows);

            for(int r=1;r<rows;r++){

                String ID= driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]/td[1]")).getText();


                String Product_name= driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]/td[2]")).getText();


                String Price= driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]/td[3]")).getText();
                System.out.println(ID +"\t"+Product_name+"\t" +Price);

                WebElement checkbox= driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]/td/input[@type='checkbox']"));

                checkbox.click();

            }

        }

    }

    @AfterTest
    public void closeBrowser(){driver.quit();

    }


}
