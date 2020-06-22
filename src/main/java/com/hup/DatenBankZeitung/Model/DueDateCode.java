package com.hup.DatenBankZeitung.Model;

import com.hup.DatenBankZeitung.Model.Service.Dis_PublicationCalendarService;
import com.hup.DatenBankZeitung.Model.Service.Hupx_DueDateProduct2CodeService;

import java.sql.*;
import java.time.LocalDate;

public class DueDateCode {
    private String productCode;
    private String systemCode;
    private int companyClientNo;
    private LocalDate startDate;
    private String variantCode;
    private String dueDateCode;
    private Offset offset;
    private WeekDay weekDay;
    private BaseDateCalculation baseDateCalculation;
    private Hupx_DueDateProduct2CodeService hupx_dueDateProduct2CodeService;
    private Dis_PublicationCalendarService dis_publicationCalendarService;

    public DueDateCode() {
    }

    public DueDateCode(String productCode, String systemCode, String dueDateCode, int companyClientNo, LocalDate startDate, String variantCode, Hupx_DueDateProduct2CodeService hupx_dueDateProduct2CodeService, Dis_PublicationCalendarService dis_publicationCalendarService) {
        this.productCode = productCode;
        loadCalculations(productCode,systemCode,dueDateCode,companyClientNo,startDate,variantCode,hupx_dueDateProduct2CodeService,dis_publicationCalendarService);
        validation(dis_publicationCalendarService);

    }
    public LocalDate validation(Dis_PublicationCalendarService dis_publicationCalendarService){
        WeekDay weekDay = new WeekDay();
        LocalDate baseDate = dis_publicationCalendarService.loadMinDate(productCode,variantCode,startDate);
        if(weekDay.isValid(baseDate))
        {
            return offset.calc(baseDate);
        }
        else
            return startDate;
    }
//*public LocalDate calc(LocalDate date) throws SQLException {
//        LocalDate baseDate = baseDateCalculation.calc(startDate);
//        if (weekDay.isValid(baseDate)) {
//
//            return offset.calc(baseDate);
//        } else
//            return date;
//    }*//



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

     */
    public void loadCalculations( String productCode, String systemCode, String dueDateCode, int companyClientNo, LocalDate startDate, String variantCode, Hupx_DueDateProduct2CodeService hupx_dueDateProduct2CodeService,Dis_PublicationCalendarService dis_publicationCalendarService)  {
        int offsetKey = hupx_dueDateProduct2CodeService.loadOffsetKey(productCode,systemCode,dueDateCode,companyClientNo,startDate);
        int offsetValue = hupx_dueDateProduct2CodeService.loadoffsetValue(productCode,systemCode,dueDateCode,companyClientNo,startDate);
        int referenceKey = hupx_dueDateProduct2CodeService.loadReferenceKey(productCode,systemCode,dueDateCode,companyClientNo,startDate);;
        int weekdayKey = hupx_dueDateProduct2CodeService.loadWeekdayKey(productCode,systemCode,dueDateCode,companyClientNo,startDate);
        String referenceValue = hupx_dueDateProduct2CodeService.loadreferenceValue(productCode,systemCode,dueDateCode,companyClientNo,startDate);//wozu?

            offset = offsetKey(offsetKey, startDate, offsetValue);
            weekDay = new WeekDay(weekdayKey);
            baseDateCalculation = baseDateCalculationDueDate(referenceKey, productCode, variantCode,dis_publicationCalendarService);
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
    private BaseDateCalculation baseDateCalculationDueDate(int dueDate, String productCode, String variantCode,Dis_PublicationCalendarService dis_publicationCalendarService) {
        if (dueDate == 1) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.EVT, variantCode, productCode,dis_publicationCalendarService );
        } else if (dueDate == 2) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.NextEVT, variantCode, productCode,dis_publicationCalendarService);
        } else if (dueDate == 3 || dueDate == 23) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.BegOfTheMonth, variantCode, productCode,dis_publicationCalendarService);
        } else if (dueDate == 4 || dueDate == 24) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.BegOfTheNextMonth, variantCode, productCode,dis_publicationCalendarService);
        } else if (dueDate == 20) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.noAction, variantCode, productCode,dis_publicationCalendarService);
        } else
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.noAction, variantCode, productCode,dis_publicationCalendarService);//
    }
// Service
}