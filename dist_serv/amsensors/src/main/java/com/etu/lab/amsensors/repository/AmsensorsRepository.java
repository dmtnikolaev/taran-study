package com.etu.lab.amsensors.repository;

import com.etu.lab.amsensors.model.Amsensor;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AmsensorsRepository
        extends CrudRepository<Amsensor, String> {
    public Amsensor findById (int id);
    public boolean existsById(int id);
}
