package com.org.Page;

import com.org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage {
    private final By userName = By.cssSelector("#user-name");
    private final By password = By.cssSelector("#password");
    private final By login = By.cssSelector("#login-button");


    /**
     * Constructor
     */

    public LogInPage(WebDriver driver){
        super(driver);
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
