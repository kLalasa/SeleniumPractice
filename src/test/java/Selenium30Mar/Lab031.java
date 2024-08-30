package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Lab031 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Actions act = new Actions(driver);

        WebElement reg_click= driver.findElement(By.xpath("//a[text()='Register']"));

        act.keyDown(Keys.CONTROL).click(reg_click).keyUp(Keys.CONTROL).perform();

        List<String> ids= new ArrayList(driver.getWindowHandles());

        driver.switchTo().window(ids.get(1));
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Lalasa");

        driver.switchTo().window(ids.get(0));
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("T=shirts");
    }
}
