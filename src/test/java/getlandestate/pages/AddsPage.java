package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddsPage {


    public AddsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


        //Ilanlarim sayfasindaki ilanlar butonu
        @FindBy(xpath = "( //span[contains(text(),'İlanlar')] ")
        public WebElement addsOnAdverts;



        //Ilanlarim sayfasindaki aratma kutucugu
        @FindBy(xpath = "(//input[@id='q']  ")
        public WebElement searchBoxOnAdverts;



        //Ilanlarim sayfasindaki arama butonu
        @FindBy(xpath = "( //button[@type='submit'] ")
        public WebElement searchButtonOnAdverts;



        //Ilanlarimdaki guncelleme butonu
        @FindBy(xpath = "(  //tbody//button[2]//*[name()='svg']")
        public WebElement updateButtonOnAdverts;



        //Durum Aktif butonu
        @FindBy(xpath = "( //span[@class='p-tag-value'] ")
        public WebElement situationActiveButton;



        //Durum Reddedildi butonu
        @FindBy(xpath = "(//span[@class='p-tag-value']")
        public WebElement statusRejectedButton;



        //Guncelleme sayfasindaki Ddm butonu
        @FindBy(xpath = "(//select[@id='statusForAdvert']")
        public WebElement statusDdmButton;



        // Guncelleme sayfasindaki update butonu
        @FindBy(xpath = "(//button[@type='submit']")
        public WebElement updateButtonOnEdit;




        // Guncelleme basarili mesaji
        @FindBy(xpath = "(//body/div[@id='root']/div[@class='p-toast p-component p-toast-top-right p-ripple-disabled']/div/div[1]/div[1]/div[1]/div[1]")
        public WebElement updateSuccesfulMessage;





}
