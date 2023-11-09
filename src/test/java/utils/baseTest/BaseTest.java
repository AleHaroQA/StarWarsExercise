package utils.baseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;
import utils.MyDriver;

public class BaseTest {

    MyDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser", "url" })
    public void beforeMethod(String browser, String url) {
        //inicializamos el driver
        driver = new MyDriver(browser);
        //podemos configurar como mostrar el browser
        driver.getDriver().manage().window().maximize();
        //navega a la página solicitada
        navigateTo(url);
    }

    /**Navigates to given URL
     * @param url*/
    //Método que nos permite solo navegar
    public void navigateTo(String url) {
        driver.getDriver().get(url);
    }

    /**It instantiates the first page loaded.
     * @return FirstPage*/
    public HomePage loadFirstPage() {
        return new HomePage(driver.getDriver());
    }

    /**After the test execution it closes the browser.*/
    @AfterMethod()
    public void afterMethod() {
        driver.getDriver().close();
    }
}
