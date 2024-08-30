import Datadriventesting_practice.ExcelUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

public class Lab004 {
    public static void main(String[] args) throws IOException {
        EdgeDriver driver;
        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver= new EdgeDriver(edgeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-B58001.html");
        driver.manage().window().maximize();

        String filepath = System.getProperty("user.dir") + "\\src\\test\\java\\Test_Data\\TestData3.xlsx";

        int rows = ExcelUtils.getRowCount(filepath, "Sheet1");

        for (int i = 1; i <= rows; i++) {

            String pinc = ExcelUtils.getCellData(filepath, "Sheet1", i, 0);
            String rateofinterest = ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
            String per1 = ExcelUtils.getCellData(filepath, "Sheet1", i, 2);
            String per2 = ExcelUtils.getCellData(filepath, "Sheet1", i, 3);
            String free = ExcelUtils.getCellData(filepath, "Sheet1", i, 4);
            String exp_mvalue = ExcelUtils.getCellData(filepath, "Sheet1", i, 5);

            // clear existing value
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pinc);

            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
          // clear existing value
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);

            Select perdrp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            perdrp.selectByVisibleText(per2);

            Select fredrp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            fredrp.selectByVisibleText(free);

            driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();

            try {
                // Check for alert
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Unexpected alert: " + alertText);
                alert.accept(); // Accept the alert to proceed

                ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "fail");
                ExcelUtils.fillRedColour(filepath, "Sheet1", i, 7);
            } catch (NoAlertPresentException e) {
                // No alert found, proceed with verification
                String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval'] //strong")).getText();

                if (Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue)) {
                    System.out.println("Test passed");
                    ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "passed");
                    ExcelUtils.fillGreenColour(filepath, "Sheet1", i, 7);
                } else {
                    System.out.println("Test failed");
                    ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "fail");
                    ExcelUtils.fillRedColour(filepath, "Sheet1", i, 7);
                }

                driver.findElement(By.xpath("//img[@class='PL5']")).click();
            }
        }

        driver.quit();
    }
}