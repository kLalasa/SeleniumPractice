package Gmail;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample {

    private WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--disable-notifications");
        driver = new EdgeDriver(options);
    }
    @Test
    public void Test(){
        String URL = "https://mail.google.com/mail/u/1/#inbox/QgrcJHshZXrxqMPLdlVGkmKcXjTZwDNCMVQ";
        driver.get(URL);
        driver.manage().window().maximize();
    }


}
