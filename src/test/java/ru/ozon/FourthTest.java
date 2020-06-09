package ru.ozon;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.WebCart;
import page.WebJuicers;
import page.WebMain;
import pretraining.Settings;
import results.TestListener;

@Listeners({TestListener.class})
public class FourthTest extends Settings {
    @Test
    public void fourthTest() {
        WebMain mainPage = new WebMain(driver, webDriverWait);

        WebJuicers juicersPage = new WebJuicers(driver);
        juicersPage.openCatalog();

        juicersPage.setMinPrice();
        juicersPage.setMaxPrice();

        juicersPage.setMinPower();

        juicersPage.cheepSort();
        juicersPage.checkPriceRange();
        juicersPage.checkPowerRange();
        juicersPage.addToCart2();


        WebCart basketPage = new WebCart(driver);
        basketPage.openCart();
        basketPage.checkPower();
    }
}