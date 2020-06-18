package com.hup.DatenBankZeitung.Model;

import java.sql.*;
import java.time.LocalDate;

public class DueDateCode {

    public DueDateCode(Connection conn, String productCode, String systemCode, String dueDateCode, int companyClientNo, LocalDate startDate, String variantCode) throws SQLException {
        executeSql(conn, productCode, systemCode, dueDateCode, companyClientNo, startDate, variantCode); //

    }

    public LocalDate calc(LocalDate date) throws SQLException {
        LocalDate baseDate = baseDateCalculation.calc(startDate, conn);
        if (weekDay.isValid(baseDate)) {

            return offset.calc(baseDate);
        } else
            return date;
    }

    private String productCode;
    private String systemCode;
    private int companyClientNo;
    private LocalDate startDate;
    private Connection conn;
    private String dueDateCode;
    private Offset offset;
    private WeekDay weekDay;
    private BaseDateCalculation baseDateCalculation;

    public Offset getOffset() {
        return offset;
    }

    public void setOffset(Offset offset) {
        this.offset = offset;
    }

    public BaseDateCalculation getBaseDateCalculation() {
        return baseDateCalculation;
    }

    public void setBaseDateCalculation(BaseDateCalculation baseDateCalculation) {
        this.baseDateCalculation = baseDateCalculation;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public DueDateCode(String dueDateCode) {
        dueDateCode = dueDateCode;
    }

    public String getDueDateCode() {
        return dueDateCode;
    }

    public void setDueDateCode(String dueDateCode) {
        dueDateCode = dueDateCode;
    }

    /**
     * Method to execute the sql Query  which will pass the values to WEEKDAY, OFFSET and BASEDATECALCULATION class.
     *
     * @param conn Connection with datebase
     * @throws SQLException
     */
    public void executeSql(Connection conn, String productCode, String systemCode, String dueDateCode, int companyClientNo, LocalDate startDate, String variantCode) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT( * ), MAX(OFFSETKEY), MAX(OFFSETVALUE),\n" +
                "        MAX( REFERENCEKEY ), MAX( WEEKDAYKEY ), MAX( REFERENCEVALUE ) " +
                "FROM sysadm.HUPX_DUEDATEPRODUCT2CODE WHERE PRODUCTCODE = ? AND\n" +
                "        SYSTEMCODE = ? AND DUEDATECODE = ? AND COMPANYCLIENTNO IN ( -1, ? ) AND \n" +
                "        ? BETWEEN STARTDATE AND ENDDATE;");
        statement.setString(1, productCode);
        statement.setString(2, systemCode);
        statement.setString(3, dueDateCode);
        statement.setInt(4, companyClientNo);
        statement.setDate(5, Date.valueOf(startDate));
        ResultSet results = statement.executeQuery();
        while (results.next()) {
            int offsetKey = results.getInt("OFFSETKEY");
            int offsetValue = results.getInt("OFFSETVALUE");
            int referenceKey = results.getInt("REFERENCEKEY");
            int weekdayKey = results.getInt("WEEKDAYKEY");
            String referenceValue = results.getString("REFERENCEVALUE");
            offset = offsetKey(offsetKey, startDate, offsetValue);
            weekDay = new WeekDay(weekdayKey);
            baseDateCalculation = baseDateCalculationDueDate(referenceKey, productCode, variantCode);
        }
        results.close();
        statement.close();
        this.conn = conn;
        this.productCode = productCode; /// hier aus duedatecode
        this.companyClientNo = companyClientNo;
        this.systemCode = systemCode;
        this.startDate = startDate;
        this.dueDateCode = dueDateCode;
    }

    /**
     * Setting the OffsetKey Enum by the Offset Value.
     *
     * @return
     */
    private Offset offsetKey(int offsetKey, LocalDate startDate, int offsetValue) {
        if (offsetKey == 1) {
            return offset = new Offset(offsetValue, Offset.OffSetKey.DAY);//
        } else if (offsetKey == 2) {
            return
                    offset = new Offset(offsetValue, Offset.OffSetKey.WORKDAYS);//
        } else if (offsetKey == 4) {
            return
                    offset = new Offset(offsetValue, Offset.OffSetKey.WEEK);//
        } else if (offsetKey == 5) {
            return
                    offset = new Offset(offsetValue, Offset.OffSetKey.MONTH);//
        }

        return new Offset();
    }

    /**
     * Setting the basedatecalculationKey by by the dueDate.
     */
    private BaseDateCalculation baseDateCalculationDueDate(int dueDate, String productCode, String variantCode) {
        if (dueDate == 1) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.EVT, variantCode, productCode);
        } else if (dueDate == 2) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.NextEVT, variantCode, productCode);
        } else if (dueDate == 3 || dueDate == 23) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.BegOfTheMonth, variantCode, productCode);
        } else if (dueDate == 4 || dueDate == 24) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.BegOfTheNextMonth, variantCode, productCode);
        } else if (dueDate == 20) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.noAction, variantCode, productCode);
        } else
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.noAction, variantCode, productCode);//
    }

}