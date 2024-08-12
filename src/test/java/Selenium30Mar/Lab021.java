package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab021 {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='frame-one796456169']"));
        if (iframeElement != null) {
            System.out.println("Iframe found, attempting to switch...");
            driver.switchTo().frame(iframeElement);
        } else {
            System.out.println("Iframe not found.");
        }


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement calendarIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='icon_calendar']")));
        calendarIcon.click();


//        String expected_year="2025";
//        String expected_month="April";
//        String expected_date="20";
//
//        WebElement year_dropdown= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
//        Select select_year=new Select(year_dropdown);
//
//        select_year.selectByVisibleText(expected_year);




    }
}
