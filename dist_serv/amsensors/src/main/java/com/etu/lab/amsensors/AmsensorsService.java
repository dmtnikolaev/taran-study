package com.etu.lab.amsensors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.etu.lab.amsensors.model.Amsensor;

@Service
public class AmsensorsService {
    @Autowired
    private MessageSource messages;

    private final List<Amsensor> dataBase = new ArrayList<>();

    public Amsensor readAmsensor(int id, Locale locale) throws Exception {
        for (var a : dataBase) {
            if (a.getId() == id) {
                return a;
            }
        }

        var mes = String.format(messages.getMessage("amsensors.read.error", null, locale), id);
        throw new Exception(mes);
    }

    public String createAmsensor(Amsensor amsensor, Locale locale) throws Exception {
        String responseMessage = null;
        for (var a : dataBase) {
            if (a.getId() == amsensor.getId())
            {
                var mes = String.format(messages.getMessage("amsensors.create.error", null, locale), amsensor.getId());
                throw new Exception(mes);
            }
        }

        dataBase.add(amsensor);
        return String.format(messages.getMessage("amsensors.create.successful", null, locale), amsensor.getId());
    }

    public String updateAmsensor(Amsensor amsensor, Locale locale) throws Exception {
        for (var a : dataBase) {
            if (amsensor.getId() == a.getId())
            {
                dataBase.set(dataBase.indexOf(a), amsensor);
                return String.format(messages.getMessage("amsensors.update.successful", null, locale), amsensor.getId());
            }
        }

        var mes = String.format(messages.getMessage("amsensors.update.error", null, locale), amsensor.getId());
        throw new Exception(mes);
    }

    public String deleteAmsensor(int id, Locale locale) throws Exception {
        for (var amsensor : dataBase) {
            if (amsensor.getId() == id) {
                dataBase.remove(amsensor);
                return String.format(messages.getMessage("amsensors.delete.successful", null, locale), amsensor.getId());
            }
        }

        var mes = String.format(messages.getMessage("amsensors.delete.error", null, locale), id);
        throw new Exception(mes);
    }
}
