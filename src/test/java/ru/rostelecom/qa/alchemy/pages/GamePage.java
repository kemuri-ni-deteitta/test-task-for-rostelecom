package ru.rostelecom.qa.alchemy.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class GamePage {

    // Левый верхний виджет в header игрового экрана
    private final SelenideElement topLeftHeaderWidget =
            $(AppiumBy.xpath("//x2.f1/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]"));

    private final SelenideElement watchButton =
            $(AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Watch\")"
            ));

    public void clickTopLeftHeaderWidget() {
        topLeftHeaderWidget
                .shouldBe(Condition.visible)
                .click();
    }

    public void waitForWatchButton() {
        watchButton.shouldBe(Condition.visible);
    }

    public void clickWatchButton() {
        watchButton
                .shouldBe(Condition.visible)
                .click();
    }
}