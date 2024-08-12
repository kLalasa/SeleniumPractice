package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Lab022 {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

       WebElement desktop= driver.findElement(By.xpath("//li[@class='nav-item dropdown']/a[text()='Desktops']"));

       WebElement Mac= driver.findElement(By.xpath("//div[@class='dropdown-menu']//a[text()='Mac (1)']"));
       Actions act= new Actions(driver);
       act.moveToElement(desktop).moveToElement(Mac).click().build().perform();

    }
}
