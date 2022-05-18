package com.Framework.core;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestReporter {

    static ExtentReports mainReport = ExtentReporter.getReporter();
   static ThreadLocal<ExtentTest> extentTests = new ThreadLocal<>();
    ThreadLocal<Integer> testIds = new ThreadLocal<>();
    static Map<Integer,ExtentTest> testMap = new HashMap<Integer,ExtentTest>();

    public static void startTest(String testCaseName, String description){
        ExtentTest test = mainReport.startTest(testCaseName,description);
        extentTests.set(test);
        testMap.put((int)(long) Thread.currentThread().getId(),extentTests.get());    //Generate uniqueID
    }
    public static void stopTest(){
        mainReport.endTest((ExtentTest) testMap.get((int)(long)Thread.currentThread().getId()));
    }

    public synchronized static  ExtentTest getTest(){
        return (ExtentTest) testMap.get((int)(long) Thread.currentThread().getId());
    }
    public synchronized static void logPassStep(String passedMessage){

        getTest().log(LogStatus.PASS, passedMessage);
    }

    public synchronized static void logFailStep(String failedMessage){

        getTest().log(LogStatus.FAIL, failedMessage);
    }

    public synchronized static void logWarningStep(String warningMessage){
        getTest().log(LogStatus.WARNING, warningMessage);
    }
    public synchronized static void logInfoStep(String infoMessage){

        getTest().log(LogStatus.INFO, infoMessage);
    }

    public synchronized static void logFatalStep(String fatalMessage){

        getTest().log(LogStatus.FATAL, fatalMessage);
    }

    public synchronized static void logSkipStep(String skippedMessage){
        getTest().log(LogStatus.SKIP, skippedMessage);
    }
    public synchronized static void logPassedStepWithScreenshot(String base64){
        getTest().log(LogStatus.PASS, getTest().addBase64ScreenShot("data:image/png;base64, "+base64));
    }
    public synchronized static void logFailedStepWithScreenshot(String base64){
        getTest().log(LogStatus.FAIL, getTest().addBase64ScreenShot("data:image/png;base64, "+base64));
    }
}
