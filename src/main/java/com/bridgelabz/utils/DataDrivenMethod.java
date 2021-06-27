/**
 * Description : add data driven method
 * Author      : Mayur Mansukh
 * Date        : 9/6/21
 */
package com.bridgelabz.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataDrivenMethod {

    public static XSSFWorkbook excel_utils_base() throws IOException {
        File file = new File("C:\\Users\\admin\\IdeaProjects\\BooksWagon_WebApp_Automate\\Excel\\BooksWagonData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        return workbook;
    }

    public static String excelData() throws IOException {
        XSSFSheet sheet = excel_utils_base().getSheetAt(0);
        XSSFCell username = sheet.getRow(1).getCell(0);
        return String.valueOf(username);
    }

    public static String excelData2() throws IOException {
        XSSFSheet sheet = excel_utils_base().getSheetAt(0);
        XSSFCell password = sheet.getRow(1).getCell(1);
        return String.valueOf(password);
    }
}
