package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lab018 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test

    public void testPositive() throws InterruptedException {
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WebElement Depart = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select Depart_options = new Select(Depart);

        Depart_options.selectByVisibleText("Boston");

        WebElement Dest = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select Dest_options = new Select(Dest);
        Dest_options.selectByVisibleText("London");

        WebElement Find_Button = driver.findElement(By.xpath("//input[@type='submit']"));
        Find_Button.click();

        int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
        System.out.println("No of rows  " + rows);

        ArrayList<Double> price_arr = new ArrayList<Double>();

        for (int r = 1; r < rows; r++) {

            String price = driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]//td[6]")).getText();
            //  System.out.println(price +"\t");
            Double price_list = Double.parseDouble(price.replace("$", ""));
            price_arr.add(price_list);
            System.out.println(price_list);
        }

        Collections.sort(price_arr);
        System.out.println("Minimum price  " + price_arr.get(0));

        for (int r = 1; r < rows; r++) {

            String price = driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]//td[6]")).getText();


            if (price.equals("$200.98")) {

                WebElement Chooseflight = driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]/td[1]/input[@type='submit']"));
                Chooseflight.click();
                Thread.sleep(5000);
                System.out.println(driver.getTitle());

                break;

            }
        }


    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();

    }
}
