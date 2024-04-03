package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab005 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new EdgeDriver();

    }

    @Test(groups = "QA")
    @Description("Test case Description")
    public void testcase_Positive() throws InterruptedException{
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test(groups = "QA")
    @Description("Testcase Description")
    public void testcase_Negative() throws InterruptedException{
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser(){

    }


}
