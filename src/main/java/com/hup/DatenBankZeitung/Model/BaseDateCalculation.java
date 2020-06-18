package com.hup.DatenBankZeitung.Model;

import com.hup.DatenBankZeitung.Model.Service.Dis_PublicationCalendarService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import java.sql.*;

import static com.hup.DatenBankZeitung.Model.BaseDateCalculation.BaseDateCalculationKey.EVT;
import static com.hup.DatenBankZeitung.Model.BaseDateCalculation.BaseDateCalculationKey.NextEVT;


public class BaseDateCalculation {

    private BaseDateCalculationKey baseDateCalculationKey;
    private String variantcode;
    private String productCode;
    private Dis_PublicationCalendarService dis_publicationCalendarService;
    public BaseDateCalculation(BaseDateCalculationKey baseDateCalculationKey, String variantCode, String productCode,Dis_PublicationCalendarService dis_publicationCalendarService) {
        this.variantcode = variantCode;
        this.productCode = productCode;
        this.baseDateCalculationKey = baseDateCalculationKey;
    }

    /**
     * This method calls the Enum with the BaseDateCalculationKey.
     * The value of EVT and NextEVT are taken from the DateBank so it was necessary
     * to build a method which will connect it outside Enum.
     * In case there are other Enum Values called, it's done in the Enum Class.
     *
     * @param date Startdate
     * @param conn connection to DateBase
     * @return Edited Date
     * @throws SQLException SQL Datebase
     */
    public LocalDate calc(LocalDate date, Connection conn) throws SQLException {
        if (baseDateCalculationKey == EVT) {
            return loadMinDate(conn, productCode, variantcode, date);
        } else if (baseDateCalculationKey == NextEVT) {
            LocalDate publicationDate = loadMinDate(conn, productCode, variantcode, date);
            if (publicationDate == null)
                return null;
            else
                return loadMinDate(conn, productCode, variantcode, publicationDate.plusDays(1));
        } else
            return baseDateCalculationKey.calc(date);
    }


    // UMBAUEN




    /**
     * Enum to manage date by referencekey
     * EVT - with the next possible day
     * NextEVT - with the 1+ possible day
     * BegOfMonth, with the beginning of the current month
     * BegOfNextMonth with the beginning of the next month
     * NoAction does nothing
     */
    public enum BaseDateCalculationKey {
        EVT,
        NextEVT,
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
    public LocalDate loadMinDate(Connection conn, String productCode, String variantCode, LocalDate publicationDate) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT  MIN(PUBLICATIONDATE) FROM sysadm.DIS_PUBLICATIONCALENDAR" +
                "    WHERE DELIVERYPARTNERNO = 0 AND PRODUCTCODE = ? AND + VARIANTCODE = ? AND PUBLICATIONDATE >= ?");

        statement.setString(1, productCode);
        statement.setString(2, variantCode);
        statement.setDate(3, Date.valueOf(publicationDate));
        ResultSet results = statement.executeQuery();
        Date minDate = null;
        while (results.next()) {
            minDate = results.getDate("PUBLICATIONDATE");
        }
        results.close();
        statement.close();
        if (minDate != null)
            return minDate.toLocalDate();
        else
            return null;
    }
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



