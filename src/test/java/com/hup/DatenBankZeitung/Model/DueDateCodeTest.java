package com.hup.DatenBankZeitung.Model;
import static org.mockito.BDDMockito.given;

import com.hup.DatenBankZeitung.Model.Service.Dis_PublicationCalendarService;
import com.hup.DatenBankZeitung.Model.Tabelle.Dis_PublicationCalendar;
import com.hup.DatenBankZeitung.Repository.Dis_PublicationCalendarRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DueDateCodeTest {

    private Dis_PublicationCalendarService service;
    private DueDateCode dueDateCode;

@BeforeEach
    public void setUp()
    {
        service = Mockito.mock(Dis_PublicationCalendarService.class);
    }
            @Test
            void validation() {
                LocalDate date = LocalDate.of(1995,01,01);
                dueDateCode = new DueDateCode();
                Dis_PublicationCalendar dis_publicationCalendar = new Dis_PublicationCalendar();
                dis_publicationCalendar.setPublicationdate(date);
               List<Dis_PublicationCalendar> dis_publicationCalendars =  new ArrayList();
               dis_publicationCalendars.add(dis_publicationCalendar);
                System.out.println(dis_publicationCalendars.size());
                System.out.println(service==null?"ja":"nein");
                Mockito.when(service.findMinDate(Mockito.anyString(),Mockito.anyString(),Mockito.any(LocalDate.class))).thenReturn(dis_publicationCalendars);
              //  given(service.findMinDate("ABC","DEF",date)).willReturn(dis_publicationCalendars);
                assertThat(dueDateCode.validation(service)).isEqualTo(date);
            }



    @Test
    void loadCalculations() {
    }
}