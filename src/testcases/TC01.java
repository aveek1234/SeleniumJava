package testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class TC01
{
    WebDriver driver ;
    @BeforeTest
    @Parameters({"browser","url"})
    public void setup(String browser,String url) throws Exception {

        if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
            System.setProperty("Webdriver.gecko.driver", "/Users/prasenjitnandy/Documents/seleniumDependencies/drivers/geckodriver");

        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
            System.setProperty("Webdriver.chrome.driver", "/Users/prasenjitnandy/Documents/seleniumDependencies/drivers/chromedriver");
        }
        else if (browser.equalsIgnoreCase("safari"))
        {
            driver = new SafariDriver();
        }
        else
        {
            throw new Exception("Incorrect Browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }
    @Test
    public void TestCase1() throws InterruptedException
        {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("aveek.adhya@lexmark.com");
        Thread.sleep(2000);
        loginPage.clickNext();
        Thread.sleep(2000);
        loginPage.enterPassword("Password@1234");
        Thread.sleep(2000);
        loginPage.clickLogin();
        Thread.sleep(4000);
        driver.quit();
    }
}
