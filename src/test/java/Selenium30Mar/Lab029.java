package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Lab029 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();
        Actions act=new Actions(driver);


        WebElement Min_slider=driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
        System.out.println(Min_slider.getLocation());//(59,250)
        act.dragAndDropBy(Min_slider,60,250).perform();
        System.out.println(Min_slider.getLocation());


        WebElement Max_slider=driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
        System.out.println(Max_slider.getLocation());
        act.dragAndDropBy(Max_slider,-100, 250).perform();
        System.out.println(Max_slider.getLocation());



    }
}