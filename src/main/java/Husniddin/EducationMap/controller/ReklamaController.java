package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.entity.Reklama;
import Husniddin.EducationMap.service.FaylService;
import Husniddin.EducationMap.service.ReklamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reklama")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ReklamaController {
    @Autowired
    private ReklamaService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody Reklama reklama) throws Exception{
        return  new ResponseEntity(service.add(reklama),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Reklama reklama) throws Exception {
        service.update(reklama);
        return ResponseEntity.noContent().build();
    }
}
