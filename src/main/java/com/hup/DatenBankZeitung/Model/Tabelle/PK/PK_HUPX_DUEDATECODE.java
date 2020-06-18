package com.hup.DatenBankZeitung.Model.Tabelle.PK;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PK_HUPX_DUEDATECODE implements Serializable {
    private String systemcode;
    private String duedatecode;

    public PK_HUPX_DUEDATECODE() {
    }

    public PK_HUPX_DUEDATECODE(String systemcode, String duedatecode) {
        this.duedatecode = duedatecode;
        this.systemcode = systemcode;
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
}
