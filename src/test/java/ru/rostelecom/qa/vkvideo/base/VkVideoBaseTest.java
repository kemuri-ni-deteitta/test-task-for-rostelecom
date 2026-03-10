package ru.rostelecom.qa.vkvideo.base;

import org.junit.jupiter.api.BeforeEach;
import ru.rostelecom.qa.core.base.BaseTest;
import ru.rostelecom.qa.core.driver.AppType;
import ru.rostelecom.qa.vkvideo.components.AuthBottomSheet;
import ru.rostelecom.qa.vkvideo.components.OnboardingOverlay;
import ru.rostelecom.qa.vkvideo.components.VideoFeed;
import ru.rostelecom.qa.vkvideo.pages.HomePage;

public class VkVideoBaseTest extends BaseTest {

    @Override
    protected AppType getAppType() {
        return AppType.VKVIDEO;
    }

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

        // Открываем первое видео из ленты
        VideoFeed feed = new VideoFeed();
        System.out.println("Before first video open");
        feed.openFirstVideo();
    }
}