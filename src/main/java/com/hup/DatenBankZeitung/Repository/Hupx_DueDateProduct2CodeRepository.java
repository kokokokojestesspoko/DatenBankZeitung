package com.hup.DatenBankZeitung.Repository;

import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_DueDateProduct2Code;
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
    //COUNT
}
