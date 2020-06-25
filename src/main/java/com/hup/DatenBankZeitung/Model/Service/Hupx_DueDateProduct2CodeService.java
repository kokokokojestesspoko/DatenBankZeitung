package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_DueDateProduct2Code;
import com.hup.DatenBankZeitung.Repository.Hupx_DueDateProduct2CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Hupx_DueDateProduct2CodeService {
    @Autowired
    Hupx_DueDateProduct2CodeRepository hupx_dueDateProduct2CodeRepository;
    public List<Hupx_DueDateProduct2Code> findAllKeysByCodes(String productcode, String systemcode, String duedatecode, int nCompanyClientNo, LocalDate dtToday)
    {
        return hupx_dueDateProduct2CodeRepository.findKeysByCodes( productcode, systemcode, duedatecode,  nCompanyClientNo,  dtToday);
    }
    public int loadOffsetKey(String productcode, String systemcode, String duedatecode, int nCompanyClientNo, LocalDate dtToday)
    {  int offsetKey = 0;
        for(Hupx_DueDateProduct2Code hupx_dueDateProduct2Code: hupx_dueDateProduct2CodeRepository.findKeysByCodes(productcode,systemcode,duedatecode,nCompanyClientNo,dtToday))
        {
            offsetKey = hupx_dueDateProduct2Code.getOffsetkey();
        }
        return offsetKey;
    }
    public int loadoffsetValue(String productcode, String systemcode, String duedatecode, int nCompanyClientNo, LocalDate dtToday)
    {  int offsetValue = 0;
        for(Hupx_DueDateProduct2Code hupx_dueDateProduct2Code: hupx_dueDateProduct2CodeRepository.findKeysByCodes(productcode,systemcode,duedatecode,nCompanyClientNo,dtToday))
        {
            offsetValue = hupx_dueDateProduct2Code.getOffsetvalue();
        }
        return offsetValue;
    }
    public int loadReferenceKey(String productcode, String systemcode, String duedatecode, int nCompanyClientNo, LocalDate dtToday)
    {  int referenceKey = 0;
        for(Hupx_DueDateProduct2Code hupx_dueDateProduct2Code: hupx_dueDateProduct2CodeRepository.findKeysByCodes(productcode,systemcode,duedatecode,nCompanyClientNo,dtToday))
        {
            referenceKey = hupx_dueDateProduct2Code.getReferencekey();
        }
        return referenceKey;
    }
    public int loadWeekdayKey(String productcode, String systemcode, String duedatecode, int nCompanyClientNo, LocalDate dtToday)
    {  int weekdayKey = 0;
        for(Hupx_DueDateProduct2Code hupx_dueDateProduct2Code: hupx_dueDateProduct2CodeRepository.findKeysByCodes(productcode,systemcode,duedatecode,nCompanyClientNo,dtToday))
        {
            weekdayKey = hupx_dueDateProduct2Code.getWeekdaykey();
        }
        return  weekdayKey;
    }
    public String loadreferenceValue(String productcode, String systemcode, String duedatecode, int nCompanyClientNo, LocalDate dtToday)
    {  String referenceValue = null;

        for(Hupx_DueDateProduct2Code hupx_dueDateProduct2Code: hupx_dueDateProduct2CodeRepository.findKeysByCodes(productcode,systemcode,duedatecode,nCompanyClientNo,dtToday))
        {
            referenceValue = hupx_dueDateProduct2Code.getReferencevalue();

        }
        return  referenceValue;
    }
    public int counterFromKeys(String productcode, String systemcode, String duedatecode, int nCompanyClientNo, LocalDate dtToday)
    {
        List<Hupx_DueDateProduct2Code> list = new ArrayList<>();
        list = hupx_dueDateProduct2CodeRepository.findKeysByCodes(productcode,systemcode,duedatecode,nCompanyClientNo,dtToday);
        int counter = list.size();
        return counter;
    }
}

