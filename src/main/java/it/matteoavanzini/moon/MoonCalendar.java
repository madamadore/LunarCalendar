package it.matteoavanzini.moon;

import java.util.Calendar;
import java.util.Date;

/**
 * An implementation of LunarCalendar interface.
 *
 * it calculates the calendar moon's day in days, using the formula:
 *
 *      day = day of month + number of month + epatta
 *
 * 'epatta' is a special number that helps to correct the calcule of lunar day.
 *
 *  A Lunar month has the duration of 30 days all over the year, but every 19 years it needs a +1 day correction
 * */
public class MoonCalendar implements LunarCalendar {

    private int EPATTA_2014 = 29;

    private int epatta(Date date) {
        int epatta = 2;
        int year = getYearDate(date);
        int month = getMonthDate(date);
        if (month < 2) year -= 1;

        if (year < 2014) {
            epatta = epattaDescrescente(2014 - year, 28);
        } else if (year > 2014) {
            epatta = epattaCrescente(year - 2014, 28);
        }
        return epatta;
    }

    private int epattaCrescente(int years, int starting) {
        int epatta = starting;
        for (int y = 0, count = 1; y < years; y++, count++) {
            epatta += 11;
            if (count == 19) {
                epatta += 1;
                count = 1;
            }
            if (epatta > 30) epatta -= 30;
        }
        return epatta;
    }

    private int epattaDescrescente(int years, int starting) {
        int epatta = starting;
        for (int y = 0, count = 1; y < years; y++, count++) {
            epatta -= 11;
            if (count == 19) {
                epatta -= 1;
                count = 1;
            }
            if (epatta < 0) epatta += 30;
        }
        return epatta;
    }

    private int getMonthDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    private int getYearDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    private int getMonthDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    private int capomese(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        int capomese = (month + 11) % 12;
        return capomese == 0 ? 12 : capomese;
    }

    @Override
    public int getMoonDay(Date date) {
        int day = getMonthDay(date) + capomese(date) + epatta(date);
        day = day % 30;
        day += 1;
        return day;
    }

    @Override
    public boolean isWaxing(Date date) {
        int day = getMoonDay(date);
        if (day > 0 && day < 16) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isWaning(Date date) {
        int day = getMoonDay(date);
        if (day > 15) {
            return true;
        }
        return false;
    }

    @Override
    public MOON_PHASE getLunarPhase(Date date) {
        int day = getMoonDay(date);
        MOON_PHASE phase = null;
        if (day == 0 || day == 30) {
            phase = MOON_PHASE.NEW;
        } else if (day > 0 && day < 7) {
            phase = MOON_PHASE.WAXING_TO_QUARTER;
        } else if (day == 7) {
            phase = MOON_PHASE.FIRST_QUARTER;
        } else if (day > 7 && day < 15) {
            phase = MOON_PHASE.WAXING_TO_FULL;
        } else if (day == 15) {
            phase = MOON_PHASE.FULL;
        } else if (day > 15 && day < 22) {
            phase = MOON_PHASE.WANING_TO_QUARTER;
        } else if (day == 22) {
            phase = MOON_PHASE.LAST_QUARTER;
        } else if (day > 22 && day < 30) {
            phase = MOON_PHASE.WANING_TO_NEW;
        }
        return phase;
    }
}
