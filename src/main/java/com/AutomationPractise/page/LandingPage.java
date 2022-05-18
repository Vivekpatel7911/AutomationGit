package com.AutomationPractise.page;

import com.Framework.core.BaseUtils;
import com.Framework.core.EnvPropertiesLoader;
import com.Framework.core.ExtentTestReporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LandingPage extends BaseUtils {
    Wait wait;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement btn_signIn;
    @FindBy(id = "email_create")
    WebElement tbx_enterEmail;
    @FindBy(id = "SubmitCreate")
    WebElement btn_createAnAccount;


    public LandingPage(){
        wait = new WebDriverWait(baseDriver.get(), EnvPropertiesLoader.standardWait);
        PageFactory.initElements(baseDriver.get(),this);
    }
    public void openAutomationPractiseWebsite(){
        launchURL(EnvPropertiesLoader.applicationURL);

    }
    public LoginPage navigateSignInPage(){
        try{
            btn_signIn.click();
            ExtentTestReporter.logPassStep("SignIn Button clicked");
        }catch (Exception e){
            ExtentTestReporter.logFailStep("Unable to click");
        }
        return new LoginPage();
    }
    public RegistrationPage navigateRegistrationPage(String emailAddress){
        btn_signIn.click();
        try {
            tbx_enterEmail.sendKeys(emailAddress);
            btn_createAnAccount.click();
            ExtentTestReporter.logPassStep("Navigated to Registration Page");
        }catch (Exception e){
            ExtentTestReporter.logFailStep("Unable to click");
        }
        return new RegistrationPage();
    }
}
