package ProjectCeylan.PageObject;

import ProjectCeylan.PageObject.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@name='uid']")
    public WebElement userIdInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement userPasswordInput;

    @FindBy(xpath = "//input[@name='btnLogin']")
    public WebElement loginButton;

    @FindBy(xpath = "//h2[text()='Guru99 Bank']")
    public WebElement loginPageTitle;

}

