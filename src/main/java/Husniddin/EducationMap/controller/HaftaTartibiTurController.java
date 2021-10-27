package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.entity.HaftaTartibiTur;
import Husniddin.EducationMap.service.FaylService;
import Husniddin.EducationMap.service.HaftaTartibiTurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/hafta-tartibi-tur")
@CrossOrigin(origins = "*",maxAge = 3600)
public class HaftaTartibiTurController {
    @Autowired
    private HaftaTartibiTurService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/selected")
    public ResponseEntity<?> getSelected() throws Exception{
        return new ResponseEntity(service.getAllByStatus(), HttpStatus.OK);
    }
    @GetMapping(value = "/status/{id}")
    public void getStatus(@PathVariable Long id){
        try {
            new ResponseEntity(service.status(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody HaftaTartibiTur haftaTartibiTur) throws Exception{
        return  new ResponseEntity(service.add(haftaTartibiTur),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody HaftaTartibiTur haftaTartibiTur) throws Exception {
        service.update(haftaTartibiTur);
        return ResponseEntity.noContent().build();
    }
}
