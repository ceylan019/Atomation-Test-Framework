package ProjectCeylan.PageObject;

import ProjectCeylan.Utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    static NewCustomerPage newCustomerPage = new NewCustomerPage();
    public BasePage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    public static void checkAd(){
        try {
            if (DriverUtil.getDriver().findElement(By.xpath("//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']")).isDisplayed()){
                DriverUtil.getDriver().switchTo().frame(DriverUtil.getDriver().findElement(By.xpath("//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']")));
                DriverUtil.getDriver().switchTo().frame(DriverUtil.getDriver().findElement(By.xpath("//iframe[@id='ad_iframe']")));
                if (newCustomerPage.closeAdButton.isDisplayed()){
                    newCustomerPage.closeAdButton.click();
                    DriverUtil.getDriver().switchTo().parentFrame();
                }else{
                    DriverUtil.getDriver().switchTo().parentFrame();
                }
            }
        }catch (Exception e ){
            DriverUtil.getDriver().switchTo().parentFrame();
        }
    }

    public static void sleep(int sec){
        try {
            Thread.sleep(1000 * sec);
        }catch (Exception e){

        }
    }
}
