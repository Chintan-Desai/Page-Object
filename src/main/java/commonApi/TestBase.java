package commonApi;

import ExcelReader.excelReader;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by Sharif on 11/29/2017.
 */
public class TestBase {

    public static final Logger log = Logger.getLogger(TestBase.class.getName());
    excelReader excel;

    public static WebDriver driver;
    String url = "http://automationpractice.com/index.php";
    String browser = "chrome";

   /* public static Properties Repository = new Properties();
    public static File f;
    public static FileInputStream FI;*/
    //public static ExtentReports extent;
    //public static ExtentTest test;


    public void init()throws IOException{
        selectBrowser(browser);
        getUrl(url);
        String log4jConfigPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfigPath);
    }

    public void selectBrowser(String browser){
        if(browser.equals("chrome")||browser.equals("CHROME")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//drivers//chromedriver.exe");
            log.info("Creating the object of "+browser);
            driver = new ChromeDriver();
        }else if (browser.equals("firefox")||browser.equals("FIREFOX")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//drivers//chromedriver.exe");
            log.info("Creating the object of "+browser);
            driver = new ChromeDriver();
        }else if(browser.equals("ie")||browser.equals("IE")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//drivers//chromedriver.exe");
            log.info("Creating the object of "+browser);
            driver = new ChromeDriver();
        }
    }

    public void getUrl(String url){
        log.info("Navigating to "+url);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public String[][] getData(String excelName, String sheetName) {
        String path = System.getProperty("user.dir") + "//src//main//java//excelData" + excelName;
        excel = new excelReader(path);
        String[][] data = excel.getDataFromSheet(sheetName, excelName);
        return data;
    }

    /*public void loadPropertiesFile()throws IOException{
        f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
        FI = new FileInputStream(f);
        Repository.load(FI);
    }*/



}
