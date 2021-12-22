package co.com.sofka.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebUI {
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_FIREFOX_DRIVER = "webdriver.gecko.driver";

    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/driver/windows/chrome/chromedriver.exe";
    private static final String WEBDRIVER_FIREFOX_DRIVER_PATH = "src/test/resources/driver/windows/firefox/geckodriver.exe";


    private static final String DEMO_QA_URL = "https://demoqa.com/automation-practice-form";

    protected WebDriver driver;

    /*
    protected void setUpWebdriver(){
        System.setProperty(WEBDRIVER_FIREFOX_DRIVER, WEBDRIVER_FIREFOX_DRIVER_PATH);

    }

    protected void setUpWebdriverUrl(){
        driver = new FirefoxDriver();
        driver.get(DEMO_QA_URL);
        driver.manage().window().maximize();
    }

     */

    protected void setUpWebdriver(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);

    }

    protected void setUpWebdriverUrl(){
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
        driver.manage().window().maximize();
    }

    protected void generalSetUp(){
        setUpWebdriver();
        setUpWebdriverUrl();
    }

    protected void quietDriver(){
        driver.close();
    }

}
