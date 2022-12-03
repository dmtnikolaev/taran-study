package com.etu.lab.amsensors;

import com.etu.lab.amsensors.model.Amsensor;
import com.etu.lab.amsensors.service.AmsensorsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Locale;

@RestController
@RequestMapping(value = "sensors")
public class AmsensorsController {
    @Autowired
    private AmsensorsService amsensorsService;

    @Autowired
    private MessageSource messages;

    @GetMapping(value = "{id}")
    public ResponseEntity getAmsensor(
                @PathVariable("id") int id,
                @RequestHeader(value = "Accept-Language", required = false) Locale locale
            ) throws Exception {
        try {
            var amsensor = amsensorsService.readAmsensor(id, locale);
            amsensor.add(linkTo(methodOn(AmsensorsController.class)
                            .getAmsensor(id, locale))
                            .withSelfRel(),
                    linkTo(methodOn(AmsensorsController.class)
                            .createAmsensor(amsensor, locale))
                            .withRel(messages.getMessage("amsensors.hateoas.create", null, locale)),
                    linkTo(methodOn(AmsensorsController.class)
                            .putAmsensor(amsensor, locale))
                            .withRel(messages.getMessage("amsensors.hateoas.update", null, locale)),
                    linkTo(methodOn(AmsensorsController.class)
                            .deleteAmsensor(id, locale))
                            .withRel(messages.getMessage("amsensors.hateoas.delete", null, locale)));
            return ResponseEntity.ok(amsensor);
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

    @DeleteMapping(value = "")
    public ResponseEntity deleteAllAmsensors(
                @RequestHeader(value = "Accept-Language", required = false) Locale locale
            ) {
        String responseMessage = amsensorsService.deleteAllAmsensors(locale);
        return ResponseEntity.ok(responseMessage);
    }

}
