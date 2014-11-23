package pages;

import org.openqa.selenium.WebElement;
import ui_tests.TestData;

import java.util.ArrayList;

/**
 * Created by c2613 on 21.11.2014.
 */
public class LoginPage extends GeneralPage {

    private String URL = "https://my.rozetka.com.ua/";

    ArrayList <String> newWindowsSet;

    public WebElement clickAutorizationLink(){

        return elementIsLocated(getLocator("autorizationLink"));

    }

    public void switchToAutorizationWindow(){

        newWindowsSet = new ArrayList<String>(webDriver.getWindowHandles());

        webDriver.switchTo().window(newWindowsSet.get(1));

    }



    public WebElement clickButtonVKontakte(){

        return elementIsLocated(getLocator("buttonVKontakte"));

    }

    public void writeVKLogin(){

        elementIsLocated(getLocator("linkVKLogin")).sendKeys(TestData.MYVKLOGIN);
    }

    public void writeVKPassword(){

        elementIsLocated(getLocator("linkVKPassword")).sendKeys(TestData.MYVKPASS);
    }

    public WebElement clickButtonVoyti(){

        return elementIsLocated(getLocator("buttonVoyti"));
    }


    public WebElement clickButtonRazreshit(){

        return elementIsLocated(getLocator("buttonRazreshit"));
    }


    public void switchToMainWindow(){

        webDriver.switchTo().window(newWindowsSet.get(0));
    }

    public WebElement verifyFIOinTopRightCorner(){

        return elementIsLocated(getLocator("linkFIO"));
    }

    public boolean isOpened()
    {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public WebElement verifyLogin(){

        return elementIsLocated(getLocator("linkVerifyLogin"));
    }

    public WebElement verifyEmail(){

        return elementIsLocated(getLocator("linkVerifyEmail"));
    }
}
