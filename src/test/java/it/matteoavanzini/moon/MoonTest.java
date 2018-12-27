package it.matteoavanzini.moon;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class MoonTest {

    @Test
    public void testCampomese() throws ParseException {
        Moon moon = new Moon();
        assertEquals(IMoon.MOON_PHASE.WANING, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("29/02/2016")));
        assertEquals(IMoon.MOON_PHASE.NEW, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("13/06/2018")));
        assertEquals(IMoon.MOON_PHASE.FULL, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("29/05/2018")));
        assertEquals(IMoon.MOON_PHASE.WANING, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("29/06/2018")));
        assertEquals(IMoon.MOON_PHASE.WAXING, moon.getLunarPhase(new SimpleDateFormat("dd/MM/yyyy").parse("15/06/2018")));

    }
}
