package com.hup.DatenBankZeitung.Model;

import com.hup.DatenBankZeitung.Model.Service.*;
import com.hup.DatenBankZeitung.Model.Tabelle.Hup_Duedate;

import java.time.LocalDate;

public class DueDateCode {
    private String productCode;
    private String systemCode;
    private int companyClientNoIn;
    private LocalDate publicationdate;
    private LocalDate startDate;
    private String variantCode;
    private String dueDateCode;
    private Offset offset;
    private WeekDay weekDay;
    private BaseDateCalculation baseDateCalculation;
    private Hupx_DueDateProduct2CodeService hupx_dueDateProduct2CodeService;
    private Dis_PublicationCalendarService dis_publicationCalendarService;
    private HupProductiondateService hupProductiondateService;
    private Hupx_DuedatecodeService hupx_duedatecodeService;
    private Hup_Duedate hup_duedate;
    private Hup_DuedateService hup_duedateService;

    public DueDateCode() {
    }

    public DueDateCode(String productCode, String systemCode, int companyClientNoIn,  LocalDate startDate, String variantCode,
                       String dueDateCode) {
        this.productCode = productCode;
        this.systemCode = systemCode;
        this.companyClientNoIn = companyClientNoIn;
        this.startDate = startDate;
        this.variantCode = variantCode;
        this.dueDateCode = dueDateCode;

    }

    public LocalDate validation(Dis_PublicationCalendarService dis_publicationCalendarService) {
        WeekDay weekDay = new WeekDay();
        LocalDate baseDate = dis_publicationCalendarService.loadMinDate(productCode, variantCode, startDate);
        if (weekDay.isValid(baseDate)) {
            return offset.calc(baseDate);
        } else
            return startDate;
    }

    public int loadCompanyClient(int companyClientNoIn) {
        if (companyClientNoIn == 0) {
            return -1;
        } else
            return companyClientNoIn;
    }

//*public LocalDate calc(LocalDate date) throws SQLException {
//        LocalDate baseDate = baseDateCalculation.calc(startDate);
//        if (weekDay.isValid(baseDate)) {
//
//            return offset.calc(baseDate);
//        } else
//            return date;
//    }*//

    public LocalDate logik() {
        LocalDate dtMinDate = null;
        LocalDate dtPublicationDate = null;
        LocalDate dtResult = null;
        int companyClientNo;
        int offsetkey = 0;
        int offsetvalue = 0;
        int referencekey = 0;
        int weekdaykey = 0;
        String referencevalue;
        LocalDate dtToday = hupProductiondateService.loadDtToday(hupProductiondateService.loadProductiondate());
        companyClientNo = loadCompanyClient(companyClientNoIn);
        int deafulttime = hupx_duedatecodeService.loadDeafultTime(systemCode, dueDateCode, dtToday);
        int nCount = hupx_duedatecodeService.getnCounter(systemCode, dueDateCode, dtToday);
        int bCalculate = hupx_duedatecodeService.getbCalculate(nCount);
        if (hupx_duedatecodeService.getbCalculate(hupx_duedatecodeService.getnCounter(systemCode, dueDateCode, dtToday)) == 1) {
            dtMinDate = hupx_duedatecodeService.setMinDate();
            dtPublicationDate = startDate;
            dtResult = hup_duedateService.loadDueDateTime(dtPublicationDate, productCode, variantCode, dueDateCode, systemCode, companyClientNo);
            if (hup_duedateService.duedatetimeCounter(dtPublicationDate, productCode, variantCode, dueDateCode, systemCode, companyClientNo) == 1) {
                bCalculate = 0;
            } else {
                offsetkey = hupx_dueDateProduct2CodeService.loadOffsetKey(productCode, systemCode, dueDateCode, companyClientNo, dtToday);
                offsetvalue = hupx_dueDateProduct2CodeService.loadoffsetValue(productCode, systemCode, dueDateCode, companyClientNo, dtToday);
                referencekey = hupx_dueDateProduct2CodeService.loadReferenceKey(productCode, systemCode, dueDateCode, companyClientNo, dtToday);
                weekdaykey = hupx_dueDateProduct2CodeService.loadWeekdayKey(productCode, systemCode, dueDateCode, companyClientNo, dtToday);
                referencevalue = hupx_dueDateProduct2CodeService.loadreferenceValue(productCode, systemCode, dueDateCode, companyClientNo, dtToday);
                if (hupx_dueDateProduct2CodeService.counterFromKeys(productCode, systemCode, dueDateCode, companyClientNo, dtToday) == 0) {
                    offsetkey = hupx_dueDateProduct2CodeService.loadOffsetKeyBetweenDates(productCode, systemCode, dueDateCode, companyClientNo, dtToday);
                    offsetvalue = hupx_dueDateProduct2CodeService.loadoffsetValueBetweenDates(productCode, systemCode, dueDateCode, companyClientNo, dtToday);
                    referencekey = hupx_dueDateProduct2CodeService.loadReferenceKeyBetweenDates(productCode, systemCode, dueDateCode, companyClientNo, dtToday);
                    weekdaykey = hupx_dueDateProduct2CodeService.loadWeekdayKeyBetweenDates(productCode, systemCode, dueDateCode, companyClientNo, dtToday);
                    referencevalue = hupx_dueDateProduct2CodeService.loadreferenceValueBetweenDates(productCode, systemCode, dueDateCode, companyClientNo, dtToday);
                }
                if (hupx_dueDateProduct2CodeService.counterFromKeys(productCode, systemCode, dueDateCode, companyClientNo, dtToday) != 1)
                {
                    bCalculate = 0;
                } else if (referencekey != 1 || referencekey != 2 || referencekey != 3 || referencekey != 4 || referencekey != 5 || referencekey != 20 || referencekey != 23
                        || referencekey != 24 || referencekey != 25 || offsetkey > 1 && offsetkey < 5 || weekdaykey > 1 & weekdaykey < 127) {
                    bCalculate = 0;
                }
            }
        }
        if (bCalculate == 1 & referencekey < 20) {
            dtResult = dis_publicationCalendarService.dtResultCheckifnotnull(productCode, variantCode, dtPublicationDate);
            if (dtResult == dtMinDate) {
                bCalculate = 0;
                dtResult = null;
            } else if (referencekey == 2) {
                dtResult = dis_publicationCalendarService.loadMinDate(productCode, variantCode, dtPublicationDate);
                if (dtResult == dtMinDate) {
                    bCalculate = 0;
                    dtResult = null;
                }
            }
        }
        if (bCalculate == 1) {
            if (dtResult == null) {
                dtResult = dtPublicationDate;
            }
            if (referencekey == 3 || referencekey == 4 || referencekey == 23 || referencekey == 24) {
                baseDateCalculation = baseDateCalculationDueDate(referencekey, productCode, variantCode, dis_publicationCalendarService);
            }
            if (bCalculate == 1 && offsetvalue != 0) {
                offset = offsetKey(offsetkey, offsetvalue);

            }
            weekDay = new WeekDay(weekdaykey);
            dtResult = baseDateCalculation.getBaseDateCalculationKey().calc(dtResult);
         //   dtResult = offset.calc(dtResult);
            if (weekDay.isValid(dtResult)) {
                return offset.calc(dtResult);
            } else
                return dtResult;
        }
        return dtResult;
    }

