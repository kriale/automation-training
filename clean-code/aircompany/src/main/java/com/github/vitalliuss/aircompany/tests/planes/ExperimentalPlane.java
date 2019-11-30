package com.github.vitalliuss.aircompany.tests.planes;

import com.github.vitalliuss.aircompany.tests.models.PrivacyLevel;
import com.github.vitalliuss.aircompany.tests.models.ExperimentalType;

public class ExperimentalPlane extends Plane{

    private ExperimentalType type;
    private PrivacyLevel privacyLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalType type, PrivacyLevel privacyLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.privacyLevel = privacyLevel;
    }

    public PrivacyLevel getPrivacyLevel(){
        return privacyLevel;
    }

    public void setPrivacyLevel(PrivacyLevel privacyLevel){
        this.privacyLevel = privacyLevel;
    }

    public ExperimentalType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
