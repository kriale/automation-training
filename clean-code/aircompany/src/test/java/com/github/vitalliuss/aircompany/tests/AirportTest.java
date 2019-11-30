package com.github.vitalliuss.aircompany.tests;

import com.github.vitalliuss.aircompany.tests.planes.ExperimentalPlane;
import com.github.vitalliuss.aircompany.tests.models.PrivacyLevel;
import com.github.vitalliuss.aircompany.tests.models.ExperimentalType;
import com.github.vitalliuss.aircompany.tests.models.MilitaryType;
import com.github.vitalliuss.aircompany.utils.AirportUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.vitalliuss.aircompany.tests.planes.MilitaryPlane;
import com.github.vitalliuss.aircompany.tests.planes.PassengerPlane;
import com.github.vitalliuss.aircompany.tests.planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static final List<Plane> PLANES = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000,
                    60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300,
                    63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100,
                    70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800,
                    65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800,
                    80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100,
                    30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500,
                    50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000,
                    60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000,
                    80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000,
                    70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000,
                    20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000,
                    10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000,
                    11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000,
                    110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482,
                    500, ExperimentalType.HIGH_ALTITUDE, PrivacyLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560,
                    307, 500,
                    ExperimentalType.VERTICAL_TAKE_OFF_AND_LANDING_TYPE, PrivacyLevel.TOP_SECRET)
    );

    private static final PassengerPlane PLANE_WITH_MAX_PASSENGER_CAPACITY =
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    private Airport airport;


    @BeforeMethod
    public void init() {
        this.airport = new Airport(PLANES);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        Assert.assertTrue(AirportUtils.areOnlyTransportMilitaryPlanes(
                airport.getTransportMilitaryPlanes()));
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Assert.assertEquals(airport.getPassengerPlaneWithMaxPassengersCapacity(),
                PLANE_WITH_MAX_PASSENGER_CAPACITY);
    }

    @Test
    public void testSortPlanesByMaxLoadCapacity() {
        airport.sortByMaxLoadCapacity();
        Assert.assertTrue(AirportUtils.isSortedPlaneListByMaxLoadCapacity(airport.getPlanes()));
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Assert.assertTrue(AirportUtils.hasAtLeastOnePlaneOfSuchMilitaryPlaneType(
                airport.getBomberMilitaryPlanes(), MilitaryType.BOMBER));
    }

    @Test
    public void testHasNotUnclassifiedExperimentalPlanes(){
        Assert.assertFalse(AirportUtils.hasAtLeastOnePlaneOfSuchPrivacyLevel(
                airport.getExperimentalPlanes(), PrivacyLevel.UNCLASSIFIED));
    }
}
