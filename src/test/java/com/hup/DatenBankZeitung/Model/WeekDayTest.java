package com.hup.DatenBankZeitung.Model;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class WeekDayTest {

    @org.junit.jupiter.api.Test
    public void should_return_if_is_Valid() throws Exception {
        WeekDay weekDay = new WeekDay(4);
        assertTrue(weekDay.isValid(LocalDate.of(2020, 05, 20)));
        assertFalse(weekDay.isValid(LocalDate.of(2020, 05, 19)));
        WeekDay weekDay1 = new WeekDay(1);
        assertTrue(weekDay1.isValid(LocalDate.of(2020, 05, 18)));
        assertFalse(weekDay1.isValid(LocalDate.of(2020, 05, 19)));
    }


    @org.junit.jupiter.api.Test
    public void should_return_day_of_week() throws Exception {

        WeekDay weekDay = new WeekDay(4);
        assertTrue(weekDay.getDayOfWeeks().contains(DayOfWeek.WEDNESDAY));
        WeekDay weekDay2 = new WeekDay(1);
        assertTrue(weekDay2.getDayOfWeeks().contains(DayOfWeek.MONDAY));
    }


    @org.junit.jupiter.api.Test
    public void toDecimalTest() throws Exception {
        WeekDay weekDay = new WeekDay(4);
        assertEquals(weekDay.toDecimal(), 4);

    }

    @org.junit.jupiter.api.Test
    public void constructorTest() throws Exception {
        HashSet<DayOfWeek> dayOfWeeks = new HashSet<DayOfWeek>();

        dayOfWeeks.add(DayOfWeek.MONDAY);
        dayOfWeeks.add(DayOfWeek.SUNDAY);
        WeekDay weekDay = new WeekDay(dayOfWeeks);
        assertEquals(weekDay.toDecimal(), 65);

    }

    @org.junit.jupiter.api.Test
    public void constructorTestAll() throws Exception {
        HashSet<DayOfWeek> dayOfWeeks = new HashSet<DayOfWeek>();
        dayOfWeeks.add(DayOfWeek.MONDAY);
        dayOfWeeks.add(DayOfWeek.TUESDAY);
        dayOfWeeks.add(DayOfWeek.WEDNESDAY);
        dayOfWeeks.add(DayOfWeek.THURSDAY);
        dayOfWeeks.add(DayOfWeek.FRIDAY);
        dayOfWeeks.add(DayOfWeek.SATURDAY);
        dayOfWeeks.add(DayOfWeek.SUNDAY);
        WeekDay weekDay = new WeekDay(dayOfWeeks);
        assertEquals(weekDay.toDecimal(), 127);

    }

}
