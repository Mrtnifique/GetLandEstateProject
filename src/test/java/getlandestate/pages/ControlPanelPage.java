package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ControlPanelPage {
    public ControlPanelPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//span[@class='d-none d-sm-inline'])[3]")
    public WebElement categoriesButton;

    @FindBy(xpath = "//button[contains(@class,'add-new-btn btn')]")
    public WebElement categoriesAddNewButton;

    @FindBy(id = "title")
    public WebElement categoriesAddNewTitleBox;

    @FindBy(id = "seq")
    public WebElement categoriesAddNewSequenceBox;

    @FindBy(id = "icon")
    public WebElement categoriesAddNewIconBox;

    @FindBy(xpath = "//button[contains(@class,'category-common-button create-button')]")
    public WebElement categoriesAddNewCreateButton;

    @FindBy(name = "search")
    public WebElement categoriesSearchBox;

    @FindBy(xpath = "//button[contains(@class,'search-button btn')]")
    public WebElement categoriesSearchBoxSearchButton;

    @FindBy(xpath = "//div[text()='OhBoyWhataUniqueName']")
    public WebElement muratAssertionData;

    @FindBy(xpath = "(//button[contains(@class,'btn-link btn')])[2]")
    public WebElement categoriesFirstCategoryDeleteButton;

    @FindBy(xpath = "(//span[@class='p-button-label p-c'])[2]")
    public WebElement categoriesDeleteButtonConfirmButton;
}
