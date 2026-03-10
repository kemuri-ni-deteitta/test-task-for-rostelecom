package ru.rostelecom.qa.alchemy.tests;

import org.junit.jupiter.api.Test;
import ru.rostelecom.qa.alchemy.pages.MainMenuPage;
import ru.rostelecom.qa.alchemy.pages.GamePage;
import ru.rostelecom.qa.alchemy.base.AlchemyBaseTest;
import ru.rostelecom.qa.alchemy.components.AdOverlay;

public class PlayTest extends AlchemyBaseTest{

    @Test
    void shouldOpenGameAfterPlayClick() {
        MainMenuPage mainMenu = new MainMenuPage();
        mainMenu.clickPlay();

        GamePage gamePage = new GamePage();
        gamePage.clickTopLeftHeaderWidget();
        gamePage.clickWatchButton();

        AdOverlay adOverlay = new AdOverlay();
        adOverlay.closeAdStepByStep();

        gamePage.shouldHaveFourHints();


    }
}
