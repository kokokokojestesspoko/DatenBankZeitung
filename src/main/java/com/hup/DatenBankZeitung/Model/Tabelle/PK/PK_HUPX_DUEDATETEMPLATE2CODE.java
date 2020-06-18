package com.hup.DatenBankZeitung.Model.Tabelle.PK;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class PK_HUPX_DUEDATETEMPLATE2CODE implements Serializable{
    public PK_HUPX_DUEDATETEMPLATE2CODE() {
    }

    private String duedatetemplatecode;
    private String systemcode;
    private String duedatecode;
    private int companyclientno;

    public PK_HUPX_DUEDATETEMPLATE2CODE(String duedatetemplatecode, String systemcode, String duedatecode, int companyclientno) {
        this.duedatetemplatecode = duedatetemplatecode;
        this.systemcode = systemcode;
        this.duedatecode = duedatecode;
        this.companyclientno = companyclientno;
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

    public int getCompanyclientno() {
        return companyclientno;
    }

    public void setCompanyclientno(int companyclientno) {
        this.companyclientno = companyclientno;
    }
}
