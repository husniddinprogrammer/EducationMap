package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.FaolTur;
import Husniddin.EducationMap.service.FanTuriService;
import Husniddin.EducationMap.service.FaolTurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/faol-tur")
@CrossOrigin(origins = "*",maxAge = 3600)
public class FaolTurController {
    @Autowired
    private FaolTurService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody FaolTur faolTur) throws Exception{
        return  new ResponseEntity(service.add(faolTur),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody FaolTur faolTur, @PathVariable long id) throws Exception {

        Optional<FaolTur> Optional = service.getById(id);

        if (!Optional.isPresent())
            return ResponseEntity.notFound().build();

        faolTur.setId(id);
        service.update(faolTur);
        return ResponseEntity.noContent().build();
    }
}
