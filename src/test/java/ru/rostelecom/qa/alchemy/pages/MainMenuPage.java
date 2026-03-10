package ru.rostelecom.qa.alchemy.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
public class MainMenuPage {

    // Кнопка Play в главном меню игры
    private final SelenideElement playButton =
            $(AppiumBy.xpath("//android.widget.TextView[@text='Play']"));

    // Нажимаем на кнопку Play и ждём, что она станет доступной для клика
    public void clickPlay() {
        playButton.shouldBe(Condition.visible).click();
    }
}