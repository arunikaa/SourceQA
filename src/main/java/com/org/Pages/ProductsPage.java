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
    private final By shoppingCart = By.cssSelector(".shopping_cart_link");


    public ProductsPage(WebDriver driver){
        super(driver);
        logger.info("Product page initialized");

    }

    //Check the navigation to the products page

    public String checkProductsAvailability(){

        WebElement elem = driver.findElement(txt_products);
        return  elem.getText();

    }

    //Check number of products available in the inventory
    public int checkNumberOfProductsAvailable(){

        WebElement listContainer = driver.findElement(inventoryList);
        List<WebElement> items = listContainer.findElements(inventoryItems);


        return items.size();
    }

    //Add defined number of products to the cart
    public void addFirstNProductsToCart(int numberOfProducts){

        WebElement listContainer = driver.findElement(inventoryList);
        List<WebElement> items = listContainer.findElements(inventoryItems);

        int count = Math.min(numberOfProducts, items.size());
        for(int i = 0; i < count; i++){
            WebElement addBtn = items.get(i).findElement(addToCartButton);
            addBtn.click();
        }
    }

    //return the number of products in the shopping cart

    public int getItemsInCart(){
        String count= driver.findElement(shoppingCart).getText();
        return Integer.parseInt(count);

    }

}
