package ru.rostelecom.qa.alchemy.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class AdOverlay {

    private final SelenideElement pageIndex1 =
            $(AppiumBy.accessibilityId("pageIndex: 1"));

    private final SelenideElement pageIndex2 =
            $(AppiumBy.accessibilityId("pageIndex: 2"));

    private final SelenideElement pageIndex3 =
            $(AppiumBy.accessibilityId("pageIndex: 3"));

    private final SelenideElement page1CloseButton =
            $(AppiumBy.xpath(
                    "//android.widget.RelativeLayout[@content-desc='pageIndex: 1']" +
                            "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                            "/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]" +
                            "/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView"
            ));

    private final SelenideElement page2CloseButton =
            $(AppiumBy.xpath(
                    "//android.widget.RelativeLayout[@content-desc='pageIndex: 2']" +
                            "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                            "/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]" +
                            "/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView"
            ));

    private final SelenideElement page3CloseButton =
            $(AppiumBy.xpath(
                    "//android.widget.RelativeLayout[@content-desc='pageIndex: 3']" +
                            "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                            "/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView"
            ));

    public void closeAdStepByStep() {

        closePage1();

        closePage2();

        closePage3();
    }

    private void closePage1() {

        if (pageIndex1.is(Condition.visible)) {
            System.out.println("Detected pageIndex: 1");

            page1CloseButton
                    .shouldBe(Condition.visible, Duration.ofSeconds(10))
                    .click();

            System.out.println("Closed pageIndex: 1");
        }
    }

    private void closePage2() {

        if (pageIndex2.is(Condition.visible)) {
            System.out.println("Detected pageIndex: 2");

            page2CloseButton
                    .shouldBe(Condition.visible, Duration.ofSeconds(10))
                    .click();

            System.out.println("Closed pageIndex: 2");
        }
    }

    private void closePage3() {

        if (pageIndex3.is(Condition.visible)) {
            System.out.println("Detected pageIndex: 3");

            page3CloseButton
                    .shouldBe(Condition.visible, Duration.ofSeconds(10))
                    .click();

            System.out.println("Closed pageIndex: 3");
        }
    }
}