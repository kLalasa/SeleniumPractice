package Selenium24Mar;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab001 {
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
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        WebElement element=driver.findElement(By.id("dropdown"));

        Select select=new Select(element);

       select.selectByVisibleText("Option 2");

        List<WebElement>webElementList=select.getOptions();
        System.out.println(webElementList.size());

        Thread.sleep(10000);

    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



}
