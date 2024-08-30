package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Lab028 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();


        Actions act=new Actions(driver);

        WebElement from1= driver.findElement(By.xpath("//li[@id='credit2']/a"));
        WebElement to1=driver.findElement(By.xpath("//ol[@id='bank']/li"));

        WebElement from2= driver.findElement(By.xpath("//div[@class='ui-widget-content']//li[2]"));
        WebElement to2= driver.findElement(By.xpath("//ol[@id='amt7']/li"));
//
        WebElement from3=driver.findElement(By.xpath("//li[@id='credit1']/a"));
        WebElement to3=driver.findElement(By.xpath("//ol[@id='loan']/li"));
//
        WebElement from4=driver.findElement(By.xpath("//div[@class='ui-widget-content']//li[4]"));
        WebElement to4= driver.findElement(By.xpath("//ol[@id='amt8']/ li"));

        act.dragAndDrop(from1,to1).perform();
        act.dragAndDrop(from2,to2).perform();
        act.dragAndDrop(from3,to3).perform();
        act.dragAndDrop(from4,to4).perform();

        if(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed())
        {
            System.out.println("Perfect Displayed !!!");
        }
        else
        {
            System.out.println("Perfect not Displayed !!!");
        }

        driver.quit();





    }

}
