package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import util.AbstractPage;
import util.NameOfElement;

public class LoginPage extends AbstractPage {

    @NameOfElement("E-mail")
    @FindBy(css = "input[name='username']")
    public SelenideElement login;

    @NameOfElement("Пароль")
    @FindBy(css = "input[name='password']")
    public SelenideElement password;

    @NameOfElement("кнопка с текстом 'Войти'")
    @FindBy(xpath = "//button/span/span[text()='Войти']")
    public SelenideElement enterButton;

    @NameOfElement("Фрейм входа в кабинет")
    @FindBy(css = ".login-window")
    public SelenideElement frameEnterToCabinet;

    @NameOfElement("уведомление об ошибке")
    @FindBy(css = ".login-window-notify--error")
    public SelenideElement loginWindowNotifyError;

}
