package ru.rostelecom.qa.vkvideo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class VideoPlayerPage {

    // Root контейнер видеоплеера (основная область проигрывания видео)
    private final SelenideElement playerContainer =
            $(AppiumBy.id("com.vk.vkvideo:id/playerContainer"));

    // Элемент с текстом текущего времени воспроизведения (например "00:35 / 03:14")
    private final SelenideElement currentProgress =
            $(AppiumBy.id("com.vk.vkvideo:id/current_progress"));

    // Ожидаем, пока экран видеоплеера станет видимым
    public void waitForPlayerOpened() {
        playerContainer.shouldBe(Condition.visible);
    }

    // Тап по плееру, чтобы показать скрытые controls (progress bar и таймер)
    public void showControls() {
        playerContainer.shouldBe(Condition.visible).click();
        currentProgress.shouldBe(Condition.visible);
    }

    // Получаем текст текущего прогресса воспроизведения
    public String getCurrentProgressText() {
        return currentProgress.shouldBe(Condition.visible).getText();
    }

    // Извлекаем левую часть строки времени и переводим её в секунды
    public int getCurrentProgressSeconds() {
        String fullText = getCurrentProgressText();
        String leftPart = fullText.split("/")[0].trim();
        return parseTimeToSeconds(leftPart);
    }

    // Основная проверка: увеличился ли прогресс воспроизведения за несколько секунд
    public boolean isVideoPlaying() {

        // Ждём, пока экран плеера полностью откроется
        waitForPlayerOpened();

        // Показываем controls и читаем текущее время
        showControls();
        int before = getCurrentProgressSeconds();

        // Ждём несколько секунд, чтобы видео успело продвинуться
        sleep(4000);

        // Снова показываем controls и читаем новое значение времени
        showControls();
        int after = getCurrentProgressSeconds();

        // Если время увеличилось минимум на 2 секунды — видео считается воспроизводящимся
        return after - before >= 2;
    }

    // Перевод строки формата mm:ss или hh:mm:ss в секунды
    private int parseTimeToSeconds(String timeText) {

        // Разделяем строку времени по символу ":"
        String[] parts = timeText.split(":");

        // Формат mm:ss
        if (parts.length == 2) {
            int minutes = Integer.parseInt(parts[0].trim());
            int seconds = Integer.parseInt(parts[1].trim());
            return minutes * 60 + seconds;
        }

        // Формат hh:mm:ss
        if (parts.length == 3) {
            int hours = Integer.parseInt(parts[0].trim());
            int minutes = Integer.parseInt(parts[1].trim());
            int seconds = Integer.parseInt(parts[2].trim());
            return hours * 3600 + minutes * 60 + seconds;
        }

        // Если формат времени неизвестен — выбрасываем исключение
        throw new IllegalArgumentException("Unsupported time format: " + timeText);
    }

}