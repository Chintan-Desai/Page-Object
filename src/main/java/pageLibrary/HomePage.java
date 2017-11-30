package pageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testCase.TestBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by Sharif on 11/29/2017.
 */
public class HomePage{
    public static final Logger log = Logger.getLogger(HomePage.class.getName());
    WebDriver driver;

    @FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    WebElement signIn;

    @FindBy(xpath = ".//*[@id='email']")
    WebElement LoginEmailId;

    @FindBy(xpath = ".//*[@id='passwd']")
    WebElement LoginPassword;

    @FindBy(xpath = ".//*[@id='SubmitLogin']")
    WebElement submitButton;

    @FindBy(xpath = ".//*[@id='center_column']/div[1]/ol/li")
    WebElement AuthenticationFailed;


    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void loginToApplication(String email, String password)throws InterruptedException{
        signIn.click();
        log.info("Clicked on sign in and object is :-"+signIn.toString());
        LoginEmailId.sendKeys(email);
        log.info("Entered email address:-"+email+" and object is :-"+LoginEmailId.toString());
        LoginPassword.sendKeys(password);
        log.info("Entered password:-"+password+" and object is:-"+LoginPassword.toString());
        submitButton.click();
        log.info("Elicked on submit button and object is:-"+submitButton.toString());
    }
    public String invalidText(){
        log.info("Error message is:-"+AuthenticationFailed.getText());
        return AuthenticationFailed.getText();
    }


}
