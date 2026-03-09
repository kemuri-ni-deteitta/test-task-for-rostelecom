package ru.rostelecom.qa.vkvideo.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import ru.rostelecom.qa.vkvideo.base.VkVideoBaseTest;
import ru.rostelecom.qa.vkvideo.pages.VideoPlayerPage;

public class VkVideoPlaybackTest extends VkVideoBaseTest {

    @RepeatedTest(10)
    void shouldStartVideoPlayback(RepetitionInfo repetitionInfo) {

        System.out.println("Test run: " + repetitionInfo.getCurrentRepetition());

        // Проводим тест воспроизведения видео
        VideoPlayerPage player = new VideoPlayerPage();
        boolean playing = player.isVideoPlaying();

        Assertions.assertTrue(
                playing,
                "Expected video to be playing but progress did not change"
        );
    }
}