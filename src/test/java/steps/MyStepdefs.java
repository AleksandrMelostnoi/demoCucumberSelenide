package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.After;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import pageobjects.LoginPage;
import pageobjects.FirstPage;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MyStepdefs {

    private FirstPage firstPage = page(FirstPage.class);
    private LoginPage loginPage = page(LoginPage.class);

    @Допустим("^пользователь открывает страницу riskmarket\\.ru$")
    public void openRiskmarketRu() {
        System.out.println("Открываем страницу!");
        open("http://riskmarket.ru");
    }

    @Тогда("^элемент \"([^\"]*)\" отображен на \"(.*)\"$")
    public void checkThatElementWithNameIsDisplayed(String elementName, String page) {
        if ("первой странице".equals(page)) {
            firstPage.get(elementName).shouldBe(Condition.appears);
        } else if ("странице аутентификации".equals(page)) {
            loginPage.get(elementName).shouldBe(Condition.appears);
        }
    }

    @И("^пользователь нажимает на элемент \"(.*)\" на \"(.*)\"$")
    public void pressElement(String element, String page) {
        if ("первой странице".equals(page)) {
            firstPage.get(element).click();
        } else if ("странице аутентификации".equals(page)) {
            loginPage.get(element).click();
        }
    }

    @И("^пользователь на \"([^\"]*)\" в поле ввода \"([^\"]*)\" вводит текст: \"([^\"]*)\"$")
    public void typeToInputWithNameText(String page, String nameOfElement, String text) {
        if ("странице аутентификации".equals(page)) {
            loginPage.get(nameOfElement).sendKeys(text);
        }
    }

    @И("^ждет пока не исчезнет форма аутентификации$")
    public void waitUntilLoginFrameDisappears() {
        loginPage.get("Фрейм входа в кабинет").waitUntil(Condition.disappears, 15000);
    }

    @After
    public void tearDown() {
        close();
    }
}
