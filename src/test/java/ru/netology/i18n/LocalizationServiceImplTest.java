package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {

    @Test
    public void testRuLocale() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String text = localizationService.locale(Country.RUSSIA);
        assertEquals(text, "Добро пожаловать");
    }

    @Test
    public void testEnLocale() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String text = localizationService.locale(Country.USA);
        assertEquals(text, "Welcome");
    }
}