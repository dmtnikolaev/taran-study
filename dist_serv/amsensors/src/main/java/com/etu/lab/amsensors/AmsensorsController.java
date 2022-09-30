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

    @GetMapping(value = "{id}")
    public ResponseEntity<Amsensor> getAmsensor(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(amsensorsService.readAmsensor(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping()
    public ResponseEntity<String> createAmsensor(@RequestBody Amsensor request) {
        try {
            amsensorsService.createAmsensor(request);
        } catch (Exception e) {
            return ResponseEntity.status(409).body(e.getMessage()); // 409 - Conflict
        }
        return ResponseEntity.ok(Integer.toString(request.getId()));
    }

    @PutMapping()
    public ResponseEntity<String> putAmsensor(@RequestBody Amsensor request) {
        try {
            amsensorsService.updateAmsensor(request);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

        return ResponseEntity.ok("");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Amsensor> deleteAmsensor(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(amsensorsService.deleteAmsensor(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
