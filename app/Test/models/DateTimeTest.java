package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeTest {

    @Test
    void getDate() {
        DateTime dateTime = new DateTime(12, 12, 2020, 4, 50, 23);
        Assertions.assertEquals("12-12-2020", dateTime.getDate());
    }
}
