package org.example.atmdataproject.controller;

import org.example.atmdataproject.entity.User;
import org.example.atmdataproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody User user) {

        ResponseEntity<String> responseEntity = null;

        try {
            Integer integer = userService.saveUser(user);

            responseEntity = new ResponseEntity<String>("User " + integer + " created", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;

    }



    @PutMapping("/delete")
    public ResponseEntity<String> userDeleted(@RequestBody User user){
        ResponseEntity responseEntity = null;
        boolean available = userService.isAvailable(user.getId()) ;
        if(available ){
            userService.userDeleted(user);
            responseEntity = new ResponseEntity(user.getId() + " inactivated. Activation code: " + user.getIsActive(), HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity( "Not exist!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody User user){
        ResponseEntity responseEntity =null;
        boolean available = userService.isAvailable(user.getId());

        if(available){
            userService.update(user);
            responseEntity = new ResponseEntity<String>(user.getName() + " is updated", HttpStatus.OK);

        }else{
            responseEntity = new ResponseEntity<String>("Record " + user.getName() + " not found.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;

    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
}

