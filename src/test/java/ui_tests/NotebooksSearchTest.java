package ui_tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.*;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class NotebooksSearchTest extends TestBase {

    RozetkaWelcomePage1 rozetkaWelcomePage1 = new RozetkaWelcomePage1();

    NotebooksPlanshetsPage2 notebooksPlanshetsPage2 = new NotebooksPlanshetsPage2();

    ApplePage3 applePage3 = new ApplePage3();

    ComparisonPage4 comparisonPage4 = new ComparisonPage4();

    LoginPage loginPage = new LoginPage();

    @Test
    public void setUpPreconditions(){

        rozetkaWelcomePage1.open();

        assertTrue(rozetkaWelcomePage1.isOpened());

    }

    @Test(dependsOnMethods = {"setUpPreconditions"}, priority = 1, enabled = true)
    public void searchNotebooks() throws InterruptedException {

        //click in link "Notebooks"
        rozetkaWelcomePage1.clickOnNotebooks();

        //Verify that the page is Ноутбуки and tab Ноутбуки, планшеты и компьютеры is active
        assertTrue(notebooksPlanshetsPage2.verifyProductContent().getText().contains(TestData.NOTEBOOKS));

        //verify that all 9 manufactures are present
        assertEquals(notebooksPlanshetsPage2.verifyQuantityOfManufacturers(), TestData.QUANTITY_OF_MANUFACTURERS);

        //look for an Apple and click on it.
        notebooksPlanshetsPage2.getAppleLink().click();


        //Verify that the page is Ноутбуки Apple
        assertTrue(applePage3.verifyProductContent().getText().contains(TestData.APPLE_NOTEBOOKS));

        //Click "Выводить: от дорогих к дешевым"
        applePage3.expensiveSorting();

        //Verify that there are Apple MacBook Pro Retina 15" (Z0PU002JE) and Apple MacBook Air 11" (MD712UA/A)
        assertTrue(applePage3.verifyAppleNotebook1().getText().contains(TestData.APPLE_NOTEBOOK1));
        assertTrue(applePage3.verifyAppleNotebook2().getText().contains(TestData.APPLE_NOTEBOOK2));

        //Click boolean check "К сравнению" for Apple MacBook Pro Retina 15" (Z0PU002JE)
        applePage3.clickCheckboxAppleNotebook1().click();

        //Verify that button was clicked
        //assertTrue(applePage3.clickCheckboxAppleNotebook1().isSelected());

        //Verify that appears "Cписок сравнения:" on the right side of the page.
        assertEquals(applePage3.verify_K_sravneniyu1().getText(), TestData.APPLE_NOTEBOOK1 + TestData.OFFICIAL_GUARANTEE);

        //Click boolean check "К сравнению" for Apple MacBook Air 11" (MD712UA/A)
        applePage3.clickCheckboxAppleNotebook2JS();

        //Verify that button was clicked
        //assertTrue(applePage3.clickCheckboxAppleNotebook2().isSelected());

        //Verify that appeared "Cписок сравнения:" with contains   Apple_notebook1 и Apple_notebook2
        assertEquals(applePage3.verify_K_sravneniyu1().getText(), TestData.APPLE_NOTEBOOK1 + TestData.OFFICIAL_GUARANTEE);
        assertEquals(applePage3.verify_K_sravneniyu2().getText(), TestData.APPLE_NOTEBOOK2 + TestData.OFFICIAL_GUARANTEE);

        //Click "В сравнении" from one of the product's name above
        applePage3.clickVSravnenii().click();

        //Verify that the page contains "Сравнение товаров"
        assertTrue(comparisonPage4.verifyComparison().getText().contains(TestData.COMPARISON_NOTEBOOKS));

        //Verify that the page "Добавить модель should contain Apple MacBook Pro Retina 15" (Z0PU002JE) Официальная гарантия! and
        //Apple MacBook Air 11" (MD712UA/A) Официальная гарантия!
        assertEquals(comparisonPage4.verifyExistNotebook1().getText(), TestData.APPLE_NOTEBOOK1 + TestData.OFFICIAL_GUARANTEE);
        assertEquals(comparisonPage4.verifyExistNotebook2().getText(), TestData.APPLE_NOTEBOOK2 + TestData.OFFICIAL_GUARANTEE);

    }

    @Test(dependsOnMethods = {"setUpPreconditions"}, priority = 2, enabled = false)
    public void loginIntoRozetka() throws InterruptedException {

        loginPage.clickAutorizationLink().click();

        sleep(1000);

        loginPage.clickButtonVKontakte().click();

        loginPage.switchToAutorizationWindow();

        loginPage.writeVKLogin();

        loginPage.writeVKPassword();

        loginPage.clickButtonVoyti().click();

        loginPage.clickButtonRazreshit().click();

        sleep(1000);

        loginPage.switchToMainWindow();

        //Verify that your First and Last Name appeared on the top right corner
        assertEquals(loginPage.verifyFIOinTopRightCorner().getText(),TestData.MY_FIO);

        loginPage.verifyFIOinTopRightCorner().click();

        //Verify  - Мои настройки page is opened
        assertTrue(loginPage.isOpened());

        //Verify - Ваше имя and Электронная почтa are valid
        assertEquals(loginPage.verifyLogin().getText(),TestData.MY_FIO);
        assertEquals(loginPage.verifyEmail().getText(),TestData.EMAIL);

    }

}
