package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

import static java.lang.Thread.sleep;

/**
 * Created by a.ganushevich on 14.11.2014.
 */
public class ApplePage3 extends TestBase {

    protected WebElement productContent;

    //Линк на титульную надпись Ноутбуки Apple
    protected By productLink = By.xpath(".//*[@id='head_banner_container']/div[4]/div/div[1]/div[2]/div/div[2]/h1");

    protected By sortingList = By.xpath(".//*[@id='sort_view']/a");

    protected By sortingByExpensive = By.xpath(".//*[@id='sort_view']/div/div/ul/li[2]/a");

    protected By linkAppleNotebook1 = By.xpath(".//div[@class='gtile-i-title']/a[contains(text(),'Z0PU002JE')]");

    protected By linkAppleNotebook2 = By.xpath(".//div[@class='gtile-i-title']/a[contains(text(),'MD712UA/A')]");

    protected By linkCheckboxAppleNotebook1 = By.xpath(".//div[@class='gtile-i-title']/a[contains(text(),'Z0PU002JE')]/../../div[5]/div[1]/label/input");

    protected By linkCheckboxAppleNotebook2 = By.xpath(".//div[@class='gtile-i-title']/a[contains(text(),'MD712UA/A')]/../../div[5]/div[1]/label/input");

    protected By link_K_sravneniyu1 = By.xpath(".//div[@class='c-right']/div/div/div/div/ul/li[1]/a[2]");

    protected By link_K_sravneniyu2 = By.xpath(".//div[@class='c-right']/div/div/div/div/ul/li[2]/a[2]");

    protected By link_V_sravnenii = By.xpath(".//div[@class='c-right']/div/div/div/div/a");


    public WebElement verifyProductContent(){

        Log4Test.info("Verify that page has title: Ноутбуки Apple ");
        return productContent = webDriver.findElement(productLink);

    }

    public void expensiveSorting() throws InterruptedException {

        Log4Test.info("Verify correct working of drop-down list");
        //нажимаем дроп-лист сортировки "по рейтингу"
        webDriver.findElement(sortingList).click();

        sleep(300);

        //выбираем "от дорогих к дешевым"
        webDriver.findElement(sortingByExpensive).click();

    }

    public WebElement verifyAppleNotebook1(){

        Log4Test.info("Verify exists Notebooks Apple1");
        return webDriver.findElement(linkAppleNotebook1);

    }

    public WebElement verifyAppleNotebook2(){

        Log4Test.info("Verify exists Notebooks Apple2");
        return webDriver.findElement(linkAppleNotebook2);

    }


    public WebElement clickCheckboxAppleNotebook1(){

        Log4Test.info("Verify correct click on checkbox next to the Apple Notebook1");
        return webDriver.findElement(linkCheckboxAppleNotebook1);

    }

    public WebElement verify_K_sravneniyu1() {

        Log4Test.info("Verify appears phrases: Notebooks Apple1 on the right side of the page");
        return webDriver.findElement(link_K_sravneniyu1);

    }

    public void clickCheckboxAppleNotebook2JS(){

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", webDriver.findElement(linkCheckboxAppleNotebook2));
    }

    public WebElement clickCheckboxAppleNotebook2(){

        Log4Test.info("Verify correct click on checkbox next to the Apple Notebook2");
        return webDriver.findElement(linkCheckboxAppleNotebook2);
    }

    public WebElement verify_K_sravneniyu2() {

        Log4Test.info("Verify appears phrases: Notebooks Apple2 on the right side of the page");
        return webDriver.findElement(link_K_sravneniyu2);

    }

    public WebElement clickVSravnenii(){

        Log4Test.info("Verify correct click on link: В сравнении");
        return webDriver.findElement(link_V_sravnenii);

    }
}
