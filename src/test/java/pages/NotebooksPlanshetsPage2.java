package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui_tests.TestData;
import utils.Log4Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by a.ganushevich on 14.11.2014.
 */
public class NotebooksPlanshetsPage2 extends GeneralPage {

    List<WebElement> listOfManufactures;

    public WebElement verifyProductContent(){

        Log4Test.info("Verify that the page is Ноутбуки and tab Ноутбуки, планшеты и компьютеры in active condition");
        return elementIsLocated(getLocator("linkTitleNotebooks"));

    }

    public int verifyQuantityOfManufacturers(){

        //коллекция производителей ноутбуков
        listOfManufactures = webDriver.findElements(getLocator("linkOfAllmanufacturers"));

        int quantity = 0;

        for(WebElement l : listOfManufactures){

            quantity++;

        }
        Log4Test.info("Verify quantity of manufactures");
        return quantity;
        //return listOfManufactures.size(); It`s more easy way ;)

    }

    public WebElement getAppleLink() {

        Iterator<WebElement> i = listOfManufactures.iterator();

        WebElement appleLink = null;

        while (i.hasNext()) {

            WebElement row = i.next();

            if (row.getText().equals(TestData.MANUFACTURER_NAME)) {

                appleLink = row.findElement(By.linkText(TestData.MANUFACTURER_NAME));

            }
        }
        Log4Test.info("Verify exists right Apple link");
        return appleLink;
    }


}
