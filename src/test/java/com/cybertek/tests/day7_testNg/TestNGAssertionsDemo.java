package com.cybertek.tests.day7_testNg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Opening browser");
    }


    @Test
    public void test1(){

        System.out.println("=====TEST1=====");
        System.out.println("First Assertion");
        Assert.assertEquals("title", "tiTle");

        System.out.println("Second Assertion");
        Assert.assertEquals("url", "url");


    }


    @Test
    public void test2(){
        System.out.println("======TEST2=======");
        Assert.assertEquals("test2", "test2");
    }

    @Test
    public void test3(){
        String expectedTitle = "Cyt";
        String actualTitle = "Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title starts with Cyb");

    }


    @Test
    public void test4(){
        // verify email contains @

        String email = "mike@smith.com";

        Assert.assertTrue(email.contains("@"), "verify email contains @");
    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1, "verify that 0 is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one", "oNe", "if value first not equal to value second");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close browser");
    }

}
