package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.service.FanTuriService;
import Husniddin.EducationMap.service.FaylService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/fayl")
@CrossOrigin(origins = "*",maxAge = 3600)
public class FaylController {
    @Autowired
    private FaylService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody Fayl fayl) throws Exception{
        return  new ResponseEntity(service.add(fayl),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Fayl fayl) throws Exception {
        service.update(fayl);
        return ResponseEntity.noContent().build();
    }
}
