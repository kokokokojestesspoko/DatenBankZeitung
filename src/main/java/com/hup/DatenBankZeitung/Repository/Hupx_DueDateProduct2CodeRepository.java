package com.hup.DatenBankZeitung.Repository;

import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_DueDateProduct2Code;
import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_Duedatetemplate2product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface Hupx_DueDateProduct2CodeRepository extends JpaRepository<Hupx_DueDateProduct2Code, Integer> {

    @Query(value = "      SELECT  MAX( offsetkey ), MAX( offsetvalue )," +
            "        MAX( referencekey ), MAX( weekdaykey ), MAX( referencevalue )" +
            "      FROM Hupx_DueDateProduct2Code WHERE productcode = ?1 AND" +
            "        systemcode = ?2 AND duedatecode = ?3 AND companyclientno IN ( -1, ?4 ) AND " +
            "        ?5 BETWEEN startdate AND enddate")
    List<Hupx_DueDateProduct2Code> findKeysByCodes(String productcode, String systemcode, String duedatecode, int nCompanyClientNo, LocalDate dtToday);

    @Query(value = "select max(b.offsetkey),max(b.offsetvalue),max(b.referencekey),max(b.weekdaykey),max(b.referencevalue)" +
            " from Hupx_Duedatetemplate2product a, Hupx_Duedatetemplate2code b where a.productcode = ?1 AND b.duedatetemplatecode = a.duedatetemplatecode " +
            "AND b.systemcode = ?2 and b.duedatecode = ?3 and b.companyclientno = ?4 and ?5 between a.startdate and a.enddate and ?5 between b.startdate and b.enddate ")
    List<Hupx_DueDateProduct2Code> findValuesBeetwenDates(String productcode, String systemcode, String duedatecode, int companyclientno, LocalDate dtToday);
}

