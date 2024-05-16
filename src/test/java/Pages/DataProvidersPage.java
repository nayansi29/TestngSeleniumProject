package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//import static Base.BaseTest.driver;

public class DataProvidersPage {


    private String username="username";
    private String password="password";

    private String login="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']";
    private String dashboardText="//h6[text()='Dashboard']";

     private  String ErrorMsg="//p[text()='Invalid credentials']";



    public void loginToOrangeHrmWithDataProvider(String Username,String Password) throws InterruptedException {

//        driver.findElement(By.name(username)).sendKeys(Username);
//        driver.findElement(By.name(password)).sendKeys(Password);
//        driver.findElement(By.xpath(login)).submit();
//        Thread.sleep(1000);
//        WebElement DashboardText=driver.findElement(By.xpath(dashboardText));
//        Assert.assertTrue(DashboardText.isDisplayed());

    }
}



