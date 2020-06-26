package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_Duedatecode;
import com.hup.DatenBankZeitung.Repository.Hupx_DuedatecodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Hupx_DuedatecodeService {
    @Autowired
    Hupx_DuedatecodeRepository hupx_duedatecodeRepository;

    public int loadDeafultTime(String systemcode, String duedatecode, LocalDate today) {
        int time = 0;
        for (Hupx_Duedatecode hupx_duedatecode : hupx_duedatecodeRepository.findByDeafultTime(systemcode, duedatecode, today)) {
            time = hupx_duedatecode.getDefaulttime();
        }
        return time;
    }

    public int getnCounter(String systemcode, String duedatecode, LocalDate today) {
        List<Hupx_Duedatecode> list = new ArrayList();
        list = hupx_duedatecodeRepository.findByDeafultTime(systemcode, duedatecode, today);
        int count = list.size();
        return count;
    }

    public int getbCalculate(int getnCounter) {
        if (getnCounter == 1)
            return 1;
        else
            return 0;
    }

    public LocalDate setMinDate() {
        return LocalDate.of(1990, 01, 01);
    }
}
