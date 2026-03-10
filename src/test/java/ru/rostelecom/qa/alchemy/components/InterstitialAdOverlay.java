package ru.rostelecom.qa.alchemy.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class InterstitialAdOverlay {

    // Таймер рекламы на первом экране
    private final SelenideElement countdownTimer =
            $(AppiumBy.id("com.ilyin.alchemy:id/inter_text_countdown"));

    // Кнопка закрытия рекламы
    private final SelenideElement closeButton =
            $(AppiumBy.id("com.ilyin.alchemy:id/bigo_ad_btn_close"));

    public void closeInterstitialAdFlow() {

        waitForCountdownTimer();

        clickFirstClose();

        clickSecondCloseWithDelay();
    }

    private void waitForCountdownTimer() {
        System.out.println("Waiting for countdown timer");
        countdownTimer.shouldBe(Condition.visible);
        System.out.println("Countdown timer detected");
    }

    private void clickFirstClose() {

        System.out.println("Reading ad countdown timer");

        String countdownText = countdownTimer.shouldBe(Condition.visible).getText();
        int seconds = Integer.parseInt(countdownText);

        System.out.println("Ad countdown detected: " + seconds + " seconds");

        System.out.println("Waiting for close button");

        closeButton
                .shouldBe(Condition.visible, Duration.ofSeconds(seconds + 10))
                .click();

        System.out.println("First close click done");
    }

    private void clickSecondCloseWithDelay() {
        System.out.println("Waiting for second close button");
        closeButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        System.out.println("Second close first click done");

        sleep(2000);

        closeButton.shouldBe(Condition.visible).click();
        System.out.println("Second close second click done");
    }
}