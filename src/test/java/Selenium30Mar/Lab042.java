package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Lab042 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        List<WebElement>links=driver.findElements(By.tagName("a"));
        System.out.println("No of links  " +links.size());
        int noofbrokenlinks=0;

        for(WebElement link:links) {
            String hrefattvalue = link.getAttribute("href");
            if (hrefattvalue == null || hrefattvalue.isEmpty()) {
                System.out.println("Not possible to check");
                continue;
            }

            try {


                URL linkURL = new URL(hrefattvalue);
                HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();
                connection.connect();

                if(connection.getResponseCode()>=400){

                    System.out.println(hrefattvalue+ "----->Brokenlink");
                    noofbrokenlinks++;
                }else{
                    System.out.println(hrefattvalue+ "--->Not a broken link");
                }
            }catch (Exception e){

            }


        }

        System.out.println("No of Brokenlinks:" +noofbrokenlinks);
        driver.quit();

    }
}
