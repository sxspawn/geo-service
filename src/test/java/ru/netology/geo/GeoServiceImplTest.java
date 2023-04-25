package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTest {

    @Test
    public void testRuByIp() {
        GeoService geoService = new GeoServiceImpl();
        Location location = geoService.byIp(GeoServiceImpl.MOSCOW_IP);
        assertEquals(location.getCountry(), Country.RUSSIA);
        assertEquals(location.getCity(), "Moscow");
    }

    @Test
    public void testEnByIp() {
        GeoService geoService = new GeoServiceImpl();
        Location location = geoService.byIp(GeoServiceImpl.NEW_YORK_IP);
        assertEquals(location.getCountry(), Country.USA);
        assertEquals(location.getCity(), "New York");
    }
}