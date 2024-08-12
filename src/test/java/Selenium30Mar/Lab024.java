package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class Lab024 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://w3.p2hp.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult");
        WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement box2= driver.findElement(By.xpath("//input[@id='field2']"));

       WebElement button= driver.findElement(By.xpath("//button[text()='Copy Text']"));

       box1.clear();
       box1.sendKeys("WELCOME");

        Actions act=new Actions(driver);
        act.doubleClick(button).perform();

    }
}
