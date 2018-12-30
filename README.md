Moon Phases
===========
This is a Java Library that calculates the moon calendar. It splits the lunar month in 8 equals parts:

_New Moon_, _Waxing to first quarter_, _First quarter_, _Waxing to full moon_, _Full moon_, 
_Waning to second quarter_, _Second quarter_, _Waning to new moon_ 

These parts are defined in the **LunarCalendar** interface.

The library works with every date in every time (past, present or future).

The **LunarCalendar** interface defines two main methods:

```
    public MOON_PHASE getLunarPhase(Date date);
    public int getMoonDay(Date date);
```

In `src/resource/images` there are 8 SVG images representing the 8 phase of the moon 

Usage
-----
```
    Date now = Calendar.getInstace.getTime();
    LunarCalendar calendar = new Moon()
    MOON_PHASE phase = calendar.getLunarPhase(now);
```

or

```
    LunarCalendar calendar = new Moon()
    try {
        Date past = new SimpleDateFormat("dd/MM/yyyy").parse("19/06/2018");
        int day = calendar.getMoonDay(past);
    } catch (ParseException e) {}
```

License
-------
GPL. See _license_ file
