package TestNG_Annotations;

import org.testng.annotations.*;

public class TC2 {
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

        void test3(){
            System.out.println("This is test3");

        }
        @Test
        void  test4(){
            System.out.println("This is test4");

        }
        @BeforeSuite

        void beforeSuite(){
            System.out.println("This will be executed before all the classes");
        }
        @AfterSuite

        void afterSuite(){
            System.out.println("This will be executed after all the classes");
        }
    }


