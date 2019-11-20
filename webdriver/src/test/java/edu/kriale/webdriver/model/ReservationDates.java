package edu.kriale.webdriver.model;

import java.util.Objects;
import java.util.Optional;

public class ReservationDates {
    private String checkInDate;
    private String checkOutDate;


    public ReservationDates(String checkInDate, String checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public ReservationDates() {
    }

    public Optional<String> getCheckInDate() {
        return Optional.ofNullable(checkInDate);
    }

    public ReservationDates setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
        return this;
    }

    public Optional<String> getCheckOutDate() {
        return Optional.ofNullable(checkOutDate);
    }

    public ReservationDates setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDates that = (ReservationDates) o;
        return Objects.equals(checkInDate, that.checkInDate) &&
                Objects.equals(checkOutDate, that.checkOutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkInDate, checkOutDate);
    }

    @Override
    public String toString() {
        return "ReservationDates{" +
                "checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                '}';
    }
}
