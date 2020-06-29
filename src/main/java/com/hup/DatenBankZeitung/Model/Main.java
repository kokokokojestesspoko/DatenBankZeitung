package com.hup.DatenBankZeitung.Model;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
@SpringBootApplication
public class Main {

   public static void main(String[] args) {
         DueDateCode dueDateCodeClass;
         String productCode = "test Product Code";
         String systemCode = "test System Code";
        int companyClientNoIn = 45;
        LocalDate startDate = LocalDate.of(2005, 01, 01);
         String variantCode = " test variant code";
      String dueDateCode = " test duedatecode";


        dueDateCodeClass = new DueDateCode(productCode, systemCode, companyClientNoIn, startDate, variantCode, dueDateCode);
            LocalDate endDate = dueDateCodeClass.logik();
            System.out.println(endDate);

    }

}