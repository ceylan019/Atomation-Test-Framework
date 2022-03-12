package ProjectCeylan.TestSteps;

import ProjectCeylan.PageObject.BasePage;
import ProjectCeylan.PageObject.HomePage;
import ProjectCeylan.PageObject.LoginPage;
import ProjectCeylan.PageObject.NewCustomerPage;
import ProjectCeylan.Utils.DriverUtil;
import ProjectCeylan.Utils.PropertiesFileReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginGuru99 extends BaseTest {

    Faker faker = new Faker();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    NewCustomerPage newCustomerPage = new NewCustomerPage();

    @Test
    public void TC_1_LoginGuru99() {
        // Step 1) Go to Guru99 Demo Site   http://demo.guru99.com/V4/
        // Step 1 is done in before test annotation in the BaseTest class.

        // Step 2) In Login page check text "Guru99 Bank" is present

        String expectedTitle = "Guru99 Bank";
        String actualTitle = loginPage.loginPageTitle.getText();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Step 3) Login into application  with given
        // credentials(you need to enter your email in order to get credentials in advance)

        loginPage.userIdInput.sendKeys(PropertiesFileReader.getProperties("userID"));
        loginPage.userPasswordInput.sendKeys(PropertiesFileReader.getProperties("password"));
        loginPage.loginButton.click();

        // Step 4) Verify that the Home page contains text as "Manger Id: mngr368294"
        String expectedMangerText ="Manger Id : "+PropertiesFileReader.getProperties("userID");
                                    //Manger Id : mngr391914
        String actualMangerText =DriverUtil.getDriver().findElement(By.xpath("//td[text()='Manger Id : "+PropertiesFileReader.getProperties("userID")+"']")).getText();
                                                                                    //td[text()='Manger Id : mngr391914']
        Assert.assertEquals(expectedMangerText,actualMangerText);

        // Step 5) Click on new customer button and verify you are in New Customer Entry Page

        homePage.newCustomerButton.click();
        BasePage.checkAd();
        BasePage.sleep(3);

        String expectedNewCustomerTitle = "Add New Customer";
        String actualNewCustomerTitle =  newCustomerPage.newCustomerTitle.getText();
        Assert.assertEquals(expectedNewCustomerTitle, actualNewCustomerTitle);

        // Step 6) Fill the information for new customer
        newCustomerPage.newCustomerName.sendKeys(faker.name().fullName().replace("-",""));
        newCustomerPage.maleRadioButton.click();
        newCustomerPage.setDate("1993","11","01");
        newCustomerPage.addressInput.sendKeys("Mars");
        newCustomerPage.cityInput.sendKeys("Toronto");
        newCustomerPage.stateInput.sendKeys("Canada");
        newCustomerPage.pinnoInput.sendKeys("4546734564");
        newCustomerPage.telephoneNoInput.sendKeys("4161234567");
        newCustomerPage.emailInput.sendKeys(faker.internet().emailAddress());
        newCustomerPage.passwordInput.sendKeys("6262");
        newCustomerPage.submitButton.click();

        // Step 7) Verify new customer added sucessfully
        String expectedSuccessMessage = "Customer Registered Successfully!!!";
        String actualSuccessMessage = newCustomerPage.successMessage.getText();
        Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage);
    }
}
