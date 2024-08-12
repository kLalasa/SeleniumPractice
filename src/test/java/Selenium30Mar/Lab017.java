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

public class Lab017 {

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

        int  rows= driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("No of rows: " +rows);

        int coloums= driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println("No of coloums: " +coloums);

        String bookname= driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
        System.out.println("Booknmae:" +bookname);
//
//        for(int r=2;r<=rows;r++){
//
//            for(int c=1;c<=coloums;c++){
//
//                String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td["+c+"]")).getText();
//                System.out.print(value+"\t");
//
//            }
//            System.out.println();
//        }


     /*   for(int r=2;r<=rows;r++){

            String authorname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();

            if(authorname.equals("Mukesh")){
                String book_name=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
                System.out.println(book_name+ "\t" +authorname);
            }
        }*/

        int total=0;
        for(int r=2;r<=rows;r++) {

            String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
            total=total+Integer.parseInt(price);

        }

        System.out.println("total price of books  " +total);

    }

    @AfterTest
    public void closeBrowser(){driver.quit();

    }
}
