package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

public class EditPage extends BasePage {
    public EditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "firstHeading")
    private WebElement editTitle;

    public boolean isTitleEditCorrect(String nameFilm){
        waitElementVisibility(editTitle);
        return editTitle.isDisplayed() &&
                editTitle.getText().toString().contains(nameFilm);
    }
}
