package com.hup.DatenBankZeitung.Model.Overview;



import java.time.LocalDate;

public class Overview {
    private int nCount;
    private LocalDate dtMinDate;
    private int nCompanyClientNo;
    private int bCalculate;
    private int nDefaultTime;
    private int nOffSetKey;
    private int nOffSetValue;
    private int nReferenceKey;
    private int nWeekDayKey;
    private String strReferenceValue;
    private int nOffSetCounter;
    private LocalDate dtPublicationDate;
    private LocalDate dToday;
    private LocalDate dtResult;

    public int getnCount() {
        return nCount;
    }

    public void setnCount(int nCount) {
        this.nCount = nCount;
    }

    public LocalDate getDtMinDate() {
        return dtMinDate;
    }

    public void setDtMinDate(LocalDate dtMinDate) {
        this.dtMinDate = dtMinDate;
    }

    public int getnCompanyClientNo() {
        return nCompanyClientNo;
    }

    public void setnCompanyClientNo(int nCompanyClientNo) {
        this.nCompanyClientNo = nCompanyClientNo;
    }

    public int getbCalculate() {
        return bCalculate;
    }

    public void setbCalculate(int bCalculate) {
        this.bCalculate = bCalculate;
    }

    public int getnDefaultTime() {
        return nDefaultTime;
    }

    public void setnDefaultTime(int nDefaultTime) {
        this.nDefaultTime = nDefaultTime;
    }

    public int getnOffSetKey() {
        return nOffSetKey;
    }

    public void setnOffSetKey(int nOffSetKey) {
        this.nOffSetKey = nOffSetKey;
    }

    public int getnOffSetValue() {
        return nOffSetValue;
    }

    public void setnOffSetValue(int nOffSetValue) {
        this.nOffSetValue = nOffSetValue;
    }

    public int getnReferenceKey() {
        return nReferenceKey;
    }

    public void setnReferenceKey(int nReferenceKey) {
        this.nReferenceKey = nReferenceKey;
    }

    public int getnWeekDayKey() {
        return nWeekDayKey;
    }

    public void setnWeekDayKey(int nWeekDayKey) {
        this.nWeekDayKey = nWeekDayKey;
    }

    public String getStrReferenceValue() {
        return strReferenceValue;
    }

    public void setStrReferenceValue(String strReferenceValue) {
        this.strReferenceValue = strReferenceValue;
    }

    public int getnOffSetCounter() {
        return nOffSetCounter;
    }

    public void setnOffSetCounter(int nOffSetCounter) {
        this.nOffSetCounter = nOffSetCounter;
    }

    public LocalDate getDtPublicationDate() {
        return dtPublicationDate;
    }

    public void setDtPublicationDate(LocalDate dtPublicationDate) {
        this.dtPublicationDate = dtPublicationDate;
    }

    public LocalDate getdToday() {
        return dToday;
    }

    public void setdToday(LocalDate dToday) {
        this.dToday = dToday;
    }

    public LocalDate getDtResult() {
        return dtResult;
    }

    public void setDtResult(LocalDate dtResult) {
        this.dtResult = dtResult;
    }
}
