package edu.kriale.webdriver.model;

import java.util.Objects;

public class HotelReservationRoom {
    private int adultsNumber;
    private int childrenNumber;


    public HotelReservationRoom(int adultsNumber, int childrenNumber) {
        this.adultsNumber = adultsNumber;
        this.childrenNumber = childrenNumber;
    }

    public int getAdultsNumber() {
        return adultsNumber;
    }

    public void setAdultsNumber(int adultsNumber) {
        this.adultsNumber = adultsNumber;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelReservationRoom that = (HotelReservationRoom) o;
        return adultsNumber == that.adultsNumber &&
                childrenNumber == that.childrenNumber;
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
