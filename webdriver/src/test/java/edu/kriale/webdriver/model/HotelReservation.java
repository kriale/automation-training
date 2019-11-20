package edu.kriale.webdriver.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class HotelReservation {
    private String goingTo;
    private ReservationDates reservationDates;
    private List<HotelReservationRoom> hotelReservationRooms = new ArrayList<>();


    public HotelReservation(String goingTo,
                            ReservationDates reservationDates,
                            List<HotelReservationRoom> hotelReservationRooms) {
        this.goingTo = goingTo;
        this.reservationDates = reservationDates;
        this.hotelReservationRooms = hotelReservationRooms;
    }

    public HotelReservation() {
    }

    public Optional<String> getGoingTo() {
        return Optional.ofNullable(goingTo);
    }

    public HotelReservation setGoingTo(String goingTo) {
        this.goingTo = goingTo;
        return this;
    }

    public Optional<ReservationDates> getReservationDates() {
        return Optional.ofNullable(reservationDates);
    }

    public HotelReservation setReservationDates(ReservationDates reservationDates) {
        this.reservationDates = reservationDates;
        return this;
    }

    public List<HotelReservationRoom> getHotelReservationRooms() {
        return hotelReservationRooms;
    }

    public HotelReservation setHotelReservationRooms(List<HotelReservationRoom> hotelReservationRooms) {
        this.hotelReservationRooms = hotelReservationRooms;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelReservation that = (HotelReservation) o;
        return Objects.equals(goingTo, that.goingTo) &&
                Objects.equals(reservationDates, that.reservationDates) &&
                Objects.equals(hotelReservationRooms, that.hotelReservationRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goingTo, reservationDates, hotelReservationRooms);
    }

    @Override
    public String toString() {
        return "HotelReservation{" +
                "goingTo='" + goingTo + '\'' +
                ", reservationDates=" + reservationDates +
                ", hotelReservationRooms=" + hotelReservationRooms +
                '}';
    }
}
