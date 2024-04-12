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

public class Lab002 {


    EdgeDriver driver;
    @BeforeTest

    public void openBrowser(){


        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver= new EdgeDriver(edgeOptions);

    }
    @Test
    public void testPositive ()throws InterruptedException{
        String URL="https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        driver.manage().window().maximize();

        //document.querySelector("div#userName").shadowRoot.querySelector("div").shadowRoot.querySelector("input#pizza")

        JavascriptExecutor js = (JavascriptExecutor) driver;


        //Javascript Code -  document.querySelector("div#userName").shadowRoot.querySelector("div").shadowRoot.querySelector("input#pizza")


        WebElement divScrollTo = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);",divScrollTo);

        Thread.sleep(3000);


        WebElement inputboxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
        inputboxPizza.sendKeys("Farmhouse");

        Thread.sleep(13000);






    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
