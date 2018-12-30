package it.matteoavanzini.moon;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class MoonTest {

    @Test
    public void testLunarPhase() throws ParseException {
        MoonCalendar moon = new MoonCalendar();
        assertEquals(LunarCalendar.MOON_PHASE.WANING_TO_QUARTER, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("08/03/2018")));
        assertEquals(LunarCalendar.MOON_PHASE.WANING_TO_QUARTER, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("29/02/2016")));

        assertEquals(LunarCalendar.MOON_PHASE.WAXING_TO_FULL, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("12/01/2017")));
        assertEquals(LunarCalendar.MOON_PHASE.WANING_TO_QUARTER, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("26/01/2019")));
        assertEquals(LunarCalendar.MOON_PHASE.WANING_TO_NEW, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019")));
        assertEquals(LunarCalendar.MOON_PHASE.WANING_TO_NEW, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("13/06/2018")));
        assertEquals(LunarCalendar.MOON_PHASE.WAXING_TO_QUARTER, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("16/06/2018")));
        assertEquals(LunarCalendar.MOON_PHASE.WAXING_TO_QUARTER, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("20/06/2018")));
        assertEquals(LunarCalendar.MOON_PHASE.WAXING_TO_FULL, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("25/06/2018")));
        assertEquals(LunarCalendar.MOON_PHASE.WAXING_TO_FULL, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("29/05/2018")));

        assertEquals(LunarCalendar.MOON_PHASE.WANING_TO_NEW, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("09/07/2018")));
    }
}
