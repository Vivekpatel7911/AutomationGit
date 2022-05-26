package com.AutomationPractise.page;

import com.Framework.core.BaseTests;
import com.Framework.core.BaseUtils;
import com.Framework.core.EnvPropertiesLoader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BaseUtils {
    Wait wait;

    @FindBy(xpath = "//a[@class = 'logout']")
    WebElement btn_signOut;
    public DashboardPage(){
        wait = new WebDriverWait(baseDriver.get(), EnvPropertiesLoader.standardWait);
        PageFactory.initElements(baseDriver.get(),this);
    }
    public WebElement getSignOut(){
        return btn_signOut;
    }

}
