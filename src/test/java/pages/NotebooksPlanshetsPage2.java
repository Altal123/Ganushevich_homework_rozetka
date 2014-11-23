package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui_tests.TestData;
import utils.Log4Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by a.ganushevich on 14.11.2014.
 */
public class NotebooksPlanshetsPage2 extends TestBase {

    //Линк на заголовок: ноутбуки, планшеты и компьютеры
    protected By productLink = By.xpath("//td[@id='computers-notebooks']/div[@class='m-main-i active']/a[1]/span");

    List<WebElement> listOfManufactures;

    protected WebElement productContent;

    public WebElement verifyProductContent(){

        Log4Test.info("Verify that the page is Ноутбуки and tab Ноутбуки, планшеты и компьютеры in active condition");
        return productContent = webDriver.findElement(productLink);

    }

    public int verifyQuantityOfManufacturers(){

        //коллекция производителей ноутбуков
        listOfManufactures = webDriver.findElements(By.xpath(".//*[@id='head_banner_container']/div[4]/div/div/div[2]/div[3]/ul/li[2]/ul/li"));

        int quantity = 0;

        for(WebElement link : listOfManufactures){

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
        //не забыть добавить проверку что appleLink != null.
        return appleLink;
    }


}
