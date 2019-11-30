package com.github.vitalliuss.aircompany.utils;

import com.github.vitalliuss.aircompany.tests.models.MilitaryType;
import com.github.vitalliuss.aircompany.tests.models.PrivacyLevel;
import com.github.vitalliuss.aircompany.tests.planes.ExperimentalPlane;
import com.github.vitalliuss.aircompany.tests.planes.MilitaryPlane;
import com.github.vitalliuss.aircompany.tests.planes.Plane;

import java.util.List;

public class AirportUtils {
    public static boolean areOnlyTransportMilitaryPlanes(List<MilitaryPlane> planes) {
        return planes.stream().allMatch(plane -> plane.getType().equals(MilitaryType.TRANSPORT));
    }

    public static boolean isSortedPlaneListByMaxLoadCapacity(List<? extends Plane> planes) {
        Plane nextPlane = planes.get(0);
        for (int i = 0; i < planes.size() - 1; i++) {
            Plane currentPlane = nextPlane;
            nextPlane = planes.get(i + 1);
            if (currentPlane.getMinLoadCapacity() > nextPlane.getMinLoadCapacity()) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasAtLeastOnePlaneOfSuchMilitaryPlaneType(List<MilitaryPlane> planes, MilitaryType type) {
        return planes.stream().anyMatch(plane -> plane.getType().equals(type));
    }

    public static boolean hasAtLeastOnePlaneOfSuchPrivacyLevel(List<ExperimentalPlane> planes, PrivacyLevel level) {
        return planes.stream().anyMatch(plane -> plane.getPrivacyLevel().equals(level));
    }
}
