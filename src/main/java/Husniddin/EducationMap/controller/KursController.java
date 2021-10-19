package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.entity.Kurs;
import Husniddin.EducationMap.service.FaylService;
import Husniddin.EducationMap.service.KursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/kurs")
@CrossOrigin(origins = "*",maxAge = 3600)
public class KursController {
    @Autowired
    private KursService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody Kurs kurs) throws Exception{
        return  new ResponseEntity(service.add(kurs),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Kurs kurs) throws Exception {
        service.update(kurs);
        return ResponseEntity.noContent().build();
    }
}
