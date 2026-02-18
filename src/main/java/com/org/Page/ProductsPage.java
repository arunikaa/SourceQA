package com.org.Page;

import com.org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By userName = By.cssSelector("#user-name");
    private final By password = By.cssSelector("#password");
    private final By login = By.cssSelector("#login-button");

    public ProductsPage(WebDriver driver){
        super(driver);
        logger.info("Product page initialized");

    }

    public void enterUsername(String user){
        enterText(userName,user);

    }

    public void enterPassword(String pword){

        enterText(password,pword);
    }

    public void clickLogIn(){
        click(login);

    }


}
