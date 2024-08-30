package Selenium30Mar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Lab040 {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
//        options.setExperimentalOption("excludeSwitches",new String[]{"enable automation"});
//        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.opencart.com/");
        driver.manage().window().maximize();

        String act_title=driver.getTitle();
        if(act_title.equals("OpenCart - Open Source Shopping Cart Solution")){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }
        driver.quit();



    }

}
