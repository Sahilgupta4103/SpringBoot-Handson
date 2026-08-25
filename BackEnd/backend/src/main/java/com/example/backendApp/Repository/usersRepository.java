package com.example.backendApp.Repository;

import com.example.backendApp.entity.backendEntry;
import com.example.backendApp.entity.users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface usersRepository extends MongoRepository<users, String> {
    users findByUserName(String userName);
}
