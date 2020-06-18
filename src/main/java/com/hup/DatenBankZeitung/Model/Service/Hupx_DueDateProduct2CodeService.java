package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_DueDateProduct2Code;
import com.hup.DatenBankZeitung.Repository.Hupx_DueDateProduct2CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Hupx_DueDateProduct2CodeService {
    @Autowired
    Hupx_DueDateProduct2CodeRepository hupx_dueDateProduct2CodeRepository;
    List<Hupx_DueDateProduct2Code> findAllKeysByCodes(String productcode, String systemcode, String duedatecode, int nCompanyClientNo, LocalDate dtToday)
    {
        return hupx_dueDateProduct2CodeRepository.findKeysByCodes( productcode, systemcode, duedatecode,  nCompanyClientNo,  dtToday);
    }

}
