package com.org.E2E;


import com.org.Pages.LogInPage;
import com.org.Pages.ProductsPage;
import com.org.Utilities.LoginTestData;
import com.org.Utilities.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends com.org.Base.BaseTest {

    @Test(description = "login to the system with valid username and password",
            dataProvider = "loginData", dataProviderClass = Util.class)
    public void loginUser(LoginTestData testData){
        LogInPage lp = new LogInPage(driver);
        ProductsPage pr = new ProductsPage(driver);
        lp.enterUsername(testData.getUsername());
        lp.enterPassword(testData.getPassword());
        lp.clickLogIn();
        Assert.assertNotNull(pr.checkProductsAvailability(),"Value should not be null");
        Assert.assertNotNull(pr.checkNumberOfProductsAvailable(),"No products available");
        pr.addFirstNProductsToCart(2);

    }
}
