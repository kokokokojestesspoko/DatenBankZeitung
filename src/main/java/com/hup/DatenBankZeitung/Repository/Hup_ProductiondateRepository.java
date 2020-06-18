package com.hup.DatenBankZeitung.Repository;

import com.hup.DatenBankZeitung.Model.Tabelle.Hup_Productiondate;
import org.springframework.data.jpa.repository.JpaRepository;
;
import java.time.LocalDate;
import java.util.List;

public interface Hup_ProductiondateRepository extends JpaRepository<Hup_Productiondate,Integer> {

     List<Hup_Productiondate> findByProductiondate(LocalDate productiondate);
}
