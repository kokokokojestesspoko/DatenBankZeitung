package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_DueDateProduct2Code;
import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_Duedatetemplate2product;
import com.hup.DatenBankZeitung.Repository.Hupx_Duedatetemplate2productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Hupx_Duedatetemplate2productService {
    @Autowired
    Hupx_Duedatetemplate2productRepository hupx_duedatetemplate2productRepository;

    List<Hupx_Duedatetemplate2product> findAllValuesBeetwenDates(String productcode, String systemcode, String duedatecode, int companyclientno, LocalDate dtToday)
    {
        return hupx_duedatetemplate2productRepository.findValuesBeetwenDates( productcode, systemcode,  duedatecode, companyclientno,dtToday);
    }
    public int loadOffsetkey(String productcode, String systemcode, String duedatecode, int nCompanyClientNo, LocalDate dtToday)
        {  int offsetkey = 0;
            for(Hupx_Duedatetemplate2product hupx_duedatetemplate2product : hupx_duedatetemplate2productRepository.findValuesBeetwenDates(productcode,systemcode,duedatecode,nCompanyClientNo,dtToday))
            {
                offsetkey = hupx_duedatetemplate2product.get();
            }
            return  offsetkey;
    }
}
