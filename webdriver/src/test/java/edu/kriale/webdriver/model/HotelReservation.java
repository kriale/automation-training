package edu.kriale.webdriver.model;

import java.util.Objects;

public class HotelReservation {
    private String goingTo;
    private ReservationDates reservationDates;
    private HotelReservationRoom hotelReservationRoom;


    public HotelReservation(String goingTo,
                            ReservationDates reservationDates,
                            HotelReservationRoom hotelReservationRoom) {
        this.goingTo = goingTo;
        this.reservationDates = reservationDates;
        this.hotelReservationRoom = hotelReservationRoom;
    }

    public String getGoingTo() {
        return goingTo;
    }

    public void setGoingTo(String goingTo) {
        this.goingTo = goingTo;
    }

    public ReservationDates getReservationDates() {
        return reservationDates;
    }

    public void setReservationDates(ReservationDates reservationDates) {
        this.reservationDates = reservationDates;
    }

    public HotelReservationRoom getHotelReservationRoom() {
        return hotelReservationRoom;
    }

    public void setHotelReservationRoom(HotelReservationRoom hotelReservationRoom) {
        this.hotelReservationRoom = hotelReservationRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelReservation that = (HotelReservation) o;
        return Objects.equals(goingTo, that.goingTo) &&
                Objects.equals(reservationDates, that.reservationDates) &&
                Objects.equals(hotelReservationRoom, that.hotelReservationRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goingTo, reservationDates, hotelReservationRoom);
    }

    @Override
    public String toString() {
        return "HotelReservation{" +
                "goingTo='" + goingTo + '\'' +
                ", reservationDates=" + reservationDates +
                ", hotelReservationRoom=" + hotelReservationRoom +
                '}';
    }
}
