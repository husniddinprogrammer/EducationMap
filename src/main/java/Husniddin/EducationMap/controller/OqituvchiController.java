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
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/qidiruv-ism/{ism}")
    public ResponseEntity<?> getAllQidiruvIsm(@PathVariable String ism) throws Exception {
        return new ResponseEntity(service.getAllByIsmLike(ism), HttpStatus.OK);
    }
    @GetMapping(value = "/qidiruv-sana/{sana1}/{sana2}")
    public ResponseEntity<?> getAllQidiruvSana(@PathVariable String sana1,@PathVariable String sana2) throws Exception {
        return new ResponseEntity(service.getAllByQoshilganVaqtiBetweenOrderByIdDesc(sana1,sana2), HttpStatus.OK);
    }
    @GetMapping(value = "/qidiruv-fan/{id}")
    public ResponseEntity<?> getAllQidiruvFan(@PathVariable Long id) throws Exception {
        return new ResponseEntity(service.getAllByFan1IdOrFan2IdOrFan3IdOrderByIdDesc(id), HttpStatus.OK);
    }
    @GetMapping(value = "/qidiruv-sana-fan/{sana1}/{sana2}/{id}")
    public ResponseEntity<?> getAllQidiruvSanaFan(@PathVariable String sana1, @PathVariable String sana2,@PathVariable Long id) throws Exception {
        return new ResponseEntity(service.getAllByQoshilganVaqtiBetweenAndFan1IdOrFan2IdOrFan3IdOrderByIdDesc(sana1, sana2, id), HttpStatus.OK);
    }
    @GetMapping(value = "/selected")
    public ResponseEntity<?> getAllSelected() throws Exception {
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
