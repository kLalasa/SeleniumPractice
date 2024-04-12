package Selenium24Mar;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab003 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options=new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver=new EdgeDriver(options);

    }
    @Test
    @Description("Test case description")
    public void testPositive(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        List<WebElement> checkboxes= driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        WebElement ch1=checkboxes.get(0);
        ch1.click();

    }
    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }
}
