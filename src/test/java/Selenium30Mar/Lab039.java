package Selenium30Mar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Lab039 {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://expired.badssl.com/");
        driver.manage().window().maximize();
        System.out.println("Title of the page " +driver.getTitle());

    }}

