package com.etu.lab.amsensors.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Amsensor {
    private int id;
    private String modelName;
    private double detectionAngle;
    private double detectionDistance;
    private double sirenSoundPressure;
    private int price;
}
