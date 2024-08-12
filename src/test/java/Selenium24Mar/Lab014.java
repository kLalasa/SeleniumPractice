package Selenium24Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab014 {

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

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();

        driver.findElement(By.xpath("//div[@class='oxd-table-filter']//div[6]//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
        Thread.sleep(5000);

        //driver.findElement(By.xpath("//span[normalize-space()='Payroll Administrator']")).click();

        List<WebElement>options=driver.findElements(By.xpath("//div[@role='listbox']//span"));
        System.out.println(options.size());

        for(WebElement op:options){
            System.out.println(op.getText());
        }

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();

    }
}
