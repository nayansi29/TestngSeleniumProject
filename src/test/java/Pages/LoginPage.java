package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }


    private String username="username";
    private String password="password";

    private String login="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']";



    public void loginToOrangeHrm() throws InterruptedException {
//        baseTest = new BaseTest();
        Thread.sleep(5000);
//        baseTest.getWebDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name(username)).sendKeys("Admin");
        driver.findElement(By.name(password)).sendKeys("admin123");
        Thread.sleep(5000);
        driver.findElement(By.xpath(login)).submit();
        Thread.sleep(5000);

    }



}
