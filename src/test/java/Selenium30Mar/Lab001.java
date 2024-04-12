package Selenium30Mar;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab001 {

    EdgeDriver driver;
    @BeforeTest

    public void openBrowser(){


        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver= new EdgeDriver(edgeOptions);

    }
    @Test

    public void testPositive () throws InterruptedException{

        String url="https://www.amcharts.com/svg-maps/?map=india";
        driver.get(url);
        List<WebElement> states=driver.findElements(By.xpath("//*[local-name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));

        for(WebElement state:states){
            System.out.println(state.getAttribute("aria-label"));
            if (state.getAttribute("aria-label").contains("Tripura"))
                state.click();
        }
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
