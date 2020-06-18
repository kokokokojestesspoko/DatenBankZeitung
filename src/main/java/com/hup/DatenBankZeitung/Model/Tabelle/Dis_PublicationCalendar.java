package com.hup.DatenBankZeitung.Model.Tabelle;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DIS_PUBLICATIONCALENDAR")
public class Dis_PublicationCalendar {
    //public no Arg Constructor
    public Dis_PublicationCalendar() {
    }


    @Id
    @Column(name = "RECNO")
    private int recno;
    @Column(name = "DELIVERYPARTNERNO")
    private int deliverypartnerno;
    @Column(name = "VARIANTCODE")
    private String variantcode;
    @Column(name = "PRODUCTCODE")
    private String productcode;
    @Column(name = "PUBLICATIONDATE")
    private LocalDate publicationdate;
    @Column(name = "PUBLICATIONWEEKDAY")
    private int publicationweekday;
    @Column(name = "PUBLICATIONDAYCODE")
    private String publicationdaycode;
    @Column(name = "DISPATCHPERFORMDATE")
    private LocalDate dispatchperformdate;
    @Column(name = "STATPUBLICATIONDAYCODE")
    private String statpublicationdaycode;
    @Column(name = "BOOKNUMBER")
    private int booknumber;
    @Column(name = "EDITIONID")
    private String editionid;
    @Column(name = "SPECIALTAXRULECODE")
    private String specialtaxrulecode;

    public Dis_PublicationCalendar(int recno, int deliverypartnerno, String variantcode, String productcode,
                                   LocalDate publicationdate, int publicationweekday, String publicationdaycode,
                                   LocalDate dispatchperformdate, String statpublicationdaycode, int booknumber,
                                   String editionid, String specialtaxrulecode) {
        this.recno = recno;
        this.deliverypartnerno = deliverypartnerno;
        this.variantcode = variantcode;
        this.productcode = productcode;
        this.publicationdate = publicationdate;
        this.publicationweekday = publicationweekday;
        this.publicationdaycode = publicationdaycode;
        this.dispatchperformdate = dispatchperformdate;
        this.statpublicationdaycode = statpublicationdaycode;
        this.booknumber = booknumber;
        this.editionid = editionid;
        this.specialtaxrulecode = specialtaxrulecode;
    }

    public int getRecno() {
        return recno;
    }

    public void setRecno(int recno) {
        this.recno = recno;
    }

    public int getDeliverypartnerno() {
        return deliverypartnerno;
    }

    public void setDeliverypartnerno(int deliverypartnerno) {
        this.deliverypartnerno = deliverypartnerno;
    }

    public String getVariantcode() {
        return variantcode;
    }

    public void setVariantcode(String variantcode) {
        this.variantcode = variantcode;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public LocalDate getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(LocalDate publicationdate) {
        this.publicationdate = publicationdate;
    }

    public int getPublicationweekday() {
        return publicationweekday;
    }

    public void setPublicationweekday(int publicationweekday) {
        this.publicationweekday = publicationweekday;
    }

    public String getPublicationdaycode() {
        return publicationdaycode;
    }

    public void setPublicationdaycode(String publicationdaycode) {
        this.publicationdaycode = publicationdaycode;
    }

    public LocalDate getDispatchperformdate() {
        return dispatchperformdate;
    }

    public void setDispatchperformdate(LocalDate dispatchperformdate) {
        this.dispatchperformdate = dispatchperformdate;
    }

    public String getStatpublicationdaycode() {
        return statpublicationdaycode;
    }

    public void setStatpublicationdaycode(String statpublicationdaycode) {
        this.statpublicationdaycode = statpublicationdaycode;
    }

    public int getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(int booknumber) {
        this.booknumber = booknumber;
    }

    public String getEditionid() {
        return editionid;
    }

    public void setEditionid(String editionid) {
        this.editionid = editionid;
    }

    public String getSpecialtaxrulecode() {
        return specialtaxrulecode;
    }

    public void setSpecialtaxrulecode(String specialtaxrulecode) {
        this.specialtaxrulecode = specialtaxrulecode;
    }

    @Override
    public String toString() {
        return "Dis_PublicationCalendar{" +
                "recno=" + recno +
                ", deliverypartnerno=" + deliverypartnerno +
                ", variantcode='" + variantcode + '\'' +
                ", productcode='" + productcode + '\'' +
                ", publicationdate=" + publicationdate +
                ", publicationweekday=" + publicationweekday +
                ", publicationdaycode='" + publicationdaycode + '\'' +
                ", dispatchperformdate=" + dispatchperformdate +
                ", statpublicationdaycode='" + statpublicationdaycode + '\'' +
                ", booknumber=" + booknumber +
                ", editionid='" + editionid + '\'' +
                ", specialtaxrulecode='" + specialtaxrulecode + '\'' +
                '}';
    }
}
