

package com.hup.DatenBankZeitung.Test;

        import com.hup.DatenBankZeitung.Model.BaseDateCalculation;
        import org.junit.Test;
        import org.junit.jupiter.api.Disabled;


        import java.sql.Connection;
        import java.sql.SQLException;
        import java.time.LocalDate;

        import static org.junit.jupiter.api.Assertions.*;
@Disabled
class BaseDateCalculationTest {
    @Disabled
    @Test

    public void should_return_the_beginning_of_current_month() throws Exception{
        assertEquals(BaseDateCalculation.BaseDateCalculationKey.BegOfTheMonth.calc(LocalDate.of(2020,01,05)).toString(),"2020-01-01");
        assertEquals(BaseDateCalculation.BaseDateCalculationKey.BegOfTheMonth.calc(LocalDate.of(2020,11,27)).toString(),"2020-11-01");
    }

    private void assertEquals(String toString, String s) {
    }
    @Disabled
    @Test
    public void should_return_the_beginning_of_next_month() throws Exception{
        assertEquals(BaseDateCalculation.BaseDateCalculationKey.BegOfTheNextMonth.calc(LocalDate.of(2020,01,05)).toString(),"2020-02-01");
        assertEquals(BaseDateCalculation.BaseDateCalculationKey.BegOfTheNextMonth.calc(LocalDate.of(2020,11,27)).toString(),"2020-12-01");
    }
}