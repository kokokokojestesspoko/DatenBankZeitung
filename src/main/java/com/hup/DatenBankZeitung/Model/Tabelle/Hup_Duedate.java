package com.hup.DatenBankZeitung.Model.Tabelle;

import com.hup.DatenBankZeitung.Model.Tabelle.PK.PK_HUP_DUEDATE;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "HUP_DUEDATE")
public class Hup_Duedate {
    public Hup_Duedate() {
    }

    @EmbeddedId
    private PK_HUP_DUEDATE pk_hup_duedate;
    @Column(name = "RECNO")
    private int recno;
    @Column(name = "GROUPID1")
    private String groupid1;
    @Column(name = "GROUPID2")
    private String groupid2;
    @Column(name = "GROUPID3")
    private String groupid3;
    @Column(name = "GROUPID4")
    private String groupid4;
    @Column(name = "PRODUCTCODE")
    private String productcode;
    @Column(name = "VARIANTCODE")
    private String variantcode;
    @Column(name = "SYSTEMCODE")
    private String systemcode;
    @Column(name = "DUEDATECODE")
    private String duedatecode;
    @Column(name = "PUBLICATIONDATE")
    private LocalDate publicationdate;
    @Column(name = "DUEDATETIME")
    private LocalDate duedatetime;
    @Column(name = "DONEFLAG")
    private int doneflag;
    @Column(name = "ALERTEDFLAG")
    private String alertedflag;
    @Column(name = "CREATEDBYCLIENTNO")
    private int createdbyclientno;
    @Column(name = "CREATETIME")
    private LocalDate createtime;
    @Column(name = "CHANGEDBYCLIENTNO")
    private int changedbyclientno;
    @Column(name = "CHANGETIME")
    private LocalDate changetime;
    @Column(name = "COMPANYCLIENTNO")
    private int companyclientno;

    public Hup_Duedate(PK_HUP_DUEDATE pk_hup_duedate, int recno, String groupid1, String groupid2, String groupid3, String groupid4, String productcode, String variantcode, String systemcode, String duedatecode, LocalDate publicationdate, LocalDate duedatetime, int doneflag, String alertedflag, int createdbyclientno, LocalDate createtime, int changedbyclientno, LocalDate changetime, int companyclientno) {

        this.pk_hup_duedate = pk_hup_duedate;
        this.recno = recno;
        this.groupid1 = groupid1;
        this.groupid2 = groupid2;
        this.groupid3 = groupid3;
        this.groupid4 = groupid4;
        this.productcode = productcode;
        this.variantcode = variantcode;
        this.systemcode = systemcode;
        this.duedatecode = duedatecode;
        this.publicationdate = publicationdate;
        this.duedatetime = duedatetime;
        this.doneflag = doneflag;
        this.alertedflag = alertedflag;
        this.createdbyclientno = createdbyclientno;
        this.createtime = createtime;
        this.changedbyclientno = changedbyclientno;
        this.changetime = changetime;
        this.companyclientno = companyclientno;
    }

    public int getCompanyclientno() {
        return companyclientno;
    }

    public void setCompanyclientno(int companyclientno) {
        this.companyclientno = companyclientno;
    }

    public PK_HUP_DUEDATE getPk_hup_duedate() {
        return pk_hup_duedate;
    }

    public void setPk_hup_duedate(PK_HUP_DUEDATE pk_hup_duedate) {
        this.pk_hup_duedate = pk_hup_duedate;
    }

    public int getRecno() {
        return recno;
    }

    public void setRecno(int recno) {
        this.recno = recno;
    }

    public String getGroupid1() {
        return groupid1;
    }

    public void setGroupid1(String groupid1) {
        this.groupid1 = groupid1;
    }

    public String getGroupid2() {
        return groupid2;
    }

    public void setGroupid2(String groupid2) {
        this.groupid2 = groupid2;
    }

    public String getGroupid3() {
        return groupid3;
    }

    public void setGroupid3(String groupid3) {
        this.groupid3 = groupid3;
    }

    public String getGroupid4() {
        return groupid4;
    }

    public void setGroupid4(String groupid4) {
        this.groupid4 = groupid4;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getVariantcode() {
        return variantcode;
    }

    public void setVariantcode(String variantcode) {
        this.variantcode = variantcode;
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

    public LocalDate getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(LocalDate publicationdate) {
        this.publicationdate = publicationdate;
    }

    public LocalDate getDuedatetime() {
        return duedatetime;
    }

    public void setDuedatetime(LocalDate duedatetime) {
        this.duedatetime = duedatetime;
    }

    public int getDoneflag() {
        return doneflag;
    }

    public void setDoneflag(int doneflag) {
        this.doneflag = doneflag;
    }

    public String getAlertedflag() {
        return alertedflag;
    }

    public void setAlertedflag(String alertedflag) {
        this.alertedflag = alertedflag;
    }

    public int getCreatedbyclientno() {
        return createdbyclientno;
    }

    public void setCreatedbyclientno(int createdbyclientno) {
        this.createdbyclientno = createdbyclientno;
    }

    public LocalDate getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDate createtime) {
        this.createtime = createtime;
    }

    public int getChangedbyclientno() {
        return changedbyclientno;
    }

    public void setChangedbyclientno(int changedbyclientno) {
        this.changedbyclientno = changedbyclientno;
    }

    public LocalDate getChangetime() {
        return changetime;
    }

    public void setChangetime(LocalDate changetime) {
        this.changetime = changetime;
    }
}
