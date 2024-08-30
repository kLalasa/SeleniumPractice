package Selenium30Mar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class Lab041 {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        File file =new File("C:\\Users\\klala\\OneDrive\\Desktop\\CRXFile.crx");
        options.addExtensions(file);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com");
    }
}
