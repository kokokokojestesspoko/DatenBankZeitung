package com.hup.DatenBankZeitung.Model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Offset {

    private int offSetValue;
    private OffSetKey offSetKey;

    public Offset( int offSetValue, OffSetKey offSetKey) {

        this.offSetValue = offSetValue;
        this.offSetKey = offSetKey;
    }


    public LocalDate calc(LocalDate refDate)
    {
        return offSetKey.calc(refDate,offSetValue);
    }

    public Offset() {
    }

    /**
     * Enum which will manage the operations on Dates.
     */
    public enum OffSetKey {
        /**
         * method calc is adding or substracting the number of DAYS,MONTHS,WEEKS or WORKINGDAYS(without sundays).
         * <p>
         * It's necessary to multiply the amount of days with -1, because the method "minus(Days,Weeks etc)"
         * <p>
         * is substracting the minus number twice. which gives always the plus number.
         * <p>
         * By multipling it's possible to substract
         */
        DAY {
            public LocalDate calc(LocalDate refDate, int offSetValue) {
                return refDate.minusDays(offSetValue * -1);
            }
        },
        WEEK {
            public LocalDate calc(LocalDate refDate, int offSetValue) {
                int week = offSetValue * -7;
                return refDate.minusDays(week);
            }
        },
        MONTH {
            public LocalDate calc(LocalDate refDate, int offSetValue) {
                return refDate.minusMonths(offSetValue * -1);
            }
        },
        WORKDAYS {
            public LocalDate calc(LocalDate refDate, int offSetValue) {
                    LocalDate result = refDate;
                    int days = 0;
                    if(offSetValue<=0)
                    {
                    while (days < Math.abs(offSetValue)) {
                        result = result.minusDays(1);
                        if (!(result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                            ++days;
                        }
                    }}
                    else { while (days < offSetValue) {
                        result = result.plusDays(1);
                        if (!(result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                            ++days;
                        }
                    }}
                    return result;
                }
        };

        public LocalDate calc(LocalDate refDate, int offSetValue) {
            return refDate;
        }
}

    public void setoffSetValue(int offSetValue) {
        this.offSetValue = offSetValue;
    }

    public int getOffSetValue() {
        return offSetValue;
    }

    public OffSetKey getOffSetKey() {
        return offSetKey;
    }

    public int getoffSetValue() {
        return offSetValue;
    }
}