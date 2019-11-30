package edu.kriale.webdriver.service;

import edu.kriale.webdriver.model.HotelReservation;
import edu.kriale.webdriver.model.ReservationDates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelReservationCreator {
    private static final String TEST_DATA_CASE3_GOING_TO = "test-data.case3.going-to";
    private static final String TEST_DATA_CASE3_CHECK_IN_PLUS_DAYS = "test-data.case3.check-in.plus-days";
    private static final String TEST_DATA_CASE3_CHECK_OUT_PLUS_DAYS = "test-data.case3.check-out.plus-days";

    private static final String TEST_DATA_CASE4_GOING_TO = "test-data.case4.going-to";
    private static final String TEST_DATA_CASE4_CHECK_IN_PLUS_DAYS = "test-data.case4.check-in.plus-days";
    private static final String TEST_DATA_CASE4_CHECK_OUT_PLUS_DAYS = "test-data.case4.check-out.plus-days";

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static HotelReservation withLessThanOneDayStayingFromProperty() {
        LocalDate nowDate = LocalDate.now();
        return (new HotelReservation())
                .setGoingTo(TestDataReader.getTestData(TEST_DATA_CASE3_GOING_TO))
                .setReservationDates(new ReservationDates(
                        getDateStringWithPlusDays(nowDate, TEST_DATA_CASE3_CHECK_IN_PLUS_DAYS),
                        getDateStringWithPlusDays(nowDate, TEST_DATA_CASE3_CHECK_OUT_PLUS_DAYS)));
    }

    public static HotelReservation withSimpleCredentialsFromProperty(){
        LocalDate nowDate = LocalDate.now();
        return (new HotelReservation())
                .setGoingTo(TestDataReader.getTestData(TEST_DATA_CASE4_GOING_TO))
                .setReservationDates(new ReservationDates(
                        getDateStringWithPlusDays(nowDate, TEST_DATA_CASE4_CHECK_IN_PLUS_DAYS),
                        getDateStringWithPlusDays(nowDate, TEST_DATA_CASE4_CHECK_OUT_PLUS_DAYS)))
                .setHotelReservationRooms(HotelReservationRoomCreator.getOneRoomWithWithoutChildren());
    }


    private static LocalDate getDateWithPlusDays(LocalDate date, String plusDaysParamName) {
        return date.plusDays(Integer.parseInt(TestDataReader
                .getTestData(plusDaysParamName)));
    }

    private static String getDateString(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    private static String getDateStringWithPlusDays(LocalDate date, String plusDaysParamName) {
        return getDateString(getDateWithPlusDays(date, plusDaysParamName));
    }
}
