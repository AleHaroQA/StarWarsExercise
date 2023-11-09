package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

public class HistoryPage extends BasePage {

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "firstHeading")
    private WebElement historyTitle;

    public boolean isTitleHistoryCorrect(String nameFilm){
        waitElementVisibility(historyTitle);
        return historyTitle.isDisplayed() &&
                historyTitle.getText().toString().contains(nameFilm);
    }
}
