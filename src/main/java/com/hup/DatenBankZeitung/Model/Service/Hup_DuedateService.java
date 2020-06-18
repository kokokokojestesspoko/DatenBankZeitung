package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.Tabelle.Hup_Duedate;
import com.hup.DatenBankZeitung.Repository.Hup_DuedateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Hup_DuedateService {
    @Autowired
    Hup_DuedateRepository hup_duedateRepository;

    List<Hup_Duedate> findDuedatetime(LocalDate publicationdate, String productcode, String variancode, String duedatecode, String systemcode, int ncompanyclientno)
    {
        return hup_duedateRepository.findDuedatetime(publicationdate, productcode, variancode, duedatecode,  systemcode,  ncompanyclientno);

    }

}
