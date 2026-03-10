package ru.rostelecom.qa.core.driver;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

public class DriverProvider {

    public static void createDriver(AppType appType) {
        try {
            UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformName("Android");
            options.setDeviceName("emulator-5554");

            options.setAppPackage(appType.getAppPackage());
            options.setAppActivity(appType.getAppActivity());

            AndroidDriver driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    options
            );

            WebDriverRunner.setWebDriver(driver);

        } catch (Exception e) {
            throw new RuntimeException("Failed to create driver for app: " + appType, e);
        }
    }

    public static void closeDriver() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }
}