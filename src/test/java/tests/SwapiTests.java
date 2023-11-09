package tests;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EditPage;
import pages.HistoryPage;
import pages.HomePage;
import pages.ResultPage;
import utils.baseTest.BaseTest;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;


public class SwapiTests extends BaseTest {

    @Test
    @Ignore
    public void searchTest(){

        Response response;
        response = given().get("https://swapi.dev/api/people/1");
        String name =  response.then().extract().path("name");
        HomePage home = loadFirstPage();

        ResultPage results = home.searchText(name);

        assertTrue(results.isTitleCorrect(name), "The title does not match.");
    }

    @Test
    @Ignore
    public void searchFilmTest(){

        Response response;

        Random random = new Random();
        int numFilm = random.nextInt(6);

        response = given().get("https://swapi.dev/api/films/" + numFilm );
        String nameFilm =  response.then().extract().path("title");
        HomePage home = loadFirstPage();

        ResultPage results = home.searchText(nameFilm);

        EditPage editResult = results.clickOnEdit();

        assertTrue(editResult.isTitleEditCorrect(nameFilm), "The title does not match.");
    }

    @Test
    public void FilmHistorialTest(){

        Response response;

        /*Random random = new Random();
        int numFilm = random.nextInt(1,6);*/

        response = given().get("https://swapi.dev/api/films/6" );
        String nameFilm =  response.then().extract().path("title");
        System.out.println(nameFilm);
        HomePage home = loadFirstPage();

        ResultPage results = home.searchText(nameFilm);

        HistoryPage historyResults = results.clickOnHistorial();

        assertTrue(historyResults.isTitleHistoryCorrect(nameFilm), "The title does not match.");
    }
}


/*private WebDriver driver = new ChromeDriver();

    @FindBy(css = "[name='search']")
    private WebElement searchInput;

    @FindBy(css= "#searchform button")
    private WebElement searchButton;

    @Given("Soy un usuario en la página web de Wikipedia solicitando el personaje de Star Wars número 1")
    public void user_is_on_wikipedia() {

        driver.get("https://www.wikipedia.org/wiki/Wikipedia:Portada");
    }

    @When("Busco el nombre del personaje solicitado en la página de búsqueda de Wikipedia")
    public void enter_character() {

        searchInput.sendKeys("Luke Skywalker");
        searchButton.click();
    }

    @Then("Debería poder ver correctamente la página del artículo para el personaje solicitado")
    public void direct_to_resultPage() {
        driver.get("https://en.wikipedia.org/wiki/Luke_Skywalker");
    }

    @After()
    public void closeBrowser()
    {
        driver.close();
    }*/