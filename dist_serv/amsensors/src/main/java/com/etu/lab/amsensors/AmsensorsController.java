package com.etu.lab.amsensors;

import com.etu.lab.amsensors.model.Amsensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(value = "sensors")
public class AmsensorsController {
    @Autowired
    private AmsensorsService amsensorsService;

    @GetMapping(value = "{id}")
    public ResponseEntity<String> getAmsensor(
                @PathVariable("id") int id,
                @RequestHeader(value = "Accept-Language", required = false) Locale locale
            ) {
        try {
            return ResponseEntity.ok(amsensorsService.readAmsensor(id, locale));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<String> createAmsensor(
                @RequestBody Amsensor request,
                @RequestHeader(value = "Accept-Language", required = false) Locale locale
            ) {
        try {
            String responseMessage = amsensorsService.createAmsensor(request, locale);
            return ResponseEntity.ok(responseMessage);
        } catch (Exception e) {
            return ResponseEntity.status(409).body(e.getMessage()); // 409 - Conflict
        }
    }

    @PutMapping()
    public ResponseEntity<String> putAmsensor(
                @RequestBody Amsensor request,
                @RequestHeader(value = "Accept-Language", required = false) Locale locale
            ) {
        try {
            String responseMessage = amsensorsService.updateAmsensor(request, locale);
            return ResponseEntity.ok(responseMessage);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteAmsensor(
                @PathVariable("id") int id,
                @RequestHeader(value = "Accept-Language", required = false) Locale locale
            ) {
        try {
            String responseMessage = amsensorsService.deleteAmsensor(id, locale);
            return ResponseEntity.ok(responseMessage);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
