package com.hup.DatenBankZeitung.Model.Tabelle.PK;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;


@Embeddable
public class PK_HUP_DUEDATE implements Serializable {
    private String productcode;
    private String variantcode;
    private String systemcode;
    private String duedatecode;
    private LocalDate publicationdate;
    private int companyclientno;

    public PK_HUP_DUEDATE() {
    }

    public PK_HUP_DUEDATE(String productcode, String variantcode, String systemcode, String duedatecode, LocalDate publicationdate, int companyclientno) {
        this.productcode = productcode;
        this.variantcode = variantcode;
        this.systemcode = systemcode;
        this.duedatecode = duedatecode;
        this.publicationdate = publicationdate;
        this.companyclientno = companyclientno;
    }

    public int getCompanyclientno() {
        return companyclientno;
    }

    public void setCompanyclientno(int companyclientno) {
        this.companyclientno = companyclientno;
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
}
