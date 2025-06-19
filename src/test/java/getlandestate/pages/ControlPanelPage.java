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

    //Users Page
    @FindBy(xpath = "(//a[@class='side-menu-link nav-link'])[5]")
    public WebElement usersButton;

    //Tour Requests Page
    @FindBy(xpath = "//a[@title='Tour Requests']")
    public WebElement tourRequestsButton;

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

    // TC15 Test Data
    @FindBy(xpath = "//div[text()='Tobias Rieper']")
    public WebElement muratAssertionData2;

    //TC15 Test Data
    @FindBy(xpath = "//div[text()='HouseMD']")
    public WebElement muratAssertionData3;

    //TC15 Test Data
    @FindBy(xpath = "//p[text()='gupguzel ev']")
    public WebElement muratAssertionData4;

    //Categories/Delete Button for the First Visible Category
    @FindBy(xpath = "(//button[contains(@class,'btn-link btn')])[2]")
    public WebElement categoriesFirstCategoryDeleteButton;

    //Categories/Delete Alert Confirmation
    @FindBy(xpath = "(//span[@class='p-button-label p-c'])[2]")
    public WebElement categoriesDeleteButtonConfirmButton;

    //Edit Button for the First Visible Advert
    @FindBy(xpath = "(//button[@title='Edit'])[1]")
    public WebElement advertTitleEditButton;

    //Edit Button for the First Visible User
    //Short version does not work for some reason
    @FindBy(xpath = "//div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/div[1]/button[2]")
    public WebElement usersEditButton;

    //Edit Section Advert Title for the First Visible Advert
    @FindBy(xpath = "(//input[@name='title'])[1]")
    public WebElement firstAdvertTitle;

    //Advert Types/Add New/Create Button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement advertTypeCreateButton;

    //Advert Types/Search Button
    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement advertTypeSearchButton;

    //Users/Edit/Role
    @FindBy(id = "role")
    public WebElement userRole;

    //Users/Edit/Update Button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement userEditUpdateButton;

    //Users/User Role Text
    @FindBy(xpath = "//span[@data-pc-section='value']")
    public WebElement userRoleText;

    //Categories/Edit/Update Button
    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement categoriesEditUpdateButton;

    //Categories/Edit/Back Button
    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement categoriesEditBackButton;


    //Seval Aslan  baslangic 123



































































































    //Seval Aslan  bitis 223

    // Ayhan Togan baslangic 225










































































    // Ayhan Togan bitis 300

    //Merve Subas baslangic 302










































































    //Merve Subas bitis 377

    //Ruhin Bey baslangic 379













































































    //Ruhin Bey bitis 457

    //Sumeyye Niyet baslangic 459

































































    //Sumeyye Niyet bitis 525

    //Pinar Yuzer baslangic 527










































































    //Pinar Yuzer bitis 602

    //Semih Oner baslangic 604







































































    //Semih Oner bitis 676

    //Emine Gurses baslangic 678










































































    //Emine Gurses bitis 753

    //Selin Onal baslangic 755








































































    //Selin Onal bitis 828

    //Rezzan Erva Odabaşı 830
    //Pen button
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/div[1]/button[2]")
    public WebElement penButton;

    //User update button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement userUpdateButton;

    //Erva data doogrulama
    @FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]")
    public WebElement yildizDisplayed;

    //Erva data assert
    @FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]")
    public WebElement ladyYildizDisplayed;


































































    //Rezzan Erva Odabaşı bitis 898

    //Emine Arı Baslangıc 900








































































    //Emine Arı bitis 973

    //Fatih Üstünyer baslangic 975










































































    //Fatih Üstünyer bitis 1050
}
