package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab002 {

    @Test
    @Description("Verify the current URl, title of VWO app")
    public void test(){

        WebDriver driver=new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");


        WebElement emailInputBox=driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement emailPwdbox=driver.findElement(By.id("login-password"));
        emailPwdbox.sendKeys("admin");

        driver.findElement(By.id("js-login-btn")).click();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        WebElement err_msg=driver.findElement(By.className("notification-box-description"));
        String err_msg_text=err_msg.getText();
        Assert.assertEquals(err_msg_text,"Your email, password, IP address or location did not match");

    }
}
