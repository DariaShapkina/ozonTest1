package ru.ozon;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.WebCart;
import page.WebJuicers;
import page.WebMain;
import pretraining.Settings;
import results.TestListener;

@Listeners({TestListener.class})
public class ThirdTest extends Settings {
    @Test
    public void thirdTest() {
        WebMain mainPage = new WebMain(driver, webDriverWait);

        WebJuicers juicersPage = new WebJuicers(driver);
        juicersPage.openCatalog();
        juicersPage.setMinPrice();
        juicersPage.setMaxPrice();
        juicersPage.cheepSort();
        juicersPage.checkPriceRange();
        juicersPage.addToCart();


        WebCart shopCart = new WebCart(driver);
        shopCart.openCart();
        shopCart.checkPrice();
    }
}
