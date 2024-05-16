package Tests;

import org.testng.annotations.DataProvider;

public class DataProviderData {


    @DataProvider(name = "Login")
    public Object[][] getData(){

        Object[][] data={{"admin","admin123"},{"Admin","admin123"}};
        return data;
    }
}
