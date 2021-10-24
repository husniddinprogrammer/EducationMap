package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.service.FanTuriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/fan-turi")
@CrossOrigin(origins = "*",maxAge = 3600)
public class FanTuriController {
    @Autowired
    private FanTuriService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/selected")
    public ResponseEntity<?> getSelected() throws Exception{
        return new ResponseEntity(service.findAllByStatus(), HttpStatus.OK);
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
    public ResponseEntity save(@RequestBody FanTuri fanTuri) throws Exception{
        return  new ResponseEntity(service.add(fanTuri),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody FanTuri fanTuri) throws Exception {
        service.update(fanTuri);
        return ResponseEntity.noContent().build();
    }
}
