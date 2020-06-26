package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.Tabelle.Hup_Productiondate;
import com.hup.DatenBankZeitung.Repository.Hup_ProductiondateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class HupProductiondateService {
    @Autowired
    Hup_ProductiondateRepository hup_productiondateRepository;

    public LocalDate loadProductiondate() {
        return LocalDate.now();
    }

    public LocalDate loadDtToday(LocalDate loadProductiondate) {
        LocalDate date = null;
        for (Hup_Productiondate hup_productiondate : hup_productiondateRepository.findByProductiondate(loadProductiondate)) {
            date = hup_productiondate.getProductiondate();
        }
        if (date != null)
            return date;
        else
            return null;
    }
}
