package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Lab026 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);
        WebElement target = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement destination=driver.findElement(By.xpath("//div[@id='droppable']"));


        actions.dragAndDrop(target,destination).perform();
    }

}
