package com.hup.DatenBankZeitung.Model.Tabelle;
import com.hup.DatenBankZeitung.Model.Tabelle.PK.PK_HUPX_DUEDATETEMPLATE2PRODUCT;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "HUPX_DUEDATETEMPLATE2PRODUCT")
public class Hupx_Duedatetemplate2product {

    public Hupx_Duedatetemplate2product() {
    }

    @EmbeddedId
    private PK_HUPX_DUEDATETEMPLATE2PRODUCT pk_hupx_duedatetemplate2PRODUCT;
    @Column(name = "RECNO")
    private int recno;
    @Column(name = "SORTKEY")
    private int sortkey;
    @Column(name = "DUEDATETEMPLATECODE")
    private String duedatetemplatecode;
    @Column(name = "PRODUCTCODE")
    private String productcode;
    @Column(name = "STARTDATE")
    private LocalDate startdate;
    @Column(name = "ENDDATE")
    private LocalDate enddate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Hupx_DueDateProduct2Code> hupx_dueDateProduct2Codes;

    public Hupx_Duedatetemplate2product(PK_HUPX_DUEDATETEMPLATE2PRODUCT pk_hupx_duedatetemplate2PRODUCT,int recno,
                                        int sortkey,String duedatetemplatecode,String productcode, LocalDate startdate,LocalDate enddate) {
    this.pk_hupx_duedatetemplate2PRODUCT = pk_hupx_duedatetemplate2PRODUCT;
    this.recno = recno;
    this.sortkey = sortkey;
    this.duedatetemplatecode = duedatetemplatecode;
    this.productcode = productcode;
    this.startdate = startdate;
    this.enddate = enddate;
    }

    public PK_HUPX_DUEDATETEMPLATE2PRODUCT getPk_hupx_duedatetemplate2PRODUCT() {
        return pk_hupx_duedatetemplate2PRODUCT;
    }

    public void setPk_hupx_duedatetemplate2PRODUCT(PK_HUPX_DUEDATETEMPLATE2PRODUCT pk_hupx_duedatetemplate2PRODUCT) {
        this.pk_hupx_duedatetemplate2PRODUCT = pk_hupx_duedatetemplate2PRODUCT;
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

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        return "Hupx_Duedatetemplate2product{" +
                "pk_hupx_duedatetemplate2PRODUCT=" + pk_hupx_duedatetemplate2PRODUCT +
                ", recno=" + recno +
                ", sortkey=" + sortkey +
                ", duedatetemplatecode='" + duedatetemplatecode + '\'' +
                ", productcode='" + productcode + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                '}';
    }
}
