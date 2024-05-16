package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import static Base.BaseTest.driver;

public class DashboardPage {

   WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }


    private String dashboardText="//h6[text()='Dashboar']";





    public Boolean verifyDashboardPage(){
        WebElement  dashboardTextPresent=driver.findElement(By.xpath(dashboardText));
        return dashboardTextPresent.isDisplayed();

    }


    public void loginToOrangeHrmWithDataProvider(String username, String pass) {
    }

//    public void loginToOrangeHrmWithDataProvider(String Username,String Password) throws InterruptedException {
////        baseTest = new BaseTest();
////        baseTest.getWebDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
//        usernameInput.sendKeys(Username);
//        passwordInput.sendKeys(Password);
//        loginButton.submit();
//        Assert.assertTrue(ErrorMessage.isDisplayed());
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        usernameInput.sendKeys(Username);
//        passwordInput.sendKeys(Password);
//        loginButton.submit();
//        Thread.sleep(5000);
//
//    }
}
