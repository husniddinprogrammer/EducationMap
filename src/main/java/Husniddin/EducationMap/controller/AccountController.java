package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.security.JwtUtil;
import Husniddin.EducationMap.security.Token;
import Husniddin.EducationMap.security.UserMaxsus;
import Husniddin.EducationMap.security.UserProvider;
import Husniddin.EducationMap.service.UserService;
import Husniddin.EducationMap.service.dto.UserDTO;
import Husniddin.EducationMap.service.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserProvider userProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserMaxsus userMaxsus)
            throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userMaxsus.getUsername(), userMaxsus.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        } catch (Exception ex){
            ex.printStackTrace();
        }

         UserDetails userDetails = userProvider.loadUserByUsername(userMaxsus.getUsername());

         String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new Token(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserVM userVM) throws Exception{

        userService.register(userVM);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping()
    public ResponseEntity<UserDTO> getCurrentUser(){
        return ResponseEntity.ok(userService.getCurrentUser());
    }
}