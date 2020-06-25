package com.hup.DatenBankZeitung.Model.Service;

import com.hup.DatenBankZeitung.Model.Tabelle.Dis_PublicationCalendar;
import com.hup.DatenBankZeitung.Repository.Dis_PublicationCalendarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Dis_PublicationCalendarService {



    Dis_PublicationCalendarRepository dis_publicationCalendarRepository;
    @Autowired
    public Dis_PublicationCalendarService(Dis_PublicationCalendarRepository dis_publicationCalendarRepository) {
    }

    public List<Dis_PublicationCalendar> findMinDate(String productcode, String variantcode, LocalDate dtResult)
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
    public LocalDate loaddtResult(String productcode, String variantcode,LocalDate publicationdate)
    {
        LocalDate date = null;
        for(Dis_PublicationCalendar dis_publicationCalendar: dis_publicationCalendarRepository.findMinPublicationDateBiggerThanPublicationdate(productcode,variantcode,publicationdate))
        {
            date = dis_publicationCalendar.getPublicationdate();
        }
        return date;
    }
    public LocalDate dtResultCheckifnotnull(String productcode, String variantcode,LocalDate publicationdate)
    {   LocalDate date;
        if(loaddtResult(productcode,variantcode,publicationdate) != null)
        {
            date = loaddtResult(productcode,variantcode,publicationdate);
            return date;
        }
        else
            date = LocalDate.of(1990,01,01);
            return date;
    }

    public LocalDate loadMinDate(String productcode, String variantcode,LocalDate dtResult)
    {
        LocalDate date = null;
        for(Dis_PublicationCalendar dis_publicationCalendar: dis_publicationCalendarRepository.findMinPublicationDate(productcode,variantcode,dtResult))
        {
            date = dis_publicationCalendar.getPublicationdate();
        }
       return date;
    }



    //LOAD MIN DATE and Set it up.
}
