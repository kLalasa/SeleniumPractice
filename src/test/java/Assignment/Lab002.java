package Assignment;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab002 {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver=new EdgeDriver(edgeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test(priority = 1)

    public void testPositive(){

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement success=driver.findElement(By.xpath("//div[@class='flash success']"));
        String text= success.getText();
        System.out.println(text);

        if(text.contains("You logged into a secure area!"))
            System.out.println("Login Successful");
        else
            System.out.println("Login not successful");


    }
    @Test(priority = 2)

    public void testNegative(){

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Super");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement success=driver.findElement(By.xpath("//div[@class='flash error']"));
        String text= success.getText();
        System.out.println(text);

        if(text.contains("\n" +
                "            Your username is invalid!\n" +
                "            "))
            System.out.println("Login Successful");
        else
            System.out.println("Login not successful");




    }

    @AfterTest

    public void closeBrowser(){

        driver.quit();
    }



}
