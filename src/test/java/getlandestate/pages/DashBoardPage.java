package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
    public DashBoardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Login Button
    @FindBy(linkText = "Login")
    public WebElement loginButton;

    //Search Box
    @FindBy(xpath = "//button[@class='btn btn-primary']//*[name()='svg']")
    public WebElement searchBox;

    //Filter Page
    @FindBy(xpath = "//select[@id='c']")
    public WebElement categoryFilter;

    //Country Filter
    @FindBy(xpath = "//select[@id='ctry']")
    public WebElement countryFilter;

    //City Filter
    @FindBy(xpath = "//select[@id='city']")
    public WebElement cityFilter;

    //District Filter
    @FindBy(xpath = "//select[@id='dist']")
    public WebElement districtFilter;

    //Filter Search Button
    @FindBy(xpath = "//button[normalize-space()='Search']")
    public WebElement filterSearchButton;

    //House Displayed
    @FindBy(xpath = "//img[@alt='Scenic_Spacious_Garden_House']")
    public WebElement houseDisplayed;

    //House Click
    @FindBy(xpath = "//img[@alt='Scenic_Spacious_Garden_House']")
    public WebElement houseClick;

    //Contact Number Eyes Button
    @FindBy(xpath = "//div[contains(@class,'advert-details-owner-phone')]//button[2]")
    public WebElement contactNumberEyesButton;

    //Contact Alert
    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement contactAlert;

    //Contact Alert Close Button
    @FindBy(xpath = "//button[@class='close-button btn btn-primary']//*[name()='svg']")
    public WebElement contactAlertCloseButton;

    //Tour Date
    @FindBy(xpath = "//input[@id='tourDate']")
    public WebElement tourDate;

    //Tour Time
    @FindBy(xpath = "//select[@id='tourTime']")
    public WebElement tourTime;

    //Submit Tour Request Button
    @FindBy(xpath = "//div[@class='tour-request-form-button-wrapper']")
    public WebElement submitTourRequestButton;

    //Contact Alert
    @FindBy(xpath = "//div[@class='auth-modal-body modal-body']")
    public WebElement contactAlert2;

    //Create one now butonuna tıklanır
    @FindBy(xpath = "//span[@class='register-link']")
    public WebElement createOneNowButton;


    //Tour date is required
    @FindBy(xpath = "//div[normalize-space()='Tour date is required']")
    public WebElement tourDateIsRequired;

    //Tour time is required
    @FindBy(xpath = "//div[normalize-space()='Tour time is required']")
    public WebElement tourTimeIsRequired;


    // Contact
    @FindBy(xpath= "//*[@id='offcanvas-menu']/div[2]/div[1]/a[4]")
    public WebElement contact;

    // Contact FirstName
    @FindBy(xpath= "//*[@id='firstName']")
    public WebElement firstName;

    // Contact Lastname
    @FindBy(xpath= "//*[@id='lastName']")
    public WebElement lastName;

    // Contact email
    @FindBy(xpath= "//*[@id='email']")
    public WebElement  email;

    // Contact message
    @FindBy(xpath= "//*[@id='message']")
    public WebElement message;

    // Contact Submit Button
    @FindBy(xpath= "//button[@type='submit']")
    public WebElement submitButton;

    // Contact Submit Button negatif
    @FindBy(xpath= "//button[@type='submit']")
    public WebElement submitButton01;

    // Contact Firstname warning
    @FindBy(xpath= "//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/form/div[1]/div")
    public WebElement firstNameWarning;

    // Contact Lastname warning
    @FindBy(xpath= "//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/form/div[2]/div")
    public WebElement lastNameWarning;

    // Contact required email warning
    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/form/div[3]/div")
    public WebElement requiredEmailWarning;

    //Contact invalid email warning
    @FindBy(xpath= "//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/form/div[3]/div")
    public WebElement invalidEmailWarning;

    // Contact success Message
    @FindBy(xpath= "//div[@class='p-toast-detail']")
    public WebElement successMessage;



    //Seval Aslan  baslangic 140



































































































    //Seval Aslan  bitis 240

    // Ayhan Togan baslangic 242










































































    // Ayhan Togan bitis 317

    //Merve Subas baslangic 319










































































    //Merve Subas bitis 394

    //Ruhin Bey baslangic 396













































































    //Ruhin Bey bitis 474

    //Sumeyye Niyet baslangic 476

































































    //Sumeyye Niyet bitis 542

    //Pinar Yuzer baslangic 544
    @FindBy(xpath = "//div[@class='user-logo-nav navbar-nav']")
    public WebElement dashboardButton;

    @FindBy(xpath = "//span[normalize-space()='My Tour Requests']")
    public WebElement MyTourRequestsButton;

    @FindBy(xpath = "//button[@class='nav-link active']")
    public WebElement MyResponseButton;
    // Randevu listesini tutan ana container

    @FindBy(xpath = "//div[@class='tr-datatable-wrapper']//div[contains(@class, 'card')]")
    public WebElement randevuListesi;


    @FindBy(xpath = "(//p[contains(text(),'Sahibinden Satılık Uygun Daire')])[1]")
    public WebElement ilanAdi;

    @FindBy(xpath = "(//div[contains(text(),'azra yılmaz')])[1]")
    public WebElement talepEden;

    @FindBy(xpath = "//td[contains(., '04.08.3205')]")
    public WebElement turTarihi;

    @FindBy(xpath = "//td[contains(., 'PM') or contains(., 'AM')]")
    public WebElement turSaati;

    @FindBy(xpath = "(//button[@type='button'])[16]")
    public WebElement onayButton;

    @FindBy(xpath = "(//button[@aria-label='Evet'])[1]")
    public WebElement yesButton;

    @FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[21]")
    public WebElement kabulEtButton;

    @FindBy(xpath = "(//button[@type='button'])[17]")
    public WebElement redButton;

    @FindBy(xpath = "//span[contains(text(),'Onaylandi')]")
    public WebElement Onaylandi;

    @FindBy(xpath = "//tr[@draggable='false']//span[@class='p-tag-value'][normalize-space()='DECLINED']")
    public WebElement pasifIlanaAitRandevuTalebi;
    //US14-TC01 icin lazım locate'ler---------------------------------------------
    // Aktif ilan için randevu
    @FindBy(xpath = "//tr[@draggable='false']//td[@role='cell']//div//div//div[@class='getproperty']")
    public WebElement aktifIlani;
    //tur ayarla formu
    @FindBy(xpath = "//h3[normalize-space()='Tur Ayarla']")
    public WebElement turAyarlaFormu;
    //tarih secme
    @FindBy(xpath = "//input[@id='tourDate']")
    public WebElement tarihSecme;
    //saat secme
    @FindBy(xpath = "//select[@id='tourTime']")
    public WebElement saatSecme;
    //tur talebi gonder butonu
    @FindBy(xpath = "//button[normalize-space()='Tur talebi gönder']")
    public WebElement turTalebiGonderButton;
    //talebiniz gonderildi
    @FindBy(xpath = "//div[@class='p-toast-message-text']")
    public WebElement talebinizGonderildi;
    //tur talebi beklemede olarak listelenir
    @FindBy(xpath = "(//td[@role='cell'])[3]")
    public WebElement turTalebiBeklemede;
    //US14-TC02 icin lazım locate'ler---------------------------------------------
    @FindBy(xpath = "//a[@href='/my-adverts']")
    public WebElement ilanlarimButton;
    //ilan listesi
    @FindBy(xpath = "//div[@class='advert-container container']")
    public WebElement ilanListesi;
    //ilan detay sayfasi
    @FindBy(xpath = "(//div[@class='text'])[1]")
    public WebElement ilanDetay;
    //detay sayfasi
    @FindBy(xpath = "//div[@class='user-layout-spacer']")
    public WebElement detaySayfasi;
    //Durum butonu
    @FindBy(xpath = "//div[@id='react-aria8364566776-:r5:-tabpane-response']//thead[@class='p-datatable-thead']//span[@class='p-column-title'][normalize-space()='Durum']")
    public WebElement durumElement;











































































    //Pinar Yuzer bitis 619

    //Semih Oner baslangic 621
    //Anasayfa Rent Button
    @FindBy (xpath = "//button[text()='Rent']")
    public WebElement homePageRentButton;
    //Ilanda cikan 2. ilan
    @FindBy (xpath = "(//div[@class='property-card card'])[3]")
    public WebElement semihTest1;
    //Ilanda ki RENT yazisi
    @FindBy (xpath = "//div[text()='RENT']")
    public WebElement rentYazisi;
    //Anasayfs Properties Butonu
    @FindBy (xpath = "//a[@data-rr-ui-event-key='2']")
    public WebElement homePagePropertiesButton;
    //Advert Type Button
    @FindBy  (xpath = "//select[@name='at']")
    public WebElement advertTypeButton;
    //Filter Search Box
    @FindBy (xpath = "//input[@placeholder='Search']")
    public WebElement filterSearchBox;
    //Bulunan ilan sayisi 0
    @FindBy (xpath = "//span[text()='0']")
    public WebElement totalFound0;
    //Price Range min
    @FindBy (xpath = "//input[@placeholder='min']")
    public WebElement priceRangeMin;
    //Price Range max
    @FindBy (xpath = "//input[@placeholder='max']")
    public WebElement priceRangeMax;
    //Start price must be less than end price
    @FindBy (xpath = "//div[@class='p-toast-message-text']")
    public WebElement priceHataMesaji;
    //Category Button
    @FindBy (xpath = "//select[@name='c']")
    public WebElement categoryButton;
    //TC06 Test Data
    @FindBy (xpath = "//div[@class='property-card card']")
    public WebElement semihTest2;
    //Anasayfa Sale Button
    @FindBy (xpath = "//button[text()='Sale']")
    public WebElement homePageSaleButton;
    //Ilandaki Sale Yazisi
    @FindBy (xpath = "//div[text()='SALE']")
    public WebElement saleYazisi;






































    //Semih Oner bitis 693

    //Emine Gurses baslangic 695

    //TC01E

    //Back to Site butonuna  tıklanır
    @FindBy(xpath = "//a[@class='side-menu-link back-site nav-link' and @title='Back to Site']")
    public WebElement backToSiteButton;

    //Profile Button
    @FindBy(xpath ="//html[1]/body[1]/div[1]/div[1]/nav[1]/div[1]/div[2]/div[1]/div[1]/img[1]")
    public WebElement profileButton;

    //My Adverts Button
    @FindBy(xpath = "//a[@href='/my-adverts']")
    public WebElement myAdvertsButton;

    //Village House
    @FindBy(xpath= "//table[@class=\"p-datatable-table\"]")
    public WebElement villageHouse01;


    //@TC02E


    // Edit butonuna tıkla
    @FindBy(xpath = "//tbody/tr[1]/td[5]/div[1]/div[1]/button[2]//*[name()='svg']")
    public WebElement editAdvertButton;

    //Price butonuna tıkla
    @FindBy(xpath = "//input[@id='price']")
    public WebElement priceButton;      //input[@id='price']     document.querySelector(\"#price\")"

    //Update butonuna tıkla
    @FindBy(xpath = "//button[normalize-space()='Update']")
    public WebElement updateButton;

    //Basarıyla guncellenmiştir mesajı
    @FindBy(xpath = "//*[@class='p-toast-message-text']")
    public WebElement mesageButton;

    @FindBy(xpath = "//div[normalize-space()='Price must be positive']")
    public WebElement mustBePositive;









































































    //Emine Gurses bitis 770

    //Selin Onal baslangic 772

    // Tour Reqeuest1
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div/div[2]/a[6]")
    public WebElement tourRequest18;

    // First Properties (ilk ilan)
    @FindBy(xpath="//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[1]")
    public WebElement firstProperties18;

    //Adverts Button
    @FindBy(xpath = "//*[@id=\"subMenu\"]/div/a[2]/span[1]")
    public WebElement advertsButton18;

    // My Properties (kendi verdiğim ilan)
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[3]/div/div/div/div[1]/table")
    public WebElement myProperties18;

    // Tour Request
    @FindBy(xpath="//*[@id=\"subMenu\"]/div/a[4]")
    public WebElement tourRequestButton18;

    // Manager my Response
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[3]/ul/li[2]")
    public WebElement managerResponses18;

    // manager username
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/nav/div/div[2]/div/div")
    public WebElement username18;

    //manager log out
    @FindBy(xpath = "//*[@id=\"subMenu\"]/div/a[6]")
    public WebElement logout18;

    // manager log out submit button
    @FindBy(xpath = "//*[@id=\"pr_id_2\"]/div[3]/button[2]/span")
    public WebElement logoutsubmitbutton18;





































































    //Selin Onal bitis 845

    //Rezzan Erva Odabaşı 847



































































    //Rezzan Erva Odabaşı bitis 915

    //Emine Arı Baslangıc 917








































































    //Emine Arı bitis 990

    //Fatih Üstünyer baslangic 992










































































    //Fatih Üstünyer bitis 1067

}
