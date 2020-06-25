package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.DueDateCode;
import com.hup.DatenBankZeitung.Model.Tabelle.Hup_Duedate;
import com.hup.DatenBankZeitung.Repository.Hup_DuedateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Hup_DuedateService {
    @Autowired
    Hup_DuedateRepository hup_duedateRepository;

    public LocalDate loadDueDateTime(LocalDate publicationdate, String productcode, String variancode, String duedatecode, String systemcode, int ncompanyclientno)
    {   LocalDate time = null;
        for(Hup_Duedate hup_duedate : hup_duedateRepository.findDuedatetime(publicationdate,productcode,variancode,duedatecode,systemcode,ncompanyclientno))
        {
            time = hup_duedate.getDuedatetime();
        }
        return time;
    }
    public int duedatetimeCounter(LocalDate publicationdate, String productcode, String variancode, String duedatecode, String systemcode, int ncompanyclientno)
    {
        List<Hup_Duedate> list = new ArrayList<>();
        list = hup_duedateRepository.findDuedatetime(publicationdate,productcode,variancode,duedatecode,systemcode,ncompanyclientno);
        int count = list.size();
        return count;

    }

}
