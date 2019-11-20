package edu.kriale.webdriver.model;

import java.util.Objects;
import java.util.Optional;

public class HotelReservationRoom {
    private Integer adultsNumber;
    private Integer childrenNumber;


    public HotelReservationRoom(Integer adultsNumber, Integer childrenNumber) {
        this.adultsNumber = adultsNumber;
        this.childrenNumber = childrenNumber;
    }

    public HotelReservationRoom() {
    }

    public Optional<Integer> getAdultsNumber() {
        return Optional.ofNullable(adultsNumber);
    }

    public HotelReservationRoom setAdultsNumber(Integer adultsNumber) {
        this.adultsNumber = adultsNumber;
        return this;
    }

    public Optional<Integer> getChildrenNumber() {
        return Optional.ofNullable(childrenNumber);
    }

    public HotelReservationRoom setChildrenNumber(Integer childrenNumber) {
        this.childrenNumber = childrenNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelReservationRoom that = (HotelReservationRoom) o;
        return Objects.equals(adultsNumber, that.adultsNumber) &&
                Objects.equals(childrenNumber, that.childrenNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adultsNumber, childrenNumber);
    }

    @Override
    public String toString() {
        return "HotelReservationRoom{" +
                "adultsNumber=" + adultsNumber +
                ", childrenNumber=" + childrenNumber +
                '}';
    }
}
