package pages;

import org.openqa.selenium.By;

import utils.Log4Test;

public class RozetkaWelcomePage1 extends GeneralPage{

    private String URL = "http://rozetka.com.ua/";

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
        waitForPageLoaded();
        elementIsLocated(getLocator("linkNotebooks")).click();


    }


}