    /**
     * Method to execute the sql Query  which will pass the values to WEEKDAY, OFFSET and BASEDATECALCULATION class.
     */
    public void loadCalculations(String productCode, String systemCode, String dueDateCode, int companyClientNo, LocalDate startDate, String variantCode, Hupx_DueDateProduct2CodeService hupx_dueDateProduct2CodeService, Dis_PublicationCalendarService dis_publicationCalendarService) {
        int offsetKey = hupx_dueDateProduct2CodeService.loadOffsetKey(productCode, systemCode, dueDateCode, companyClientNo, startDate);
        int offsetValue = hupx_dueDateProduct2CodeService.loadoffsetValue(productCode, systemCode, dueDateCode, companyClientNo, startDate);
        int referenceKey = hupx_dueDateProduct2CodeService.loadReferenceKey(productCode, systemCode, dueDateCode, companyClientNo, startDate);
        ;
        int weekdayKey = hupx_dueDateProduct2CodeService.loadWeekdayKey(productCode, systemCode, dueDateCode, companyClientNo, startDate);
        String referenceValue = hupx_dueDateProduct2CodeService.loadreferenceValue(productCode, systemCode, dueDateCode, companyClientNo, startDate);

        offset = offsetKey(offsetKey,  offsetValue);
        weekDay = new WeekDay(weekdayKey);
        baseDateCalculation = baseDateCalculationDueDate(referenceKey, productCode, variantCode, dis_publicationCalendarService);
    }

    /**
     * Setting the OffsetKey Enum by the Offset Value.
     *
     * @return
     */
    private Offset offsetKey(int offsetKey,  int offsetValue) {
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
    private BaseDateCalculation baseDateCalculationDueDate(int referencekey, String productCode, String variantCode, Dis_PublicationCalendarService dis_publicationCalendarService) {
        if (referencekey == 1) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.EVT, variantCode, productCode, dis_publicationCalendarService);
        } else if (referencekey == 2) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.NextEVT, variantCode, productCode, dis_publicationCalendarService);
        } else if (referencekey == 3 || referencekey == 23) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.BegOfTheMonth, variantCode, productCode, dis_publicationCalendarService);
        } else if (referencekey == 4 || referencekey == 24) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.BegOfTheNextMonth, variantCode, productCode, dis_publicationCalendarService);
        } else if (referencekey == 20) {
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.noAction, variantCode, productCode, dis_publicationCalendarService);
        } else
            return baseDateCalculation = new BaseDateCalculation(BaseDateCalculation.BaseDateCalculationKey.noAction, variantCode, productCode, dis_publicationCalendarService);//
    }

    public BaseDateCalculation getBaseDateCalculation() {
        return baseDateCalculation;
    }

    public void setBaseDateCalculation(BaseDateCalculation baseDateCalculation) {
        this.baseDateCalculation = baseDateCalculation;
    }

    public Offset getOffset() {
        return offset;
    }

    public void setOffset(Offset offset) {
        this.offset = offset;
    }
    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public String getDueDateCode() {
        return dueDateCode;
    }

    public void setDueDateCode(String dueDateCode) {
        this.dueDateCode = dueDateCode;
    }
}