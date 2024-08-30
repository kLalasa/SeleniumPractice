package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Lab023 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();

       WebElement button= driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

       Actions act=new Actions(driver);

      Action myaction= act.contextClick(button).build();//creating an action and storing in a variable
      myaction.perform();//completing the action

       driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']")).click();

       driver.switchTo().alert().accept();

       //Actions -class, will be used to perform mouse actions
        //Action -interface, will be used to store created actions

    }
}
