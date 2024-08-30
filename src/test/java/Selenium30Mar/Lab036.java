package Selenium30Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Lab036 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

        driver.manage().window().maximize();

//        driver.findElement(By.xpath("//input[@name='filesToUpload']")).sendKeys("C:\\Users\\klala\\OneDrive\\Desktop\\New Text Document.txt");
//
//        String file_name=driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText();
//        System.out.println(file_name);
//
//        if(file_name.equals("New Text Document.txt")){
//
//            System.out.println("File Successfully uploaded");
//        }
//        else
//            System.out.println("File upload failed");


        String file1="C:\\Users\\klala\\OneDrive\\Desktop\\New Text Document (2).txt";
        String file2="C:\\Users\\klala\\OneDrive\\Desktop\\New Text Document.txt";

        driver.findElement(By.xpath("//input[@name='filesToUpload']")).sendKeys(file1+"\n"+file2);

        int nooffiles=driver.findElements(By.xpath("//ul[@id='fileList']/li")).size();
        System.out.println(nooffiles);

        if(driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText().equals("New Text Document (2).txt")
        && driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText().equals("New Text Document.txt")){

            System.out.println("File names matching");
        }
        else {
            System.out.println("File names not matching");
        }
   }
}
