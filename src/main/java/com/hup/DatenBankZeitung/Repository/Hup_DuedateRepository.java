package com.hup.DatenBankZeitung.Repository;

import com.hup.DatenBankZeitung.Model.Tabelle.Hup_Duedate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface Hup_DuedateRepository extends JpaRepository<Hup_Duedate, Integer> {

    //-- 1. gibt es zu dem refdatum bereits ein Eintrag in der hup_duedate ?
    //    -- das darf auch dann sein, wenn wir nix mit EVT oder folgeEVT was zu tun haben, also ohne kalender.

 @Query(value = "    SELECT MAX( duedatetime ) FROM Hup_Duedate WHERE publicationdate = ?1 AND productcode = ?2 " +
         "AND  variantcode = ?3 AND duedatecode = ?4 AND systemcode = ?4 AND companyclientno = -1 or ?5")
    List<Hup_Duedate> findDuedatetime(LocalDate publicationdate, String productcode, String variancode, String duedatecode, String systemcode, int ncompanyclientno);
}
