package com.hup.DatenBankZeitung.Repository;

import com.hup.DatenBankZeitung.Model.Tabelle.Hupx_Duedatecode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface Hupx_DuedatecodeRepository extends JpaRepository<Hupx_Duedatecode, Integer> {


    //*
    // SELECT /*+ RULE */ COUNT( * ), MAX( DEFAULTTIME ) INTO nCount, nDefaultTime FROM sysadm.HUPX_DUEDATECODE
    //  WHERE SYSTEMCODE = strSystemCode AND DUEDATECODE = strDueDateCode AND dtToday BETWEEN STARTDATE AND ENDDATE;*//

    @Query(value = "SELECT MAX( defaulttime ) FROM Hupx_Duedatecode" +
            "  WHERE systemcode = ?1 AND duedatecode = ?2 AND  ?3 BETWEEN startdate AND enddate")                       //removed count
    List<Hupx_Duedatecode> findByDeafultTime(String systemcode, String duedatecode, LocalDate today);
//COUNT

}
