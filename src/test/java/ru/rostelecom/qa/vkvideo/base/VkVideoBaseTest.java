package ru.rostelecom.qa.vkvideo.base;

import org.junit.jupiter.api.BeforeEach;
import ru.rostelecom.qa.core.base.BaseTest;
import ru.rostelecom.qa.vkvideo.components.AuthBottomSheet;
import ru.rostelecom.qa.vkvideo.components.OnboardingOverlay;
import ru.rostelecom.qa.vkvideo.components.VideoFeed;
import ru.rostelecom.qa.vkvideo.pages.HomePage;

public class VkVideoBaseTest extends BaseTest {

    @BeforeEach
    void prepareVkVideoApp() {

        // Закрываем onboarding, если он появился
        OnboardingOverlay onboardingOverlay = new OnboardingOverlay();
        System.out.println("Before onboarding close");
        onboardingOverlay.closeIfPresent();

        // Пропускаем окно авторизации, если оно появилось
        AuthBottomSheet authBottomSheet = new AuthBottomSheet();
        System.out.println("Before auth skip");
        authBottomSheet.skipIfPresent();

        // Ждём, пока главная страница полностью загрузится
        HomePage homePage = new HomePage();
        System.out.println("Before home load");
        homePage.waitForLoaded();

        // Ждём появления карточек и открываем первое видео
        VideoFeed feed = new VideoFeed();
        feed.openFirstVideo();

    }
}