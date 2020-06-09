package ru.ozon;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.WebMain;
import pretraining.Settings;
import results.TestListener;

@Listeners({TestListener.class})
public class FirstTest extends Settings {

    @Test
    public void firstTest() {
        WebMain mainPage = new WebMain(driver, webDriverWait);
        mainPage.clickLogBut();
        mainPage.inputPhoneNum();
        mainPage.inputCode();
        mainPage.checkSettings();
    }
}

