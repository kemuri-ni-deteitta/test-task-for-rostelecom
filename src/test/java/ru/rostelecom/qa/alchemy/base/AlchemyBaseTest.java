package ru.rostelecom.qa.alchemy.base;

import ru.rostelecom.qa.core.base.BaseTest;
import ru.rostelecom.qa.core.driver.AppType;

public class AlchemyBaseTest extends BaseTest {

    @Override
    protected AppType getAppType() {
        return AppType.ALCHEMY;
    }
}