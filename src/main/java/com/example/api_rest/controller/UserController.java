package com.example.api_rest.controller;

import com.example.api_rest.dto.UserDTO;
import com.example.api_rest.dto.UserMinDTO;
import com.example.api_rest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserMinDTO>> findAll(){
        List<UserMinDTO> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    
    @PostMapping("/create-all")
    public ResponseEntity<UserDTO> createAllEntities(@RequestBody UserDTO user){
        var userCreated = userService.createAll(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserMinDTO user){
        var userCreated = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody UserMinDTO userToUpdate){
        UserDTO user = userService.update(userToUpdate);
        return ResponseEntity.ok().body(user);
    }
}
