package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

public class ResultPage extends BasePage {
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".mw-page-title-main")
    private WebElement pageTitle;
    //método que comprueba si el título está correcto
    public boolean isTitleCorrect(String title){
        waitElementVisibility(pageTitle);
        return pageTitle.isDisplayed() &&
                pageTitle.getText().equalsIgnoreCase(title);
    }

    @FindBy(css = "li#ca-edit a")
    private WebElement edit;
    public EditPage clickOnEdit(){
        waitElementVisibility(edit);
        edit.click();
        return new EditPage(super.getDriver());
    }

    @FindBy(css = "li#ca-history a")
    /*@FindBy(css = "#ca-history > a > span")*/
    private WebElement historial;
    public HistoryPage clickOnHistorial(){
        waitElementVisibility(historial);
        historial.click();
        return new HistoryPage(super.getDriver());
    }

}
