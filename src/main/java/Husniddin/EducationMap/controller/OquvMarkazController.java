package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.entity.OquvMarkaz;
import Husniddin.EducationMap.service.FaylService;
import Husniddin.EducationMap.service.OquvMarkazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/oquv-markaz")
@CrossOrigin(origins = "*",maxAge = 3600)
public class OquvMarkazController {
    @Autowired
    private OquvMarkazService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAllByWeek(), HttpStatus.OK);
    }
    @GetMapping(value = "/selected")
    public ResponseEntity<?> getSelected() throws Exception{
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
    @GetMapping(value = "/qidirish-nomi/{nomi}")
    public ResponseEntity<?> getQidirishNomi(@PathVariable String nomi) throws IOException {
        return new ResponseEntity(service.getAllByNomiLike(nomi), HttpStatus.OK);
    }
    @GetMapping(value = "/qidirish-viloyat/{viloyat}")
    public ResponseEntity<?> getQidirishViloyat(@PathVariable String viloyat){
       return new ResponseEntity(service.getAllByViloyatOrderByIdDesc(viloyat), HttpStatus.OK);
    }
    @GetMapping(value = "/qidirish-sana/{sana1}/{sana2}")
    public ResponseEntity<?> getQidirishSana(@PathVariable String sana1,@PathVariable String sana2){
       return new ResponseEntity(service.getAllByQoshilganVaqtiBetweenOrderByIdDesc(sana1,sana2), HttpStatus.OK);
    }
    @GetMapping(value = "/qidirish-sana-viloyat/{sana1}/{sana2}/{viloyat}")
    public ResponseEntity<?> getQidirishSanaViloyat(@PathVariable String sana1,@PathVariable String sana2,String viloyat){
       return new ResponseEntity(service.getAllByQoshilganVaqtiBetweenAndViloyatOrderByIdDesc(sana1,sana2,viloyat), HttpStatus.OK);
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
