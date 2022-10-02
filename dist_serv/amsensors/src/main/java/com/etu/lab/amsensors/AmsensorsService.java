package com.etu.lab.amsensors;

import org.springframework.stereotype.Service;
import com.etu.lab.amsensors.model.Amsensor;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmsensorsService {
    private final List<Amsensor> dataBase = new ArrayList<>();

    public Amsensor readAmsensor(int id) throws Exception {
        for (var a : dataBase) {
            if (a.getId() == id) {
                return a;
            }
        }

        throw new Exception("element with id '" + id + "' not found");
    }

    public void createAmsensor(Amsensor amsensor) throws Exception {
        for (var a : dataBase) {
            if (a.getId() == amsensor.getId())
            {
                throw new Exception("element with id '" + amsensor.getId() + "' already exists");
            }
        }

        dataBase.add(amsensor);
    }

    public void updateAmsensor(Amsensor amsensor) throws Exception {
        for (var a : dataBase) {
            if (amsensor.getId() == a.getId())
            {
                dataBase.set(dataBase.indexOf(a), amsensor);
                return;
            }
        }

        throw new Exception("element with id '" + amsensor.getId() + "' not found");
    }

    public Amsensor deleteAmsensor(int id) throws Exception {
        for (var a : dataBase) {
            if (a.getId() == id) {
                dataBase.remove(a);
                return a;
            }
        }
        throw new Exception("element with id '" + id + "' not found");
    }
}
