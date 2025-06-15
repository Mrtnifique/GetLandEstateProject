package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ControlPanelPage {
    public ControlPanelPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Categories Page
    @FindBy(xpath = "(//span[@class='d-none d-sm-inline'])[3]")
    public WebElement categoriesButton;

    //Advert Types Page
    @FindBy(xpath = "//span[text()='Advert Types']")
    public WebElement advertTypeButton;

    //Categories/"+" Button
    @FindBy(xpath = "//button[contains(@class,'add-new-btn btn')]")
    public WebElement categoriesAddNewButton;

    //Categories/Add new/Title Bar
    @FindBy(id = "title")
    public WebElement categoriesAddNewTitleBox;

    //Categories/Add new/Sequence Bar
    @FindBy(id = "seq")
    public WebElement categoriesAddNewSequenceBox;

    //Categories/Add new/Icon Text Bar
    @FindBy(id = "icon")
    public WebElement categoriesAddNewIconBox;

    //Categories/Add new/Create Button
    @FindBy(xpath = "//button[contains(@class,'category-common-button create-button')]")
    public WebElement categoriesAddNewCreateButton;

    //Categories/Search Box
    @FindBy(name = "search")
    public WebElement categoriesSearchBox;

    //Categories/Search Button
    @FindBy(xpath = "//button[contains(@class,'search-button btn')]")
    public WebElement categoriesSearchBoxSearchButton;

    // TC15 Test Data
    @FindBy(xpath = "//div[text()='OhBoyWhataUniqueName']")
    public WebElement muratAssertionData;

    //Categories/Delete Button for the First Visible Category
    @FindBy(xpath = "(//button[contains(@class,'btn-link btn')])[2]")
    public WebElement categoriesFirstCategoryDeleteButton;

    //Categories/Delete Alert Confirmation
    @FindBy(xpath = "(//span[@class='p-button-label p-c'])[2]")
    public WebElement categoriesDeleteButtonConfirmButton;

    //Edit Button for the First Visible Advert
    @FindBy(xpath = "(//button[@title='Edit'])[1]")
    public WebElement advertTitleEditButton;

    //Edit Section Advert Title for the First Visible Advert
    @FindBy(xpath = "(//input[@name='title'])[1]")
    public WebElement firstAdvertTitle;

    //Advert Types/Add New/Create Button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement advertTypeCreateButton;

    //Advert Types/Search Button
    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement advertTypeSearchButton;
}
