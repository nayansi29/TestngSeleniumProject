package Tests;

import Base.BaseTest;
import Pages.DashboardPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    public LoginPage loginPage;
    public DashboardPage dashboardPage;


    @Test(groups = {"sanity"})
    public void VerifyDashboradPage() throws InterruptedException {
        loginPage =new LoginPage(getDriver());
        loginPage.loginToOrangeHrm();
        dashboardPage=new DashboardPage(getDriver());
        boolean dashboardTextIsPresent=dashboardPage.verifyDashboardPage();
        Assert.assertTrue(dashboardTextIsPresent);

    }

//    @Test(priority = 1)
//    public void print(){
//        System.out.println("a");
//    }



}
