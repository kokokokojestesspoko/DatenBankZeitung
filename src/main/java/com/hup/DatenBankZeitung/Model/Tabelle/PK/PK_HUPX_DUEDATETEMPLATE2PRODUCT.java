package com.hup.DatenBankZeitung.Model.Tabelle.PK;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class PK_HUPX_DUEDATETEMPLATE2PRODUCT implements Serializable {
    public PK_HUPX_DUEDATETEMPLATE2PRODUCT() {
    }

    private String duedatetemplatecode;
    private String productcode;
    private LocalDate startdate;

    public PK_HUPX_DUEDATETEMPLATE2PRODUCT(String duedatetemplatecode, String productcode, LocalDate startdate) {
        this.duedatetemplatecode = duedatetemplatecode;
        this.productcode = productcode;
        this.startdate = startdate;
    }

    public String getDuedatetemplatecode() {
        return duedatetemplatecode;
    }

    public void setDuedatetemplatecode(String duedatetemplatecode) {
        this.duedatetemplatecode = duedatetemplatecode;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }
}
