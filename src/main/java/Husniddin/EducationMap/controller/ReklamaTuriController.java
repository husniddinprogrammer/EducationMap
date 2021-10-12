package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.entity.ReklamaTuri;
import Husniddin.EducationMap.service.FaylService;
import Husniddin.EducationMap.service.ReklamaTuriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/reklama-turi")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ReklamaTuriController {
    @Autowired
    private ReklamaTuriService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody ReklamaTuri reklamaTuri) throws Exception{
        return  new ResponseEntity(service.add(reklamaTuri),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ReklamaTuri reklamaTuri, @PathVariable long id) throws Exception {

        Optional<ReklamaTuri> Optional = service.getById(id);

        if (!Optional.isPresent())
            return ResponseEntity.notFound().build();

        reklamaTuri.setId(id);
        service.update(reklamaTuri);
        return ResponseEntity.noContent().build();
    }
}
