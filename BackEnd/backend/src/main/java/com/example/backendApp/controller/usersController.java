package com.example.backendApp.controller;

import com.example.backendApp.Repository.usersRepository;
import com.example.backendApp.entity.backendEntry;
import com.example.backendApp.entity.users;
import com.example.backendApp.service.usersService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Users")
public class usersController {

    @Autowired
    private usersService usersService;
    @Autowired
    private usersRepository usersRepository;

    @GetMapping
      public List<users> getAll() {
        return usersService.getUsers(); }

    @PostMapping
      public users creatUser(@RequestBody users user) {
        usersService.saveUser(user);
        return user;
    }

    @GetMapping("id/{myId}")
       public users getUsersByID(@PathVariable ObjectId myId) {
        return usersService.getUserById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteUserById(@PathVariable ObjectId myId) {
        return usersService.deleteUserById(myId);
    }

    @PutMapping("/{userName}")
    public users updateUser(@RequestBody users user, @PathVariable String userName) {
        users userInDb = usersService.findByUserName(userName);
        if(userInDb != null){
            userInDb.setUserName(user.getUserName() != null && !user.getUserName().isEmpty() ? user.getUserName() : userInDb.getUserName());
            userInDb.setPassword(user.getPassword() != null && !user.getPassword().isEmpty() ? user.getPassword() : userInDb.getPassword());
            usersService.saveUser(userInDb);
            return userInDb;
        }
        return null;
    }
}


