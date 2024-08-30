package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Lab030 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();
        Actions act = new Actions(driver);

        driver.findElement(By.xpath("//textarea[@name='text1']")).sendKeys("Welcome");
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        //ctrl+shift+A

        //act.keydown(Keys.CONTROL).keyDown(Keya.SHIFT).sendKeys("A").keysUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform

        //ENTER

        //act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();


    }
}
