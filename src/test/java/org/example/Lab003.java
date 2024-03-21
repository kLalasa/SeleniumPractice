package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Lab003 {
    @Test
    public void TestLogin(){
    WebDriver driver=new EdgeDriver();
    driver.get("https://app.vwo.com");
      //  WebElement anchorTag= driver.findElement(By.linkText("Start a free trial"));
        WebElement anchorTag=driver.findElement(By.partialLinkText("Start a free"));

        System.out.println(anchorTag.getAttribute("href"));
        anchorTag.click();
        driver.close();


}
}
