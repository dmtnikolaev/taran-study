package com.etu.lab.amsensors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.etu.lab.amsensors.model.Amsensor;
import com.etu.lab.amsensors.repository.AmsensorsRepository;
import com.etu.lab.amsensors.config.ServiceConfig;

@Service
public class AmsensorsService {
    @Autowired
    private MessageSource messages;

    @Autowired
    private AmsensorsRepository repository;

    @Autowired
    private ServiceConfig config;

    public Amsensor readAmsensor(int id, Locale locale) throws IllegalArgumentException {
        var a = repository.findById(id);
        if (a != null) {
            return a.withComment(config.getProperty());

        }
        var mes = String.format(messages.getMessage("amsensors.read.error", null, locale), id);
        throw new IllegalArgumentException(mes);
    }

    public String createAmsensor(Amsensor amsensor, Locale locale) throws Exception {
        if (repository.existsById(amsensor.getId()))
        {
            var mes = String.format(messages.getMessage("amsensors.create.error", null, locale), amsensor.getId());
            throw new IllegalArgumentException(mes);
        }

        repository.save(amsensor);
        return String.format(messages.getMessage("amsensors.create.successful", null, locale), amsensor.getId());
    }

    public String updateAmsensor(Amsensor amsensor, Locale locale) throws Exception {
        if (!repository.existsById(amsensor.getId()))
        {
            var mes = String.format(messages.getMessage("amsensors.update.error", null, locale), amsensor.getId());
            throw new Exception(mes);
        }
        repository.save(amsensor);
        return String.format(messages.getMessage("amsensors.update.successful", null, locale), amsensor.getId());
    }

    public String deleteAmsensor(int id, Locale locale) throws Exception {
        if (!repository.existsById(id))
        {
            var mes = String.format(messages.getMessage("amsensors.delete.error", null, locale), id);
            throw new Exception(mes);
        }

        var amsensor = new Amsensor();
        amsensor.setId(id);
        repository.delete(amsensor);
        return String.format(messages.getMessage("amsensors.delete.successful", null, locale), amsensor.getId());

    }

    public String deleteAllAmsensors(Locale locale) {
        repository.deleteAll();
        return messages.getMessage("amsensors.delete_all.successful", null, locale);
    }
}
