package com.hup.DatenBankZeitung.Repository;

import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_Duedatetemplate2product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface Hupx_Duedatetemplate2productRepository extends JpaRepository<Hupx_Duedatetemplate2product, Integer> {


    @Query(value = "select max(b.offsetkey),max(b.offsetvalue),max(b.referencekey),max(b.weekdaykey),max(b.referencevalue)" +
            " from Hupx_Duedatetemplate2product a, Hupx_Duedatetemplate2code b where a.productcode = ?1 AND b.duedatetemplatecode = a.duedatetemplatecode " +
            "AND b.systemcode = ?2 and b.duedatecode = ?3 and b.companyclientno = ?4 and ?5 between a.startdate and a.enddate and ?5 between b.startdate and b.enddate ")
    List<Hupx_Duedatetemplate2product> findValuesBeetwenDates(String productcode, String systemcode, String duedatecode, int companyclientno, LocalDate dtToday);
}
