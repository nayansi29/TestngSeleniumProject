package Tests;

import Base.BaseTest;
import Pages.DashboardPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest  extends BaseTest{
    public LoginPage loginPage;
    public DashboardPage dashboardPage;





    @Test(priority = 1)
    public void OrangeHrm() throws InterruptedException {
        loginPage = new LoginPage(getDriver());
        dashboardPage=new DashboardPage(getDriver());
        loginPage.loginToOrangeHrm();
        dashboardPage.verifyDashboardPage();

    }

    //depends on Methods

//    @Test(dependsOnMethods = "OrangeHrm",description = "Verify Dashboard Text in dashboard Page")
//    public void VerifyDashboradPage() throws InterruptedException {
//        dashboardPage=new DashboardPage();
//        boolean dashboardTextIsPresent=dashboardPage.verifyDashboardPage();
//        Assert.assertTrue(dashboardTextIsPresent);
//        System.out.println("paass");
//
//    }


//    @Test(priority = 1,enabled = false)
//    public void print(){
//        System.out.println("a");
//    }


//    @Test(priority = 2)
//    public void print() throws InterruptedException {
//        System.out.println("print");
//    }





}
