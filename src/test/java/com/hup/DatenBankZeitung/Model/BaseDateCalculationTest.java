package com.hup.DatenBankZeitung.Model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BaseDateCalculationTest {

    @Test
    public void should_return_the_beginning_of_current_month() throws Exception{
        assertEquals(BaseDateCalculation.BaseDateCalculationKey.BegOfTheMonth.calc(LocalDate.of(2020,01,05)).toString(),"2020-01-01");
        assertEquals(BaseDateCalculation.BaseDateCalculationKey.BegOfTheMonth.calc(LocalDate.of(2020,11,27)).toString(),"2020-11-01");
    }

    @Test
    public void should_return_the_beginning_of_next_month() throws Exception{
        assertEquals(BaseDateCalculation.BaseDateCalculationKey.BegOfTheNextMonth.calc(LocalDate.of(2020,01,05)).toString(),"2020-02-01");
        assertEquals(BaseDateCalculation.BaseDateCalculationKey.BegOfTheNextMonth.calc(LocalDate.of(2020,11,27)).toString(),"2020-12-01");
    }
}