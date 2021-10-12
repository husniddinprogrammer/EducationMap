package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.error.ApiError;
import Husniddin.EducationMap.service.FaylService;
import Husniddin.EducationMap.service.UserService;
import Husniddin.EducationMap.service.dto.UserDTO;
import Husniddin.EducationMap.service.vm.UserVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {
    @Autowired
    private UserService service;
    Logger logger = LoggerFactory.getLogger(UserController.class.getName());
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll(Pageable pageable){
        return new ResponseEntity(service.getAll(pageable).getContent(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody UserVM user) throws Exception{
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
