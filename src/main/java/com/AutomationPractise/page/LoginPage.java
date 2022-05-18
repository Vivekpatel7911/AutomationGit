package com.AutomationPractise.page;

import com.Framework.core.BaseUtils;
import com.Framework.core.EnvPropertiesLoader;
import com.Framework.core.ExtentTestReporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseUtils {
    Wait wait;

    @FindBy(id = "email")
    WebElement tbx_emailAddress;

    @FindBy(id = "passwd")
    WebElement tbx_password;

    @FindBy(id = "SubmitLogin")
    WebElement btn_SignIn;

    public LoginPage(){
        wait = new WebDriverWait(baseDriver.get(), EnvPropertiesLoader.standardWait);
        PageFactory.initElements(baseDriver.get(),this);
    }
    public void LoginToApplication(String username,String password){
        try {


            wait.until(ExpectedConditions.visibilityOf(tbx_emailAddress));
            tbx_emailAddress.sendKeys(username);
            tbx_password.sendKeys(password);
            btn_SignIn.click();
            ExtentTestReporter.logPassStep("Login_Successful :" +username+ " and "+password+ "");
            ExtentTestReporter.logPassedStepWithScreenshot(captureScreenshotAsBase64());
        }catch (Exception e) {
            ExtentTestReporter.logFailStep("Login_Error");
            ExtentTestReporter.logFailedStepWithScreenshot(captureScreenshotAsBase64());

        }


    }

}
