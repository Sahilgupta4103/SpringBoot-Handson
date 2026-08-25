package com.example.backendApp.Repository;

import com.example.backendApp.entity.userTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepo extends MongoRepository<userTable, String> {
    userTable findByUsername(String username);
}
