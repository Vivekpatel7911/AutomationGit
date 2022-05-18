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

public class RegistrationPage extends BaseUtils {

    Wait wait;

//    @FindBy(id = "email_create")
//    WebElement tbx_enterEmail;

//    @FindBy(id = "SubmitCreate")
//    WebElement btn_createAnAccount;

    @FindBy(id = "customer_firstname")
    WebElement tbx_FirstName;
    @FindBy(id = "customer_lastname")
    WebElement tbx_LastName;
    @FindBy(id = "passwd")
    WebElement tbx_Password;
    @FindBy(id = "company")
    WebElement tbx_CompanyName;
    @FindBy(id = "address1")
    WebElement tbx_Address1;
    @FindBy(id = "address2")
    WebElement tbx_Address2;
    @FindBy(id = "city")
    WebElement tbx_City;

    public RegistrationPage() {
        wait = new WebDriverWait(baseDriver.get(), EnvPropertiesLoader.standardWait);
        PageFactory.initElements(baseDriver.get(), this);
    }

    public void RegisterToApplication(String emailAddress) {
//        wait.until(ExpectedConditions.visibilityOf(tbx_enterEmail));
//        tbx_enterEmail.sendKeys(emailAddress);
//        btn_createAnAccount.click();

    }

    public void EnterRegistrationDetails(String city, String firstname, String lastname, String password, String company, String address1, String address2) {
        try {
            tbx_FirstName.sendKeys(firstname);
            tbx_LastName.sendKeys(lastname);
            tbx_Password.sendKeys(password);
            tbx_CompanyName.sendKeys(company);
            tbx_Address1.sendKeys(address1);
            tbx_Address2.sendKeys(address2);
            tbx_City.sendKeys(city);
            ExtentTestReporter.logPassStep("Enter the Registration Info :" + firstname + " , " + lastname + " . ");
            ExtentTestReporter.logPassedStepWithScreenshot(captureScreenshotAsBase64());
        } catch (Exception e) {
            ExtentTestReporter.logFailStep("Unable to Enter Details");
        }
    }
}