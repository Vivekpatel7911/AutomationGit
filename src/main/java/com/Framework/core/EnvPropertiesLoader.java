package com.Framework.core;

import java.io.IOException;

public class EnvPropertiesLoader {

     public static String browserName;
     public static String chromeBinaryPath;
     public static String edgeBinaryPath;
     public static String IEBinaryPath;
     public static long longWait;
     public static long shortWait;
     public static long standardWait;
     public static String applicationURL;
     public static Boolean TakeScreenShot;
    public static String environmentName;
     public static Boolean TakeScreenShotsFor;

    public static void LoadPropertiesLoader() throws IOException {

        PropertiesLoader propertiesLoaderObj = new PropertiesLoader();
        propertiesLoaderObj.loadAllProperties(System.getProperty("user.dir") + "//src//main//resources//config.properties");

        if (System.getProperty("browser") == null || System.getProperty("browser").isEmpty()) {
            browserName = propertiesLoaderObj.getProperty("browser");
        }else {
            browserName = System.getProperty("browser");
        }
        chromeBinaryPath = propertiesLoaderObj.getProperty("chromeBinaryPath");
        edgeBinaryPath = propertiesLoaderObj.getProperty("edgeBinaryPath");
        IEBinaryPath = propertiesLoaderObj.getProperty("IEBinaryPath");
        longWait = Long.valueOf(propertiesLoaderObj.getProperty("longWait"));
        shortWait = Long.valueOf(propertiesLoaderObj.getProperty("shortWait"));
        standardWait = Long.valueOf(propertiesLoaderObj.getProperty("standardWait"));
         applicationURL = propertiesLoaderObj.getProperty("URL");
        TakeScreenShot = Boolean.valueOf(propertiesLoaderObj.getProperty("TakeScreenShot"));
        if (System.getProperty("environment") == null || System.getProperty("environment").isEmpty())
            environmentName = propertiesLoaderObj.getProperty("environment");
        else
            environmentName = System.getProperty("environment");
    }

    public static void main(String[] args) throws IOException {
        EnvPropertiesLoader.LoadPropertiesLoader();
        System.out.println(browserName);
        System.out.println(chromeBinaryPath);
        System.out.println(longWait);
    }
}
