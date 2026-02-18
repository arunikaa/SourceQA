package com.org.Pages;

import com.org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private final By txt_products = By.cssSelector(".title");
    private final By inventoryList = By.cssSelector(".inventory_list");
    private final By inventoryItems = By.cssSelector(".inventory_item");
    private final By addToCartButton = By.cssSelector("button.btn_inventory");


    public ProductsPage(WebDriver driver){
        super(driver);
        logger.info("Product page initialized");

    }

    public String checkProductsAvailability(){

        WebElement elem = driver.findElement(txt_products);
        return  elem.getText();

    }

    public int checkNumberOfProductsAvailable(){
        WebElement listContainer = driver.findElement(inventoryList);
        List<WebElement> items = listContainer.findElements(inventoryItems);
        return items.size();

    }

    public void addFirstNProductsToCart(int numberOfProducts){

        WebElement listContainer = driver.findElement(inventoryList);
        List<WebElement> items = listContainer.findElements(inventoryItems);

        int count = Math.min(numberOfProducts, items.size());

        for(int i = 0; i < count; i++){
            WebElement addBtn = items.get(i).findElement(addToCartButton);
            addBtn.click();
        }
    }


}
