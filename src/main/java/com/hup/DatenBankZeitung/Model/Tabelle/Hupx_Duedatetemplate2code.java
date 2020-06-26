package com.hup.DatenBankZeitung.Model.Tabelle;

import com.hup.DatenBankZeitung.Model.Tabelle.PK.PK_HUPX_DUEDATETEMPLATE2CODE;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "HUPX_DUEDATETEMPLATE2CODE")
public class Hupx_Duedatetemplate2code {
    public Hupx_Duedatetemplate2code() {
    }

    @EmbeddedId
    private PK_HUPX_DUEDATETEMPLATE2CODE pk_hupx_duedatetemplate2CODE;
    @Column(name = "RECNO")
    private int recno;
    @Column(name = "SORTKEY")
    private int sortkey;
    @Column(name = "DUEDATETEMPLATECODE")
    private String duedatetemplatecode;
    @Column(name = "SYSTEMCODE")
    private String systemcode;
    @Column(name = "DUEDATECODE")
    private String duedatecode;
    @Column(name = "STARTDATE")
    private LocalDate startdate;
    @Column(name = "ENDDATE")
    private LocalDate enddate;
    @Column(name = "OFFSETKEY")
    private int offsetkey;
    @Column(name = "OFFSETVALUE")
    private int offsetvalue;
    @Column(name = "REFERENCEKEY")
    private int referencekey;
    @Column(name = "WEEKDAYKEY")
    private int weekdaykey;
    @Column(name = "REFERENCEVALUE")
    private String referencevalue;
    @Column(name = "COMPANYCLIENTNO")
    private int companyclientno;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "duedatetemplatecode", nullable = false)
    private Hupx_Duedatetemplate2product hupx_duedatetemplate2product;


    public Hupx_Duedatetemplate2code(PK_HUPX_DUEDATETEMPLATE2CODE pk_hupx_duedatetemplate2CODE, int recno, int sortkey,
                                     String duedatetemplatecode, String systemcode, String duedatecode, LocalDate startdate,
                                     LocalDate enddate, int offsetkey, int offsetvalue, int referencekey, int weekdaykey,
                                     String referencevalue, int companyclientno) {
        this.pk_hupx_duedatetemplate2CODE = pk_hupx_duedatetemplate2CODE;
        this.recno = recno;
        this.sortkey = sortkey;
        this.duedatetemplatecode = duedatetemplatecode;
        this.systemcode = systemcode;
        this.duedatecode = duedatecode;
        this.startdate = startdate;
        this.enddate = enddate;
        this.offsetkey = offsetkey;
        this.offsetvalue = offsetvalue;
        this.referencekey = referencekey;
        this.weekdaykey = weekdaykey;
        this.referencevalue = referencevalue;
        this.companyclientno = companyclientno;
    }

    public PK_HUPX_DUEDATETEMPLATE2CODE getPk_hupx_duedatetemplate2CODE() {
        return pk_hupx_duedatetemplate2CODE;
    }

    public void setPk_hupx_duedatetemplate2CODE(PK_HUPX_DUEDATETEMPLATE2CODE pk_hupx_duedatetemplate2CODE) {
        this.pk_hupx_duedatetemplate2CODE = pk_hupx_duedatetemplate2CODE;
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

    public String getDuedatetemplatecode() {
        return duedatetemplatecode;
    }

    public void setDuedatetemplatecode(String duedatetemplatecode) {
        this.duedatetemplatecode = duedatetemplatecode;
    }

    public String getSystemcode() {
        return systemcode;
    }

    public void setSystemcode(String systemcode) {
        this.systemcode = systemcode;
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

    public int getWeekdaykey() {
        return weekdaykey;
    }

    public void setWeekdaykey(int weekdaykey) {
        this.weekdaykey = weekdaykey;
    }

    public String getReferencevalue() {
        return referencevalue;
    }

    public void setReferencevalue(String referencevalue) {
        this.referencevalue = referencevalue;
    }

    public int getCompanyclientno() {
        return companyclientno;
    }

    public void setCompanyclientno(int companyclientno) {
        this.companyclientno = companyclientno;
    }

    @Override
    public String toString() {
        return "Hupx_Duedatetemplate2code{" +
                "pk_hupx_duedatetemplate2CODE=" + pk_hupx_duedatetemplate2CODE +
                ", recno=" + recno +
                ", sortkey=" + sortkey +
                ", duedatetemplatecode='" + duedatetemplatecode + '\'' +
                ", systemcode='" + systemcode + '\'' +
                ", duedatecode='" + duedatecode + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", offsetkey=" + offsetkey +
                ", offsetvalue=" + offsetvalue +
                ", referencekey=" + referencekey +
                ", weekdaykey=" + weekdaykey +
                ", referencevalue='" + referencevalue + '\'' +
                ", companyclientno=" + companyclientno +
                '}';
    }
}
