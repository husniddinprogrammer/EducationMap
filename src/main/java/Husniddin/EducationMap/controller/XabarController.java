package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.entity.Xabar;
import Husniddin.EducationMap.service.FaylService;
import Husniddin.EducationMap.service.XabarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/xabar")
@CrossOrigin(origins = "*",maxAge = 3600)
public class XabarController {
    @Autowired
    private XabarService service;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody Xabar xabar) throws Exception{
        return  new ResponseEntity(service.add(xabar),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Xabar xabar, @PathVariable long id) throws Exception {

        Optional<Xabar> Optional = service.getById(id);

        if (!Optional.isPresent())
            return ResponseEntity.notFound().build();

        xabar.setId(id);
        service.update(xabar);
        return ResponseEntity.noContent().build();
    }
}
