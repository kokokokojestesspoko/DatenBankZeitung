package com.hup.DatenBankZeitung.Model.Tabelle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "HUPX_CALENDAR")
public class Hupx_Calendar {

    public Hupx_Calendar() {
    }

    @Id
    @Column(name = "CALENDARDATE")
    private LocalDate calendardate;
    @Column(name = "RECNO")
    private int recno;
    @Column(name = "CALENDARYEAR")
    private int calendaryear;
    @Column(name = "CALENDARWEEKDAY")
    private int calendarweekday;
    @Column(name = "CALENDARDAY")
    private int calendarday;
    @Column(name = "CALENDARWEEK")
    private int calendarweek;
    @Column(name = "ISHOLIDAYFLAG")
    private int isholidayflag;
    @Column(name = "DESCRIPTION")
    private String description;

    public Hupx_Calendar(LocalDate calendardate, int recno, int calendaryear, int calendarweekday, int calendarday,
                         int calendarweek, int isholidayflag, String description) {
        this.calendardate = calendardate;
        this.recno = recno;
        this.calendaryear = calendaryear;
        this.calendarweekday = calendarweekday;
        this.calendarday = calendarday;
        this.calendarweek = calendarweek;
        this.isholidayflag = isholidayflag;
        this.description = description;
    }

    public LocalDate getCalendardate() {
        return calendardate;
    }

    public void setCalendardate(LocalDate calendardate) {
        this.calendardate = calendardate;
    }

    public int getRecno() {
        return recno;
    }

    public void setRecno(int recno) {
        this.recno = recno;
    }

    public int getCalendaryear() {
        return calendaryear;
    }

    public void setCalendaryear(int calendaryear) {
        this.calendaryear = calendaryear;
    }

    public int getCalendarweekday() {
        return calendarweekday;
    }

    public void setCalendarweekday(int calendarweekday) {
        this.calendarweekday = calendarweekday;
    }

    public int getCalendarday() {
        return calendarday;
    }

    public void setCalendarday(int calendarday) {
        this.calendarday = calendarday;
    }

    public int getCalendarweek() {
        return calendarweek;
    }

    public void setCalendarweek(int calendarweek) {
        this.calendarweek = calendarweek;
    }

    public int getIsholidayflag() {
        return isholidayflag;
    }

    public void setIsholidayflag(int isholidayflag) {
        this.isholidayflag = isholidayflag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Hupx_Calendar{" +
                "calendardate=" + calendardate +
                ", recno=" + recno +
                ", calendaryear=" + calendaryear +
                ", calendarweekday=" + calendarweekday +
                ", calendarday=" + calendarday +
                ", calendarweek=" + calendarweek +
                ", isholidayflag=" + isholidayflag +
                ", description='" + description + '\'' +
                '}';
    }
}
