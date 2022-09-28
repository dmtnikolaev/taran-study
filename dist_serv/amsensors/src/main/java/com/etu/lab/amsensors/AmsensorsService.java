package com.etu.lab.amsensors;

import org.springframework.stereotype.Service;
import com.etu.lab.amsensors.model.Amsensor;

import java.util.Currency;
import java.util.Random;

@Service
public class AmsensorsService {

    public Amsensor getAmsensor() {
        Amsensor amsensor = new Amsensor();
        amsensor.setId(new Random().nextInt());
        amsensor.setModelName("МА-795");
        amsensor.setPrice(2300);
        amsensor.setDetectionAngle(110);
        amsensor.setDetectionDistance(10);
        amsensor.setSirenSoundPressure(120);

        return amsensor;
    }

    public String createAmsensor(Amsensor amsensor) {
        String responceMessage = null;
        if (amsensor != null) {
            responceMessage = String.format("This is the post and the object is: %s", amsensor.toString());
        }

        return responceMessage;
    }
}
