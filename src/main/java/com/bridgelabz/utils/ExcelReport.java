/**
 * Description : add Excel report method
 * Author      : Mayur Mansukh
 * Date        : 9/6/21
 */
package com.bridgelabz.utils;

import org.automationtesting.excelreport.Xl;

public class ExcelReport {
    public void ExcelReport() throws Exception {
        Xl.generateReport("excel-report.xlsx");
    }
}
