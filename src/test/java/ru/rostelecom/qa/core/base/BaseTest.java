package ru.rostelecom.qa.core.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.rostelecom.qa.core.driver.AppType;
import ru.rostelecom.qa.core.driver.DriverProvider;

public abstract class BaseTest {

    protected abstract AppType getAppType();

    @BeforeEach
    void setUp() {
        DriverProvider.createDriver(getAppType());
        System.out.println("BaseTest: create driver for " + getAppType());
    }

    @AfterEach
    void tearDown() {
        DriverProvider.closeDriver();
    }
}