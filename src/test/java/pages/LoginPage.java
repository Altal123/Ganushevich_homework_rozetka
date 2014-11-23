package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by c2613 on 21.11.2014.
 */
public class LoginPage extends TestBase {

    private String URL = "https://my.rozetka.com.ua/";

    protected By autorizationLink = By.xpath(".//*[@id='user_menu']/div/a");

    protected By buttonVKontakte = By.xpath(".//*[@type='vkontakte']/a");

    protected By linkVKLogin = By.xpath(".//*[@id='box']/div/input[5]");

    protected By linkVKPassword = By.xpath(".//*[@id='box']/div/input[6]");

    protected By buttonVoyti = By.xpath(".//*[@id='install_allow']");

    protected By buttonRazreshit = By.xpath(".//*[@id='install_allow']");

    protected By linkFIO = By.xpath(".//*[@id='user_menu']/div[2]/a");

    protected By linkVerifyLogin = By.xpath(".//div[@class='iform']/div[1]/div[2]");

    protected By linkVerifyEmail = By.xpath(".//div[@class='iform']/div[2]/div[2]");

    ArrayList <String> newWindowsSet;

    protected String myVKLogin = "";

    protected String myVKPass = "";

    public WebElement clickAutorizationLink(){

        return webDriver.findElement(autorizationLink);

    }

    public void switchToAutorizationWindow(){

        newWindowsSet = new ArrayList<String>(webDriver.getWindowHandles());

        webDriver.switchTo().window(newWindowsSet.get(1));

    }



    public WebElement clickButtonVKontakte(){

        return webDriver.findElement(buttonVKontakte);

    }

    public void writeVKLogin(){

        webDriver.findElement(linkVKLogin).sendKeys(myVKLogin);
    }

    public void writeVKPassword(){

        webDriver.findElement(linkVKPassword).sendKeys(myVKPass);
    }

    public WebElement clickButtonVoyti(){

        return webDriver.findElement(buttonVoyti);
    }


    public WebElement clickButtonRazreshit(){

        return webDriver.findElement(buttonRazreshit);
    }


    public void switchToMainWindow(){

        webDriver.switchTo().window(newWindowsSet.get(0));
    }

    public WebElement verifyFIOinTopRightCorner(){

        return webDriver.findElement(linkFIO);
    }

    public boolean isOpened()
    {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public WebElement verifyLogin(){

        return webDriver.findElement(linkVerifyLogin);
    }

    public WebElement verifyEmail(){

        return webDriver.findElement(linkVerifyEmail);
    }
}
