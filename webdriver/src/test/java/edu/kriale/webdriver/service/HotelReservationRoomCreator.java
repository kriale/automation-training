package edu.kriale.webdriver.service;

import edu.kriale.webdriver.model.HotelReservationRoom;

import java.util.ArrayList;
import java.util.List;

public class HotelReservationRoomCreator {
    private static final String TEST_DATE_CASE4_ADULTS = "test-data.case4.adults";

    private static final String TEST_DATE_CASE7_ADULTS = "test-data.case7.adults";
    private static final String TEST_DATE_CASE7_CHILDREN = "test-data.case7.children";

    private static final String TEST_DATE_CASE9_ADULTS = "test-data.case9.adults";


    public static List<HotelReservationRoom> getOneRoomWithWithoutChildren() {
        List<HotelReservationRoom> rooms = new ArrayList<>();
        rooms.add(getRoomWithWithoutChildren());
        return rooms;
    }

    public static List<HotelReservationRoom> getOneRoomWithChildren() {
        List<HotelReservationRoom> rooms = new ArrayList<>();
        rooms.add(getRoomWithChildren());
        return rooms;
    }

    public static List<HotelReservationRoom> getOneRoomWithLargeNumberOfPassengers() {
        List<HotelReservationRoom> rooms = new ArrayList<>();
        rooms.add(getRoomWithLargeNumberOfPassengers());
        return rooms;
    }

    private static HotelReservationRoom getRoomWithWithoutChildren() {
        return (new HotelReservationRoom())
                .setAdultsNumber(Integer.parseInt(TestDataReader
                        .getTestData(TEST_DATE_CASE4_ADULTS)));
    }

    private static HotelReservationRoom getRoomWithChildren() {
        return (new HotelReservationRoom())
                .setAdultsNumber(Integer.parseInt(TestDataReader
                        .getTestData(TEST_DATE_CASE7_ADULTS)))
                .setChildrenNumber(Integer.parseInt(TestDataReader
                        .getTestData(TEST_DATE_CASE7_CHILDREN)));
    }

    private static HotelReservationRoom getRoomWithLargeNumberOfPassengers() {
        return (new HotelReservationRoom())
                .setAdultsNumber(Integer.parseInt(TestDataReader
                        .getTestData(TEST_DATE_CASE9_ADULTS)));
    }
}
