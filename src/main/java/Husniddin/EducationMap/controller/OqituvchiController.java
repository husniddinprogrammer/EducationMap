package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.entity.Oqituvchi;
import Husniddin.EducationMap.service.FaylService;
import Husniddin.EducationMap.service.OqituvchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/oqituvchi")
@CrossOrigin(origins = "*",maxAge = 3600)
public class OqituvchiController {
    @Autowired
    private OqituvchiService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody Oqituvchi oqituvchi) throws Exception{
        return  new ResponseEntity(service.add(oqituvchi),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Oqituvchi oqituvchi) throws Exception {
        service.update(oqituvchi);
        return ResponseEntity.noContent().build();
    }
}
