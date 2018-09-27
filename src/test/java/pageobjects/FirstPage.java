package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import util.AbstractPage;
import util.NameOfElement;

public class FirstPage extends AbstractPage {

    @NameOfElement("кнопка 'Личный кабинет'")
    @FindBy(xpath = "//button[contains(@class,'login-btn')]")
    public SelenideElement privateCabinetButton;

    @NameOfElement("кнопка 'Выход'")
    @FindBy(css = ".sidebar__btn--exit-btn")
    public SelenideElement exitButton;
}
