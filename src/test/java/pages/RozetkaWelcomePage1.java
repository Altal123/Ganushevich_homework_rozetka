package pages;


import core.TestBase;
import org.openqa.selenium.By;

import utils.Log4Test;

public class RozetkaWelcomePage1 extends TestBase{

    private String URL = "http://rozetka.com.ua/";

    protected By searchString = By.className("header-search-input-text");
    protected By linkNotebooks = By.linkText("Ноутбуки");

    public void open()
    {

        webDriver.get(URL);
        Log4Test.info("Open WebUrl " + URL);

    }

    public boolean isOpened()
    {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void clickOnNotebooks()
    {
        Log4Test.info("Click on link Notebooks");
        webDriver.findElement(linkNotebooks).click();

    }


}
