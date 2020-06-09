package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebJuicers {
    WebDriver driver;
    WebDriverWait wait;

    public WebJuicers(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[1]/input")
    private WebElement minPrice;

    @FindBy(xpath = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[8]/div[2]/div[2]/div[1]/input")
    private WebElement minPower;

    @FindBy(xpath = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[2]/input")
    private WebElement maxPrice;

    @FindBy(xpath = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/button/div")
    private WebElement priceRange;

    @FindBy(xpath = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/button/div/span")
    private WebElement powerRange;

    @FindBy(xpath = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div/div/input")
    private WebElement chooseSortTypeInput;

    @FindBy(xpath = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div[3]/div/div/button/div/div")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div[3]/div[3]/div/div/button/div/div")
    private WebElement addPowerToCart;

    @FindBy(xpath = "//*[@id=\"__ozon\"]/div/div[1]/header/div[1]/div[4]/a[2]/svg")
    private WebElement gotoCart;

    protected static final String priceLocation = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span";
    protected static final String buttonCart = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div[3]/div/div/button/div/div";

    @Step("Перейти в соковыжималки")
    public void openCatalog() {
        driver.get("https://www.ozon.ru/category/sokovyzhimalki-10592/");
        wait.until(ExpectedConditions.visibilityOf(minPrice));
    }

    @Step("Выставить минимальную цену")
    public void setMinPrice() {
        minPrice.sendKeys("\b\b\b");
        minPrice.sendKeys(Integer.toString(3000));
        minPrice.sendKeys(Keys.ENTER);
    }

    @Step("Выставить максимальную цену")
    public void setMaxPrice() {
        maxPrice.sendKeys("\b\b\b\b\b");
        maxPrice.sendKeys(Integer.toString(4000));
        maxPrice.sendKeys(Keys.ENTER);
    }

    @Step("Выставить минимальную мощность")
    public void setMinPower() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceLocation)));
        minPower.sendKeys("\b\b");
        minPower.sendKeys(Integer.toString(1000));
        minPower.sendKeys(Keys.ENTER);
    }



    @Step("Сортировка по цене")
    public void cheepSort() {
        chooseSortTypeInput.click();
        for(int i = 0; i < 2; i++) {
            chooseSortTypeInput.sendKeys(Keys.ARROW_DOWN);
        }
        chooseSortTypeInput.sendKeys(Keys.ENTER);
    }

    @Step("Проверка цен")
    public void checkPriceRange() {
        String priceRange = "Цена: от 3 000 до 4 000";
        Assert.assertEquals(priceRange, this.priceRange.getText());
    }

    @Step("Проверка мощности")
    public void checkPowerRange() {
        String powerRange = "Мощность, Вт: от 1 000 до 1 000";
        Assert.assertEquals(powerRange, this.powerRange.getText());
    }

    @Step("Добавить в корзину")
    public void addToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonCart)));
        addToCart.click();
    }


    @Step("Добавить в корзину мощную")
    public void addToCart2() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonCart)));
        addPowerToCart.click();
    }
}
