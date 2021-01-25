package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {


    @Test
    public void readExcelFile(){
        //Create an object from ExcelUtil
        //it accepts two argument
        //Argument 1: location of the file(path)
        //Argument 2: sheet that wew want to open(sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short" );

        // How many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        //How many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        //Get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        //Get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);
        }

        //GetNona
        System.out.println("dataList.get(2).get(\"firstname\") = " + dataList.get(2).get("firstname"));

        //Get Harber
        System.out.println("dataList.get(8).get(\"lastname\") = " + dataList.get(8).get("lastname"));

        //Get all data in 2d Array
        String[][] dataArray = qa3short.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));


    }
}
