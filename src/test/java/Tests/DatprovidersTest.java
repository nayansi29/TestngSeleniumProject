package Tests;

import Base.BaseTest;
import Pages.DashboardPage;
import Pages.DataProvidersPage;
import Pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DatprovidersTest extends BaseTest {

    DataProvidersPage dataProvidersPage;

        @Test(dataProvider = "Login",dataProviderClass = DataProviderData.class)
            public void print(String Username,String Pass) throws InterruptedException {
            dataProvidersPage=new DataProvidersPage();
            dataProvidersPage.loginToOrangeHrmWithDataProvider(Username,Pass);
    }


}

