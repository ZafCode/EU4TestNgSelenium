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

    @AfterMethod
    public void tearDown(){
        System.out.println("Close browser");
    }

}
