package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.error.ApiError;
import Husniddin.EducationMap.service.UserService;
import Husniddin.EducationMap.service.vm.UserVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {
    @Autowired
    private UserService service;
    Logger logger = LoggerFactory.getLogger(UserController.class.getName());
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/status/{id}")
    public void getStatus(@PathVariable Long id){
        try {
            new ResponseEntity(service.status(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping(value = "/today/")
    public void getToday(){
        new ResponseEntity(service.getToday(), HttpStatus.OK);
    }
    @GetMapping(value = "/sana/{sana}")
    public void getSana(@PathVariable String sana){
        new ResponseEntity(service.getSana(sana), HttpStatus.OK);
    }
    @GetMapping(value = "/qidirish/{username}")
    public void getQidirish(@PathVariable String username){
        new ResponseEntity(service.getAllByUsernameLike(username), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody User user) throws Exception{
        try {
            return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiError(HttpStatus.BAD_REQUEST, e.getMessage(), ""));
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UserVM user, @PathVariable long id) throws Exception {
        return new ResponseEntity<>(service.update(user), HttpStatus.OK);
    }
}
