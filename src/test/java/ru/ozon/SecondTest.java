package ru.ozon;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.WebCity;
import page.WebMain;
import pretraining.Settings;
import results.TestListener;

@Listeners({TestListener.class})
public class SecondTest extends Settings {

    @Test
    public void secondTest() {
        WebMain mainPage = new WebMain(driver, webDriverWait);
        WebCity cityPage = new WebCity(driver);
        cityPage.clickCityLbl();
        cityPage.inputCity();
        cityPage.checkNewCity();
        mainPage.clickLogBut();
        mainPage.inputPhoneNum();
        mainPage.inputCode();
        mainPage.checkSettings();
        cityPage.checkNewCityAfter();
    }
}
