package pages;

import org.openqa.selenium.WebElement;
import ui_tests.TestData;
import utils.Log4Test;

/**
 * Created by a.ganushevich on 15.11.2014.
 */
public class ComparisonPage4 extends GeneralPage {


    public WebElement verifyComparison(){

        Log4Test.info("Verify that page contains title: \"Сравнение товаров\"");
        return elementIsLocated(getLocator("linkComparison"));

    }

    public WebElement verifyExistNotebook1(){

        Log4Test.info("Verify that page contains: " + TestData.APPLE_NOTEBOOK1);
        return elementIsLocated(getLocator("linkExistNotebook1"));

    }

    public WebElement verifyExistNotebook2(){

        Log4Test.info("Verify that page contains: " + TestData.APPLE_NOTEBOOK2);
        return elementIsLocated(getLocator("linkExistNotebook2"));

    }

}
