package com.hup.DatenBankZeitung.Model.Tabelle;


import com.hup.DatenBankZeitung.Model.Tabelle.PK.PK_HUPX_DUEDATEPRODUCT2CODE;

import static java.lang.String.format;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HUPX_DUEDATEPRODUCT2CODE")

public class Hupx_DueDateProduct2Code {
    //Empty constructor


    public Hupx_DueDateProduct2Code() { //Duedate<----
    }

    @EmbeddedId //Which one is PK? Product,System or DueDate code?// suchen
    private PK_HUPX_DUEDATEPRODUCT2CODE pk_hupx_duedateproduct2CODE;
    @Column(name="RECNO")
    private int recno;
    @Column(name="SORTKEY")
    private int sortkey;
    @Column(name="PRODUCTCODE")
    private String productcode;
    @Column(name="SYSTEMCODE")
    private String systemcode;
    @Column(name="DUEDATECODE")
    private String duedatecode;
    @Column(name="STARTDATE")
    private LocalDate startdate;
    @Column(name="ENDDATE")
    private LocalDate enddate;
    @Column(name="OFFSETKEY")
    private int offsetkey;
    @Column(name="OFFSETVALUE")
    private int offsetvalue;
    @Column(name="WEEKDAYKEY")
    private int weekdaykey;
    @Column(name="REFERENCEKEY")
    private int referencekey;
    @Column(name="REFERENCEVALUE")
    private String referencevalue;
    @Column(name="COMPANYCLIENTNO")
    private int companyclientno;

    public Hupx_DueDateProduct2Code(PK_HUPX_DUEDATEPRODUCT2CODE pk_hupx_duedateproduct2CODE, int recno, int sortkey, String productcode, String systemcode, String duedatecode, LocalDate startdate,
                                    LocalDate enddate, int offsetkey, int offsetvalue, int weekdaykey, int referencekey, String referencevalue, int companyclientno) {
        this.pk_hupx_duedateproduct2CODE = pk_hupx_duedateproduct2CODE;
        this.recno = recno;
        this.sortkey = sortkey;
        this.productcode = productcode;
        this.duedatecode = duedatecode;
        this.startdate = startdate;
        this.enddate = enddate;
        this.offsetkey = offsetkey;
        this.offsetvalue = offsetvalue;
        this.weekdaykey = weekdaykey;
        this.referencekey = referencekey;
        this.referencevalue = referencevalue;
        this.systemcode = systemcode;
        this.companyclientno = companyclientno;
    }

    //Spring way to create Get/Set?

    public PK_HUPX_DUEDATEPRODUCT2CODE getPk_hupx_duedateproduct2CODE() {
        return pk_hupx_duedateproduct2CODE;
    }

    public void setPk_hupx_duedateproduct2CODE(PK_HUPX_DUEDATEPRODUCT2CODE pk_hupx_duedateproduct2CODE) {
        this.pk_hupx_duedateproduct2CODE = pk_hupx_duedateproduct2CODE;
    }

    public int getCompanyclientno() {
        return companyclientno;
    }

    public int getWeekdaykey() {
        return weekdaykey;
    }

    public void setWeekdaykey(int weekdaykey) {
        this.weekdaykey = weekdaykey;
    }

    public void setCompanyclientno(int companyclientno) {
        this.companyclientno = companyclientno;
    }

    public String getSystemcode() {
        return systemcode;
    }

    public void setSystemcode(String systemcode) {
        this.systemcode = systemcode;
    }

    public int getRecno() {
        return recno;
    }

    public void setRecno(int recno) {
        this.recno = recno;
    }

    public int getSortkey() {
        return sortkey;
    }

    public void setSortkey(int sortkey) {
        this.sortkey = sortkey;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getDuedatecode() {
        return duedatecode;
    }

    public void setDuedatecode(String duedatecode) {
        this.duedatecode = duedatecode;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public int getOffsetkey() {
        return offsetkey;
    }

    public void setOffsetkey(int offsetkey) {
        this.offsetkey = offsetkey;
    }

    public int getOffsetvalue() {
        return offsetvalue;
    }

    public void setOffsetvalue(int offsetvalue) {
        this.offsetvalue = offsetvalue;
    }

    public int getReferencekey() {
        return referencekey;
    }

    public void setReferencekey(int referencekey) {
        this.referencekey = referencekey;
    }

    public String getReferencevalue() {
        return referencevalue;
    }

    public void setReferencevalue(String referencevalue) {
        this.referencevalue = referencevalue;
    }

    @Override
    public String toString() {
        return "Hupx_Product2Code{" +
                "recno=" + recno +
                ", sortkey=" + sortkey +
                ", productcode='" + productcode + '\'' +
                ", duedatecode='" + duedatecode + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", offsetkey=" + offsetkey +
                ", offsetvalue=" + offsetvalue +
                ", referencekey=" + referencekey +
                ", referencevalue='" + referencevalue + '\'' +
                '}';
    }
}

