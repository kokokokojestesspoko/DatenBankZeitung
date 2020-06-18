package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.Tabelle.Hup_Productiondate;
import com.hup.DatenBankZeitung.Repository.Hup_ProductiondateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HupProductiondateService {
    @Autowired
    Hup_ProductiondateRepository hup_productiondateRepository;

    List<Hup_Productiondate> findProductiondate(LocalDate productiondate)
    {
        return hup_productiondateRepository.findByProductiondate(productiondate);
    }

    public LocalDate loadDtToday(LocalDate productiondate)
    {   LocalDate date = null;
        for(Hup_Productiondate hup_productiondate : hup_productiondateRepository.findByProductiondate(productiondate))
        {
        date = hup_productiondate.getProductiondate();
        }
        if(date != null)
            return date;
        else
            return null;
    }
}
