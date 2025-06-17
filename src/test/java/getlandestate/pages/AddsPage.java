package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddsPage {
    public AddsPage() {


        PageFactory.initElements(Driver.getDriver(),this);

        //ilanlarim butonu
}
        @FindBy(xpath="//*[@id=\"subMenu\"]/div/a[2]/span[1]/span")
                public WebElement addsBuuton;

    //Ilan beklemede butonu
    @FindBy(xpath="(//*[@class='p-tag-value'])[1]")
                public WebElement waitingButtonVerify;

    //Degisim-guncelleme ana butonu
    @FindBy(xpath="(//*[@stroke-linejoin='round'])[3]")
                public WebElement addsChangeButton;

    //Silme butonu
    @FindBy(xpath="(//*[@stroke-linejoin='round'])[4]")
                public WebElement addsDeleteButton;

    //Aktiflestirme butonu
    @FindBy(xpath="//*[@id='custom-switch']")
                public WebElement addsActivateButton; //(champs elysses)

    //Guncelleme butonu
    @FindBy(xpath="(//*[@type='submit'])[1]")
                public WebElement addsUpdateButton;

    //Guncelleme Basarili Mesaji
    @FindBy(xpath="//button[contains(@class,'p-toast-detail')] ")
                public WebElement addsUpdateVerifyButton;//(kontrol edilecek )

    //Ilan basariyla silindi mesaji
    @FindBy(xpath=" ")
                public WebElement addsDeletedVerify;





}
