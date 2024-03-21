package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Lab004 {
    @Test

    public void testVWOLogin2(){

        WebDriver driver=new EdgeDriver();
        driver.get("https://app.vwo.com");

        List<WebElement>all_tags=driver.findElements(By.tagName("a"));

        all_tags.size();
        for (WebElement element:all_tags){
            System.out.println(element.getText());
        }
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }


        driver.close();
    }
}
