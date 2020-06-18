package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.Overview.Overview;
import com.hup.DatenBankZeitung.Model.Tabelle.Dis_PublicationCalendar;
import com.hup.DatenBankZeitung.Repository.Dis_PublicationCalendarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Dis_PublicationCalendarService {
    @Autowired
    Dis_PublicationCalendarRepository dis_publicationCalendarRepository;

    List<Dis_PublicationCalendar> findMinDate(String productcode, String variantcode, LocalDate dtResult)
    {
        return dis_publicationCalendarRepository.findMinPublicationDate(productcode,variantcode,dtResult);
    }
    List<Dis_PublicationCalendar> publicationdateLessThandtResult( String productcode, String variantcode, LocalDate dtResult)
    {
        return dis_publicationCalendarRepository.findPublicationdateLessThanResult(productcode,variantcode,dtResult);
    }
    List<Dis_PublicationCalendar> publicationdateMoreThandtResult( String productcode, String variantcode, LocalDate dtResult)
    {
        return dis_publicationCalendarRepository.findPublicationdateMoreThanResult(  productcode,variantcode,  dtResult);
    }

    public LocalDate loadMinDate(String productcode, String variantcode,LocalDate dtResult)
    {
        LocalDate date = null;
        for(Dis_PublicationCalendar dis_publicationCalendar: dis_publicationCalendarRepository.findMinPublicationDate(productcode,variantcode,dtResult))
        {
            date = dis_publicationCalendar.getPublicationdate();
        }
        if(date != null)
            return date;
        else
          return  null;

    }



    //LOAD MIN DATE and Set it up.
}