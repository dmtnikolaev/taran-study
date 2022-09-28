package com.etu.lab.amsensors;

import com.etu.lab.amsensors.model.Amsensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "sensors")
public class AmsensorsController {

    @Autowired
    private AmsensorsService amsensorsService;

    @GetMapping
    public ResponseEntity<Amsensor> getAmsensor() {
        Amsensor amsensor = amsensorsService.getAmsensor();
        return ResponseEntity.ok(amsensor);
    }

    @PostMapping
    public ResponseEntity<String> createAmsensor(@RequestBody Amsensor request) {
        return ResponseEntity.ok(amsensorsService.createAmsensor(request));
    }
}
