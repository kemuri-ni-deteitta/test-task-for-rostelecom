package ru.rostelecom.qa.vkvideo.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;

public class OnboardingOverlay {

    private final SelenideElement overlayRoot =
            $(AppiumBy.id("com.vk.vkvideo:id/onboarding_view_pager"));

    private final SelenideElement closeButton =
            $(AppiumBy.id("com.vk.vkvideo:id/close_btn_left"));

    // Проверяем, отображается ли overlay прямо сейчас
    public boolean isDisplayed() {
        System.out.println("Overlay отображается");
        return overlayRoot.is(Condition.visible);
    }

    // Закрываем overlay, если он появился
    public void closeIfPresent() {

        System.out.println("OnboardingOverlay: waiting for overlay");

        try {

            // ждём появления overlay
            overlayRoot.shouldBe(Condition.visible, Duration.ofSeconds(5));

            System.out.println("OnboardingOverlay: overlay appeared");

            closeButton.shouldBe(Condition.visible)
                    .click();

            System.out.println("OnboardingOverlay: close clicked");

            overlayRoot.shouldNot(Condition.exist);

            System.out.println("OnboardingOverlay: overlay closed");

        } catch (AssertionError e) {

            System.out.println("OnboardingOverlay: overlay not shown");

        }
    }
}