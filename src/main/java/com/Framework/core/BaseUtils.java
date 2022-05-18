package com.Framework.core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseUtils {
    public static ThreadLocal<WebDriver> baseDriver = new ThreadLocal<>();
    PropertiesLoader ORProps;
    String ORFilePath;


//    public BaseUtils() throws IOException {
//
//        ORProps = new PropertiesLoader();
//        ORFilePath = System.getProperty("user.dir") + "//src//main//resources//OR.properties";
//        ORProps.loadAllProperties(ORFilePath);
//    }

    public void launchBrowser(String  browserType) {

        if (browserType.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            // to block popups add

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", ("user+dir") + "//browserDownload//");
            prefs.put("excludeSwitches", Arrays.asList("disable-popup-blocking"));
            prefs.put("credencials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("useAutomationExtension", false);
            options.setExperimentalOption("prefs", prefs);
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\binaries\\chromedriver.exe");
            //baseDriver = new ChromeDriver(options);
            baseDriver.set(new ChromeDriver(options));

        } else if (browserType.equalsIgnoreCase("IE")) {
            InternetExplorerOptions ieOptions = new InternetExplorerOptions();
            ieOptions.destructivelyEnsureCleanSession();
            ieOptions.introduceFlakinessByIgnoringSecurityDomains();
            ieOptions.ignoreZoomSettings();
            ieOptions.requireWindowFocus();
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\binaries\\IEDriverServer.exe");
            //baseDriver = new InternetExplorerDriver(ieOptions);
            baseDriver.set(new InternetExplorerDriver(ieOptions));

        } else if (browserType.equalsIgnoreCase("Edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\binaries\\msedgedriver.exe");
            //baseDriver = new EdgeDriver();
            baseDriver.set(new EdgeDriver(edgeOptions));
        }

        baseDriver.get().manage().window().maximize();
        baseDriver.get().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        baseDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void closeAllBrowsers() {
        baseDriver.get().quit();
    }

    public void closeBrowser() {
        baseDriver.get().close();}

    public void refreshBrowser() {
        baseDriver.get().navigate().refresh();

    }

    public void launchURL(String url) {
        baseDriver.get().navigate().to(url);

    }

    public void sleepFor(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public void clickOn(String elementName) {
        ElementFinder obj = new ElementFinder(baseDriver.get());
        String value = ORProps.getProperty(elementName);
        String by = value.split("-")[0];                         // or use  String by = splittedValues[0];
        String byValue = value.split("-")[1];                   //or use  String byValue = splittedValues[0];
        WebElement element = obj.findElementsBy(by, byValue);
        element.click();
    }

    public void typeInto(String elementName, String testValue) {
        ElementFinder obj = new ElementFinder(baseDriver.get());
        String value = ORProps.getProperty(elementName);
//        String[] splittedValues = value.split("-");
//        String by = splittedValues[0];
//        String byValue = splittedValues[0];
        String by = value.split("-")[0];
        String byValue = value.split("-")[1];
        WebElement element = obj.findElementsBy(by, byValue);
        element.sendKeys(testValue);
    }

    public WebElement getElementFromWebPage(String elementName) {
        ElementFinder obj = new ElementFinder(baseDriver.get());
        String value = ORProps.getProperty(elementName);
        String by = value.split("-")[0];                         // or use  String by = splittedValues[0];
        String byValue = value.split("-")[1];                   //or use  String byValue = splittedValues[0];
        WebElement element = obj.findElementsBy(by, byValue);
        element.click();
        return element;
    }

    public void switchToSecondWindow() {
        //step1--> get no of windows.
        Set<String> windows = baseDriver.get().getWindowHandles();  //because when u click on tab new tab opens that's index[1]

        //step2-->convert set into a list so that we can fetch the window by index.
        List<String> windowList = new ArrayList<String>(windows);
        baseDriver.get().switchTo().window(windowList.get(1));
    }

    public void switchToOriginalWindow() {

        Set<String> windows = baseDriver.get().getWindowHandles();
        List<String> windowList = new ArrayList<String>(windows);
        baseDriver.get().switchTo().window(windowList.get(0));
    }

    public void switchToLastWindow() {

        Set<String> windows = baseDriver.get().getWindowHandles();
        List<String> windowList = new ArrayList<String>(windows);
        baseDriver.get().switchTo().window(windowList.get(windowList.size() - 1));
    }

    public void switchToSecondLastWindow() {

        Set<String> windows = baseDriver.get().getWindowHandles();
        List<String> windowList = new ArrayList<String>(windows);
        baseDriver.get().switchTo().window(windowList.get(windowList.size() - 2));
    }

    public void switchToFrame(WebElement element) {

        baseDriver.get().switchTo().defaultContent();
    }

    public void switchToJavaScriptAlert() {

        baseDriver.get().switchTo().alert().accept();
    }

    public void switchToJavaScriptAlertAndDismiss() {

        baseDriver.get().switchTo().alert().dismiss();
    }

    public void captureScreenshots(String TestName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) baseDriver.get();
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(System.getProperty("user.dir")
                +"src//test//resources//screenshots//" +TestName+new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss").format(new Date()) +".png"));

    }
    public String captureScreenshotAsBase64(){
        TakesScreenshot screenshot = (TakesScreenshot) baseDriver.get();
        String screenshotString = screenshot.getScreenshotAs(OutputType.BASE64);
        ThreadLocal<String> str = new ThreadLocal<>();
        System.out.println(screenshotString);
        str.set(screenshotString);
        return str.get();
    }


}




