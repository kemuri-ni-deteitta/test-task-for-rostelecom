package ru.rostelecom.qa.core.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.rostelecom.qa.core.driver.DriverProvider;
public class BaseTest {

    @BeforeEach
    void setUp() {
        DriverProvider.createDriver();

        System.out.println("BaseTest: create driver");
    }

    @AfterEach
    void tearDown() {
        DriverProvider.closeDriver();
    }
}