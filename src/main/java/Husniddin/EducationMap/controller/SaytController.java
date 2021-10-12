package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.entity.Sayt;
import Husniddin.EducationMap.service.FaylService;
import Husniddin.EducationMap.service.SaytService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/sayt")
@CrossOrigin(origins = "*",maxAge = 3600)
public class SaytController {
    @Autowired
    private SaytService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody Sayt sayt) throws Exception{
        return  new ResponseEntity(service.add(sayt),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Sayt sayt, @PathVariable long id) throws Exception {

        Optional<Sayt> Optional = service.getById(id);

        if (!Optional.isPresent())
            return ResponseEntity.notFound().build();

        sayt.setId(id);
        service.update(sayt);
        return ResponseEntity.noContent().build();
    }
}
