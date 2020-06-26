package com.hup.DatenBankZeitung.Model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class WeekDay {
    int FLAG_MONDAY = 1;
    int FlAG_TUESDAY = 2;
    int FLAG_WEDNESDAY = 4;
    int FLAG_THURSDAY = 8;
    int FLAG_FRIDAY = 16;
    int FLAG_SATURDAY = 32;
    int FLAG_SUNDAY = 64;
    private int numberToBinary = 0;
    private HashSet<DayOfWeek> dayOfWeeks = new HashSet<>();

    public WeekDay() {
    }

    public WeekDay(int numberToBinary) {
        this.numberToBinary = numberToBinary;
        whichDays();
    }

    public WeekDay(HashSet<DayOfWeek> dayOfWeek) {
        this.dayOfWeeks.addAll(dayOfWeek);

        this.numberToBinary = toDecimal();
    }

    public HashSet<DayOfWeek> getDayOfWeeks() {
        return dayOfWeeks;
    }

    /**
     * Converts Binary number to decimal
     *
     * @return int decimal
     */
    public int toDecimal() {

        int decimalNumber = 0;  // dec

        for (Iterator<DayOfWeek> it = dayOfWeeks.iterator(); it.hasNext(); ) {
            DayOfWeek day = it.next();
            if (day == DayOfWeek.MONDAY) {
                decimalNumber = decimalNumber | FLAG_MONDAY;
            }

            if (day == DayOfWeek.TUESDAY) {
                decimalNumber = decimalNumber | FlAG_TUESDAY;
            }
            if (day == DayOfWeek.WEDNESDAY) {
                decimalNumber = decimalNumber | FLAG_WEDNESDAY;
            }
            if (day == DayOfWeek.THURSDAY) {
                decimalNumber = decimalNumber | FLAG_THURSDAY;
            }
            if (day == DayOfWeek.FRIDAY) {
                decimalNumber = decimalNumber | FLAG_FRIDAY;
            }
            if (day == DayOfWeek.SATURDAY) {
                decimalNumber = decimalNumber | FLAG_SATURDAY;
            }
            if (day == DayOfWeek.SUNDAY) {
                decimalNumber = decimalNumber | FLAG_SUNDAY;
            }

        }
        return decimalNumber;
    }

    private void whichDays() {

        int check = numberToBinary;

        if ((check & FLAG_MONDAY) == FLAG_MONDAY) {
            dayOfWeeks.add(DayOfWeek.MONDAY);
        }
        if ((check & FlAG_TUESDAY) == FlAG_TUESDAY) {
            dayOfWeeks.add(DayOfWeek.TUESDAY);
        }
        if ((check & FLAG_WEDNESDAY) == FLAG_WEDNESDAY) {
            dayOfWeeks.add(DayOfWeek.WEDNESDAY);
        }
        if ((check & FLAG_THURSDAY) == FLAG_THURSDAY) {
            dayOfWeeks.add(DayOfWeek.THURSDAY);
        }
        if ((check & FLAG_FRIDAY) == FLAG_FRIDAY) {
            dayOfWeeks.add(DayOfWeek.FRIDAY);
        }
        if ((check & FLAG_SATURDAY) == FLAG_SATURDAY) {
            dayOfWeeks.add(DayOfWeek.SATURDAY);
        }
        if ((check & FLAG_SUNDAY) == FLAG_SUNDAY) {
            dayOfWeeks.add(DayOfWeek.SUNDAY);
        }
    }

    /**
     * is checking if given day of week is to find in the hashmap
     *
     * @param localDate it the date we will check
     * @return boolean with validation.
     */
    public boolean isValid(LocalDate localDate) {
        return dayOfWeeks.contains(localDate.getDayOfWeek());
    }
}


