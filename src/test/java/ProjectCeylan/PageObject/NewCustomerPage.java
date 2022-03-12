package ProjectCeylan.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class NewCustomerPage extends BasePage {
    @FindBy(xpath = "//p[text()='Add New Customer']")
    public WebElement newCustomerTitle;

    @FindBy(xpath = "//input[@name=\"name\"]")
    public WebElement newCustomerName;

    @FindBy(xpath = "//input[@value='m']")
    public WebElement maleRadioButton;

    @FindBy(xpath = "//input[@value='f']")
    public WebElement femaleRadioButton;

    @FindBy(id = "dob")
    public WebElement datePicker;

    @FindBy(xpath = "//textarea[@name='addr']")
    public WebElement addressInput;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityInput;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement stateInput;

    @FindBy(xpath = "//input[@name='pinno']")
    public WebElement pinnoInput;

    @FindBy(xpath = "//input[@name='telephoneno']")
    public WebElement telephoneNoInput;

    @FindBy(xpath = "//input[@name='emailid']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@name='sub']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@name='res']")
    public WebElement resetButton;

    @FindBy(xpath = "//p[text()='Customer Registered Successfully!!!']")
    public WebElement successMessage;

    @FindBy(xpath = "//span[text()='Close']")
    public WebElement closeAdButton;

    public void setDate(String year, String month, String day) {
        datePicker.click();
        datePicker.sendKeys(day);
        datePicker.sendKeys(Keys.chord(Keys.SHIFT,Keys.TAB));
        datePicker.sendKeys(month);
        datePicker.sendKeys(Keys.chord(Keys.SHIFT,Keys.TAB));
        datePicker.sendKeys(Keys.chord(Keys.SHIFT,Keys.TAB));
        datePicker.sendKeys(year);
    }

}
