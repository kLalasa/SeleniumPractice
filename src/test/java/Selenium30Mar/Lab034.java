package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Lab034 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.opencart.com/");
        driver.manage().window().maximize();

        WebElement ele= driver.findElement(By.xpath("//div[@class='page-header']//h2[text()='Support based on your needs']"));


        JavascriptExecutor js=(JavascriptExecutor) driver;

//        js.executeScript("arguments[0].scrollIntoView();",ele);
//        System.out.println(js.executeScript("return window.pageYOffset;"));


        js.executeScript("window.scrollBy(0,document.body.scrollHeight");
        System.out.println(js.executeScript("return window.pageYOffset;"));

        //Scrolling upto  Initial position


        js.executeScript("window.scrollBy(0,-document.body.scrollHeight");

//      For Horizontal Scroll bar
//        js.executeScript("window.scrollBy(0,document.body.scrollWidth");
//        System.out.println(js.executeScript("return window.pageXOffset;"));



    }
}
