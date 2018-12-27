package it.matteoavanzini.moon;

import java.util.Date;

public interface IMoon
{
    enum MOON_PHASE { NEW, WAXING, FULL, WANING }

    int getMoonDay(Date date);
    boolean isWaxing(Date date);
    boolean isWaning(Date date);
    MOON_PHASE getLunarPhase(Date date);
}
