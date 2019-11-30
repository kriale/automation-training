package com.github.vitalliuss.aircompany.tests;

import com.github.vitalliuss.aircompany.tests.planes.ExperimentalPlane;
import com.github.vitalliuss.aircompany.tests.models.MilitaryType;
import com.github.vitalliuss.aircompany.tests.planes.MilitaryPlane;
import com.github.vitalliuss.aircompany.tests.planes.PassengerPlane;
import com.github.vitalliuss.aircompany.tests.planes.Plane;

import java.util.*;
import java.util.stream.Collectors;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {

    private List<? extends Plane> planes;


    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }


    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream()
                .filter(PassengerPlane.class::isInstance)
                .map(PassengerPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream()
                .filter(MilitaryPlane.class::isInstance)
                .map(MilitaryPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream()
                .filter(ExperimentalPlane.class::isInstance)
                .map(ExperimentalPlane.class::cast)
                .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return Collections.max(getPassengerPlanes(),
                Comparator.comparingInt(PassengerPlane::getPassengersCapacity));
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanesOfSpecificType(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanesOfSpecificType(MilitaryType.BOMBER);
    }

    private List<MilitaryPlane> getMilitaryPlanesOfSpecificType(MilitaryType type) {
        return getMilitaryPlanes().stream()
                .filter(plane -> plane.getType().equals(type))
                .collect(Collectors.toList());
    }

    public Airport sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }


    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMinLoadCapacity));
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        collection.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "planes=" + planes.toString() +
                '}';
    }
}
