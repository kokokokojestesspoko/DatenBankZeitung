package com.hup.DatenBankZeitung.Model.Tabelle.PK;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PK_HUPX_DUEDATEPRODUCT2CODE implements Serializable {
    private String productcode;
    private String systemcode;
    private String duedatecode;
    private int companyclientno;

    public PK_HUPX_DUEDATEPRODUCT2CODE() {
    }

    public PK_HUPX_DUEDATEPRODUCT2CODE(String productcode, String systemcode, String duedatecode, int companyclientno) {
        this.productcode = productcode;
        this.systemcode = systemcode;
        this.duedatecode = duedatecode;
        this.companyclientno = companyclientno;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
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

    public int getCompanyclientno() {
        return companyclientno;
    }

    public void setCompanyclientno(int companyclientno) {
        this.companyclientno = companyclientno;
    }
}
