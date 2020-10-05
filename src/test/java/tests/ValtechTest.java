package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PartnersPage;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class ValtechTest {
    private WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) {
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
            driver=new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if(browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src//test//resources//msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.valtech.co.uk");
    }

    @Test
    public void partners() {
        HomePage homePage = new HomePage(driver);
        homePage.openMenu();
        homePage.selectPartnersItem();
        PartnersPage partnersPage = new PartnersPage(driver);
        assertEquals(partnersPage.checkPage(), "Partners");
        partnersPage.clickOnOurPartnersButton();
        partnersPage.printPartners();
    }

    @Test
    public void offices() {

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}