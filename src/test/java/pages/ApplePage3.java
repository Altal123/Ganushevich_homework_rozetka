package pages;

import org.openqa.selenium.WebElement;
import utils.Log4Test;

import static java.lang.Thread.sleep;

/**
 * Created by a.ganushevich on 14.11.2014.
 */
public class ApplePage3 extends GeneralPage {

    protected WebElement productContent;

    public WebElement verifyProductContent(){

        Log4Test.info("Verify that page has title: Ноутбуки Apple ");
        return elementIsLocated(getLocator("productLink"));

    }

    public void expensiveSorting() throws InterruptedException {

        Log4Test.info("Verify correct working of drop-down list");
        //нажимаем дроп-лист сортировки "по рейтингу"
        elementIsLocated(getLocator("sortingList")).click();

        sleep(300);

        //выбираем "от дорогих к дешевым"
        elementIsLocated(getLocator("sortingByExpensive")).click();

    }

    public WebElement verifyAppleNotebook1(){

        Log4Test.info("Verify exists Notebooks Apple1");
        return elementIsLocated(getLocator("linkAppleNotebook1"));

    }

    public WebElement verifyAppleNotebook2(){

        Log4Test.info("Verify exists Notebooks Apple2");
        return elementIsLocated(getLocator("linkAppleNotebook2"));

    }


    public WebElement clickCheckboxAppleNotebook1(){

        Log4Test.info("Click on checkbox beside the Apple Notebook1");
        return elementIsLocated(getLocator("linkCheckboxAppleNotebook1"));

    }

    public boolean verifyCheckboxAppleNotebook1WasClicked(){
        Log4Test.info("Verification that checkbox beside the Apple Notebook1 was clicked");
        return elementIsSelected(getLocator("linkClickedCheckboxAppleNotebook1"));
    }

    public WebElement verify_K_sravneniyu1() {

        Log4Test.info("Verify appears phrases: Notebooks Apple1 on the right side of the page");
        return elementIsLocated(getLocator("link_K_sravneniyu1"));

    }

    public WebElement clickCheckboxAppleNotebook2(){

        Log4Test.info("Click on checkbox beside the Apple Notebook2");
        return elementIsLocated(getLocator("linkCheckboxAppleNotebook2"));
    }

    public boolean verifyCheckboxAppleNotebook2WasClicked(){
        Log4Test.info("Verification that checkbox beside the Apple Notebook2 was clicked");
        return elementIsSelected(getLocator("linkClickedCheckboxAppleNotebook2"));
    }

    public WebElement verify_K_sravneniyu2() {

        Log4Test.info("Verify appears phrases: Notebooks Apple2 on the right side of the page");
        return elementIsLocated(getLocator("link_K_sravneniyu2"));

    }

    public WebElement clickVSravnenii(){

        Log4Test.info("Verify correct click on link: В сравнении");
        return elementIsLocated(getLocator("link_V_sravnenii"));

    }
}
