package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.entity.OquvMarkaz;
import Husniddin.EducationMap.service.FaylService;
import Husniddin.EducationMap.service.OquvMarkazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/oquv-markaz")
@CrossOrigin(origins = "*",maxAge = 3600)
public class OquvMarkazController {
    @Autowired
    private OquvMarkazService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody OquvMarkaz oquvMarkaz) throws Exception{
        return  new ResponseEntity(service.add(oquvMarkaz),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody OquvMarkaz oquvMarkaz) throws Exception {
        service.update(oquvMarkaz);
        return ResponseEntity.noContent().build();
    }
}
