package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class Lab020 {


    static void FutureDate(WebDriver driver,String month,String year,String date){

        while (true) {

            String current_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String current_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(current_month.equals(month) && current_year.equals(year)){

                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            // driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

        }
        List<WebElement> dates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td"));

        for( WebElement dt:dates){
            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }

    }

    static void pastDate(WebDriver driver,String month,String year, String date){
        while (true) {

            String current_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String current_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(current_month.equals(month) && current_year.equals(year)){

                break;
            }
            //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
             driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

        }
        List<WebElement> dates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td"));

        for( WebElement dt:dates){
            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }






    }

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);


        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        pastDate(driver,"April","2023","20");



    }
}
