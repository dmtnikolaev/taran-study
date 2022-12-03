package com.etu.lab.amsensors.model;

import org.springframework.hateoas.RepresentationModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "amsensors")
public class Amsensor extends RepresentationModel<Amsensor> implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Column(name = "detection_angle", nullable = false)
    private double detectionAngle;

    @Column(name = "detection_distance", nullable = false)
    private double detectionDistance;

    @Column(name = "siren_sound_pressure", nullable = false)
    private double sirenSoundPressure;

    @Column(name = "price", nullable = false)
    private int price;

    private String comment;

    public Amsensor withComment(String comment) {
        this.setComment(comment);
        return this;
    }
}
