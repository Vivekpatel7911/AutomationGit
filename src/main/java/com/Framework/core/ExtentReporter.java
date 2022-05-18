package com.Framework.core;


import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentReporter {

//  1.    create a report file - provide a location
//  2.    Create a Object of class for creating a mainframe page.
//  3.    Create a test in the report.
//  4.    Start logging the report Data.
//  5.    Take ScreenShots of the Report.


    public static ExtentReports mainReport;

    public static ExtentReports getReporter(){

        String path = System.getProperty("user.dir")+"//src//test//resources//reports";
        File reportDirectory = new File(path);
        if (!reportDirectory.exists()){
            reportDirectory.mkdir();
        }
        mainReport = new ExtentReports(path + "//AutomationReport.html");
        return mainReport;
    }

}
