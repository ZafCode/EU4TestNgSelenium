package com.cybertek.tests.day10_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test1(){
        //-  /Users/mcpc/IdeaProjects/EU4TestNgSelenium/src/test/resources/textfile.txt
        //-   /Users/mcpc/IdeaProjects/EU4TestNgSelenium

       // System.out.println(System.getProperty("user.dir"));

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        String filePath = "src/test/resources/textfile.txt";

        String fullPath = projectPath+"/"+filePath;
        System.out.println(fullPath);
    }
}
