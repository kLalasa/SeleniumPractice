package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab010 {
   //@Test
    public  void  Test() throws InterruptedException{
        EdgeDriver driver;
        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver= new EdgeDriver(edgeOptions);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("qa jobs in Bangalore", Keys.ENTER);
        String expectedTitle= "qa jobs in Bangalore - Google Searchh";
        String actualTitle= driver.getTitle();
        //Assert.assertEquals(actualTitle,expectedTitle);
       // Assert.assertTrue(actualTitle.contains(expectedTitle));
        Assert.assertEquals(actualTitle,expectedTitle,"Title is mismatched");


        driver.quit();







    }
    @Test

    public void FacebookTest()throws InterruptedException{
        EdgeDriver driver;
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver=new EdgeDriver(edgeOptions);
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        WebElement element=driver.findElement(By.id("email"));
        element.clear();
        element.sendKeys("abc", Keys.ENTER);
        Thread.sleep(1000);

        SoftAssert softAssert=new SoftAssert();

        String actualTitle= driver.getTitle();
        String expectedTitle= "Log in to Facebook";
        softAssert.assertEquals(actualTitle,expectedTitle,"Title mismatched");

        String actualURL= driver.getCurrentUrl();
        String expectedURL="https://www.facebook.com/56";
        softAssert.assertEquals(actualURL,expectedURL,"URL mismatched");

        String actualText=driver.findElement(By.name("email")).getAttribute("value");
        String expectedText="";
        softAssert.assertEquals(actualText,expectedText,"text mismatched");

        String actualBorder=driver.findElement(By.name("email")).getCssValue("border");
        String expectedBorder="1px solid rgb(240, 40, 73)";
        softAssert.assertEquals(actualBorder,expectedBorder,"Username text mismatched");

        String actualErrMsg= driver.findElement(By.xpath("//div[@id='email_container']/div[2]")).getText();
        String expectedErrMsg="The emails address or mobile number you entered isn't connected to an account";
        softAssert.assertEquals(actualErrMsg,expectedErrMsg,"Err Msg mismatched");
        softAssert.assertAll();






        driver.quit();
    }



}

