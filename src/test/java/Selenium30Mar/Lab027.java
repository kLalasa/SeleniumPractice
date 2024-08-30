package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Lab027 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        Actions act=new Actions(driver);

        WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement box2= driver.findElement(By.xpath("//input[@id='field2']"));

        WebElement button= driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));

        box1.clear();

        box1.sendKeys("WELCOME");
       act.doubleClick(button).perform();

        String text= box2.getAttribute("value");
        System.out.println("text entered in the input field" +text);

        if(text.equals("WELCOME")){
            System.out.println("Text copied");
        }else{
            System.out.println("Text didnt copy");
        }

        driver.quit();








    }

}

