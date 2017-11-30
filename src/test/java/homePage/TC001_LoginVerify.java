package homePage;





import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageLibrary.HomePage;
import testCase.TestBase;

import java.io.IOException;

/**
 * Created by Sharif on 11/29/2017.
 */
public class TC001_LoginVerify extends TestBase {
    public static final Logger log = Logger.getLogger(TC001_LoginVerify.class.getName());
    HomePage homePage;

    @BeforeTest
    public void setUp()throws IOException{
        init();

    }

    @Test
    public void loginToCredential()throws InterruptedException{
        log.info("=======Etarting verifying credentials test=========");
        homePage = new HomePage(driver);
        homePage.loginToApplication("admin123456@gmail.com","admin1234io");
        Assert.assertEquals(homePage.invalidText(),"Authentication failed.");
        log.info("==========Finished verifying credential test============");
    }
    @AfterClass
    public void endTest(){
        driver.quit();
    }
}
