package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddsPage {
    public AddsPage() {


        PageFactory.initElements(Driver.getDriver(),this);
}
        @FindBy(xpath="//*[@id=\"subMenu\"]/div/a[2]/span[1]/span")
                public WebElement addsBuuton;
    @FindBy(xpath="(//*[@class='p-tag-value'])[1]")
                public WebElement waitingButtonVerify;
    @FindBy(xpath="(//*[@stroke-linejoin='round'])[3]")
                public WebElement addsChangeButton;
    @FindBy(xpath="(//*[@stroke-linejoin='round'])[4]")
                public WebElement addsDeleteButton;
    @FindBy(xpath="//*[@id='custom-switch']")
                public WebElement addsActivateButton; //(champs elysses)
    @FindBy(xpath="(//*[@type='submit'])[1]")
                public WebElement addsUpdateButton;
    @FindBy(xpath="//button[contains(@class,'p-toast-detail')] ")
                public WebElement addsUpdateVerifyButton;  //(kontrol edilecek )


}
