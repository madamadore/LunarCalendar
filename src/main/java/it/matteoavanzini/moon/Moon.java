package it.matteoavanzini.moon;

import java.util.Calendar;
import java.util.Date;

public class Moon implements IMoon {

    private int EPATTA_2014 = 29;

    private int epatta(Date date) {
        int epatta = 2;
        int year = getYearDate(date);
        if (year < 2014) {
            epatta = epattaDescrescente(2014 - year, 29);
        } else if (year > 2014) {
            epatta = epattaCrescente(year - 2014, 29);
        }
        return epatta;
    }

    private int epattaCrescente(int years, int starting) {
        int epatta = starting;
        for (int y = 0; y < years; y++) {
            epatta += 11;
            if (epatta > 30) epatta -= 30;
        }
        return epatta;
    }

    private int epattaDescrescente(int years, int starting) {
        int epatta = starting;
        for (int y = 0; y < years; y++) {
            epatta -= 11;
            if (epatta < 0) epatta += 30;
        }
        return epatta;
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
        return (month + 11) % 12;
    }

    @Override
    public int getMoonDay(Date date) {
        int day = getMonthDay(date) + capomese(date) + epatta(date);
        if (day > 30) day -= 30;
        return day;
    }

    @Override
    public boolean isWaxing(Date date) {
        int day = getMoonDay(date);
        if (day > 0 && day < 15) {
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
        MOON_PHASE phase = MOON_PHASE.WANING;
        if (day == 30) {
            phase = MOON_PHASE.NEW;
        } else if (day > 0 && day < 15) {
            phase = MOON_PHASE.WAXING;
        } else if (day == 15) {
            phase = MOON_PHASE.FULL;
        }
        return phase;
    }
}
