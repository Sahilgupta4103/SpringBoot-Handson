package com.example.backendApp.Repository;

import com.example.backendApp.entity.backendEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface backendEntryRepository extends MongoRepository<backendEntry, String> {
}
