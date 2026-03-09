package ru.rostelecom.qa.vkvideo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    // Обработка страницы "Home", по нижнему меню
    private final SelenideElement homeRoot =

            $(AppiumBy.id("com.vk.vkvideo:id/vk_video_bottom_menu_view"));
    public void waitForLoaded() {
        homeRoot.shouldBe(Condition.visible);
    }
}