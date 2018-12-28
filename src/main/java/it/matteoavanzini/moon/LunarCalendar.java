package it.matteoavanzini.moon;

import java.util.Date;

/**
 * Defines 8 phases of moon in an enum type:
 * New Moon, Waxing to first quarter, First quarter, Waxing to full moon, Full moon,
 * Waning to second quarter, Second quarter, Waning to new moon
 *
 * A <i>moon day</i> is a value between 0 and 29, where
 * <ul>
 *      <li>0 is the <b>new moon</b></li>
 *      <li>7 is the first quarter</li>
 *      <li>15 is the <b>full moon</b></li>
 *      <li>22 is the second quarter</li>
 * </ul>
 *
 * @see MoonCalendar
 * */
public interface LunarCalendar
{
    /**
     * 8 phases of moon:
     * New Moon, Waxing to first quarter, First quarter, Waxing to full moon, Full moon,
     * Waning to second quarter, Second quarter, Waning to new moon
     * */
    enum MOON_PHASE { NEW,
                        WAXING_TO_QUARTER,
                        FIRST_QUARTER,
                        WAXING_TO_FULL,
                    FULL,
                        WANING_TO_QUARTER,
                        SECOND_QUARTER,
                        WANING_TO_NEW }

    /**
     * @param date date to query of
     * @return true if the moon is between the <i>new</i> and the <i>full</i> phase, false otherwhise
     * */
    boolean isWaxing(Date date);

    /**
     * @param date date to query of
     * @return true if the moon is between the <i>new</i> and the <i>full</i> phase, false otherwhise
     * */
    boolean isWaning(Date date);

    /**
     * Check the date passed as parameter and returns one of the 8 main phases of moon
     *
     * @param date date to query of
     * @return a MOON_PHASE
     * */
    MOON_PHASE getLunarPhase(Date date);

    /**
     * <p>
     *     Check the date passed as parameter and returns the corresponding 'moon day'.
     * </p>
     * A <i>moon day</i> is a value between 0 and 29, where
     * <ul>
     *      <li>0 is the <b>new moon</b></li>
     *      <li>7 is the first quarter</li>
     *      <li>15 is the <b>full moon</b></li>
     *      <li>22 is the second quarter</li>
     * </ul>
     *
     *
     * @param date date to query of
     * @return value between from 0 to 29
     * */
    int getMoonDay(Date date);
}
