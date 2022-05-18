package AutomationPractise.test.LoginTest;


import com.AutomationPractise.page.LandingPage;
import com.AutomationPractise.page.LoginPage;


import com.Framework.core.BaseTests;
import com.Framework.core.DataProviderArguments;
import com.Framework.core.DataProviderUtils;
import org.testng.annotations.Test;



public class LoginTests extends BaseTests {


    @Test(dataProvider = "JsonDataProvider" , dataProviderClass = DataProviderUtils.class)
    @DataProviderArguments("ValidateLoginPositiveFlow=username,password")
    public void ValidateLoginPositiveFlow(String username, String password) throws InterruptedException {
        LandingPage landingPage = new LandingPage();
        landingPage.openAutomationPractiseWebsite();
        LoginPage loginPage = landingPage.navigateSignInPage();
        loginPage.LoginToApplication(username, password);

        Thread.sleep(5000);
    }
}





