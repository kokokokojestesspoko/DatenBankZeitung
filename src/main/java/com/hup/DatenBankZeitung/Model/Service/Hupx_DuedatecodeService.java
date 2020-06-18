package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_Duedatecode;
import com.hup.DatenBankZeitung.Repository.Hupx_DuedatecodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Hupx_DuedatecodeService {
    @Autowired
    Hupx_DuedatecodeRepository hupx_duedatecodeRepository;

    List<Hupx_Duedatecode> findDeafultTime(int systemcode, String duedatecode, LocalDate today)
    {
        return hupx_duedatecodeRepository.findByDeafultTime(systemcode, duedatecode, today);
    }
}
