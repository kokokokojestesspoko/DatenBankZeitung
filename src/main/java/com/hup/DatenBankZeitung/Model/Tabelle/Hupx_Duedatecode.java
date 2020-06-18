package com.hup.DatenBankZeitung.Model.Tabelle;


import com.hup.DatenBankZeitung.Model.Tabelle.PK.PK_HUPX_DUEDATECODE;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HUPX_DUEDATECODE")
public class Hupx_Duedatecode {

    public Hupx_Duedatecode() {
    }

    @EmbeddedId
    private PK_HUPX_DUEDATECODE pk_hupx_duedatecode;
    @Column(name = "RECNO")
    private int recno;
    @Column(name = "SORTKEY")
    private int sortkey;
    @Column(name = "SYSTEMCODE")
    private String systemcode;
    @Column(name = "DUEDATECODE")
    private String duedatecode;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STARTDATE")
    private LocalDate startdate;
    @Column(name = "ENDDATE")
    private LocalDate enddate;
    @Column(name = "AUTOMATICBATCHFLAG")
    private int automaticbatchflag;
    @Column(name = "DEFAULTTIME")
    private int defaulttime;

    public Hupx_Duedatecode(PK_HUPX_DUEDATECODE pk_hupx_duedatecode,int recno, int sortkey, String systemcode, String duedatecode, String description,
                            LocalDate startdate, LocalDate enddate, int automaticbatchflag, int defaulttime) {
        this.pk_hupx_duedatecode = pk_hupx_duedatecode;
        this.recno = recno;
        this.sortkey = sortkey;
        this.systemcode = systemcode;
        this.duedatecode = duedatecode;
        this.description = description;
        this.startdate = startdate;
        this.enddate = enddate;
        this.automaticbatchflag = automaticbatchflag;
        this.defaulttime = defaulttime;
    }

    public PK_HUPX_DUEDATECODE getPk_hupx_duedatecode() {
        return pk_hupx_duedatecode;
    }

    public void setPk_hupx_duedatecode(PK_HUPX_DUEDATECODE pk_hupx_duedatecode) {
        this.pk_hupx_duedatecode = pk_hupx_duedatecode;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getAutomaticbatchflag() {
        return automaticbatchflag;
    }

    public void setAutomaticbatchflag(int automaticbatchflag) {
        this.automaticbatchflag = automaticbatchflag;
    }

    public int getDefaulttime() {
        return defaulttime;
    }

    public void setDefaulttime(int defaulttime) {
        this.defaulttime = defaulttime;
    }

    @Override
    public String toString() {
        return "Hupx_Duedatecode{" +
                "recno=" + recno +
                ", sortkey=" + sortkey +
                ", systemcode='" + systemcode + '\'' +
                ", duedatecode='" + duedatecode + '\'' +
                ", description='" + description + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", automaticbatchflag=" + automaticbatchflag +
                ", defaulttime=" + defaulttime +
                '}';
    }
}
