package com.hup.DatenBankZeitung.Model;

import com.hup.DatenBankZeitung.Model.Service.Dis_PublicationCalendarService;

import java.sql.SQLException;
import java.time.LocalDate;




public class BaseDateCalculation {

    private BaseDateCalculationKey baseDateCalculationKey;
    private String variantcode;
    private String productcode;
    private Dis_PublicationCalendarService dis_publicationCalendarService;
    public BaseDateCalculation(BaseDateCalculationKey baseDateCalculationKey, String variantCode, String productcode, Dis_PublicationCalendarService dis_publicationCalendarService) {
        this.variantcode = variantCode;
        this.productcode = productcode;
        this.baseDateCalculationKey = baseDateCalculationKey;
        this.dis_publicationCalendarService = dis_publicationCalendarService;
    }


    /**
     * Enum to manage date by referencekey
     * EVT - with the next possible day
     * NextEVT - with the 1+ possible day
     * BegOfMonth, with the beginning of the current month
     * BegOfNextMonth with the beginning of the next month
     * NoAction does nothing
     */
    public enum BaseDateCalculationKey {
        EVT
                {
                    public LocalDate calc(Dis_PublicationCalendarService dis_publicationCalendarService,
                                          String productcode,String variantcode, LocalDate dtResult)
                    {
                        return  dis_publicationCalendarService.loadMinDate(productcode,variantcode,dtResult);
                    }
                },
        NextEVT
                {
                    public LocalDate calc(Dis_PublicationCalendarService dis_publicationCalendarService,
                                          String productcode,String variantcode, LocalDate dtResult)
                    {
                        LocalDate publicationDate = dis_publicationCalendarService.loadMinDate(productcode, variantcode, dtResult);
                        if (publicationDate == null)
                        return null;
                        else
                            return dis_publicationCalendarService.loadMinDate(productcode, variantcode, publicationDate.plusDays(1));
                    }
                },
        BegOfTheMonth {
            public LocalDate calc(LocalDate date) {

                //3 = Monatsanfang - Tag auf 1 gesetzt
                int i = date.getDayOfMonth();
                if (i == 1) {
                    return date;
                } else
                    i -= 1;
                return date.minusDays(i);

            }
        },
        BegOfTheNextMonth {
            public LocalDate calc(LocalDate date) {

                //3 = Monatsanfang - Tag auf 1 gesetzt
                int i = date.getDayOfMonth();
                if (i == 1) {
                    return date;
                } else
                    i -= 1;
                return date.minusDays(i).plusMonths(1);

            }
        },
        noAction {
            public LocalDate calc(LocalDate date) {
                return date;
            }
        };

        public LocalDate calc(LocalDate date) {
            return date;
        }
    }

    /**
     * Method which is connecting the DateBase in order to find the possible EVT date.
     * It's done by executing the SQL query and saving the values.
     *
     * @param conn datebase connection
     * @return date which will be passed to Enum
     * @throws SQLException Sql
     */

    /**
     * Getter and Setter
     */
    public BaseDateCalculationKey getBaseDateCalculationKey() {
        return baseDateCalculationKey;
    }

    public void setBaseDateCalculationKey(BaseDateCalculationKey baseDateCalculationKey) {
        this.baseDateCalculationKey = baseDateCalculationKey;
    }
}



