package ru.rostelecom.qa.alchemy.tests;

import org.junit.jupiter.api.Test;
import ru.rostelecom.qa.alchemy.base.AlchemyBaseTest;
import ru.rostelecom.qa.alchemy.components.InterstitialAdOverlay;
import ru.rostelecom.qa.alchemy.pages.GamePage;
import ru.rostelecom.qa.alchemy.pages.MainMenuPage;

public class PlayInterstitialAdTest extends AlchemyBaseTest {

    @Test
    void shouldCloseInterstitialAdFlow() {

        MainMenuPage mainMenuPage = new MainMenuPage();
        GamePage gamePage = new GamePage();
        InterstitialAdOverlay interstitialAdOverlay = new InterstitialAdOverlay();

        mainMenuPage.clickPlay();

        gamePage.clickTopLeftHeaderWidget();
        gamePage.clickWatchButton();

        interstitialAdOverlay.closeInterstitialAdFlow();

        gamePage.shouldHaveFourHints();
    }
}