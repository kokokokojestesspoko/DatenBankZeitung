package com.hup.DatenBankZeitung.Model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OffsetTest {

    @Test
    public void should_retourn_added_or_substracted_by_workdays_date() throws Exception {
        assertEquals(Offset.OffSetKey.WORKDAYS.calc(LocalDate.of(2020,05,27), 6).toString(), "2020-06-03");
        assertEquals(Offset.OffSetKey.WORKDAYS.calc(LocalDate.of(2020,05,27), -6).toString(), "2020-05-20");
    }

    @Test
    public void should_retourn_added_or_substracted_by_days_date() throws Exception {
        Offset offset = new Offset();
        assertEquals(Offset.OffSetKey.DAY.calc(LocalDate.of(2020,05,27), 6).toString(), "2020-06-02");
        assertEquals(Offset.OffSetKey.DAY.calc(LocalDate.of(2020,05,27), -6).toString(), "2020-05-21");
    }

    @Test
    public void should_retourn_added_or_substracted_by_weeks_date() throws Exception {
        Offset offset = new Offset();
        assertEquals(Offset.OffSetKey.WEEK.calc(LocalDate.of(2020,05,27), 1).toString(), "2020-06-03");
        assertEquals(Offset.OffSetKey.WEEK.calc(LocalDate.of(2020,05,27), -1).toString(), "2020-05-20");
    }

    @Test
    public void should_retourn_added_or_substracted_by_months_date() throws Exception {
        Offset offset = new Offset();

        assertEquals(Offset.OffSetKey.MONTH.calc(LocalDate.of(2020,05,27), 1).toString(), "2020-06-27");
        assertEquals(Offset.OffSetKey.MONTH.calc(LocalDate.of(2020,05,27), -1).toString(), "2020-04-27");
    }

}