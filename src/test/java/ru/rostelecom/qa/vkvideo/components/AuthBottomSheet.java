package ru.rostelecom.qa.vkvideo.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import static com.codeborne.selenide.Selenide.$;

public class AuthBottomSheet {

    // Root элемент bottom sheet с предложением авторизации
    private final SelenideElement sheetRoot =
            $(AppiumBy.id("com.vk.vkvideo:id/fast_login_view"));

    // Кнопка "Skip"
    private final SelenideElement skipButton =
            $(AppiumBy.id("com.vk.vkvideo:id/fast_login_tertiary_btn"));

    // Проверяем, отображается ли bottom sheet авторизации
    public boolean isDisplayed() {
        return sheetRoot.exists();
    }

    // Если окно авторизации появилось — нажимаем Skip и ждём его исчезновения
    public void skipIfPresent() {
        if (sheetRoot.exists()) {
            skipButton
                    .shouldBe(Condition.visible)
                    .click();

            sheetRoot.shouldNot(Condition.exist);
        }
    }
}