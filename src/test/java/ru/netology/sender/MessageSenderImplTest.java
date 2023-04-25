package ru.netology.sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MessageSenderImplTest {
    @Mock
    private GeoService geoService;
    @Mock
    private LocalizationService localizationService;

    private MessageSenderImpl messageSender;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }
    
    @Test
    void shouldSendRussianMessage() {
        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "172.0.32.11");
        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        when(geoService.byIp("172.0.32.11")).thenReturn(location);
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Привет");

        String actual = messageSender.send(headers);

        assertEquals("Привет", actual);
    }

    @Test
    void shouldSendEnglishMessage() {
        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "96.0.32.11");
        Location location = new Location("New York", Country.USA, " 5th Avenue", 10);
        when(geoService.byIp("96.0.32.11")).thenReturn(location);
        when(localizationService.locale(Country.USA)).thenReturn("Hello");

        String actual = messageSender.send(headers);

        assertEquals("Hello", actual);
    }
}