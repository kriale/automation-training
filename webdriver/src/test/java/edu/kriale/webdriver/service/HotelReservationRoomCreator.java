package edu.kriale.webdriver.service;

import edu.kriale.webdriver.model.HotelReservationRoom;

import java.util.ArrayList;
import java.util.List;

public class HotelReservationRoomCreator {
    private static final String TEST_DATE_CASE4_ADULTS = "test-data.case4.adults";

    public static List<HotelReservationRoom> getOneRoomWithWithoutChildren() {
        List<HotelReservationRoom> rooms = new ArrayList<>();
        rooms.add(getRoomWithWithoutChildren());
        return rooms;
    }

    public static HotelReservationRoom getRoomWithWithoutChildren() {
        return (new HotelReservationRoom())
                .setAdultsNumber(Integer.parseInt(TestDataReader
                        .getTestData(TEST_DATE_CASE4_ADULTS)));
    }
}
