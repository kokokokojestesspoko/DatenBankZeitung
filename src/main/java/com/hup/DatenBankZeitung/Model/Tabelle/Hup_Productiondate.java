package com.hup.DatenBankZeitung.Model.Tabelle;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "HUP_PRODUCTIONDATE")
public class Hup_Productiondate {

    public Hup_Productiondate() {
    }

    @Id
    @Column(name = "PRODUCTIONDATE")
    private LocalDate productiondate;
    @Column(name = "NUMBEROFDAYSOFFSET")
    private int numberofdaysoffset;
    @Column(name = "NUMBEROFDAYSDISPATCH")
    private int numberofdaysdispatch;

    public Hup_Productiondate(LocalDate productiondate, int numberofdaysoffset, int numberofdaysdispatch) {
        this.numberofdaysdispatch = numberofdaysdispatch;
        this.numberofdaysoffset = numberofdaysoffset;
        this.productiondate = productiondate;
    }

    public LocalDate getProductiondate() {
        return productiondate;
    }

    public void setProductiondate(LocalDate productiondate) {
        this.productiondate = productiondate;
    }

    public int getNumberofdaysoffset() {
        return numberofdaysoffset;
    }

    public void setNumberofdaysoffset(int numberofdaysoffset) {
        this.numberofdaysoffset = numberofdaysoffset;
    }

    public int getNumberofdaysdispatch() {
        return numberofdaysdispatch;
    }

    public void setNumberofdaysdispatch(int numberofdaysdispatch) {
        this.numberofdaysdispatch = numberofdaysdispatch;
    }
}
