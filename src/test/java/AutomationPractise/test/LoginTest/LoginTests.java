package AutomationPractise.test.LoginTest;


import com.AutomationPractise.page.DashboardPage;
import com.AutomationPractise.page.LandingPage;
import com.AutomationPractise.page.LoginPage;


import com.Framework.core.BaseTests;
import com.Framework.core.DataProviderArguments;
import com.Framework.core.DataProviderUtils;
import com.Framework.core.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTests extends BaseTests {


    @Test(retryAnalyzer = Retry.class , dataProvider = "JsonDataProvider" , dataProviderClass = DataProviderUtils.class)
    @DataProviderArguments("ValidateLoginPositiveFlow=username,password")
    public void ValidateLoginPositiveFlow(String username, String password) throws InterruptedException {
        LandingPage landingPage = new LandingPage();
        landingPage.openAutomationPractiseWebsite();
        LoginPage loginPage = landingPage.navigateSignInPage();
        loginPage.LoginToApplication(username, password);
        Thread.sleep(3000);
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.getSignOut().isDisplayed());
        Thread.sleep(5000);
    }
}





