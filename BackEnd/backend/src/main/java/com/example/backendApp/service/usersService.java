package com.example.backendApp.service;

import com.example.backendApp.Repository.usersRepository;
import com.example.backendApp.entity.users;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class usersService {

    @Autowired
    private usersRepository usersRepository;

    public void saveUser(users user){
        usersRepository.save(user);
    }
    public List<users> getUsers(){
        return usersRepository.findAll();
    }
    public Optional<users> getUserById(ObjectId myId){
        return usersRepository.findById(String.valueOf(myId));
    }
    public boolean deleteUserById(ObjectId myId){
        usersRepository.deleteById(String.valueOf(myId));
        return true;
    }

    public users findByUserName(String userName) {
        return usersRepository.findByUserName(userName);
    }
}
