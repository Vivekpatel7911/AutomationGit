package AutomationPractise.test.RegistrationTest;

import com.AutomationPractise.page.LandingPage;
import com.AutomationPractise.page.LoginPage;
import com.AutomationPractise.page.RegistrationPage;
import com.DataGenerator.RegisterDataGenerator;
import com.Framework.core.BaseTests;
import com.Framework.core.BaseUtils;
import com.Framework.core.ExtentTestReporter;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends BaseTests{
        @Test (description = "Validating the RegistrationFlow for Automation Practise Website.")
        public void ValidateRegistrationPositiveFlow() throws InterruptedException {
            LandingPage landingPage = new LandingPage();
            landingPage.openAutomationPractiseWebsite();
            landingPage.navigateSignInPage();
            landingPage.navigateRegistrationPage(RegisterDataGenerator.getEmailAddress());
            RegistrationPage registrationPage = new RegistrationPage();
            registrationPage.EnterRegistrationDetails(
                    RegisterDataGenerator.getFirstName(),
                    RegisterDataGenerator.getLastName(),
                    RegisterDataGenerator.getPassword(),
                    RegisterDataGenerator.getCompanyName(),
                    RegisterDataGenerator.getAddress1(),
                    RegisterDataGenerator.getAddress2(),
                    RegisterDataGenerator.getCity());
      //      ExtentTestReporter.logPassedStepWithScreenshot(registrationPage.captureScreenshotAsBase64());

            Thread.sleep(5000);


        }



}


