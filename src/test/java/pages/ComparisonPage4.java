package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui_tests.TestData;
import utils.Log4Test;

/**
 * Created by a.ganushevich on 15.11.2014.
 */
public class ComparisonPage4 extends TestBase {

    protected By linkComparison = By.xpath(".//*[@id='head_banner_container']/div[3]/div/table/thead/tr[1]/td[1]/h1");
    protected By linkExistNotebook1 = By.xpath(".//*[@id='head_banner_container']/div[3]/div/table/thead/tr[2]/td[2]/div[2]/a");
    protected By linkExistNotebook2 = By.xpath(".//*[@id='head_banner_container']/div[3]/div/table/thead/tr[2]/td[3]/div[2]/a");

    public WebElement verifyComparison(){

        Log4Test.info("Verify that page contains title: \"Сравнение товаров\"");
        return webDriver.findElement(linkComparison);

    }

    public WebElement verifyExistNotebook1(){

        Log4Test.info("Verify that page contains: " + TestData.APPLE_NOTEBOOK1);
        return webDriver.findElement(linkExistNotebook1);

    }

    public WebElement verifyExistNotebook2(){

        Log4Test.info("Verify that page contains: " + TestData.APPLE_NOTEBOOK2);
        return webDriver.findElement(linkExistNotebook2);

    }

}
