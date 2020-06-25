package com.hup.DatenBankZeitung.Repository;

import com.hup.DatenBankZeitung.Model.Tabelle.Dis_PublicationCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface Dis_PublicationCalendarRepository extends JpaRepository<Dis_PublicationCalendar, Integer> {





    @Query(value = "      SELECT  MIN( publicationdate )  FROM Dis_PublicationCalendar" +
            "      WHERE deliverypartnerno = 0 AND productcode = ?1 AND" +
            "        variantcode = ?2 AND publicationdate >= ?3 ")
    List<Dis_PublicationCalendar> findMinPublicationDate(String productcode, String variantcode,LocalDate dtResult);

    // Need to crate controler for NVL( MIN( PUBLICATIONDATE ), dtMinDate )

    @Query(value = "SELECT publicationdate from Dis_PublicationCalendar where deliverypartnerno = 0 and productcode" +
                    " =?1 and variantcode = ?2 and publicationdate < ?3 order by publicationdate desc")
    List<Dis_PublicationCalendar> findPublicationdateLessThanResult( String productcode, String variantcode, LocalDate dtResult);


    @Query(value = "SELECT publicationdate from Dis_PublicationCalendar where deliverypartnerno = 0 and productcode" +
            " =?1 and variantcode = ?2 and publicationdate > ?3 order by publicationdate asc")
    List<Dis_PublicationCalendar> findPublicationdateMoreThanResult( String productcode, String variantcode, LocalDate dtResult);

    @Query(value = "      SELECT  MIN( publicationdate )  FROM Dis_PublicationCalendar" +
            "      WHERE deliverypartnerno = 0 AND productcode = ?1 AND" +
            "        variantcode = ?2 AND publicationdate >= ?3 ")
    List<Dis_PublicationCalendar> findMinPublicationDateBiggerThanPublicationdate(String productcode, String variantcode,LocalDate publicationdate);
}
