package org.example;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicketFormatConverterTest {

    @Test
    public void testConvertTo12HourFormat() {
        TicketFormatConverter converter = new TicketFormatConverter();

        // Test converting time to 12-hour format
        assertEquals("12:00 AM", converter.convertTo12HourFormat("00:00"));
        assertEquals("12:30 AM", converter.convertTo12HourFormat("00:30"));
        assertEquals("11:59 AM", converter.convertTo12HourFormat("11:59"));
        assertEquals("12:00 PM", converter.convertTo12HourFormat("12:00"));
        assertEquals("01:30 PM", converter.convertTo12HourFormat("13:30"));
        assertEquals("11:59 PM", converter.convertTo12HourFormat("23:59"));
    }

    @Test
    public void testConvertTo24HourFormat() {
        TicketFormatConverter converter = new TicketFormatConverter();

        // Test converting time to 24-hour format
        assertEquals("00:00", converter.convertTo24HourFormat("12:00 AM"));
        assertEquals("00:30", converter.convertTo24HourFormat("12:30 AM"));
        assertEquals("11:59", converter.convertTo24HourFormat("11:59 AM"));
        assertEquals("12:00", converter.convertTo24HourFormat("12:00 PM"));
        assertEquals("13:30", converter.convertTo24HourFormat("01:30 PM"));
        assertEquals("23:59", converter.convertTo24HourFormat("11:59 PM"));
    }
}
