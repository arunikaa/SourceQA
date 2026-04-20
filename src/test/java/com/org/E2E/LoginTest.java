package com.org.E2E;


import com.org.Base.BaseTest;
import com.org.Pages.LogInPage;
import com.org.Pages.ProductsPage;
import com.org.Utilities.LoginTestData;
import com.org.Utilities.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority=1 ,description = "login to the system with valid username and password",
            dataProvider = "loginData", dataProviderClass = Util.class)

    public void loginUser(LoginTestData testData) {
        LogInPage lp = new LogInPage(driver);
        ProductsPage pr = new ProductsPage(driver);
        lp.enterUsername(testData.getUsername());
        lp.enterPassword(testData.getPassword());
        lp.clickLogIn();
        Assert.assertNotNull(pr.checkProductsAvailability(), "Value should not be null");
        pr.checkNumberOfProductsAvailable();
    }


    @Test(priority=2, description = "Add 2 products to the shopping card")
    public void addProducts(){

        ProductsPage pr = new ProductsPage(driver);
        pr.addFirstNProductsToCart(2);
        Assert.assertEquals(pr.getItemsInCart(),2, "Cart should have two items");

    }
}
