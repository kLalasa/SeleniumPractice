package TestNG_Annotations;

import org.testng.annotations.*;

public class TC1 {
    @BeforeClass

    void beforeClass(){
        System.out.println("This will execute Before class");
    }
    @AfterClass
    void afterClass(){
        System.out.println("This will execute Before class");
    }
    @BeforeMethod

    void BeforeMethod(){
        System.out.println("This will execute before Every Test Method");
    }
    @AfterMethod

    void AfterMethod(){

        System.out.println("This will execute After Every Test Method");
    }


    @Test

    void test1(){
        System.out.println("This is test1");

    }
    @Test
    void  test2(){
        System.out.println("This is test2");

    }
    @BeforeTest
    void  beforeTest(){
        System.out.println("This method will get executed Before all the Tests");
    }
    @AfterTest
    void afterTest(){
        System.out.println("This method will get executed After all the tests");
    }
}
