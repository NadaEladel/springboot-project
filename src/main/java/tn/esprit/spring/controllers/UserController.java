package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
   UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;
  
    @Autowired
	PasswordEncoder encoder;
    /* ////////////////////////////find////////////////////// */
    @GetMapping(value = "/user/{id}" )
    public User user(@PathVariable(name = "id") Long id ) {
        return userRepository.findById(id).get();
    }

    @DeleteMapping(value = "/deleteuser/{id}" )
    public void Delete(@PathVariable(name = "id") Long id ) {
        userRepository.deleteById(id);

    }
    Set<Role> roles = new HashSet<>();

 /*   @GetMapping(value = "/userbyrole" )
    public List<User> usersListbyrole(){
        return  userRepository.findByRole(false);

    }

*/

    @GetMapping(value = "/user/users")
    public ResponseEntity<List<User>> getNoProspectUsers() {

        try {
            List<User> _listUser = userService.getUsers();
            return new ResponseEntity<>(_listUser, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            HttpHeaders responseHeaders = new HttpHeaders();
            if (e.toString().contains("NullPointerException")) {
                responseHeaders.set("Message", e.toString());
            } else {
                responseHeaders.set("Message", e.getMessage());
            }
            return ResponseEntity.badRequest()
                    .headers(responseHeaders)
                    .body(new ArrayList<>());
        }
    }



    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> updateUserPassword(@RequestBody User user, @PathVariable("id") Long id) {
        try {
        	
        	User user1 =user;
        	user1.setPassword(encoder.encode(user.getPassword())); 
        	
        	//encoder.encode(user.getPassword());
            User _User = userService.updatePassword(user1, id);
            return new ResponseEntity<>(_User, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            HttpHeaders responseHeaders = new HttpHeaders();
            if (e.toString().contains("NullPointerException")) {
                responseHeaders.set("Message", e.toString());
            } else {
                responseHeaders.set("Message", e.getMessage());
            }
            return ResponseEntity.badRequest()
                    .headers(responseHeaders)
                    .body(new User());
        }
    }


    @DeleteMapping("/deleteUser/{idUser}")
    private void deleteUser(@PathVariable("idUser") Long id)
    {
        userService.delete(id);
    }
    
    
    //update user
    
    @PutMapping(value = "/updateUser/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        try {
            User _User = userService.updateUser(user, id);
            return new ResponseEntity<>(_User, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            HttpHeaders responseHeaders = new HttpHeaders();
            if (e.toString().contains("NullPointerException")) {
                responseHeaders.set("Message", e.toString());
            } else {
                responseHeaders.set("Message", e.getMessage());
            }
            return ResponseEntity.badRequest()
                    .headers(responseHeaders)
                    .body(new User());
        }
    }
    // get User By email
    @GetMapping(value = "/useremail/{email}" )
    public User user(@PathVariable(name = "id") String email ) {
        return userRepository.findByEmail(email).get();
    }
}
