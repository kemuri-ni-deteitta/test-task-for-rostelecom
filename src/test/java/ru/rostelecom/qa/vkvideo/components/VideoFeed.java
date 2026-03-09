package ru.rostelecom.qa.vkvideo.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import static com.codeborne.selenide.Selenide.$$;

public class VideoFeed {

    // Коллекция всех карточек видео в ленте
    private final ElementsCollection videoCards =
            $$(AppiumBy.id("com.vk.vkvideo:id/content"));

    public void openFirstVideo() {

        // Находим первую видимую карточку видео из списка
        SelenideElement firstVideo = videoCards
                .findBy(Condition.visible);

        firstVideo
                .$(AppiumBy.id("com.vk.vkvideo:id/video_display"))
                .shouldBe(Condition.visible)
                .click();
    }
}